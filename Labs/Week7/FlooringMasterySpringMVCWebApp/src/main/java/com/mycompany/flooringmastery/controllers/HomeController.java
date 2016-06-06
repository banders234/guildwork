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
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
    private OrderDao orderDao;
    private ProductDao productDao;
    private TaxDao taxDao;
    
    @Inject
    public HomeController(OrderDao orderDao, ProductDao productDao, TaxDao taxDao) {
        this.orderDao = orderDao;
        this.taxDao = taxDao;
        this.productDao = productDao;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<Order> orders = orderDao.getAll();
        List<Date> dateList = orderDao.getAllDates();
        List<Product> products = productDao.getAll();
        List<Tax> taxes = taxDao.getAll();
        Order order = new Order();
        model.put("dateList", dateList);
        model.put("order", order);
        model.put("orders", orders);
        model.put("taxes", taxes);
        model.put("products", products);
        return "home";
    }
}
