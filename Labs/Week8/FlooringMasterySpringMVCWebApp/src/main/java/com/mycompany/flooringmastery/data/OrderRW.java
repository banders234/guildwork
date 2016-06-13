/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.data;

import com.mycompany.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
/**
 *
 * @author apprentice
 */
public class OrderRW {
    private final SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
    private final SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
    
    
    public List<Order> decodeSingleFile(String dateString){
        List<Order> orderList = new ArrayList();
        String fileName="Orders_" + dateString + ".txt";
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("/home/apprentice/FlooringData/Orders/"+fileName)));
            Date date = sdf.parse(dateString);
            sc.nextLine();
            while (sc.hasNextLine()) {
 
                int counter = 0;
                String customerName="";
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split(",");
                Order myOrder = new Order();

                int id = Integer.parseInt(stringParts[counter]);
                counter++;
                myOrder.setDate(date);
                myOrder.setDateString(sdf2.format(date));
                myOrder.setOrderNumber(id);
                // Find first comma if quotes exist, take string between quotes
                String concate="";
                if (stringParts.length > 12) {
                    int iCounter = 1;
                    int overSize = stringParts.length-12;
                    concate=stringParts[1];
                    while (iCounter<=overSize) {
                        concate = concate + stringParts[iCounter+1];
                        iCounter++;
                        counter++;
                    }
                    customerName = currentLine.substring(currentLine.indexOf(',') + 2, concate.length() + overSize+1);

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
            System.out.println("Order file error!");
        }
        return orderList;
    }
    
    public void encodeSingleFile(String date, List<Order> dateOrderList) {
        final String TOKEN = ",";
        String fileName = "/home/apprentice/FlooringData/Orders/Orders_" + date + ".txt";
        try {   
                
                PrintWriter out = new PrintWriter(new FileWriter(fileName));
                if (dateOrderList.isEmpty()) {
                    File f = new File(fileName);
                    f.delete();
                }
                else {
                    out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,MaterialCostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");
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
                System.out.println("Order file error!");
            }    
    }
}
