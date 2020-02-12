package com.mindtree.propertytax.entity;

import java.util.Comparator;

/**
 * <pre>
 * <b>Description : </b>
 * TaxCostComparator. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:43 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
public class TaxCostComparator implements Comparator<CollectedTax> {

    /**
     * <pre>
     * <b>Description : </b>
     * compare.
     *
     * @param taxCost1 , may be null
     * @param taxCost2 , may be null
     * @return int , null if not found
     * </pre>
     */
    @Override
    public int compare(final CollectedTax taxCost1, final CollectedTax taxCost2) {
        return taxCost1.getTaxId().getZoneName().compareTo(taxCost1.getTaxId().getZoneName());
    }

}
