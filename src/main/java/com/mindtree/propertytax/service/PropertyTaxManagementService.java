package com.mindtree.propertytax.service;

import java.util.List;

import com.mindtree.propertytax.dto.TaxEvaluation;
import com.mindtree.propertytax.dto.TaxFormData;
import com.mindtree.propertytax.dto.ZoneWiseTaxCollection;
import com.mindtree.propertytax.exceptions.InsufficientInformationException;

/**
 * <pre>
 * <b>Description : </b>
 * PropertyTaxManagementService. 
 *
 * @version $Revision: 001 $ $Date: 2019-09-13 11:12:53 $
 * @author $Author: ketan.hulaji2 $
 * </pre>
 */
public interface PropertyTaxManagementService {

    /**
     * <pre>
     * <b>Description : </b>
     * retrieveAllCollectedTaxData.
     *
     * @return List<ZoneWiseTaxCollection> , null if not found
     * </pre>
     */
    public List<ZoneWiseTaxCollection> retrieveAllCollectedTaxData();

    /**
     * <pre>
     * <b>Description : </b>
     * Get the 'TaxFormData' attribute value.
     *
     * @return TaxFormData , null if not found
     * </pre>
     * @throws InsufficientInformationException 
     */
    public TaxFormData getFormData() throws InsufficientInformationException;

    /**
     * <pre>
     * <b>Description : </b>
     * calculateTax.
     *
     * @param taxEvaluation , may be null
     * @return double , null if not found
     * </pre>
     */
    public double calculateTax(final TaxEvaluation taxEvaluation);

    /**
     * <pre>
     * <b>Description : </b>
     * submitTax.
     * 
     * @param taxEvaluation , may be null
     * </pre>
     */
    public void submitTax(TaxEvaluation taxEvaluation);

}
