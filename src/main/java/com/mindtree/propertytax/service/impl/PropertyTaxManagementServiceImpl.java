package com.mindtree.propertytax.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
import com.mindtree.propertytax.service.PropertyTaxManagementService;

/**
 * <pre>
 * <b>Description : </b>
 * PropertyTaxManagementServiceImpl. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:53 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PropertyTaxManagementServiceImpl implements PropertyTaxManagementService {
    
    /**
     * LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(PropertyTaxManagementServiceImpl.class);

    /**
     * PropertyTaxManagementDao dao.
     */
    @Autowired
    private PropertyTaxManagementDao dao;

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveAllCollectedTaxData.
     *
     * @return List<ZoneWiseTaxCollection> , null if not found
     * </pre>
     */
    @Override
    public List<ZoneWiseTaxCollection> retrieveAllCollectedTaxData() {
        LOGGER.debug("entry: retrieveAllCollectedTaxData method");
        List<CollectedTax> collectedTax = dao.retrieveAllCollectedTaxData();

        List<ZoneWiseTaxCollection> taxCostList = constructZoneWiseTaxCollection(collectedTax);
        LOGGER.debug("Exit: retrieveAllCollectedTaxData method with args + "+ taxCostList.toString());
        return taxCostList;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * constructZoneWiseTaxCollection.
     *
     * @param collectedTaxList , may be null
     * @return List<ZoneWiseTaxCollection> , null if not found
     * </pre>
     */
    private List<ZoneWiseTaxCollection> constructZoneWiseTaxCollection(
        final List<CollectedTax> collectedTaxList) {
        LOGGER.debug("entry: constructZoneWiseTaxCollection method");
        Map<String, ZoneWiseTaxCollection> zonesMap = new HashMap<String, ZoneWiseTaxCollection>();
        List<ZoneWiseTaxCollection> zoneWiseCollection = null;
        if (collectedTaxList != null && !collectedTaxList.isEmpty()) {
            zoneWiseCollection = new ArrayList<ZoneWiseTaxCollection>();
            for (CollectedTax collectedTax : collectedTaxList) {
                ZoneWiseTaxCollection zoneCollection = zonesMap.get(collectedTax.getTaxId().getZoneName());
                if (zoneCollection == null) {
                    zoneCollection = new ZoneWiseTaxCollection();
                    zoneCollection.setZoneName(collectedTax.getTaxId().getZoneName());
                    zoneWiseCollection.add(zoneCollection);
                    zonesMap.put(collectedTax.getTaxId().getZoneName(), zoneCollection);
                }
                Double taxCost = zoneCollection.getTaxCollectedMap().get(
                    collectedTax.getTaxId().getResidentStatus());
                if (taxCost == null) {
                    taxCost = new Double(0.0);
                }
                double newTaxCost = (double) taxCost + collectedTax.getCollectedTax();
                zoneCollection.getTaxCollectedMap().put(collectedTax.getTaxId().getResidentStatus(),
                    newTaxCost);
            }
        }
        LOGGER.debug("Exit: constructZoneWiseTaxCollection method with args " + zoneWiseCollection);
        return zoneWiseCollection;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'TaxFormData' attribute value.
     *
     * @return TaxFormData , null if not found
     * </pre>
     * @throws InsufficientInformationException 
     */
    @Override
    public TaxFormData getFormData() throws InsufficientInformationException {
        LOGGER.debug("entry: getFormData method");
        TaxFormData taxFormData = new TaxFormData();
        List<PropertyType> properties = dao.retrieveAllProperties();
        List<String> propertiesList = retrieveListOfProperties(properties);
        taxFormData.setProperties(propertiesList);
        List<ResidentialStatus> residentialStatuses = dao.retrieveAllResidentialStatus();
        List<String> residentialStatusList = retrieveStatuses(residentialStatuses);
        taxFormData.setResidentialStatuses(residentialStatusList);
        List<Zone> zones = dao.retrieveAllZones();
        List<String> zonesList = retrieveZonesList(zones);
        taxFormData.setZones(zonesList);
        LOGGER.debug("Exit: getFormData method with args " + taxFormData.toString());
        return taxFormData;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveZonesList.
     *
     * @param zones , may be null
     * @return List<String> , null if not found
     * </pre>
     * @throws InsufficientInformationException 
     */
    private List<String> retrieveZonesList(final List<Zone> zones) throws InsufficientInformationException {
        LOGGER.debug("entry: retrieveZonesList method");
        if(zones==null || zones.isEmpty()){
            LOGGER.error("Exception occured because zone is null or empty");
            throw new InsufficientInformationException("Error Retrieving Data from Db. Please try again later");
        }
        List<String> zonesList = null;
        if (zones != null && !zones.isEmpty()) {
            zonesList = new ArrayList<String>();
            for (Zone zone : zones) {
                zonesList.add(zone.getZoneName());
            }
        }
        LOGGER.debug("Exit: retrieveZonesList method args "+ zonesList);
        return zonesList;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveStatuses.
     *
     * @param residentialStatuses , may be null
     * @return List<String> , null if not found
     * </pre>
     * @throws InsufficientInformationException 
     */
    private List<String> retrieveStatuses(final List<ResidentialStatus> residentialStatuses) throws InsufficientInformationException {
        LOGGER.debug("entry: retrieveStatuses method");
        if(residentialStatuses==null || residentialStatuses.isEmpty()){
            LOGGER.error("Exception occured because residentialStatuses is null or empty");
            throw new InsufficientInformationException("Error Retrieving Data from Db. Please try again later");
        }
        List<String> statusList = null;
        if (residentialStatuses != null && !residentialStatuses.isEmpty()) {
            statusList = new ArrayList<String>();
            for (ResidentialStatus status : residentialStatuses) {
                statusList.add(status.getResidentStatus());
            }
        }
        LOGGER.debug("Exit: retrieveStatuses method args "+ statusList.toString());
        return statusList;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveListOfProperties.
     *
     * @param properties , may be null
     * @return List<String> , null if not found
     * </pre>
     * @throws InsufficientInformationException 
     */
    private List<String> retrieveListOfProperties(final List<PropertyType> properties) throws InsufficientInformationException {
        LOGGER.debug("entry: retrieveListOfProperties method");
        if(properties==null || properties.isEmpty()){
            LOGGER.error("Exception occured because properties is null or empty");
            throw new InsufficientInformationException("Error Retrieving Data from Db. Please try again later");
        }
        List<String> propertiesList = null;
        if (properties != null && !properties.isEmpty()) {
            propertiesList = new ArrayList<String>();
            for (PropertyType property : properties) {
                propertiesList.add(property.getPropertyType());
            }
        }
        LOGGER.debug("Exit: retrieveListOfProperties method args " + propertiesList.toString());
        return propertiesList;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * calculateTax.
     *
     * @param taxEvaluation , may be null
     * @return double , null if not found
     * </pre>
     */
    @Override
    public double calculateTax(final TaxEvaluation taxEvaluation) {
        LOGGER.debug("entry: retrieveAllCollectedTaxData method");
        TaxId taxId = createTaxId(taxEvaluation.getZone(), taxEvaluation.getProperty(),
            taxEvaluation.getStatus());
        TaxCost taxCost = dao.retrieveTaxCost(taxId);
        double payableTax = calculatePayableTax(taxEvaluation.getConstructionYear(),
            taxEvaluation.getBuildArea(), taxCost);
        LOGGER.debug("Exit: calculateTax method tax="+payableTax);
        return payableTax;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * calculatePayableTax.
     *
     * @param year , may be null
     * @param area , may be null
     * @param taxCost , may be null
     * @return double , null if not found
     * </pre>
     */
    private double calculatePayableTax(final int year, final double area, final TaxCost taxCost) {
        LOGGER.debug("entry: calculatePayableTax method");
        double total1 = area * 10;
        int ageOfBuilding = Calendar.getInstance().get(Calendar.YEAR) - year;
        double depriciation = 0.0;
        if (ageOfBuilding <= 60) {
            depriciation = ageOfBuilding / 100.0;
        }
        else {
            depriciation = 0.6;
        }
        double total2 = total1 - (total1 * depriciation);
        double total3 = total2 * (0.2 * taxCost.getTax());
        double total4 = total3 * 0.24;
        LOGGER.debug("Exit: calculatePayableTax method tax = "+(total3 + total4));
        return total3 + total4;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * createTaxId.
     *
     * @param zoneName , may be null
     * @param propertyType , may be null
     * @param residentStatus , may be null
     * @return TaxId , null if not found
     * </pre>
     */
    private TaxId createTaxId(final String zoneName, final String propertyType, final String residentStatus) {
        LOGGER.debug("entry: createTaxId method");
        TaxId taxId = new TaxId();
        taxId.setZoneName(zoneName);
        taxId.setResidentStatus(residentStatus);
        taxId.setPropertyType(propertyType);
        LOGGER.debug("Exit: createTaxId method args " + taxId.toString());
        return taxId;
    }
    
    /**
     * <pre>
     * <b>Description : </b>
     * <submitTax.
     * 
     * @param taxEvaluation , may be null
     * </pre>
     */
    @Override
    
    public void submitTax(final TaxEvaluation taxEvaluation) {
        LOGGER.debug("entry: submitTax method");
        CollectedTaxId collectedTaxId = createCollectedTaxId(taxEvaluation.getZone() , taxEvaluation.getStatus());
        CollectedTax collectedTax = dao.retrieveCollectedTax(collectedTaxId);
        if(collectedTax == null) {
            collectedTax = new CollectedTax();
            collectedTax.setTaxId(collectedTaxId);
        }
        collectedTax.setCollectedTax(collectedTax.getCollectedTax() + taxEvaluation.getPayableTax());
        saveTax(collectedTax);
        LOGGER.debug("Exit: submitTax method");
    }
    
    
    @Transactional(propagation=Propagation.REQUIRES_NEW , readOnly=false)
    public void saveTax(CollectedTax collectedTax) {
        dao.saveTax(collectedTax);
    }

    /**
     * <pre>
     * <b>Description : </b>
     *createCollectedTaxId.
     * 
     * @param zone , may be null
     * @param status , may be null
     * @param property , may be null
     * @return
     * </pre>
     */
    private CollectedTaxId createCollectedTaxId(final String zone, final String status) {
        LOGGER.debug("entry: createCollectedTaxId method");
        CollectedTaxId collectedTaxId = new CollectedTaxId();
        collectedTaxId.setResidentStatus(status);
        collectedTaxId.setZoneName(zone);
        LOGGER.debug("Exit: createCollectedTaxId method args + " + collectedTaxId.toString());
        return collectedTaxId;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'PropertyTaxManagementDao' attribute value.
     *
     * @return PropertyTaxManagementDao , null if not found
     * </pre>
     */
    public PropertyTaxManagementDao getDao() {
        return dao;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'daoParam' attribute value.
     *
     * @param daoParam , may be null
     * </pre>
     */
    public void setDao(final PropertyTaxManagementDao daoParam) {
        this.dao = daoParam;
    }

  
}
