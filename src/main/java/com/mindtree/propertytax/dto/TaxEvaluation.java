package com.mindtree.propertytax.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * <pre>
 * <b>Description : </b>
 * TaxEvaluation. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:31 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
public class TaxEvaluation {

    /**
     * int yearOfAssessment.
     */
    @NotNull(message = "{taxevaluation.yearOfAssessment.notnull}")
    @Max(value = 2019 , message = "{taxevaluation.yearOfAssessment.max}")
    @Min(value= 1890 , message = "{taxevaluation.yearOfAssessment.min}")
    private int yearOfAssessment;

    /**
     * String nameOfOwner.
     */
    @NotNull(message="{taxevaluation.nameOfOwner.notnull}")
    @Size(min=2 , max = 50 , message = "{taxevaluation.nameOfOwner.size}")
    @Pattern(regexp="[A-za-z(\\s)]+" ,  message = "{taxevaluation.nameOfOwner.pattern}")
    private String nameOfOwner;

    /**
     * String email.
     */
    @NotNull( message = "{taxevaluation.email.notnull}")
    @Email( message = "{taxevaluation.email.email}")
    private String email;

    /**
     * String adressOfProperty.
     */
    @NotNull( message = "{taxevaluation.adressOfProperty.notnull}")
    @Size(min=2 , max = 100 ,  message = "{taxevaluation.adressOfProperty.size}")
    private String adressOfProperty;

    /**
     * String zone.
     */
    private String zone;

    /**
     * String property.
     */
    private String property;

    /**
     * String status.
     */
    private String status;

    /**
     * int constructionYear.
     */
    @NotNull( message = "{taxevaluation.constructionYear.notnull}")
    @Min(value=1 ,  message = "{taxevaluation.constructionYear.min}")
    @Max(value=2019 , message = "{taxevaluation.constructionYear.max}")
    private int constructionYear;

    /**
     * double buildArea.
     */
    @NotNull( message = "{taxevaluation.buildArea.notnull}")
    @Min(value = 1 , message = "{taxevaluation.buildArea.min}")
    private double buildArea;

    /**
     * double payableTax.
     */
    private double payableTax;

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'int' attribute value.
     *
     * @return int , null if not found
     * </pre>
     */
    public int getYearOfAssessment() {
        return yearOfAssessment;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'yearOfAssessmentParam' attribute value.
     *
     * @param yearOfAssessmentParam , may be null
     * </pre>
     */
    public void setYearOfAssessment(final int yearOfAssessmentParam) {
        this.yearOfAssessment = yearOfAssessmentParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getNameOfOwner() {
        return nameOfOwner;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'nameOfOwnerParam' attribute value.
     *
     * @param nameOfOwnerParam , may be null
     * </pre>
     */
    public void setNameOfOwner(final String nameOfOwnerParam) {
        this.nameOfOwner = nameOfOwnerParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getEmail() {
        return email;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'emailParam' attribute value.
     *
     * @param emailParam , may be null
     * </pre>
     */
    public void setEmail(final String emailParam) {
        this.email = emailParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getAdressOfProperty() {
        return adressOfProperty;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'adressOfPropertyParam' attribute value.
     *
     * @param adressOfPropertyParam , may be null
     * </pre>
     */
    public void setAdressOfProperty(final String adressOfPropertyParam) {
        this.adressOfProperty = adressOfPropertyParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getZone() {
        return zone;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'zoneParam' attribute value.
     *
     * @param zoneParam , may be null
     * </pre>
     */
    public void setZone(final String zoneParam) {
        this.zone = zoneParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getProperty() {
        return property;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'propertyParam' attribute value.
     *
     * @param propertyParam , may be null
     * </pre>
     */
    public void setProperty(final String propertyParam) {
        this.property = propertyParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'String' attribute value.
     *
     * @return String , null if not found
     * </pre>
     */
    public String getStatus() {
        return status;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'statusParam' attribute value.
     *
     * @param statusParam , may be null
     * </pre>
     */
    public void setStatus(final String statusParam) {
        this.status = statusParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'int' attribute value.
     *
     * @return int , null if not found
     * </pre>
     */
    public int getConstructionYear() {
        return constructionYear;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'constructionYearParam' attribute value.
     *
     * @param constructionYearParam , may be null
     * </pre>
     */
    public void setConstructionYear(final int constructionYearParam) {
        this.constructionYear = constructionYearParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'double' attribute value.
     *
     * @return double , null if not found
     * </pre>
     */
    public double getBuildArea() {
        return buildArea;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'buildAreaParam' attribute value.
     *
     * @param buildAreaParam , may be null
     * </pre>
     */
    public void setBuildArea(final double buildAreaParam) {
        this.buildArea = buildAreaParam;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'double' attribute value.
     *
     * @return double , null if not found
     * </pre>
     */
    public double getPayableTax() {
        return payableTax;
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Set the 'payableTaxParam' attribute value.
     *
     * @param payableTaxParam , may be null
     * </pre>
     */
    public void setPayableTax(final double payableTaxParam) {
        this.payableTax = payableTaxParam;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((adressOfProperty == null) ? 0 : adressOfProperty.hashCode());
        long temp;
        temp = Double.doubleToLongBits(buildArea);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + constructionYear;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((nameOfOwner == null) ? 0 : nameOfOwner.hashCode());
        temp = Double.doubleToLongBits(payableTax);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((property == null) ? 0 : property.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + yearOfAssessment;
        result = prime * result + ((zone == null) ? 0 : zone.hashCode());
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
        TaxEvaluation other = (TaxEvaluation) obj;
        if (adressOfProperty == null) {
            if (other.adressOfProperty != null)
                return false;
        }
        else if (!adressOfProperty.equals(other.adressOfProperty))
            return false;
        if (Double.doubleToLongBits(buildArea) != Double.doubleToLongBits(other.buildArea))
            return false;
        if (constructionYear != other.constructionYear)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (nameOfOwner == null) {
            if (other.nameOfOwner != null)
                return false;
        }
        else if (!nameOfOwner.equals(other.nameOfOwner))
            return false;
        if (Double.doubleToLongBits(payableTax) != Double.doubleToLongBits(other.payableTax))
            return false;
        if (property == null) {
            if (other.property != null)
                return false;
        }
        else if (!property.equals(other.property))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        }
        else if (!status.equals(other.status))
            return false;
        if (yearOfAssessment != other.yearOfAssessment)
            return false;
        if (zone == null) {
            if (other.zone != null)
                return false;
        }
        else if (!zone.equals(other.zone))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TaxEvaluation [yearOfAssessment=" + yearOfAssessment + ", nameOfOwner=" + nameOfOwner + ", email="
            + email + ", adressOfProperty=" + adressOfProperty + ", zone=" + zone + ", property=" + property
            + ", status=" + status + ", constructionYear=" + constructionYear + ", buildArea=" + buildArea
            + ", payableTax=" + payableTax + "]";
    }
    
    

}
