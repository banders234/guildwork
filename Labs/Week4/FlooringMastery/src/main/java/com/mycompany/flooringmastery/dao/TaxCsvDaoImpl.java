/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.app.App;
import com.mycompany.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class TaxCsvDaoImpl implements TaxDao {
    List<Tax> taxes = decode();
    private boolean test=true;
    
    @Override
    public void setTest(boolean test) {
        this.test=test;
    }
    
    @Override
    public void create(Tax tax) {
        taxes.add(tax);
        if (!test) {
            encode();
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
    public void update(Tax newTax, Tax oldTax) {
        taxes.remove(oldTax);
        taxes.add(newTax);
        if (!test) {
            encode();
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
            encode();
        }
    }
    
    @Override
    public List<Tax> getAll() {
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
    private void encode() {
        final String TOKEN = ",";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("Data/taxes.txt"));
                for (Tax myTax : taxes) { 
                    out.print(myTax.getState());
                    out.print(TOKEN);
                    
                    out.print(myTax.getTaxRate());
                    out.println();

                      
                }
                out.flush();
                out.close();
            } catch(IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }


    }
 
    private List<Tax> decode() {
        List<Tax> taxList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("Data/taxes.txt")));
            while(sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split(",");
                Tax myTax = new Tax();
                myTax.setState(stringParts[0]);
                double taxRate = Double.parseDouble(stringParts[1]);
                myTax.setTaxRate(taxRate);
                taxList.add(myTax);
            }
        } catch(FileNotFoundException | NumberFormatException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return taxList;
    }

}
