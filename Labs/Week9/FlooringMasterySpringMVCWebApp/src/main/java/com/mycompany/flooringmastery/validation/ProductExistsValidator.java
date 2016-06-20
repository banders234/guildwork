/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.validation;

import com.mycompany.flooringmastery.dao.ProductDao;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author apprentice
 */

public class ProductExistsValidator implements ConstraintValidator<ProductExists, String> {

 private Log log = LogFactory.getLog(ProductExistsValidator.class);
 
    @Autowired
    private ProductDao productDao;
 
    private ProductExists productExists;
 

    @Override
    public boolean isValid(String target, ConstraintValidatorContext context) {
  
        try {
            boolean exists = productDao.containsType(target);
            if (exists) {
                return false;
            }
        } catch (Exception e) {
            log.error(e);
        }
            return true;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void initialize(ProductExists a) {
        this.productExists = a;
    }

}
