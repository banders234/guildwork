/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productinventory.controllers;

import com.mycompany.productinventory.dao.Inventory;
import com.mycompany.productinventory.dto.Coat;
import com.mycompany.productinventory.dto.Pants;
import com.mycompany.productinventory.dto.Product;
import com.mycompany.productinventory.dto.Shirt;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ProductInventoryController {
    Inventory inventory = new Inventory();
    ConsoleIO console = new ConsoleIO();
    private final DecimalFormat df2 = new DecimalFormat("0.00");
    public void run() {
        menuChoice();
    }
    
    
    private void menuChoice() {
        
        int choice;
        
        do {
            menuDisplay();
            choice = console.getInt("Enter choice: ");
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProductStock();
                    break;
                case 3:
                    calculateInventoryValue();
                    break;
                case 4:
                    calculateProductValue();
                    break;
                case 5: 
                    console.print("Goodbye!");
                    break;
                default:
                    console.print("Invalid choice!");
                    break;   
            }
        } while (choice != 5);
    }
    
    private void menuDisplay() {
        console.print("1. Add new product");
        console.print("2. Update product stock");
        console.print("3. Calculate total value of inventory");
        console.print("4. Calculate total value of single product stock");
        console.print("5. Exit");
    }

    private void calculateProductValue() {
        List<Product> products = inventory.all();
        
        for (Product p : products) {
            console.print(p.getId() + ": " + p.getName() + ", Size " + p.getSize());
        }
        int id = console.getInt("Enter product ID: ");
        Product product = inventory.find(id);
        double totalValue = (product.getPrice()*product.getStock());
        console.print("The total value of the " + product.getName() + ", Size " + product.getSize() + " stock is $" + df2.format(totalValue) + ".");
    }

    private void calculateInventoryValue() {
        console.print("The total value of the inventory is $" + df2.format(inventory.totalValue()) + ".");
    }

    private void updateProductStock() {
        List<Product> products = inventory.all();
        console.print("List of Products:\n\n");
        for (Product p : products) {
            console.print(p.getId() + ": " + p.getName() + ", Size " + p.getSize());
        }
        int choice = console.getInt("Choose product: ");
        Product product = inventory.find(choice);
        console.print("Product name: " + product.getName() + ", Size " + product.getSize());
        console.print("Current Stock: " + product.getStock());
        int stock = console.getInt("Enter new Stock: ");
        if (stock < product.getWarning()) {
            console.print("Stock is below warning threshold! You should restock ASAP!");
        }
        product.setStock(stock);
        inventory.update(product);
    }

    private void addProduct() {
        console.print("Choose product type:\n");
        console.print("1. Shirt");
        console.print("2. Pants");
        console.print("3. Coat");
        console.print("4. Shoes\n");
        int choice = console.getIntMinMax("> ", 1,4);
        Product product = new Shirt();
        
        String name = console.getString("Enter product name: ");
        double price = console.getDouble("Enter price: ");
        console.print("Enter the initial stock for each size of this product\n"
                + "and the stock number at which you like be notified to restock.");
        
        int stock, warning;
        
        for (String s  : product.getSizeList()) {
            switch (choice) {
            case 1:
                product = new Shirt();
                break;
            case 2:
                product = new Pants();
                break;
            case 3:
                product = new Coat();
                break;
            default:
                console.print("Invalid choice!");
                break;
            }
            stock = console.getInt(s + ": ");
            warning = console.getInt("Enter notification threshold: ");
            product.setName(name);
            product.setPrice(price);
            product.setSize(s);
            product.setStock(stock);
            product.setWarning(warning);
            inventory.create(product);
        }
        
    }
    
}
