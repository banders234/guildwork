/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.data.ProductCsvRW;
import com.mycompany.flooringmastery.data.ProductXmlRW;
import com.mycompany.flooringmastery.dto.Product;
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
public class ProductDaoImpl implements ProductDao {
    List<Product> products = new ArrayList();
    private ProductXmlRW xml;
    private ProductCsvRW csv;
    private boolean test=false;
    private boolean xmlSwitch=true;
    @Inject
    public ProductDaoImpl(ProductXmlRW xml, ProductCsvRW csv) {
        this.xml = xml;
        this.csv = csv;
        if (xmlSwitch) {
            products= readXml();
        }
        else {
            products = decode();
        }
    }
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
    
    private List<Product> decode() {
        csv.encode(products);
        List<Product> productList = csv.decode();
        return productList;
    }
    private List<Product> readXml() {
        List<Product> productList = xml.readXML();
        return productList;
    }
    
    @Override
    public List<Product> getAll() {
        products.sort(Comparator.comparing(p -> p.getType()));
        return products;
    }
    
    @Override
    public void create(Product product) {
        
        products.add(product);
        if (!test) {
            if (xmlSwitch) {
                
                xml.saveToXML(products);
            }
            else {
                csv.encode(products);
            }
        }
    }
    @Override
    public void delete(Product product) {
        products.remove(product);
        if (!test) {
            if (xmlSwitch) {
                
                xml.saveToXML(products);
            }
            else {
                csv.encode(products);
            }
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
    public void update(Product product) {
        for (Product myProduct : products) {
            if (myProduct.getType().equals(product.getType())) {
                products.remove(myProduct);
                products.add(product);
                break;
            }
        }
        if (!test) {
            if (xmlSwitch) {
                
                xml.saveToXML(products);
            }
            else {
                csv.encode(products);
            }
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


 
       
}



