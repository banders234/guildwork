/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.app.App;
import com.mycompany.flooringmastery.dto.Product;
import com.mycompany.flooringmastery.dto.Tax;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author apprentice
 */
public class TaxDao {
    List<Tax> taxes = readXML("Data/taxes.xml");
    private boolean test=true;
    
    public void setTest(boolean test) {
        this.test=test;
    }
    
    public void create(Tax tax) {
        taxes.add(tax);
        saveToXML("Data/taxes.xml");
    }
    public double getTaxRate(String state) {
        double taxRate = -1;
        for (Tax myTax : taxes) {
            if (state.equals(myTax.getState())) {
                return myTax.getTaxRate();
            }
        }
        return taxRate;
    }
    
    public void update(Tax newTax, Tax oldTax) {
        taxes.remove(oldTax);
        taxes.add(newTax);
        saveToXML("Data/taxes.xml");
    }
    public boolean containsState(String state) {
        boolean contains = false;
        for (Tax myTax : taxes) {
            if (state.equals(myTax.getState().toUpperCase())) {
                contains = true;
                return contains;
            }
            
        }
        return contains;
    }
    
    public void delete(Tax tax) {
        taxes.remove(tax);
        saveToXML("Data/taxes.xml");
    }
    
    public List<Tax> getAll() {
        return taxes;
    }
    public List<String> getAllStates() {
        List<String> states = new ArrayList<>();
        for (Tax myTax : taxes) {
            states.add(myTax.getState());
        }
        Collections.sort(states);
        return states;
    }
// CSV Encode/Decode    
//    private void encode() {
//        final String TOKEN = ",";
//
//        try {
//                PrintWriter out = new PrintWriter(new FileWriter("Data/taxes.txt"));
//                for (Tax myTax : taxes) { 
//                    out.print(myTax.getState());
//                    out.print(TOKEN);
//                    
//                    out.print(myTax.getTaxRate());
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
//    private List<Tax> decode() {
//        List<Tax> taxList = new ArrayList<>();
//        try {
//            Scanner sc = new Scanner(new BufferedReader(new FileReader("Data/taxes.txt")));
//            while(sc.hasNextLine()) {
//                String currentLine = sc.nextLine();
//                String[] stringParts= currentLine.split(",");
//                Tax myTax = new Tax();
//                myTax.setState(stringParts[0]);
//                double taxRate = Double.parseDouble(stringParts[1]);
//                myTax.setTaxRate(taxRate);
//                taxList.add(myTax);
//            }
//        } catch(FileNotFoundException | NumberFormatException ex) {
//            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return taxList;
//    }
        private List<Tax> readXML(String xml) {
        List<Tax> taxList = new ArrayList<>();
        try {
            File fXmlFile = new File(xml);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            if (doc.hasChildNodes()) {
                System.out.println(doc.getChildNodes().getLength());
		NodeList ntaxes = doc.getChildNodes().item(0).getChildNodes();
                int counter = 1;
                while (counter < ntaxes.getLength()) {
                    Tax tax = new Tax();
                    NodeList nlTax = ntaxes.item(counter).getChildNodes();
                    tax.setState(nlTax.item(1).getTextContent());
                    double taxRate = Double.parseDouble(nlTax.item(3).getTextContent().substring(1));
                    tax.setTaxRate(taxRate);
                    taxList.add(tax);
                    counter+=2;
                }

            }
            return taxList;

        } catch(ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return taxList;
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
            Element rootEle = dom.createElement("taxes");
            for (Tax myTax : taxes) {
                e = dom.createElement("tax" + counter);
                f = dom.createElement("state");
                f.appendChild(dom.createTextNode(myTax.getState()));
                e.appendChild(f);
                f = dom.createElement("taxRate");
                String materialCost = "d" + myTax.getTaxRate();
                f.appendChild(dom.createTextNode(materialCost));
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
