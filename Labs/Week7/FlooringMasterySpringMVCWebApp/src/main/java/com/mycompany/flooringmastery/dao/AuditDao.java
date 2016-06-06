/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

/**
 *
 * @author apprentice
 */


import com.mycompany.flooringmastery.dto.Audit;
import com.mycompany.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class AuditDao {

    private final String FILENAME = "audits.txt";
    private List<Audit> auditHistory = new ArrayList<>();
    private SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    
    public Object create(ProceedingJoinPoint jp) {
        if(!auditHistory.isEmpty()){
            auditHistory.clear();
        }
        decode();
        Object order = null;
        Date orderDate = null;;
        String action="";
        Integer orderNumber= 0;
        try {

            order = jp.proceed();
            Audit audit = new Audit();

            String sigName = jp.getSignature().getName();
            
            Object[] args = jp.getArgs();
            Order myOrder;
            switch(sigName){
                case "create":
                    myOrder = (Order) args[0];
                    orderNumber = myOrder.getOrderNumber();
                    orderDate = myOrder.getDate();
                    action="create";
                    break;
                    
                case "delete":
                    myOrder = (Order) args[0];
                    orderNumber = myOrder.getOrderNumber();
                    orderDate = myOrder.getDate();
                    action="delete";
                    break;
                    
                case "update":
                    myOrder = (Order) args[0];
                    orderNumber = myOrder.getOrderNumber();
                    orderDate = myOrder.getDate();
                    action="update";
                    
                    break;
                   
            }
            
            Date date = new Date();
            
            audit.setModificationDate(date);
            audit.setOrderDate(orderDate);
            audit.setOrderNumber(orderNumber);
            audit.setAction(action);
            
            auditHistory.add(audit);
            encode();

        } catch (Throwable ex) {
            ex.printStackTrace();
        }

        return order;
    }
    
    

    public void encode() {
        try {

            PrintWriter out = new PrintWriter(new FileWriter(FILENAME));
            out.println("Order Date::Order Number::Action::Modification Date");
            String delim = "::";
            for (Audit myAudit : auditHistory) {
                out.print(sdf1.format(myAudit.getOrderDate()));
                out.print(delim);
                
                out.print(myAudit.getOrderNumber());
                out.print(delim);
                
                out.print(myAudit.getAction());
                out.print(delim);
                
                out.print(sdf2.format(myAudit.getModificationDate()));
                out.println();
            }
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void decode() {
        
        
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));
            sc.nextLine();
            while(sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split("::");
                Audit audit = new Audit();
                audit.setOrderDate(sdf1.parse(stringParts[0]));
                audit.setOrderNumber(Integer.parseInt(stringParts[1]));
                audit.setAction(stringParts[2]);
                audit.setModificationDate(sdf2.parse(stringParts[3]));
                
                
                auditHistory.add(audit);
            }
           
            
        } catch (FileNotFoundException ex) {
            
        } catch (IOException e) {
            
        } catch (ParseException ex) {
            Logger.getLogger(AuditDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
