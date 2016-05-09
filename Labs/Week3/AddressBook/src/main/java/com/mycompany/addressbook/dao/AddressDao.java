/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook.dao;

import com.mycompany.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AddressDao {

    Address create(Address address);

    void delete(Address address);

    List<Address> find(String lastName);

    List<Address> getAll();

    int getCount();

    void update(Address address);
    
}
