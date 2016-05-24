/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.Product;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ProductDao {

    boolean containsType(String type);
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

    void create(Product product);

    void delete(Product product);

    Product find(String productType);

    List<Product> getAll();

    List<String> getAllTypes();

    void setTest(boolean test);

    void update(Product newProduct, Product oldProduct);
    
    boolean isAlphaNumOrWS(String str);
}
