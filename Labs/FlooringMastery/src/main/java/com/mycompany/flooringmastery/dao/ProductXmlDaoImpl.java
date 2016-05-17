/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.Product;
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
public class ProductXmlDaoImpl implements ProductDao {
    private final List<Product> products = readXML("Data/products.xml");
    
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
            saveToXML("Data/products.xml");
        }
    }
    @Override
    public void delete(Product product) {
        products.remove(product);
        if (!test) {
        //    encode();
            saveToXML("Data/products.xml");
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
            saveToXML("Data/products.xml");
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
    private List<Product> readXML(String xml) {
        List<Product> productList = new ArrayList<>();
        try {
            File fXmlFile = new File(xml);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            if (doc.hasChildNodes()) {
		NodeList nproducts = doc.getChildNodes().item(0).getChildNodes();
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
            Logger.getLogger(ProductCsvDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductCsvDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
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
    
    private void saveToXML(String xml) {
        Document dom;
        Element e;
        Element f;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            dom = db.newDocument();
            Element rootEle = dom.createElement("products");
            for (Product myProduct : products) {
                e = dom.createElement("product");
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
            System.out.println("UsersXML: Error trying instantiate DocuemntBuilder");
        }
        
    }
}
