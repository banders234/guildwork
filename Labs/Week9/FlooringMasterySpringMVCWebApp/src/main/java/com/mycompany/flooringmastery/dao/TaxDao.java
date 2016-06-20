/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dao;

import com.mycompany.flooringmastery.dto.Tax;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface TaxDao {

    boolean containsState(String state);

    void create(Tax tax);

    void delete(Tax tax);

    List<Tax> getAll();
    
    Tax find(String state);
    
    List<String> getAllStates();

    double getTaxRate(String state);

    void setTest(boolean test);

    void update(Tax tax);
    
    boolean isAlpha(String str);
}
