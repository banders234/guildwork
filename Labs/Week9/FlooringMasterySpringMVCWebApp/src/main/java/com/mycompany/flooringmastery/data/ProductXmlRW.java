/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.data;

import com.mycompany.flooringmastery.dao.ProductDaoImpl;
import com.mycompany.flooringmastery.dto.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
public class ProductXmlRW {
    public List<Product> readXML() {
        List<Product> productList = new ArrayList<>();
        try {
            File fXmlFile = new File("/home/apprentice/FlooringData/products.xml");
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
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }
    
    
    
    public void saveToXML(List<Product> products) {
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
            tr.transform(new DOMSource(dom), new StreamResult(new FileOutputStream("/home/apprentice/FlooringData/products.xml")));

        } catch (IllegalArgumentException | FileNotFoundException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }
            
        } catch(ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying instantiate DocumentBuilder");
        }
        
    }
}
