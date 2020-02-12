package com.mindtree.propertytax.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mindtree.propertytax.dao.PropertyTaxManagementDao;
import com.mindtree.propertytax.dto.TaxEvaluation;
import com.mindtree.propertytax.dto.TaxFormData;
import com.mindtree.propertytax.dto.ZoneWiseTaxCollection;
import com.mindtree.propertytax.entity.CollectedTax;
import com.mindtree.propertytax.entity.CollectedTaxId;
import com.mindtree.propertytax.entity.PropertyType;
import com.mindtree.propertytax.entity.ResidentialStatus;
import com.mindtree.propertytax.entity.TaxCost;
import com.mindtree.propertytax.entity.TaxId;
import com.mindtree.propertytax.entity.Zone;
import com.mindtree.propertytax.exceptions.InsufficientInformationException;

public class PropertyTaxManagementServiceImplTest {
    
    
    PropertyTaxManagementServiceImpl propertyTaxImp = new PropertyTaxManagementServiceImpl();
    private PropertyTaxManagementDao dao;
    
   @Before
   public void initialize() {
       dao = Mockito.mock(PropertyTaxManagementDao.class);
       propertyTaxImp.setDao(dao);
   }
    

    @Test
    public void testRetrieveAllCollectedTaxData() {
        Mockito.when(dao.retrieveAllCollectedTaxData()).thenReturn(getCollectedTaxData());
        List<ZoneWiseTaxCollection> zoneWiseTax = propertyTaxImp.retrieveAllCollectedTaxData();
        assertEquals("Zone A", zoneWiseTax.get(0).getZoneName());
        assertEquals("Zone B", zoneWiseTax.get(1).getZoneName());
        assertEquals("Zone C", zoneWiseTax.get(2).getZoneName());
        assertMaps(zoneWiseTax.get(0).getTaxCollectedMap() , 10.0 , 11.0);
        assertMaps(zoneWiseTax.get(1).getTaxCollectedMap() , 12.0 , 13.0);
        assertMaps(zoneWiseTax.get(2).getTaxCollectedMap() , 14.0 , 15.0);
    }
    
    @Test
    public void testGetFormData() throws InsufficientInformationException {
        Mockito.when(dao.retrieveAllProperties()).thenReturn(getProperties());
        Mockito.when(dao.retrieveAllResidentialStatus()).thenReturn(getStatuses());
        Mockito.when(dao.retrieveAllZones()).thenReturn(getZones());
        TaxFormData taxFormData = propertyTaxImp.getFormData();
        assertEquals("Zone A", taxFormData.getZones().get(0));
        assertEquals("Zone B", taxFormData.getZones().get(1));
        assertEquals("Zone C", taxFormData.getZones().get(2));
        assertEquals("Owner", taxFormData.getResidentialStatuses().get(0));
        assertEquals("Tenant", taxFormData.getResidentialStatuses().get(1));
        assertEquals("RCC Building", taxFormData.getProperties().get(0));
        assertEquals("Tiled Sheets", taxFormData.getProperties().get(1));
        
    }
    
	/*
	 * @Test public void testCalculateTaxWhenBuildingLessThan60Years(){ TaxCost
	 * taxCost = new TaxCost(); taxCost.setTax(100.0);
	 * Mockito.when(dao.retrieveTaxCost(Mockito.any(TaxId.class))).thenReturn(
	 * taxCost); TaxEvaluation taxEvaluation = new TaxEvaluation();
	 * taxEvaluation.setConstructionYear(1996); taxEvaluation.setBuildArea(100.0);
	 * double tax = propertyTaxImp.calculateTax(taxEvaluation);
	 * assertEquals(19096.0, tax , 0.1); }
	 */
    
    @Test
    public void testCalculateTaxWhenBuildingMoreThan60Years1(){
        TaxCost taxCost = new TaxCost();
        taxCost.setTax(100.0);
        Mockito.when(dao.retrieveTaxCost(Mockito.any(TaxId.class))).thenReturn(taxCost);
        TaxEvaluation taxEvaluation = new TaxEvaluation();
        taxEvaluation.setConstructionYear(1950);
        taxEvaluation.setBuildArea(100.0);
        double tax = propertyTaxImp.calculateTax(taxEvaluation);
        assertEquals(9920.0, tax , 0.1);
    }
    
