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
    private final List<Product> products = decode();
    
    public ProductDao() {
//        saveToXML("myFile.xml");
//        readXML("myFile.xml");
    }
    
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
            encode();
        }
    }
    public void delete(Product product) {
        products.remove(product);
        if (!test) {
            encode();
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
            encode();
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
//    String role1 = "Hi";
//    String role2 = "Hey";
//    String role3 = "Hello";
//    String role4 = "Ha";
//    List<String> rolev = new ArrayList<>();
//    private boolean readXML(String xml) {
//        
//        try {
//            Node node;
//            File fXmlFile = new File(xml);
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(fXmlFile);
//            doc.getDocumentElement().normalize();
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//            if (doc.hasChildNodes()) {
//                System.out.println(doc.getChildNodes().getLength());
//		NodeList nproducts = doc.getChildNodes().item(0).getChildNodes();
//                System.out.println(nproducts.getLength());
//                int counter = 1;
//                Node types = nproducts.item(1);
//                Node materialCosts = nproducts.item(3);
//                Node laborCosts = nproducts.item(5);
//                while (counter < nproducts.getLength()) {
//                    node = nproducts.item(counter);
//                    if (node.getNodeType() == Node.ELEMENT_NODE) {
//                        System.out.println(nproducts.item(counter).getNodeName());
//                        System.out.println(counter);
//                    }
//                    counter++;
//                }
//            }
//            NodeList nList = doc.getElementsByTagName("types");
//            System.out.println("----------------------------");
//            Node n = nList.item(0);
//            nList = n.getChildNodes();
//            for (int temp = 0; temp < nList.getLength(); temp++) {
//
//		Node nNode = nList.item(temp);
//				
//		System.out.println("\nCurrent Element :" + nNode.getNodeName());
//		
//		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//                        Element eElement = (Element) nNode;
//                        NodeList nl = eElement.getElementsByTagName("type1");
//                        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
//                           System.out.println(nNode.getNodeValue());
//                        }
//			
//
//		}
//            }
//
//            return true;
//        } catch(ParserConfigurationException pce) {
//            System.out.println(pce.getMessage());
//        } catch (SAXException ex) {
//            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
//    
//    private void saveToXML(String xml) {
//        Document dom;
//        Element e = null;
//        Element f = null;
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        try {
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            
//            dom = db.newDocument();
//            int counter = 1;
//            Element rootEle = dom.createElement("products");
//            e = dom.createElement("types");
//            for (Product myProduct : products) {
//                f = dom.createElement("type" + counter);
//                f.appendChild(dom.createTextNode(myProduct.getType()));
//                e.appendChild(f);
//                counter++;
//            }
//            rootEle.appendChild(e);
//            counter=1;
//            e = dom.createElement("materialcosts");
//            for (Product myProduct : products) {
//                f = dom.createElement("materialcost" + counter);
//                String materialCost = "d" + myProduct.getMaterialCostPerSF();
//                f.appendChild(dom.createTextNode(materialCost));
//                e.appendChild(f);
//                counter++;
//            }
//            rootEle.appendChild(e);
//            counter=1;
//            e = dom.createElement("laborcosts");
//            for (Product myProduct : products) {
//                f = dom.createElement("laborcost" + counter);
//                String laborCost = "d" + myProduct.getLaborCostPerSF();
//                f.appendChild(dom.createTextNode(laborCost));
//                e.appendChild(f);
//                counter++;
//            }
//            rootEle.appendChild(e);
//            dom.appendChild(rootEle);
//        try {
//            Transformer tr = TransformerFactory.newInstance().newTransformer();
//            tr.setOutputProperty(OutputKeys.INDENT, "yes");
//            tr.setOutputProperty(OutputKeys.METHOD, "xml");
//            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
//            tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(xml)));
//
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//            
//        } catch(ParserConfigurationException pce) {
//            System.out.println("UsersXML: Error trying instantiate DocuemntBuilder");
//        }
//        
//    }
//    private void printNote(NodeList nodeList) {
//
//    for (int count = 0; count < nodeList.getLength(); count++) {
//
//	Node tempNode = nodeList.item(count);
//
//	// make sure it's element node.
//	if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
//
//		// get node name and value
//		System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
//		System.out.println("Node Value =" + tempNode.getTextContent());
//
//		if (tempNode.hasAttributes()) {
//
//			// get attributes names and values
//			NamedNodeMap nodeMap = tempNode.getAttributes();
//
//			for (int i = 0; i < nodeMap.getLength(); i++) {
//
//				Node node = nodeMap.item(i);
//				System.out.println("attr name : " + node.getNodeName());
//				System.out.println("attr value : " + node.getNodeValue());
//
//			}
//
//		}
//
//		if (tempNode.hasChildNodes()) {
//
//			// loop again if has child nodes
//			printNote(tempNode.getChildNodes());
//
//		}
//
//		System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
//
//	}
//
//    }
        }



