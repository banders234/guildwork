/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.validation;

import com.mycompany.flooringmastery.dao.TaxDao;
import java.lang.annotation.Annotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author apprentice
 */

public class StateExistsValidator implements ConstraintValidator<StateExists, String> {

 private Log log = LogFactory.getLog(StateExistsValidator.class);
 
    @Autowired
    private TaxDao taxDao;
 
    private StateExists stateExists;
 

    @Override
    public boolean isValid(String target, ConstraintValidatorContext context) {
  
        try {
            boolean exists = taxDao.containsState(target);
            if (exists) {
                return false;
            }
        } catch (Exception e) {
            log.error(e);
        }
            return true;
    }

    public void setTaxDao(TaxDao taxDao) {
        this.taxDao = taxDao;
    }

    @Override
    public void initialize(StateExists a) {
        this.stateExists = a;
    }

}