    @Test
    public void testCalculateTaxWhenBuildingMoreThan60Years2(){
        TaxCost taxCost = new TaxCost();
        taxCost.setTax(100.0);
        Mockito.when(dao.retrieveTaxCost(Mockito.any(TaxId.class))).thenReturn(taxCost);
        TaxEvaluation taxEvaluation = new TaxEvaluation();
        taxEvaluation.setConstructionYear(1900);
        taxEvaluation.setBuildArea(100.0);
        double tax = propertyTaxImp.calculateTax(taxEvaluation);
        assertEquals(9920.0, tax , 0.1);
    }

    
    @Test
    public void testSubmitTax(){
        propertyTaxImp.submitTax(new TaxEvaluation());
        Mockito.verify(dao, Mockito.times(1)).retrieveCollectedTax(Mockito.any(CollectedTaxId.class));
        Mockito.verify(dao, Mockito.times(1)).saveTax(Mockito.any(CollectedTax.class));
    }
    
    @Test
    public void testInsufficientInformationForProperties() {
        Mockito.when(dao.retrieveAllProperties()).thenReturn(null);
        Mockito.when(dao.retrieveAllResidentialStatus()).thenReturn(getStatuses());
        Mockito.when(dao.retrieveAllZones()).thenReturn(getZones());
        try {
            propertyTaxImp.getFormData();
        }
        catch (InsufficientInformationException exp) {
            assertEquals("Error Retrieving Data from Db. Please try again later", exp.getLocalizedMessage());
        }

    }
    
    @Test
    public void testInsufficientInformationForStatuses() {
        Mockito.when(dao.retrieveAllProperties()).thenReturn(getProperties());
        Mockito.when(dao.retrieveAllResidentialStatus()).thenReturn(null);
        Mockito.when(dao.retrieveAllZones()).thenReturn(getZones());
        try {
            propertyTaxImp.getFormData();
        }
        catch (InsufficientInformationException exp) {
            assertEquals("Error Retrieving Data from Db. Please try again later", exp.getLocalizedMessage());
        }

    }
    
    @Test
    public void testInsufficientInformationForZones() {
        Mockito.when(dao.retrieveAllProperties()).thenReturn(getProperties());
        Mockito.when(dao.retrieveAllResidentialStatus()).thenReturn(getStatuses());
        Mockito.when(dao.retrieveAllZones()).thenReturn(null);
        try {
            propertyTaxImp.getFormData();
        }
        catch (InsufficientInformationException exp) {
            assertEquals("Error Retrieving Data from Db. Please try again later", exp.getLocalizedMessage());
        }

    }

    private List<Zone> getZones() {
        List<Zone> zones = new ArrayList<Zone>();
        zones.add(new Zone());
        zones.add(new Zone());
        zones.add(new Zone());
        zones.get(0).setZoneName("Zone A");
        zones.get(1).setZoneName("Zone B");
        zones.get(2).setZoneName("Zone C");
        return zones;
    }


    private List<ResidentialStatus> getStatuses() {
        List<ResidentialStatus> statuses = new ArrayList<ResidentialStatus>();
        statuses.add(new ResidentialStatus());
        statuses.add(new ResidentialStatus());
        statuses.get(0).setResidentStatus("Owner");
        statuses.get(1).setResidentStatus("Tenant");
        return statuses;
    }


    private List<PropertyType> getProperties() {
        List<PropertyType> properties = new ArrayList<PropertyType>();
        properties.add(new PropertyType());
        properties.add(new PropertyType());
        properties.get(0).setPropertyType("RCC Building");
        properties.get(1).setPropertyType("Tiled Sheets");
        return properties;
    }


    private void assertMaps(Map<String, Double> taxCollectedMap, double ownerTax, double tenantTax) {
        assertEquals(ownerTax, taxCollectedMap.get("Owner").doubleValue() , 0.1);
        assertEquals(tenantTax, taxCollectedMap.get("Tenant").doubleValue() , 0.1);
      
        
    }


    private List<CollectedTax> getCollectedTaxData() {
        List<CollectedTax> collectedTaxDataList = new ArrayList<CollectedTax>();
        collectedTaxDataList.add(buildCollectedTax("Zone A" , "Owner" , 10.0));
        collectedTaxDataList.add(buildCollectedTax("Zone A" , "Tenant" , 11.0));
        collectedTaxDataList.add(buildCollectedTax("Zone B" , "Owner" , 12.0));
        collectedTaxDataList.add(buildCollectedTax("Zone B" , "Tenant" , 13.0));
        collectedTaxDataList.add(buildCollectedTax("Zone C" , "Owner" , 14.0));
        collectedTaxDataList.add(buildCollectedTax("Zone C" , "Tenant" , 15.0));
        return collectedTaxDataList;
    }


    private CollectedTax buildCollectedTax(String zone, String status, double taxAmt) {
        CollectedTax collectedTax = new CollectedTax();
        
        CollectedTaxId taxId = new CollectedTaxId();
        taxId.setResidentStatus(status);
        taxId.setZoneName(zone);
        collectedTax.setTaxId(taxId);
        collectedTax.setCollectedTax(taxAmt);
        return collectedTax;
    }

}
