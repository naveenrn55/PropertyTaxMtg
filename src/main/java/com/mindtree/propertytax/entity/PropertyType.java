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
 * PropertyType. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:43 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
@Entity
@Table(name = "propertytype")
public class PropertyType {
    /**
     * int id.
     */
    @Id
    @GenericGenerator(name = "sequence", strategy = "increment")
    @GeneratedValue(generator = "sequence")
    private int id;
    /**
     * String propertyType.
     */
    @Column
    private String propertyType;

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'int' attribute value.
     *
     * @return int , null if not found
     * </pre>
     */
    public int getId() {
        return id;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'idParam' attribute value.
     *
     * @param idParam , may be null
     * </pre>
     */
    public void setId(final int idParam) {
        this.id = idParam;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((propertyType == null) ? 0 : propertyType.hashCode());
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
        PropertyType other = (PropertyType) obj;
        if (id != other.id)
            return false;
        if (propertyType == null) {
            if (other.propertyType != null)
                return false;
        }
        else if (!propertyType.equals(other.propertyType))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PropertyType [id=" + id + ", propertyType=" + propertyType + "]";
    }
    
    

}
