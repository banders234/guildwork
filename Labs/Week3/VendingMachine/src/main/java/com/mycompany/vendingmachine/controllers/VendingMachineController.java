/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.controllers;

import com.mycompany.vendingmachine.dto.Change;
import com.mycompany.vendingmachine.dto.VendingItem;
import com.mycompany.vendingmachine.dao.VendingMachineDao;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class VendingMachineController {
    private VendingItem item = new VendingItem();
    ConsoleIO console = new ConsoleIO();
    private VendingMachineDao machine = new VendingMachineDao();
    private DecimalFormat df2 = new DecimalFormat("0.00");
    public void run() {
        vending();
    }
    private void vending() {

        boolean exit = false;
        console.print("Welcome to my vending machine!");
        console.print("");
        String password;
        while(!exit) {
            double money=0;
            Change change = new Change();
            int choice;
            List<VendingItem> items = machine.getAllInStock();
            int counter = 1;
            for (VendingItem i: items) {
                console.print("Item " +counter+ ": " + i.getName() + "| Cost: $" + df2.format(i.getCost()));
                counter++;
            }
            money=insertMoney();
            if (money==0) {
                password=console.getString("Enter admin password: ");
                if ("riprun".equals(password)) {
                    adminChoice();
                    break;
                }
                else{
                    console.print("Incorrect password!");
                    break;
                }
            }
            choice = console.getIntMinMax("Enter number of desired item: ", 0, items.size());
            VendingItem itemChoice = items.get(choice -1);
            double cost=itemChoice.getCost();
            if (money >= cost) {
                exit = changeAndReturn(money, cost, change, itemChoice, exit);
            }
            else {
                console.print("Insufficient funds!");
                console.print("Current amount entered is: " + money);
            }
        }
    }

    private boolean changeAndReturn(double money, double cost, Change change, VendingItem itemChoice, boolean exit) {
        double remainder = money - cost;
        change.getChange(remainder);
        console.print("Your change is " +change.getQuarters() + " quarters " + change.getDimes() + " dimes " + change.getNickels() + " nickels and " + change.getPennies() + " pennies.");
        int newInventory=itemChoice.getInventory() -1;
        itemChoice.setInventory(newInventory);
        machine.update(itemChoice);
        boolean valid = false;
        while (!valid) {
            String exitChoice=console.getString("Would you like to exit? (yes or no)");
            if ("yes".equals(exitChoice)) {
                console.print("Goodbye!");
                valid=true;
                exit=true;
            }
            else if ("no".equals(exitChoice)) {
                valid=true;
            }
            else{
                console.print("Invalid choice!");
            }
        }
        return exit;
    }
    
    
    private void adminMenu() {
        console.print("Welcome back admin!");
        console.print("");
        console.print("1. Add Item");
        console.print("2. Remove Item");
        console.print("3. Update Item Inventory");
        console.print("4. Edit Item Name");
        console.print("5. Update Item Price");
        console.print("6. View All Items");
        console.print("7. Display Item Count");
        console.print("8. Exit");
    }
    private double insertMoney() {
        double money = console.getDouble("Insert money: ");
        return money;
    }
    private void adminChoice() {
        int choice;
        do {
            adminMenu();
            choice=console.getIntOneLine("> ");
            switch (choice) {
                case 1:
                    item = vendingInfo();
                    machine.create(item);
                    break;
                case 2:
                    deleteItem();
                    break;
                case 3:
                    editInventory();
                    break;
                case 4:
                    editName();
                    break;
                case 5:
                    editPrice();
                    break;
                case 6:
                    listAll();
                    break;
                case 7:
                    getCount();
                    break;
                case 8:
                    console.print("Goodbye!");
                    break;
                default:
                    console.print("Invalid choice!");
                    break;
            }
        } while(choice != 8);
    }
    
    
    public VendingItem vendingInfo() {
        

        String name;
        int inventory;
        double cost;
        name = console.forceString("Please Enter Name of Item: ");
        cost = console.getDouble("Please Enter Cost of Item: ");
        inventory = console.getIntOneLine("Please Enter Initial Inventory: ");

        item.setName(name);
        item.setCost(cost);
        item.setInventory(inventory);
        return item;
    }
    
    public List<VendingItem> find() {
        List<VendingItem> itemd;
        String name = console.getStringOneLine("Please enter name of item to find: ");
        itemd = machine.find(name);
        return itemd;
    }
    public void deleteItem() {
        List<VendingItem> itemd;
        itemd = find();
        display(itemd);
        int choice = console.getIntMinMax("Enter number of the item you wish to delete:", 0, itemd.size());
        item = itemd.get(choice -1);
        machine.delete(item);
    }
    
    public void getCount() {
        console.print("There are " + machine.getCount() + " items in the vending machine.");
    }
    
    public void listAll() {
        List<VendingItem> items = machine.getAll();
        display(items);
    }
    public void editInventory() {
        List<VendingItem> itemd = find();
        display(itemd);
        int choice = console.getIntMinMax("Enter number of the item you wish to edit:", 0, itemd.size());
        item=itemd.get(choice);
        int inventory = console.getIntOneLine("Enter new inventory for" + item.getName() + ":");
        item.setInventory(inventory);
        machine.update(item);
        
    }
    public void editPrice() {
        List<VendingItem> itemd = find();
        display(itemd);
        int choice = console.getIntMinMax("Enter number of the item you wish to edit:", 0, itemd.size());
        item=itemd.get(choice);
        double price = console.getIntOneLine("Enter new price for" + item.getName() + ":");
        item.setCost(price);
        machine.update(item);
        
    }
    public void editName() {
        List<VendingItem> itemd = find();
        display(itemd);
        int choice = console.getIntMinMax("Enter number of the item you wish to edit:", 0, itemd.size());
        item=itemd.get(choice);
        String name = console.getStringOneLine("Enter new name for " + item.getName() + ":");
        item.setName(name);
        machine.update(item);
        
    }
    
    public void display(List<VendingItem> itemd) {
        int counter = 1;
        for (VendingItem i : itemd) {
            console.print("Item " + counter);
            console.print(i.getName() + " | " + i.getCost() + " | " + i.getInventory());
            console.print("");
            counter++;
        }
        
    }
}
