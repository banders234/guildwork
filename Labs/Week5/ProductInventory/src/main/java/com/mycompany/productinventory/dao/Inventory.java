/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productinventory.dao;

import com.mycompany.productinventory.app.App;
import com.mycompany.productinventory.dto.Coat;
import com.mycompany.productinventory.dto.Pants;
import com.mycompany.productinventory.dto.Product;
import com.mycompany.productinventory.dto.Shirt;
import com.mycompany.productinventory.dto.Shoes;
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
public class Inventory {
    List<Product> products = decode();
    private boolean test = false;
    
    public void create(Product product) {
        int id = 1;
        boolean valid = false;
        List<Integer> idList = new ArrayList();
        for (Product p : products) {
            idList.add(p.getId());
        }
        while (!valid) {
            if (!idList.contains(id)) {
                product.setId(id);
                products.add(product);
                valid = true;
            }
            id++;
        }
        if (!test) {
            encode();
        }
    }
    
    public Product find(int id) {
        Product product = new Shirt();
        for(Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return product;
    }
    public List<Product> all() {
        return products;
    }
    
    public double totalValue() {
        double sum = 0;
        for (Product p : products) {
            sum += (p.getStock()*p.getPrice());
        }
        return sum;
    }
    public void update(Product product) {
        for (Product p : products) {
            if (product.getId() == p.getId()) {
                products.remove(product);
                products.add(product);
                break;
            }
        }
        if (!test) {
            encode();
        }
    }
    
    public void delete(Product product) {
        products.remove(product);
        if (!test) {
            encode();
        }
    }
    
    public void setTest() {
        test = true;
    }
    
    private void encode() {
        final String TOKEN = "::";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("products.txt"));
                for (Product myProduct : products) {
                    out.print(myProduct.getId());
                    out.print(TOKEN);
                                        
                    out.print(myProduct.getName());
                    out.print(TOKEN);
                    
                    out.print(myProduct.getType());
                    out.print(TOKEN);
                    
                    out.print(myProduct.getSize());
                    out.print(TOKEN);
                    
                    out.print(myProduct.getPrice());
                    out.print(TOKEN);
                    
                    out.print(myProduct.getStock());
                    out.print(TOKEN);
                    
                    out.print(myProduct.getWarning());
                    
                    out.println();

                      
                }
                out.flush();
                out.close();
            } catch(IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }


    }
    
    private List<Product> decode() {
        List<Product> productList = new ArrayList();
        if (!test) {
            try {
                Scanner sc = new Scanner(new BufferedReader(new FileReader("products.txt")));

                while (sc.hasNextLine()) {
                    String currentLine = sc.nextLine();
                    String[] stringParts= currentLine.split("::");
                    Product myProduct;
                    if(stringParts[2].equals("shirt")) {
                        myProduct = new Shirt();
                    }
                    else if (stringParts[2].equals("pants")) {
                        myProduct = new Pants();
                    }
                    else if (stringParts[2].equals("coat")) {
                        myProduct = new Coat();
                    }
                    else {
                        myProduct = new Shoes();
                    }

                    int id = Integer.parseInt(stringParts[0]);

                    myProduct.setId(id);
                    myProduct.setName(stringParts[1]);
                    myProduct.setType(stringParts[2]);
                    myProduct.setSize(stringParts[3]);

                    double price = Double.parseDouble(stringParts[4]);
                    myProduct.setPrice(price);

                    int stock = Integer.parseInt(stringParts[5]);
                    myProduct.setStock(stock);

                    int warning = Integer.parseInt(stringParts[6]);
                    myProduct.setStock(warning);

                    productList.add(myProduct);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return productList;
    }
        
}
