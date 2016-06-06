/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.Order;
import java.util.Date;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface OrderDao {

    Order create(Order order);

    void delete(Order order);

    Order findOrderByNo(int orderNo);

    List<Order> getAll();

    List<Date> getAllDates();

    int getCount();

    List<Order> getOrdersOnDate(Date date);

    void save();

    void setTest(boolean test);

    void update(Order myOrder);
    
    
}
