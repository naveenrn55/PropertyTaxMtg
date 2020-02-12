package com.mindtree.propertytax.dao;

import java.util.List;

import com.mindtree.propertytax.entity.CollectedTax;
import com.mindtree.propertytax.entity.CollectedTaxId;
import com.mindtree.propertytax.entity.PropertyType;
import com.mindtree.propertytax.entity.ResidentialStatus;
import com.mindtree.propertytax.entity.TaxCost;
import com.mindtree.propertytax.entity.TaxId;
import com.mindtree.propertytax.entity.Zone;

/**
 * <pre>
 * <b>Description : </b>
 * PropertyTaxManagementDao. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:13:07 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
public interface PropertyTaxManagementDao {

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveAllCollectedTaxData.
     *
     * @return List<CollectedTax> , null if not found
     * </pre>
     */
    List<CollectedTax> retrieveAllCollectedTaxData();

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveAllProperties.
     *
     * @return List<PropertyType> , null if not found
     * </pre>
     */
    List<PropertyType> retrieveAllProperties();

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveAllResidentialStatus.
     *
     * @return List<ResidentialStatus> , null if not found
     * </pre>
     */
    List<ResidentialStatus> retrieveAllResidentialStatus();

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveAllZones.
     *
     * @return List<Zone> , null if not found
     * </pre>
     */
    List<Zone> retrieveAllZones();

    /**
     * <pre>
     * <b>Description : </b>
     * retriveZone.
     *
     * @param zone_id , may be null
     * @return Zone , null if not found
     * </pre>
     */
    Zone retriveZone(final int zone_id);

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveProperty.
     *
     * @param prop_id , may be null
     * @return PropertyType , null if not found
     * </pre>
     */
    PropertyType retrieveProperty(final int prop_id);

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveStatus.
     *
     * @param stat_id , may be null
     * @return ResidentialStatus , null if not found
     * </pre>
     */
    ResidentialStatus retrieveStatus(final int stat_id);

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveTaxCost.
     *
     * @param taxId , may be null
     * @return TaxCost , null if not found
     * </pre>
     */
    TaxCost retrieveTaxCost(final TaxId taxId);

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveCollectedTax.
     * 
     * @param collectedTaxId , may be null
     * @return
     * </pre>
     */
    CollectedTax retrieveCollectedTax(final CollectedTaxId collectedTaxId);

    /**
     * <pre>
     * <b>Description : </b>
     * saveTax.
     * 
     * @param collectedTax
     * </pre>
     */
    void saveTax(final CollectedTax collectedTax);

}
