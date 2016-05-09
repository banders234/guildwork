/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook.controllers;

import com.mycompany.addressbook.dto.Address;
import com.mycompany.addressbook.dao.AddressDaoImpl;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookController {
    private Address address = new Address();
    ConsoleIO console = new ConsoleIO();
    private AddressDaoImpl abook = new AddressDaoImpl();
    
    public void run() {
        firstChoice();
    }
    private void printUI() {
        console.print("Initial Menu:");
        console.print("\tPlease select the operation you wish to perform:");
        console.print("\t\t1. Add Address");
        console.print("\t\t2. Delete Address");
        console.print("\t\t3. Find Address");
        console.print("\t\t4. Display Address Count");
        console.print("\t\t5. List All Addresses");
        console.print("\t\t6. Edit Address");
        console.print("\t\t7. Exit");
    }
    
    private int userChoice() {
        int choice;
        choice = console.getIntOneLine("> ");
        return choice;
    }
    
    private void firstChoice() {
        int choice;
        do {
            printUI();
            choice = userChoice();
            switch (choice) {
                case 1:
                    address = addressInfo();
                    abook.create(address);
                    break;
                case 2:
                    deleteAddress();
                    break;
                case 3:
                    find();
                    break;
                case 4:
                    getCount();
                    break;
                case 5:
                    listAll();
                    break;
                case 6:
                    edit();
                    break;
                case 7:
                    console.print("Goodbye!");
                    break;
                default:
                    console.print("Invalid choice!");
                    break;
            }
        } while(choice != 7);
    }
    
    
    public Address addressInfo() {
        

        String firstName, lastName, streetAddress, line2 = "", l2choice, city, state, country;
        int zipCode;
        firstName = console.forceString("Please Enter First Name: ");
        lastName = console.forceString("Please Enter Last Name: ");
        streetAddress = console.forceString("Please Enter Street Address: ");
        l2choice = console.forceString("Is there an apartment, suite, etc.? (yes or no): ");
        if ("yes".equals(l2choice)) {
            line2 = console.getStringOneLine("Please Enter Address Line 2: "); 
        }
        city = console.forceString("Please Enter City: ");
        state = console.forceString("Please Enter State: ");
        zipCode = console.getIntOneLine("Please Enter Zip Code: ");
        address.setFirstName(firstName);
        address.setLastName(lastName);
        address.setStreetAddress(streetAddress);
        address.setLine2(line2);
        address.setCity(city);
        address.setState(state);
        address.setZipCode(zipCode);
        return address;
    }
    
    public List<Address> find() {
        List<Address> addressd;
        String lastName = console.getStringOneLine("Please enter last name of address to find: ");
        addressd = abook.find(lastName);
        return addressd;
    }
    public void deleteAddress() {
        List<Address> addressd;
        addressd = find();
        display(addressd);
        int choice = console.getIntMinMax("Enter number of the address you wish to delete:", 0, addressd.size() -1);
        address = addressd.get(choice -1);
        abook.delete(address);
    }
    
    public void getCount() {
        console.print("There are " + abook.getCount() + " addresses in the address book.");
    }
    
    public void listAll() {
        List<Address> addresses = abook.getAll();
        display(addresses);
    }
    public void edit() {
        List<Address> addressd = find();
        display(addressd);
        int choice = console.getIntMinMax("Enter number of the address you wish to edit:", 0, addressd.size() -1);
        address = addressd.get(choice -1);
        address = addressInfo();
        abook.update(address);
        
    }
    
    public void display(List<Address> addressd) {
        int counter = 1;
        for (Address a : addressd) {
            console.print("Address " + counter);
            console.print(a.getFirstName() + " " + a.getLastName());
            console.print(a.getStreetAddress() + " " + a.getLine2());
            console.print(a.getCity() + ", " + a.getState() + ", " + a.getZipCode());
            console.print("");
            counter++;
        }
        
    }
}
