package com.mindtree.propertytax.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.propertytax.dao.PropertyTaxManagementDao;
import com.mindtree.propertytax.entity.CollectedTax;
import com.mindtree.propertytax.entity.CollectedTaxId;
import com.mindtree.propertytax.entity.PropertyType;
import com.mindtree.propertytax.entity.ResidentialStatus;
import com.mindtree.propertytax.entity.TaxCost;
import com.mindtree.propertytax.entity.TaxId;
import com.mindtree.propertytax.entity.Zone;
import com.mindtree.propertytax.service.impl.PropertyTaxManagementServiceImpl;

/**
 * <pre>
 * <b>Description : </b>
 * PropertyTaxManagementDaoImpl. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:13:07 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
@Repository
public class PropertyTaxManagementDaoImpl implements PropertyTaxManagementDao {
    

    /**
     * LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(PropertyTaxManagementServiceImpl.class);
    /**
     * SessionFactory sessionFactory.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveAllCollectedTaxData.
     *
     * @return List<CollectedTax> , null if not found
     * </pre>
     */
    @Override
    public List<CollectedTax> retrieveAllCollectedTaxData() {
        LOGGER.debug("Entry :retrieveAllCollectedTaxData" );
        Session session = sessionFactory.openSession();
        org.hibernate.Query query = session.createQuery("from CollectedTax");
        @SuppressWarnings("unchecked")
        List<CollectedTax> taxCosts = (List<CollectedTax>) query.list();
        session.close();
        LOGGER.debug("Exit :retrieveAllCollectedTaxData" );
        return taxCosts;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveAllProperties.
     *
     * @return List<PropertyType> , null if not found
     * </pre>
     */
    @Override
    public List<PropertyType> retrieveAllProperties() {
        LOGGER.debug("Entry :retrieveAllProperties" );
        Session session = sessionFactory.openSession();
        org.hibernate.Query query = session.createQuery("from PropertyType");
        @SuppressWarnings("unchecked")
        List<PropertyType> properties = (List<PropertyType>) query.list();
        session.close();
        LOGGER.debug("Exit :retrieveAllProperties" );
        return properties;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveAllResidentialStatus.
     *
     * @return List<ResidentialStatus> , null if not found
     * </pre>
     */
    @Override
    public List<ResidentialStatus> retrieveAllResidentialStatus() {
        LOGGER.debug("Entry :retrieveAllResidentialStatus" );
        Session session = sessionFactory.openSession();
        org.hibernate.Query query = session.createQuery("from ResidentialStatus");
        @SuppressWarnings("unchecked")
        List<ResidentialStatus> residentialStatuses = (List<ResidentialStatus>) query.list();
        session.close();
        LOGGER.debug("Exit :retrieveAllResidentialStatus" );
        return residentialStatuses;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveAllZones.
     *
     * @return List<Zone> , null if not found
     * </pre>
     */
    @Override
    public List<Zone> retrieveAllZones() {
        LOGGER.debug("Entry :retrieveAllZones" );
        Session session = sessionFactory.openSession();
        org.hibernate.Query query = session.createQuery("from Zone");
        @SuppressWarnings("unchecked")
        List<Zone> zones = (List<Zone>) query.list();
        session.close();
        LOGGER.debug("Exit :retrieveAllZones" );
        return zones;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retriveZone.
     *
     * @param zone_id , may be null
     * @return Zone , null if not found
     * </pre>
     */
    @Override
    public Zone retriveZone(final int zone_id) {
        LOGGER.debug("Entry :retriveZone" );
        Session session = sessionFactory.openSession();
        Zone zone = (Zone) session.get(Zone.class, zone_id);
        session.close();
        LOGGER.debug("Exit :retriveZone" );
        return zone;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveProperty.
     *
     * @param prop_id , may be null
     * @return PropertyType , null if not found
     * </pre>
     */
    @Override
    public PropertyType retrieveProperty(final int prop_id) {
        LOGGER.debug("Entry :retrieveProperty" );
        Session session = sessionFactory.openSession();
        PropertyType property = (PropertyType) session.get(PropertyType.class, prop_id);
        session.close();
        LOGGER.debug("Exit :retrieveProperty" );
        return property;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveStatus.
     *
     * @param stat_id , may be null
     * @return ResidentialStatus , null if not found
     * </pre>
     */
    @Override
    public ResidentialStatus retrieveStatus(final int stat_id) {
        LOGGER.debug("Entry :retrieveStatus" );
        Session session = sessionFactory.openSession();
        ResidentialStatus status = (ResidentialStatus) session.get(ResidentialStatus.class, stat_id);
        session.close();
        LOGGER.debug("Exit :retrieveStatus" );
        return status;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveTaxCost.
     *
     * @param taxId , may be null
     * @return TaxCost , null if not found
     * </pre>
     */
    @Override
    public TaxCost retrieveTaxCost(final TaxId taxId) {
        LOGGER.debug("Entry :retrieveTaxCost" );
        Session session = sessionFactory.openSession();
        TaxCost taxCost = (TaxCost) session.get(TaxCost.class, taxId);
        session.close();
        LOGGER.debug("Exit :retrieveTaxCost" );
        return taxCost;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveCollectedTax.
     * 
     * @param collectedTaxId , may be null
     * @return
     * </pre>
     */
    @Override
    public CollectedTax retrieveCollectedTax(final CollectedTaxId collectedTaxId) {
  
        LOGGER.debug("Entry :retrieveCollectedTax" );
        Session session = sessionFactory.openSession();
        CollectedTax collectedTax = (CollectedTax) session.get(CollectedTax.class, collectedTaxId);
        session.close();
        LOGGER.debug("Exit :retrieveCollectedTax" );
        return collectedTax;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * saveTax.
     * 
     * @param collectedTax , not null
     * </pre>
     */
    @Override
    public void saveTax(final CollectedTax collectedTax) {
        LOGGER.debug("Entry :saveTax" );
        Session session = sessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        session.saveOrUpdate(collectedTax);
        beginTransaction.commit();
        session.close();
        LOGGER.debug("Exit :saveTax" );
    }

}
