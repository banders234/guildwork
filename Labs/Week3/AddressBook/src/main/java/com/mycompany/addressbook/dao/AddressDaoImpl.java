/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook.dao;

import com.mycompany.addressbook.dto.Address;
import com.mycompany.addressbook.controllers.App;
import com.mycompany.addressbook.dao.AddressDao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class AddressDaoImpl implements AddressDao {
    private List<Address> addresses = decode();
    private int nextId = 1;
    
    @Override
    public Address create(Address address) {
        
        address.setId(nextId);
        
        nextId++;
        addresses.add(address);
        encode();
        return address;
    }
    
    @Override
    public void delete(Address address) {
        addresses.remove(address);
        encode();
    }
    
    @Override
    public void update(Address address) {
        for (Address myAddress : addresses)  {
            if (myAddress.getId() == address.getId()) {
                addresses.remove(myAddress);
                addresses.add(address);
            }
        }
        encode();
    }
    
    @Override
    public List<Address> find(String lastName) {
        List<Address> addressl = new ArrayList<>();
        Address address = new Address();
        for (Address a : addresses) {
            if ((a.getLastName()).equals(lastName)) {
                addressl.add(a);
            }
        }
        return addressl;
    }
    
    
    @Override
    public int getCount() {
        return addresses.size();
    }
    
    @Override
    public List<Address>  getAll() {
        
        return addresses;
    }
    
    private void encode() {
        final String TOKEN = "::";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("addresses.txt"));
                for (Address myAddress : addresses) {
                    out.print(myAddress.getId());
                    out.print(TOKEN);

                    out.print(myAddress.getFirstName());
                    out.print(TOKEN);

                    out.print(myAddress.getLastName());
                    out.print(TOKEN);

                    out.print(myAddress.getStreetAddress());
                    out.print(TOKEN);

                    out.print(myAddress.getLine2());
                    out.print(TOKEN);

                    out.print(myAddress.getCity());
                    out.print(TOKEN);

                    out.print(myAddress.getState());
                    out.print(TOKEN);

                    out.print(myAddress.getZipCode());
                    out.println();
                }
                out.flush();
                out.close();

            } catch(IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }


    }
    
    private List<Address> decode() {
        List<Address> studentList = new ArrayList();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("addresses.txt")));

            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split("::");
                Address myAddress = new Address();

                int id = Integer.parseInt(stringParts[0]);

                myAddress.setId(id);
                myAddress.setFirstName(stringParts[1]);
                myAddress.setLastName(stringParts[2]);
                myAddress.setStreetAddress(stringParts[3]);
                myAddress.setLine2(stringParts[4]);
                myAddress.setCity(stringParts[5]);
                myAddress.setState(stringParts[6]);
                myAddress.setZipCode(Integer.parseInt(stringParts[7]));


                studentList.add(myAddress);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        return studentList;
        }
}
