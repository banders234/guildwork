/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook.controllers;

import com.mycompany.addressbook.controllers.AddressBookController;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main (String[] args) {
        AddressBookController aBookC = new AddressBookController();
        aBookC.run();
    }
}
