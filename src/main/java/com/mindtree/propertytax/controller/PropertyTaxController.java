package com.mindtree.propertytax.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.propertytax.dto.TaxEvaluation;
import com.mindtree.propertytax.dto.TaxFormData;
import com.mindtree.propertytax.dto.ZoneWiseTaxCollection;
import com.mindtree.propertytax.exceptions.InsufficientInformationException;
import com.mindtree.propertytax.service.PropertyTaxManagementService;

@Controller
public class PropertyTaxController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, ste);
    }

    /**
     * logger.
     */
    private static final Logger LOGGER = Logger.getLogger(PropertyTaxController.class);
    /**
     * propertyTaxMngmntService.
     */
    @Autowired
    private PropertyTaxManagementService propertyTaxMngmntService;

    @RequestMapping(value = {"/" , "" , "/home"})
    public String homePage() {
        LOGGER.debug("Entry : homePage method ");
        return "home";
    }

    @RequestMapping(value = "/taxEvaluation")
    public String taxEvaluation(Model model) {
        LOGGER.debug("Entry : taxEvaluation method ");
        TaxFormData formData;
        try {
            formData = propertyTaxMngmntService.getFormData();
            model.addAttribute("formData", formData);
            model.addAttribute("taxEvaluation", new TaxEvaluation());
            return "taxEvaluation";
        }
        catch (InsufficientInformationException exp) {
            model.addAttribute("error", exp.getLocalizedMessage());
            return "errorPage";
        }
     
    }

    @RequestMapping(value = "/submitTax", method = RequestMethod.POST)
    public String saveTax(@Valid @ModelAttribute("taxEvaluation") TaxEvaluation taxEvaluation, BindingResult result,
        Model model) {
        LOGGER.debug("Entry : saveTax method ");
        if (result.hasErrors()) {
            TaxFormData formData;
            try {
                formData = propertyTaxMngmntService.getFormData();
                model.addAttribute("formData", formData);
                model.addAttribute("taxEvaluation", taxEvaluation);
                LOGGER.debug("Exit : saveTax method as validation errors exists");
                return "taxEvaluation";
            }
            catch (InsufficientInformationException exp) {
                model.addAttribute("error", exp.getLocalizedMessage());
                return "errorPage";
            }
        }
        model.addAttribute("taxEvaluation", taxEvaluation);
        propertyTaxMngmntService.submitTax(taxEvaluation);
        LOGGER.debug("Exit : saveTax method after save is successfull");
        model.addAttribute("submit" ,"success");
        return "home";
    }

    public String cancel() {
        LOGGER.debug("Entry : cancel method ");
        return "home";
    }

    @RequestMapping(value = "/taxCollection")
    public String taxCollection() {

        LOGGER.debug("Entry : taxCollection method ");
        return "taxCollection";
    }

    @RequestMapping(value = "/collectedTax", method = RequestMethod.POST)
    @ResponseBody
    public List<ZoneWiseTaxCollection> collectedTax() {
        LOGGER.debug("Entry : collectedTax method ");
        return propertyTaxMngmntService.retrieveAllCollectedTaxData();
    }

    @RequestMapping(value = "/calculateTax", method = RequestMethod.POST)
    @ResponseBody
    public double calculateTax(@RequestBody TaxEvaluation taxEvaluation) {
        LOGGER.debug("Entry : calculateTax method ");
        return propertyTaxMngmntService.calculateTax(taxEvaluation);
    }

}
