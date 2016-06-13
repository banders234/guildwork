 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.controllers;


import com.mycompany.flooringmastery.dao.OrderDao;
import com.mycompany.flooringmastery.dao.ProductDao;
import com.mycompany.flooringmastery.dao.TaxDao;
import com.mycompany.flooringmastery.dto.OrderCommandObject;
import com.mycompany.flooringmastery.dto.Order;
import com.mycompany.flooringmastery.dto.Product;
import com.mycompany.flooringmastery.dto.Tax;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@RequestMapping(value="/order")
public class OrderController {
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    private OrderDao orderDao;
    private ProductDao productDao;
    private TaxDao taxDao;
    @Inject
    public OrderController(OrderDao dao, ProductDao productDao, TaxDao taxDao) {
        this.orderDao = dao;
        this.taxDao = taxDao;
        this.productDao = productDao;
    }
    
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("order") Order order, BindingResult result, Map<String, Object> model) {
        
        if (result.hasErrors()) {
            List<Order> orders = orderDao.getAll();
            List<Tax> taxes = taxDao.getAll();
            List<Product> products = productDao.getAll();
            List<Date> dateList = orderDao.getAllDates();
            
            model.put("dateList", dateList);
            model.put("taxes", taxes);
            model.put("products", products);
            model.put("orders", orders);
            model.put("order", order);
            return "home";
        }
        Product product = productDao.find(order.getProductType());
        Tax tax = taxDao.find(order.getState());
        double area= order.getArea();
        double taxRate = tax.getTaxRate();
        
        order.setTaxRate(taxRate);
        
        double materialCostPerSF = product.getMaterialCostPerSF();
        double laborCostPerSF = product.getLaborCostPerSF();
        
        order.setMaterialCostPerSF(materialCostPerSF);
        order.setLaborCostPerSF(laborCostPerSF);
        order.setMaterialCost(materialCostPerSF*area);
        order.setLaborCost(laborCostPerSF*area);
        
        double subtotal = (materialCostPerSF*area)+(laborCostPerSF*area);
        double taxTotal = (taxRate/100)*subtotal;
        
        order.setTax(taxTotal);
        order.setTotal(taxTotal+subtotal);
        
        model.put("order", order);
        model.put("subtotal", subtotal);
        return "confirmation";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public Order editSubmit(@RequestBody Order order) {
        orderDao.update(order);
        return order;
    }
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public String confirmDelete(@RequestParam("orderNumber") int orderNumber, Map<String,Object> model) {
        Order myOrder = orderDao.findOrderByNo(orderNumber);
        model.put("order", myOrder);
        return "deleteConfirmation";
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") Integer id) {
        Order myOrder = orderDao.findOrderByNo(id);
        orderDao.delete(myOrder);
        return "redirect:/";
    }
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public String editConfirm(@ModelAttribute("order") Order order) {
        
        orderDao.update(order);
        return "redirect:/";
    }
    
    @RequestMapping(value="", method=RequestMethod.PUT)
    @ResponseBody
    public Order update(@Valid @RequestBody OrderCommandObject command) {
        Product product;
        Tax tax;
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Order order = new Order();
        order.setOrderNumber(command.getId());
        String dateString = command.getDate();
        try {
            order.setDate(sdf2.parse(dateString));
            order.setDateString(sdf.format(order.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String customerName= command.getCustomerName();
        order.setCustomerName(customerName);
        
        String productType = command.getProductType();
        order.setProductType(productType);
        
        String state = command.getState();
        order.setState(state);
        
        double area= command.getArea();
        order.setArea(area);
        
        product = productDao.find(productType);
        tax = taxDao.find(state);
        double taxRate = tax.getTaxRate();
        
        order.setTaxRate(taxRate);
        double materialCostPerSF = product.getMaterialCostPerSF();
        double laborCostPerSF = product.getLaborCostPerSF();
        
        order.setMaterialCostPerSF(materialCostPerSF);
        order.setLaborCostPerSF(laborCostPerSF);
        order.setMaterialCost(materialCostPerSF*area);
        order.setLaborCost(laborCostPerSF*area);
        
        double subtotal = (materialCostPerSF*area)+(laborCostPerSF*area);
        double taxTotal = (taxRate/100)*subtotal;
        
        order.setTax(taxTotal);
        order.setTotal(taxTotal+subtotal);
        orderDao.update(order);
        return order;
    }
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Order show(@PathVariable("id") Integer id) {
        Order myOrder = orderDao.findOrderByNo(id);
        return myOrder;
    }
    @RequestMapping(value="", method=RequestMethod.POST)
    @ResponseBody
    public Order save(@Valid @RequestBody OrderCommandObject command, Map<String, Object> model) {
        Product product;
        Tax tax;
        Order order = new Order();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = command.getDate();
        System.out.println(dateString);
        try {
            order.setDate(sdf2.parse(dateString));
            order.setDateString(sdf.format(order.getDate()));
        } catch (ParseException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String customerName= command.getCustomerName();
        order.setCustomerName(customerName);
        System.out.println(order.getDate());
        String productType = command.getProductType();
        order.setProductType(productType);
        
        String state = command.getState();
        order.setState(state);
        
        double area= command.getArea();
        order.setArea(area);
        product = productDao.find(productType);
        tax = taxDao.find(state);
        double taxRate = tax.getTaxRate();
        
        order.setTaxRate(taxRate);
        double materialCostPerSF = product.getMaterialCostPerSF();
        double laborCostPerSF = product.getLaborCostPerSF();
        
        order.setMaterialCostPerSF(materialCostPerSF);
        order.setLaborCostPerSF(laborCostPerSF);
        order.setMaterialCost(materialCostPerSF*area);
        order.setLaborCost(laborCostPerSF*area);
        
        double subtotal = (materialCostPerSF*area)+(laborCostPerSF*area);
        double taxTotal = (taxRate/100)*subtotal;
        
        order.setTax(taxTotal);
        order.setTotal(taxTotal+subtotal);
        orderDao.create(order);
        return order;
    }
    @RequestMapping(value="/discard", method=RequestMethod.POST)
    public String discard() {
        return "redirect:/";
    }
    @RequestMapping(value="/table", method=RequestMethod.GET)
    public String table(Map<String, Object> model) {
        
        List<Order> orders = orderDao.getAll();
        model.put("orders", orders);
        
        return "fulltable";
    }
    @RequestMapping(value="/filterByDate", method=RequestMethod.POST)
    public String filterByDate(@RequestParam("dateString") String dateString, Map<String, Object> model) {
        try {
            Date date = sdf.parse(dateString);
            List<Order> orders = orderDao.getOrdersOnDate(date);
            List<Date> dateList = orderDao.getAllDates();
            List<Product> products = productDao.getAll();
            List<Tax> taxes = taxDao.getAll();
            Order order = new Order();
            model.put("selectedDateString", dateString);
            model.put("order", order);
            model.put("orders", orders);
            model.put("taxes", taxes);
            model.put("products", products);
            model.put("dateList", dateList);
        } catch (ParseException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "home";
    }
}
