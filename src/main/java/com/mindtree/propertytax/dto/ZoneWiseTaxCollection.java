package com.mindtree.propertytax.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * <b>Description : </b>
 * ZoneWiseTaxCollection. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:31 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
public class ZoneWiseTaxCollection {
    
    /**
	 * String zoneName.
	 */
    String zoneName;
    /**
	 * Map<String,Double> taxCollectedMap.
	 */
    Map<String , Double> taxCollectedMap = new HashMap<>();
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
    /**
	 * <pre>
	 * <b>Description : </b>
	 * Get the 'Map<String,Double>' attribute value.
	 *
	 * @return Map<String,Double> , null if not found
	 * </pre>
	 */
    public Map<String, Double> getTaxCollectedMap() {
        return taxCollectedMap;
    }
    /**
	 * <pre>
	 * <b>Description : </b>
	 * Set the 'taxCollectedMapParam' attribute value.
	 *
	 * @param taxCollectedMapParam , may be null
	 * </pre>
	 */
    public void setTaxCollectedMap(final Map<String, Double> taxCollectedMapParam) {
        this.taxCollectedMap = taxCollectedMapParam;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taxCollectedMap == null) ? 0 : taxCollectedMap.hashCode());
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
        ZoneWiseTaxCollection other = (ZoneWiseTaxCollection) obj;
        if (taxCollectedMap == null) {
            if (other.taxCollectedMap != null)
                return false;
        }
        else if (!taxCollectedMap.equals(other.taxCollectedMap))
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
        return "ZoneWiseTaxCollection [zoneName=" + zoneName + ", taxCollectedMap=" + taxCollectedMap + "]";
    }
    
    
    

}