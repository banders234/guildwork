/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.data.TaxCsvRW;
import com.mycompany.flooringmastery.data.TaxXmlRW;
import com.mycompany.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author apprentice
 */
public class TaxDaoImpl implements TaxDao {
    private TaxCsvRW csv;
    private TaxXmlRW xml;
    boolean xmlSwitch = xmlMode();
    private boolean test=false;
    List<Tax> taxes;
    @Inject
    public TaxDaoImpl(TaxCsvRW csv, TaxXmlRW xml) {
        this.xmlSwitch = xmlMode();
        this.csv=csv;
        this.xml=xml;
        taxes = xmlSwitch();
    }
    
    
    @Override
    public void setTest(boolean test) {
        this.test=test;
    }
    
    @Override
    public void create(Tax tax) {
        taxes.add(tax);
        if (!test) {
            if (xmlSwitch) {  
                xml.saveToXML(taxes);
            }
            else {
                csv.encode(taxes);
            }
        }
    }
    @Override
    public double getTaxRate(String state) {
        double taxRate = -1;
        for (Tax myTax : taxes) {
            if (state.equals(myTax.getState())) {
                return myTax.getTaxRate();
            }
        }
        return taxRate;
    }
    
    @Override
    public void update(Tax tax) {
        for (Tax myTax : taxes) {
            if (myTax.getState().equals(tax.getState())) {
                taxes.remove(myTax);
                taxes.add(tax);
                break;
            }
        }
        if (!test) {
            if (xmlSwitch) {  
                xml.saveToXML(taxes);
            }
            else {
                csv.encode(taxes);
            }
        }
    }
    @Override
    public boolean containsState(String state) {
        boolean contains = false;
        for (Tax myTax : taxes) {
            if (state.equalsIgnoreCase(myTax.getState())) {
                contains = true;
                return contains;
            }
            
        }
        return contains;
    }
    
    @Override
    public void delete(Tax tax) {
        taxes.remove(tax);
        if (!test) {
            if (xmlSwitch) {  
                xml.saveToXML(taxes);
            }
            else {
                csv.encode(taxes);
            }
        }
    }
    
    @Override
    public List<Tax> getAll() {
        taxes.sort(Comparator.comparing(t -> t.getState()));
        return taxes;
    }
    @Override
    public List<String> getAllStates() {
        List<String> states = new ArrayList<>();
        for (Tax myTax : taxes) {
            states.add(myTax.getState());
        }
        Collections.sort(states);
        return states;
    }
    @Override
    public boolean isAlpha(String str) {
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

    return true;
    }
    
    private boolean xmlMode() {
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("xmlMode.txt")));
            String currentLine = sc.nextLine();
            String[] stringParts = currentLine.split("=");
            if ("true".equals(stringParts[1]) && "xml".equals(stringParts[0])) {
                return true;
            }
        }
        catch (Exception ex){
            System.out.println("XML config error!");
        }
        return false;
    }

    private List<Tax> xmlSwitch() { 
        List<Tax> taxList= new ArrayList();
        if (xmlSwitch) {
            taxList= xml.readXML();
        }
        else {
            taxList = csv.decode();
        }
        return taxList;
    }

    @Override
    public Tax find(String state) {
        for (Tax myTax : taxes) {
            if (myTax.getState().equals(state)) {
                return myTax;
            }
        }
        return null;
    }
}
