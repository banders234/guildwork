/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.data.OrderRW;
import com.mycompany.flooringmastery.dto.Order;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;


/**
 *
 * @author apprentice
 */
public class OrderDaoImpl implements OrderDao {
    private final SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
    private OrderRW orderRW;
    private boolean test=false;
    private int nextId = 1;
    List<Order> orders = new ArrayList();
    @Inject
    public OrderDaoImpl(OrderRW orderRW) {
        this.orderRW = orderRW;
        orders=decode();
    }
    
    @Override
    public Order create(Order order) {
        List<Integer> idList = new ArrayList<>();
        for (Order myOrder : orders) {
            idList.add(myOrder.getOrderNumber());
        }
        while (idList.contains(nextId)) {
            nextId++;
        }
        order.setOrderNumber(nextId);
        orders.add(order);
        if (!test) {
            encode("");
        }
        return order;
    }
    
    @Override
    public void delete(Order order) {
        String currentDateString = sdf.format(order.getDate());
        orders.remove(order);
        if (!test) {
            encode(currentDateString);
        }
    }
    
    @Override
    public void save() {
        if (!test) {
            encode("");
        }
    }
    @Override
    public void update(Order myOrder) {
        String currentDateString = "";
        for (Order order : orders)  {
            if (myOrder.getOrderNumber() == order.getOrderNumber()) {
                currentDateString = sdf.format(order.getDate());
                orders.remove(order);
                orders.add(myOrder);
                break;
            }
        }
        if (!test) {
            encode(currentDateString);
        }
    }
    @Override
    public Order findOrderByNo(int orderNo) {
        Order order = new Order();
        for (Order myOrder : orders) {
            if (orderNo == myOrder.getOrderNumber()) {
                return myOrder;
            }
        }
        
        
        return order;
    }
    @Override
    public List<Order>  getAll() {
        orders.sort(Comparator.comparing(o ->  o.getDate()));
        return orders;
    }
    
    @Override
    public int getCount() {
        return orders.size();
    }
    
    @Override
    public List<Date> getAllDates() {
        boolean contains;
        String dateString1, dateString2;
        List<Date>dateList=new ArrayList<>();
        for(Order myOrder : orders) {
            contains = false;
            for (Date myDate : dateList) {
                dateString1 = sdf.format(myDate);
                dateString2 = sdf.format(myOrder.getDate());
                if (dateString1.equals(dateString2)) {
                    contains = true;
                }
            }
            if (!contains) {
                dateList.add(myOrder.getDate());
            }
        }
        Collections.sort(dateList);
        return dateList;
    }
    
    @Override
    public List<Order> getOrdersOnDate(Date date) {
        List<Order>dateOrderList=new ArrayList<>();
        String dateString = sdf.format(date);
        for(Order myOrder : orders) {
            if (dateString.equals(sdf.format(myOrder.getDate()))) {
                dateOrderList.add(myOrder);
            }
        }
        return dateOrderList;
    }
    
    @Override
    public void setTest(boolean test) {
        this.test=test;
    }

    private List<Order> decode() {
        List<Order> masterOrderList = new ArrayList();
        File dir = new File("/home/apprentice/FlooringData/Orders");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                String fileName = child.getName();
                String[] ext = fileName.split("\\.");
                if (ext.length > 1) {
                    if ("txt".equals(ext[1])) {
                        String[] fileNameParts = ext[0].split("_");
                        if ("Orders".equals(fileNameParts[0])) {
                            String date = fileNameParts[1];
                            List<Order> dateOrderList = orderRW.decodeSingleFile(date);
                            for (Order myOrder : dateOrderList) {
                                masterOrderList.add(myOrder);
                            }
                        }
                    }
                }
                
            }
        } 
        
        return masterOrderList;
    }
    private void encode(String currentDateString) {
        List<String> dateList = new ArrayList<>();
        for (Order myOrder : orders) {
            String dateString=sdf.format(myOrder.getDate());
            if (!dateList.contains(dateString)) {
                dateList.add(dateString);
            }
        }
        if (!currentDateString.equals("") && !dateList.contains(currentDateString)) {
            dateList.add(currentDateString);
        }
        for (String d : dateList) {
            List<Order> dateOrderList = new ArrayList<>();
            for (Order myOrder : orders) {
                String dateString=sdf.format(myOrder.getDate());
                if (d.equals(dateString)) {
                    dateOrderList.add(myOrder);
                }
            }
            orderRW.encodeSingleFile(d, dateOrderList);
        }
    }
}
