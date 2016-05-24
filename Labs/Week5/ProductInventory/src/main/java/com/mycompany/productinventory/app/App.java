/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productinventory.app;

import com.mycompany.productinventory.controllers.ProductInventoryController;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main (String[] args) {
        ProductInventoryController controller = new ProductInventoryController();
        controller.run();
    }
}
