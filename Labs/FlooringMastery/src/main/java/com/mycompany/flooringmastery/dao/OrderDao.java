/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.app.App;
import com.mycompany.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class OrderDao {
    private final SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
    private boolean test=true;
    List<Order> orders=decode();
    private int nextId = 1;
    
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
    
    public void delete(Order order) {
        String currentDateString = sdf.format(order.getDate());
        orders.remove(order);
        if (!test) {
            encode(currentDateString);
        }
    }
    
    public void save() {
        if (!test) {
            encode("");
        }
    }
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
    public Order findOrderByNo(int orderNo) {
        Order order = new Order();
        for (Order myOrder : orders) {
            if (orderNo == myOrder.getOrderNumber()) {
                return myOrder;
            }
        }
        
        
        return order;
    }
    public List<Order>  getAll() {
        
        return orders;
    }
    
    public int getCount() {
        return orders.size();
    }
    
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
    
    public void setTest(boolean test) {
        this.test=test;
    }
    
    
    
    private List<Order> decode() {
        List<Order> masterOrderList = new ArrayList();
        File dir = new File("Data/Orders");
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
                            List<Order> dateOrderList = decodeSingleFile(date);
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
    
    private List<Order> decodeSingleFile(String dateString){
        List<Order> orderList = new ArrayList();
        String fileName="Orders_" + dateString + ".txt";
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("Data/Orders/"+fileName)));
            Date date = sdf.parse(dateString);
            while (sc.hasNextLine()) {
 
                int counter = 0;
                String customerName="";
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split(",");
                Order myOrder = new Order();

                int id = Integer.parseInt(stringParts[counter]);
                counter++;
                myOrder.setDate(date);
                myOrder.setOrderNumber(id);
                // Find first comma if quotes exist, take string between quotes
                if (stringParts.length > 12) {
                    if (stringParts[1].charAt(0)== ('\"') && stringParts[2].indexOf('\"') >= 0) {
                        String concate = stringParts[1] + stringParts[2];
                        customerName = currentLine.substring(currentLine.indexOf(',') + 2, concate.length() + 2);
                        counter++;
                    }
                }
                else {
                    customerName = stringParts[1];
                }
                myOrder.setCustomerName(customerName);
                counter++;
                
                myOrder.setState(stringParts[counter]);
                counter++;
                
                double taxRate= Double.parseDouble(stringParts[counter]);
                myOrder.setTaxRate(taxRate);
                counter++;
                
                
                myOrder.setProductType(stringParts[counter]);
                counter++;
                
                double area= Double.parseDouble(stringParts[counter]);
                myOrder.setArea(area);
                counter++;
                
                double materialCostPerSF= Double.parseDouble(stringParts[counter]);
                myOrder.setMaterialCostPerSF(materialCostPerSF);
                counter++;
                
                double laborCostPerSF= Double.parseDouble(stringParts[counter]);
                myOrder.setLaborCostPerSF(laborCostPerSF);
                counter++;
                
                
                double materialCost= Double.parseDouble(stringParts[counter]);
                myOrder.setMaterialCost(materialCost);
                counter++;
                
                double laborCost= Double.parseDouble(stringParts[counter]);
                myOrder.setLaborCost(laborCost);
                counter++;
                
                double tax= Double.parseDouble(stringParts[counter]);
                myOrder.setTax(tax);
                counter++;
                
                double total= Double.parseDouble(stringParts[counter]);
                myOrder.setTotal(total);
                orderList.add(myOrder);
            }
        } catch (FileNotFoundException | NumberFormatException | ParseException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderList;
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
            encodeSingleFile(d, dateOrderList);
        }
    }
    private void encodeSingleFile(String date, List<Order> dateOrderList) {
        final String TOKEN = ",";
        String fileName = "Data/Orders/Orders_" + date + ".txt";
        try {   
                
                PrintWriter out = new PrintWriter(new FileWriter(fileName));
                if (dateOrderList.isEmpty()) {
                    File f = new File(fileName);
                    f.delete();
                }
                for (Order myOrder : dateOrderList) {
                    out.print(myOrder.getOrderNumber());
                    out.print(TOKEN);
                    String customerName = myOrder.getCustomerName();
                    if (customerName.indexOf(',') >= 0) {
                        customerName = ("\"" + customerName + "\"");
                    }
                    out.print(customerName);
                    out.print(TOKEN);
                    
                    out.print(myOrder.getState());
                    out.print(TOKEN);
                    
                    out.print(myOrder.getTaxRate());
                    out.print(TOKEN);
                                        
                    out.print(myOrder.getProductType());
                    out.print(TOKEN);
                    
                    out.print(myOrder.getArea());
                    out.print(TOKEN);
                    
                    out.print(myOrder.getMaterialCostPerSF());
                    out.print(TOKEN);
                                        
                    out.print(myOrder.getLaborCostPerSF());
                    out.print(TOKEN);
                    
                    out.print(myOrder.getMaterialCost());
                    out.print(TOKEN);
                                        
                    out.print(myOrder.getLaborCost());
                    out.print(TOKEN);
                    
                    out.print(myOrder.getTax());
                    out.print(TOKEN);
                    
                    out.print(myOrder.getTotal());
                    out.println();
                    
                      
                }
                out.flush();
                out.close();
            } catch(IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }    
    }
}
