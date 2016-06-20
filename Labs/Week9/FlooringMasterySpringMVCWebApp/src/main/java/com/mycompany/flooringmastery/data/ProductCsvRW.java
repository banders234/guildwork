/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.data;

import com.mycompany.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class ProductCsvRW {
    public void encode(List<Product> products) {
        final String TOKEN = ",";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("/home/apprentice/FlooringData/products.txt"));
                for (Product myProduct : products) { 
                    out.print(myProduct.getType());
                    out.print(TOKEN);
                    
                    out.print(myProduct.getMaterialCostPerSF());
                    out.print(TOKEN);
                    
                    out.print(myProduct.getLaborCostPerSF());
                    out.println();

                      
                }
                out.flush();
                out.close();
            } catch(IOException ex) {
                System.out.println("Product file error!");
            }


    }
        
    public List<Product> decode() {
        List<Product> productList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("/home/apprentice/FlooringData/products.txt")));
            while(sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split(",");
                Product myProduct = new Product();
                myProduct.setType(stringParts[0]);
                double materialCostPerSF = Double.parseDouble(stringParts[1]);
                double laborCostPerSF = Double.parseDouble(stringParts[2]);
                myProduct.setMaterialCostPerSF(materialCostPerSF);
                myProduct.setLaborCostPerSF(laborCostPerSF);
                productList.add(myProduct);
            }
        } catch(FileNotFoundException | NumberFormatException ex) {
            System.out.println("Product file error!");
        }
        
        return productList;
    }
}
