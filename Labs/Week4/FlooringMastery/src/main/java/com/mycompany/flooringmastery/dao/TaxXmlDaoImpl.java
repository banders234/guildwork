/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.Tax;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
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
public class TaxXmlDaoImpl implements TaxDao{
    List<Tax> taxes = readXML("Data/taxes.xml");
    private boolean test=true;
    
    @Override
    public void setTest(boolean test) {
        this.test=test;
    }
    
    @Override
    public void create(Tax tax) {
        taxes.add(tax);
        if (!test) {
            saveToXML("Data/taxes.xml");
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
            saveToXML("Data/taxes.xml");
        }
    }
    @Override
    public boolean containsState(String state) {
        boolean contains = false;
        for (Tax myTax : taxes) {
            if (state.equalsIgnoreCase(myTax.getState().toUpperCase())) {
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
            saveToXML("Data/taxes.xml");
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
    private List<Tax> readXML(String xml) {
        List<Tax> taxList = new ArrayList<>();
        try {
            File fXmlFile = new File(xml);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            if (doc.hasChildNodes()) {
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
        } catch (SAXException | IOException ex) {
            Logger.getLogger(ProductCsvDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return taxList;
    }
    
    private void saveToXML(String xml) {
        Document dom;
        Element e;
        Element f;
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

        } catch (IllegalArgumentException | FileNotFoundException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
            
        } catch(ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying instantiate DocumentBuilder");
        }
        
    }
}