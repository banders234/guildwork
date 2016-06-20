/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook.dao;

import com.mycompany.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.hibernate.Session;

/**
 *
 * @author apprentice
 */
public class AddressDaoImpl implements AddressDao{
    private List<Address> addresses = decode();
    private int nextId = 1;
    
    @Override
    public Address create(Address address) {
        
        List<Integer> idList = new ArrayList();
        for (Address myAddress : addresses) {
            idList.add(myAddress.getId());
        }
        boolean valid = false;
        while (!valid) {
            if (!idList.contains(nextId)) {
                address.setId(nextId);
                valid=true;
            }
            
            nextId++;
        }
        
        
        addresses.add(address);
        encode();
        return address;
    }
    
    @Override
    public void delete(Integer id) {
        for (Address address : addresses) {
            if (address.getId() == id) {
                addresses.remove(address);
                break;
            }
        }
        encode();
    }
    
    @Override
    public void update(Address address) {
        for (Address myAddress : addresses)  {
            if (myAddress.getId() == address.getId()) {
                addresses.remove(myAddress);
                addresses.add(address);
                break;
            }
        }
        encode();
    }
    
    private void encode() {
        final String TOKEN = "::";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("/home/apprentice/ProgramData/AddressBook/addresses.txt"));
                for (Address myAddress : addresses) {
                    out.print(myAddress.getId());
                    out.print(TOKEN);

                    out.print(myAddress.getFirstName());
                    out.print(TOKEN);

                    out.print(myAddress.getLastName());
                    out.print(TOKEN);

                    out.print(myAddress.getStreetNumber());
                    out.print(TOKEN);

                    out.print(myAddress.getStreetName());
                    out.print(TOKEN);

                    out.print(myAddress.getCity());
                    out.print(TOKEN);

                    out.print(myAddress.getState());
                    out.print(TOKEN);

                    out.print(myAddress.getZip());
                    out.println();
                }
                out.flush();
                out.close();

            } catch(IOException ex) {
                
            }


    }
    
    private List<Address> decode() {
        List<Address> studentList = new ArrayList();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("/home/apprentice/ProgramData/AddressBook/addresses.txt")));

            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split("::");
                Address myAddress = new Address();

                int id = Integer.parseInt(stringParts[0]);

                myAddress.setId(id);
                myAddress.setFirstName(stringParts[1]);
                myAddress.setLastName(stringParts[2]);
                myAddress.setStreetNumber(stringParts[3]);
                myAddress.setStreetName(stringParts[4]);
                myAddress.setCity(stringParts[5]);
                myAddress.setState(stringParts[6]);
                myAddress.setZip(stringParts[7]);


                studentList.add(myAddress);
            }
        } catch (FileNotFoundException ex) {
            
        }

        return studentList;
        }
    
    
    @Override
    public List<Address>  list() {
        Collections.sort(addresses, Comparator.comparing(a -> a.getLastName()));
        return addresses;
    }
    
    @Override
    public List<Address> searchByLastName(String lastName) {

        return addresses
                .stream()
                .filter(a -> a.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Address> searchByCity(String city) {
        
        return addresses
                .stream()
                .filter(a -> a.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Address> searchByZip(String zipCode) {

        return addresses
                .stream()
                .filter(a -> a.getZip().equals(zipCode))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Address> searchByState(String state) {

        List<Address> myAddresses = addresses
                .stream()
                .filter(a -> a.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
        Collections.sort(myAddresses, Comparator.comparing(a -> a.getCity()));
        return myAddresses;
    }

    @Override
    public Address get(Integer id) {
        for (Address myAddress : addresses) {
            if (myAddress.getId() == id) {
                return myAddress;
            }
        }
        return null;
    }
}
