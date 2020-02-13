/*
 * This code contains copyright information which is the proprietary property
 * of SITA Information Network Computing Limited (SITA). No part of this
 * code may be reproduced, stored or transmitted in any form without the prior
 * written permission of SITA.
 * 
 * Copyright (C) SITA Information Networking Computing UK Limited 2010-2015
 * Confidential.
 * All rights reserved.
 */
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
 * Zone. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:43 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
@Entity
@Table(name = "zone")
public class Zone {
    /**
     * int id.
     */
    @Id
    @GenericGenerator(name = "zone", strategy = "increment")
    @GeneratedValue(generator = "zone")
    private int id;
    /**
     * String zoneName.
     */
    @Column
    private String zoneName;

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
        result = prime * result + id;
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
        Zone other = (Zone) obj;
        if (id != other.id)
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
        return "Zone [id=" + id + ", zoneName=" + zoneName + "]";
    }
    
    

}
