/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.app.App;
import com.mycompany.flooringmastery.dto.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;
/**
 *
 * @author apprentice
 */
public class ProductDao {
    private final List<Product> products = readXML("Data/products.xml");
    
    private boolean test=true;
    public void setTest(boolean test) {
        this.test=test;
    }
    
    public List<String> getAllTypes() {
        List<String> productTypeList = new ArrayList<>();
        for (Product p : products) {
            productTypeList.add(p.getType());
        }
        Collections.sort(productTypeList);
        return productTypeList;
    }
    

    
    public List<Product> getAll() {
        return products;
    }
    
    public void create(Product product) {
        
        products.add(product);
        if (!test) {
        //    encode();
        saveToXML("Data/products.xml");
        }
    }
    public void delete(Product product) {
        products.remove(product);
        if (!test) {
        //    encode();
            saveToXML("Data/products.xml");
        }
    }
    public Product find(String productType) {
        Product product = new Product();
        for (Product myProduct : products) {
            if (myProduct.getType().equalsIgnoreCase(productType) ) {
                return myProduct;
            }
        }
        return product;
    }
    
    public void update(Product newProduct, Product oldProduct) {
        products.remove(oldProduct);
        products.add(newProduct);
        if (!test) {
        //   encode();
            saveToXML("Data/products.xml");
        }
    }
    
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
    // Encode and decode functions not in use!
//        private void encode() {
//        final String TOKEN = ",";
//
//        try {
//                PrintWriter out = new PrintWriter(new FileWriter("Data/products.txt"));
//                for (Product myProduct : products) { 
//                    out.print(myProduct.getType());
//                    out.print(TOKEN);
//                    
//                    out.print(myProduct.getMaterialCostPerSF());
//                    out.print(TOKEN);
//                    
//                    out.print(myProduct.getLaborCostPerSF());
//                    out.println();
//
//                      
//                }
//                out.flush();
//                out.close();
//            } catch(IOException ex) {
//                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//
//    }
//        
//    private List<Product> decode() {
//        List<Product> productList = new ArrayList<>();
//        try {
//            Scanner sc = new Scanner(new BufferedReader(new FileReader("Data/products.txt")));
//            while(sc.hasNextLine()) {
//                String currentLine = sc.nextLine();
//                String[] stringParts= currentLine.split(",");
//                Product myProduct = new Product();
//                myProduct.setType(stringParts[0]);
//                double materialCostPerSF = Double.parseDouble(stringParts[1]);
//                double laborCostPerSF = Double.parseDouble(stringParts[2]);
//                myProduct.setMaterialCostPerSF(materialCostPerSF);
//                myProduct.setLaborCostPerSF(laborCostPerSF);
//                productList.add(myProduct);
//            }
//        } catch(FileNotFoundException | NumberFormatException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return productList;
//    }

    private List<Product> readXML(String xml) {
        List<Product> productList = new ArrayList<>();
        try {
            File fXmlFile = new File(xml);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            if (doc.hasChildNodes()) {
                System.out.println(doc.getChildNodes().getLength());
		NodeList nproducts = doc.getChildNodes().item(0).getChildNodes();
                System.out.println(nproducts.getLength());
                int counter = 1;
                while (counter < nproducts.getLength()) {
                    Product product = new Product();
                    NodeList nlProduct = nproducts.item(counter).getChildNodes();
                    product.setType(nlProduct.item(1).getTextContent());
                    double mCost = Double.parseDouble(nlProduct.item(3).getTextContent().substring(1));
                    product.setMaterialCostPerSF(mCost);
                    double lCost = Double.parseDouble(nlProduct.item(5).getTextContent().substring(1));
                    product.setLaborCostPerSF(lCost);
                    productList.add(product);
                    counter+=2;
                }

            }
            return productList;

        } catch(ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }
    
    private void saveToXML(String xml) {
        Document dom;
        Element e = null;
        Element f = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            dom = db.newDocument();
            int counter = 1;
            Element rootEle = dom.createElement("products");
            for (Product myProduct : products) {
                e = dom.createElement("product" + counter);
                f = dom.createElement("type");
                f.appendChild(dom.createTextNode(myProduct.getType()));
                e.appendChild(f);
                f = dom.createElement("materialcost");
                String materialCost = "d" + myProduct.getMaterialCostPerSF();
                f.appendChild(dom.createTextNode(materialCost));
                e.appendChild(f);
                f = dom.createElement("laborcost");
                String laborCost = "d" + myProduct.getLaborCostPerSF();
                f.appendChild(dom.createTextNode(laborCost));
                e.appendChild(f);
                rootEle.appendChild(e);
                counter++;
            }
            dom.appendChild(rootEle);
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(xml)));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            
        } catch(ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying instantiate DocuemntBuilder");
        }
        
    }
 
       
}



