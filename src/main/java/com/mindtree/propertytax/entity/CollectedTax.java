package com.mindtree.propertytax.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * <b>Description : </b>
 * CollectedTax. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:43 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
@Entity
@Table(name = "collectedtax")
public class CollectedTax {
    /**
     * CollectedTaxId taxId.
     */
    @Id
    private CollectedTaxId taxId;
    /**
     * double collectedTax.
     */
    @Column
    private double collectedTax;

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'CollectedTaxId' attribute value.
     *
     * @return CollectedTaxId , null if not found
     * </pre>
     */
    public CollectedTaxId getTaxId() {
        return taxId;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'taxIdParam' attribute value.
     *
     * @param taxIdParam , may be null
     * </pre>
     */
    public void setTaxId(final CollectedTaxId taxIdParam) {
        this.taxId = taxIdParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'double' attribute value.
     *
     * @return double , null if not found
     * </pre>
     */
    public double getCollectedTax() {
        return collectedTax;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'collectedTaxParam' attribute value.
     *
     * @param collectedTaxParam , may be null
     * </pre>
     */
    public void setCollectedTax(final double collectedTaxParam) {
        this.collectedTax = collectedTaxParam;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(collectedTax);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((taxId == null) ? 0 : taxId.hashCode());
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
        CollectedTax other = (CollectedTax) obj;
        if (Double.doubleToLongBits(collectedTax) != Double.doubleToLongBits(other.collectedTax))
            return false;
        if (taxId == null) {
            if (other.taxId != null)
                return false;
        }
        else if (!taxId.equals(other.taxId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CollectedTax [taxId=" + taxId + ", collectedTax=" + collectedTax + "]";
    }
    
    

}
