/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.app.App;
import com.mycompany.flooringmastery.dto.Product;
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
public class ProductCsvDaoImpl implements ProductDao {
    private final List<Product> products = decode();
    
    private boolean test=true;
    @Override
    public void setTest(boolean test) {
        this.test=test;
    }
    
    @Override
    public List<String> getAllTypes() {
        List<String> productTypeList = new ArrayList<>();
        for (Product p : products) {
            productTypeList.add(p.getType());
        }
        Collections.sort(productTypeList);
        return productTypeList;
    }
    

    
    @Override
    public List<Product> getAll() {
        return products;
    }
    
    @Override
    public void create(Product product) {
        
        products.add(product);
        if (!test) {
        //    encode();
        encode();
        }
    }
    @Override
    public void delete(Product product) {
        products.remove(product);
        if (!test) {
        //    encode();
            encode();
        }
    }
    @Override
    public Product find(String productType) {
        Product product = new Product();
        for (Product myProduct : products) {
            if (myProduct.getType().equalsIgnoreCase(productType) ) {
                return myProduct;
            }
        }
        return product;
    }
    
    @Override
    public void update(Product newProduct, Product oldProduct) {
        products.remove(oldProduct);
        products.add(newProduct);
        if (!test) {
        //   encode();
            encode();
        }
    }
    
    @Override
    public boolean containsType(String type) {
        boolean contains = false;
        for (Product myProduct : products) {
            if (type.equalsIgnoreCase(myProduct.getType())) {
                contains = true;
                return contains;
            }
            
        }
        return contains;
    }
    
    @Override
    public boolean isAlphaNumOrWS(String str) {
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c) && !Character.isWhitespace(c) && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
        private void encode() {
        final String TOKEN = ",";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("Data/products.txt"));
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
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }


    }
        
    private List<Product> decode() {
        List<Product> productList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("Data/products.txt")));
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
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productList;
    }

 
       
}



