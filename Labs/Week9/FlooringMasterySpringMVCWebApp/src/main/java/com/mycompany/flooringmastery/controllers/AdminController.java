/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.controllers;

import com.mycompany.flooringmastery.dao.OrderDao;
import com.mycompany.flooringmastery.dao.ProductDao;
import com.mycompany.flooringmastery.dao.TaxDao;
import com.mycompany.flooringmastery.dto.Product;
import com.mycompany.flooringmastery.dto.ProductCommand;
import com.mycompany.flooringmastery.dto.Tax;
import com.mycompany.flooringmastery.dto.TaxCommand;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
@RequestMapping({"/admin"})
public class AdminController {
    private ProductDao productDao;
    private TaxDao taxDao;
    
    @Inject
    public AdminController(ProductDao productDao, TaxDao taxDao) {
        this.taxDao = taxDao;
        this.productDao = productDao;
    }
    
    @RequestMapping(value="/menu")
    public String menu(@Valid @ModelAttribute("menu") Product product, BindingResult result, Map<String, Object> model) {
        List<Product> products = productDao.getAll();
        List<Tax> taxes = taxDao.getAll();
        
        
        if (result.hasErrors()) {
            model.put("products", products);
            model.put("taxes", taxes);
            model.put("product", new Product());
            model.put("tax", new Tax());
            return "admin";
        }
        
        model.put("products", products);
        model.put("taxes", taxes);
        model.put("product", new Product());
        model.put("tax", new Tax());
        
        
        return "admin";
    }
    @RequestMapping(value="/product", method=RequestMethod.POST)
    @ResponseBody
    public Product addProduct(@Valid @RequestBody ProductCommand command) {
        Product product = new Product();
        product.setType(command.getType());
        product.setMaterialCostPerSF(command.getMaterialCostPerSF());
        product.setLaborCostPerSF(command.getLaborCostPerSF());
        
        productDao.create(product);
        
        return product;
    }
    @RequestMapping(value="/tax", method=RequestMethod.POST)
    @ResponseBody
    public Tax addTax(@Valid @RequestBody TaxCommand command) {
        Tax tax = new Tax();
        tax.setState(command.getState());
        tax.setTaxRate(command.getTaxRate());
        taxDao.create(tax);
        
        return tax;
    }
    @RequestMapping(value="/editProduct", method=RequestMethod.GET)
    public String editProduct(@RequestParam("type") String type, Map<String, Object> model) {
        
        Product product = productDao.find(type);
        model.put("product", product);
        
        return "editProduct";
    }
    @RequestMapping(value="/editTax", method=RequestMethod.GET)
    public String editTax(@RequestParam("state") String state, Map<String, Object> model) {
        
        Tax tax = taxDao.find(state);
        model.put("tax", tax);
        
        return "editTax";
    }
    @RequestMapping(value="/product", method=RequestMethod.PUT)
    @ResponseBody
    public Product editProductSubmit(@RequestBody Product product) {
        
        productDao.update(product);
        return product;
    }
    @RequestMapping(value="/tax", method=RequestMethod.PUT)
    @ResponseBody
    public Tax editTaxSubmit(@RequestBody Tax tax) {
        
        taxDao.update(tax);
        return tax;
    }
    @RequestMapping(value="/tax/{state}", method=RequestMethod.GET)
    @ResponseBody
    public Tax showTax(@PathVariable("state") String state) {
        
        return taxDao.find(state);
    }
    @RequestMapping(value="/product/{type}", method=RequestMethod.GET)
    @ResponseBody
    public Product showProduct(@PathVariable("type") String type) {
        
        return productDao.find(type);
    }
    @RequestMapping(value="/tax/{state}", method=RequestMethod.DELETE)
    @ResponseBody
    public void deleteTax(@PathVariable("state") String state) {
        Tax tax = taxDao.find(state);
        taxDao.delete(tax);
    }
    @RequestMapping(value="/product/{type}", method=RequestMethod.DELETE)
    @ResponseBody
    public void deleteProduct(@PathVariable("type") String type) {
        Product product = productDao.find(type);
        productDao.delete(product);
    }
}

