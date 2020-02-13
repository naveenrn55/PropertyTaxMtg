package com.mindtree.propertytax.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <pre>
 * <b>Description : </b>
 * ResidentialStatus. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:43 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
@Entity
@Table(name = "residentialstatus")
public class ResidentialStatus {
    /**
     * int srNo.
     */
    @Id
    @GenericGenerator(name = "residentStatus", strategy = "increment")
    @GeneratedValue(generator = "residentStatus")
    private int srNo;
    /**
     * String residentStatus.
     */
    @Column
    private String residentStatus;

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'int' attribute value.
     *
     * @return int , null if not found
     * </pre>
     */
    public int getSrNo() {
        return srNo;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'srNoParam' attribute value.
     *
     * @param srNoParam , may be null
     * </pre>
     */
    public void setSrNo(final int srNoParam) {
        this.srNo = srNoParam;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((residentStatus == null) ? 0 : residentStatus.hashCode());
        result = prime * result + srNo;
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
        ResidentialStatus other = (ResidentialStatus) obj;
        if (residentStatus == null) {
            if (other.residentStatus != null)
                return false;
        }
        else if (!residentStatus.equals(other.residentStatus))
            return false;
        if (srNo != other.srNo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ResidentialStatus [srNo=" + srNo + ", residentStatus=" + residentStatus + "]";
    }

    
}
