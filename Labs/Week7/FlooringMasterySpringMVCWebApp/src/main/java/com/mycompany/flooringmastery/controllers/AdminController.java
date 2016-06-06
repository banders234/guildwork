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
import com.mycompany.flooringmastery.dto.Tax;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(value="/addProduct", method=RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Map<String, Object> model) {
        
        List<Product> products = productDao.getAll();
        List<Tax> taxes = taxDao.getAll();
        
        if (result.hasErrors()) {
            model.put("products", products);
            model.put("taxes", taxes);
            model.put("tax", new Tax());
            model.put("product", product);
            return "admin";
        }
        if (productDao.containsType(product.getType())) {
            model.put("products", products);
            model.put("taxes", taxes);
            model.put("productMessage", "That product already exists");
            model.put("tax", new Tax());
            model.put("product", product);
            return "admin";
        }
        productDao.create(product);
        
        return "redirect:/admin/menu";
    }
    @RequestMapping(value="/addTax", method=RequestMethod.POST)
    public String addTax(@Valid @ModelAttribute("tax") Tax tax, BindingResult result, Map<String, Object> model) {
        
        List<Product> products = productDao.getAll();
        List<Tax> taxes = taxDao.getAll();
        
        if (result.hasErrors()) {
            model.put("products", products);
            model.put("taxes", taxes);
            model.put("tax", tax);
            model.put("product", new Product());
            return "admin";
        }
        if(taxDao.containsState(tax.getState())) {
            model.put("products", products);
            model.put("taxes", taxes);
            model.put("taxMessage", "That state already exists");
            model.put("tax", tax);
            model.put("product", new Product());
            return "admin";
        }
        taxDao.create(tax);
        
        return "redirect:/admin/menu";
    }
    @RequestMapping(value="/deleteProduct", method=RequestMethod.GET)
    public String deleteProduct(@RequestParam("type") String type) {
        
        Product product = productDao.find(type);
        productDao.delete(product);
        
        return "redirect:/admin/menu";
    }
    @RequestMapping(value="/deleteTax", method=RequestMethod.GET)
    public String deleteTax(@RequestParam("state") String state) {
        
        Tax tax = taxDao.find(state);
        taxDao.delete(tax);
        
        return "redirect:/admin/menu";
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
    @RequestMapping(value="/editProduct", method=RequestMethod.POST)
    public String editProductSubmit(@ModelAttribute("product") Product product) {
        
        productDao.update(product);
        
        return "redirect:/admin/menu";
    }
    @RequestMapping(value="/editTax", method=RequestMethod.POST)
    public String editTaxSubmit(@ModelAttribute("tax") Tax tax) {
        
        taxDao.update(tax);
        
        return "redirect:/admin/menu";
    }
}

