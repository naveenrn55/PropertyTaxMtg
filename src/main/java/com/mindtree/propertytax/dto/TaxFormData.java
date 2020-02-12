package com.mindtree.propertytax.dto;

import java.util.List;

/**
 * <pre>
 * <b>Description : </b>
 * TaxFormData. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:31 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
public class TaxFormData {

    /**
     * List<String> properties.
     */
    private List<String> properties;
    /**
     * List<String> residentialStatuses.
     */
    private List<String> residentialStatuses;
    /**
     * List<String> zones.
     */
    private List<String> zones;

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'List<String>' attribute value.
     *
     * @return List<String> , null if not found
     * </pre>
     */
    public List<String> getProperties() {
        return properties;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'propertiesParam' attribute value.
     *
     * @param propertiesParam , may be null
     * </pre>
     */
    public void setProperties(final List<String> propertiesParam) {
        this.properties = propertiesParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'List<String>' attribute value.
     *
     * @return List<String> , null if not found
     * </pre>
     */
    public List<String> getResidentialStatuses() {
        return residentialStatuses;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'residentialStatusesParam' attribute value.
     *
     * @param residentialStatusesParam , may be null
     * </pre>
     */
    public void setResidentialStatuses(final List<String> residentialStatusesParam) {
        this.residentialStatuses = residentialStatusesParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'List<String>' attribute value.
     *
     * @return List<String> , null if not found
     * </pre>
     */
    public List<String> getZones() {
        return zones;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'zonesParam' attribute value.
     *
     * @param zonesParam , may be null
     * </pre>
     */
    public void setZones(final List<String> zonesParam) {
        this.zones = zonesParam;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((properties == null) ? 0 : properties.hashCode());
        result = prime * result + ((residentialStatuses == null) ? 0 : residentialStatuses.hashCode());
        result = prime * result + ((zones == null) ? 0 : zones.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TaxFormData other = (TaxFormData) obj;
        if (properties == null) {
            if (other.properties != null)
                return false;
        }
        else if (!properties.equals(other.properties))
            return false;
        if (residentialStatuses == null) {
            if (other.residentialStatuses != null)
                return false;
        }
        else if (!residentialStatuses.equals(other.residentialStatuses))
            return false;
        if (zones == null) {
            if (other.zones != null)
                return false;
        }
        else if (!zones.equals(other.zones))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TaxFormData [properties=" + properties + ", residentialStatuses=" + residentialStatuses + ", zones="
            + zones + "]";
    }

}
