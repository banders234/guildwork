 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.controllers;


import com.mycompany.flooringmastery.dao.OrderDao;
import com.mycompany.flooringmastery.dao.ProductDao;
import com.mycompany.flooringmastery.dao.TaxDao;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        double taxTotal = taxRate*subtotal;
        
        order.setTax(taxTotal);
        order.setTotal(taxTotal+subtotal);
        
        model.put("order", order);
        model.put("subtotal", subtotal);
        return "confirmation";
    }
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String edit(@ModelAttribute Order order, Map<String, Object> model) {
        Order myOrder = orderDao.findOrderByNo(order.getOrderNumber());
        List<Tax> taxes = taxDao.getAll();
        List<Product> products = productDao.getAll();
        model.put("taxes", taxes);
        model.put("products", products);
        model.put("order", myOrder);
        return "edit";
    }
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public String confirmDelete(@RequestParam("orderNumber") int orderNumber, Map<String,Object> model) {
        Order myOrder = orderDao.findOrderByNo(orderNumber);
        model.put("order", myOrder);
        return "deleteConfirmation";
    }
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public String delete(@RequestParam("orderNumber") int orderNumber) {
        Order myOrder = orderDao.findOrderByNo(orderNumber);
        orderDao.delete(myOrder);
        return "redirect:/";
    }
    @RequestMapping(value="/edit", method=RequestMethod.POST)
    public String editConfirm(@ModelAttribute("order") Order order) {
        
        orderDao.update(order);
        return "redirect:/";
    }
    
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@RequestParam("orderNumber") Integer orderNumber,
                        @RequestParam("customerName") String customerName,
                        @RequestParam("date") String dateString,
                        @RequestParam("state") String state,
                        @RequestParam("productType") String productType,
                        @RequestParam("area") String areaString,
                        Map<String, Object> model) {
        Order order = new Order();
        Product product;
        Tax tax;
        order.setOrderNumber(orderNumber);
        order.setCustomerName(customerName);
        try {
            order.setDate(sdf.parse(dateString));
        } catch (ParseException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        double area = Double.parseDouble(areaString);
        order.setArea(area);
        order.setProductType(productType);
        product = productDao.find(productType);
        tax = taxDao.find(state);
        order.setState(state);
        double taxRate = tax.getTaxRate();
        
        order.setTaxRate(taxRate);
        
        double materialCostPerSF = product.getMaterialCostPerSF();
        double laborCostPerSF = product.getLaborCostPerSF();
        
        order.setMaterialCostPerSF(materialCostPerSF);
        order.setLaborCostPerSF(laborCostPerSF);
        order.setMaterialCost(materialCostPerSF*area);
        order.setLaborCost(laborCostPerSF*area);
        
        double subtotal = (materialCostPerSF*area)+(laborCostPerSF*area);
        double taxTotal = taxRate*subtotal;
        
        order.setTax(taxTotal);
        order.setTotal(taxTotal+subtotal);
        model.put("order", order);
        return "editConfirmation";
    }
    @RequestMapping(value="/show", method=RequestMethod.GET)
    public String show(Map<String, Object> model, @ModelAttribute Order order) {
        Order myOrder = orderDao.findOrderByNo(order.getOrderNumber());
        model.put("order", myOrder);
        return "show";
    }
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@RequestParam("customerName") String customerName,
                        @RequestParam("date") String dateString,
                        @RequestParam("state") String state,
                        @RequestParam("productType") String productType,
                        @RequestParam("area") String areaString,
                        Map<String, Object> model) {
        Order order = new Order();
        Product product;
        Tax tax;
        order.setCustomerName(customerName);
        try {
            order.setDate(sdf.parse(dateString));
        } catch (ParseException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        double area = Double.parseDouble(areaString);
        order.setArea(area);
        order.setProductType(productType);
        product = productDao.find(productType);
        tax = taxDao.find(state);
        order.setState(state);
        double taxRate = tax.getTaxRate();
        
        order.setTaxRate(taxRate);
        
        double materialCostPerSF = product.getMaterialCostPerSF();
        double laborCostPerSF = product.getLaborCostPerSF();
        
        order.setMaterialCostPerSF(materialCostPerSF);
        order.setLaborCostPerSF(laborCostPerSF);
        order.setMaterialCost(materialCostPerSF*area);
        order.setLaborCost(laborCostPerSF*area);
        
        double subtotal = (materialCostPerSF*area)+(laborCostPerSF*area);
        double taxTotal = taxRate*subtotal;
        
        order.setTax(taxTotal);
        order.setTotal(taxTotal+subtotal);
        orderDao.create(order);
        return "redirect:/";
    }
    @RequestMapping(value="/discard", method=RequestMethod.POST)
    public String discard() {
        return "redirect:/";
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
