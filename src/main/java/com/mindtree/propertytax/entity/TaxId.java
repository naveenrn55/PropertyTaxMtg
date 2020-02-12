package com.mindtree.propertytax.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <pre>
 * <b>Description : </b>
 * TaxId. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:43 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
@Embeddable
public class TaxId implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * String propertyType.
     */
    @Column
    private String propertyType;
    /**
     * String residentStatus.
     */
    @Column
    private String residentStatus;;
    /**
     * String zoneName.
     */
    @Column
    private String zoneName;

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getPropertyType() {
        return propertyType;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'propertyTypeParam' attribute value.
     *
     * @param propertyTypeParam , may be null
     * </pre>
     */
    public void setPropertyType(final String propertyTypeParam) {
        this.propertyType = propertyTypeParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getResidentStatus() {
        return residentStatus;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'residentStatusParam' attribute value.
     *
     * @param residentStatusParam , may be null
     * </pre>
     */
    public void setResidentStatus(final String residentStatusParam) {
        this.residentStatus = residentStatusParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getZoneName() {
        return zoneName;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'zoneNameParam' attribute value.
     *
     * @param zoneNameParam , may be null
     * </pre>
     */
    public void setZoneName(final String zoneNameParam) {
        this.zoneName = zoneNameParam;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((propertyType == null) ? 0 : propertyType.hashCode());
        result = prime * result + ((residentStatus == null) ? 0 : residentStatus.hashCode());
        result = prime * result + ((zoneName == null) ? 0 : zoneName.hashCode());
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
        TaxId other = (TaxId) obj;
        if (propertyType == null) {
            if (other.propertyType != null)
                return false;
        }
        else if (!propertyType.equals(other.propertyType))
            return false;
        if (residentStatus == null) {
            if (other.residentStatus != null)
                return false;
        }
        else if (!residentStatus.equals(other.residentStatus))
            return false;
        if (zoneName == null) {
            if (other.zoneName != null)
                return false;
        }
        else if (!zoneName.equals(other.zoneName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TaxId [propertyType=" + propertyType + ", residentStatus=" + residentStatus + ", zoneName=" + zoneName
            + "]";
    }
    
    

}
