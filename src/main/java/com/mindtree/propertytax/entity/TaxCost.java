package com.mindtree.propertytax.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * <pre>
 * <b>Description : </b>
 * TaxCost. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:43 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
/**
 * <pre>
 * <b>Description : </b>
 * <<WRITE DESCRIPTION HERE>>
 * 
 * @version $Revision: 1 $ $Date: YYYY-MM-DD 2:38:07 PM $
 * @author $Author: <<name.surname>> $ 
 * </pre>
 */
@Entity
public class TaxCost {

    /**
     * TaxId taxId.
     */
    @EmbeddedId
    private TaxId taxId;
    /**
     * double tax.
     */
    @Column
    private double tax;

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'TaxId' attribute value.
     *
     * @return TaxId , null if not found
     * </pre>
     */
    public TaxId getTaxId() {
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
    public void setTaxId(final TaxId taxIdParam) {
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
    public double getTax() {
        return tax;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'taxParam' attribute value.
     *
     * @param taxParam , may be null
     * </pre>
     */
    public void setTax(final double taxParam) {
        this.tax = taxParam;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(tax);
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
        TaxCost other = (TaxCost) obj;
        if (Double.doubleToLongBits(tax) != Double.doubleToLongBits(other.tax))
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
        return "TaxCost [taxId=" + taxId + ", tax=" + tax + "]";
    }

}
