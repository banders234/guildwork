/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.data;

import com.mycompany.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class TaxCsvRW {
    public void encode(List<Tax> taxes) {
        final String TOKEN = ",";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("/home/apprentice/FlooringData/taxes.txt"));
                for (Tax myTax : taxes) { 
                    out.print(myTax.getState());
                    out.print(TOKEN);
                    
                    out.print(myTax.getTaxRate());
                    out.println();

                      
                }
                out.flush();
                out.close();
            } catch(IOException ex) {
                System.out.println("Tax file error!");
            }


    }
 
    public List<Tax> decode() {
        List<Tax> taxList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("/home/apprentice/FlooringData/taxes.txt")));
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
            System.out.println("Tax file error!");
        }
        
        return taxList;
    }
}
