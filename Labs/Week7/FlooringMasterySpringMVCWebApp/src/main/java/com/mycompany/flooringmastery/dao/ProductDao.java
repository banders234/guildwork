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

    void create(Product product);

    void delete(Product product);

    Product find(String productType);

    List<Product> getAll();

    List<String> getAllTypes();

    void setTest(boolean test);

    void update(Product product);
    
    boolean isAlphaNumOrWS(String str);
}
