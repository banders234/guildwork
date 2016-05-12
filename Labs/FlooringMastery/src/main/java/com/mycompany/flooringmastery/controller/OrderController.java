/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.controller;

import com.mycompany.flooringmastery.app.App;
import com.mycompany.flooringmastery.dao.OrderDao;
import com.mycompany.flooringmastery.dao.ProductDao;
import com.mycompany.flooringmastery.dao.TaxDao;
import com.mycompany.flooringmastery.dto.Order;
import com.mycompany.flooringmastery.dto.Product;
import com.mycompany.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class OrderController {
    private final boolean test=config();
    private final OrderDao orderBook= new OrderDao();
    private final ProductDao productBook= new ProductDao();
    private final TaxDao taxBook= new TaxDao();
    private final ConsoleIO console = new ConsoleIO();
    private final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    private final DecimalFormat df2 = new DecimalFormat("0.00");
    Date currentDate = new Date();
    public void run() {
        setTests();
        if (test) {
            console.print("This program is in test mode! Work will not be saved!");
        }
        menu();
    }
    
    private void menu() {
        int choice = 0;
        console.print("Welcome to the Flooring Application!");
        while (choice!=7) {
            displayMenu();
            choice = console.getIntMinMax("> ",1,7);
            switch (choice) {
                case 1:
                    displayOrders();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    saveCurrentWork();
                    break;
                case 6:
                    boolean exit = adminMenu();
                    if (exit) {
                        return;
                    }
                    break;
                case 7:
                    console.print("Goodbye!");
                    break;
                default:
                    console.print("Invalid choice!");
                    break;
            }
        }
        
    }
    private void displayMenu() {
        console.print("Select an option.");
        console.print("");
        console.print("1. Display Orders");
        console.print("2. Add an Order");
        console.print("3. Edit an Order");
        console.print("4. Remove an Order");
        console.print("5. Save Current Work");
        console.print("6. Admin Menu");
        console.print("7. Quit");
    }
    
    private void displayAdminMenu() {
        console.print("Select an option.");
        console.print("");
        console.print("1. View List of State Tax Rates");
        console.print("2. View List of Products");
        console.print("3. Add State Tax Rate");
        console.print("4. Add Product");
        console.print("5. Edit State Tax Rate");
        console.print("6. Edit Product");
        console.print("7. Remove State Tax Rate");
        console.print("8. Remove Product");
        console.print("9. Return to Main Menu");
        console.print("10. Quit");
    }
    
    private boolean adminMenu() {
        boolean exit = false;
        int choice = 0;
        while (choice != 7 && choice !=8) {
            displayAdminMenu();
            choice = console.getIntMinMax("> ", 1, 10);
            switch(choice) {
                case 1:
                    getTaxes();
                    break;
                case 2:
                    getProducts();
                    break;
                case 3:
                    addTax();
                    break;
                case 4:
                    addProduct();
                    break;
                case 5:
                    editTax();
                    break;
                case 6:
                    editProduct();
                    break;
                case 7:
                    removeTax();
                    break;
                case 8:
                    removeProduct();
                    break;
                case 9:
                    console.print("Returning to Main Menu...");
                    return false;
                case 10:
                    console.print("Goodbye!");
                    return true;
                default:
                    console.print("Error!");
                    break;
                            
            }
        }
        return exit;
    }
    private void displayOrders() {
        List<Date> dateList = orderBook.getAllDates();
        if (dateList.size() > 0) {
            console.print("Please choose a date from the list.");
            for (Date d : dateList) {
                console.print(sdf.format(d));
            }
            Date date = console.getDate("Enter valid date: ");
            List<Order> ordersOnDate = orderBook.getOrdersOnDate(date);
            if (ordersOnDate.size() > 0) {
                for (Order myOrder : ordersOnDate) {
                    displayOrderInfo(myOrder);
                }
            }
            else {
                console.print("There are no orders on that date!");
            }
        }
        else{
            console.print("There are no orders in the system!");
        }
    }
    
    private void addOrder() {
        Order myOrder = new Order();
        Date date;
        String customerName, state, productType, choice;
        double taxRate, area, materialCostPerSF, laborCostPerSF, materialCost, laborCost, tax, subtotal, total;
        boolean validInput = false;
        date = console.getDate("Enter Order Date: ");
        customerName = console.forceString("Enter Customer Name: ");
        state = getValidState(false, myOrder);
        taxRate = taxBook.getTaxRate(state);
        productType = getValidProduct(false, myOrder);
        area = console.getDouble("Enter Area of Floor in Square Feet: ");
        Product product=productBook.find(productType);
        materialCostPerSF = product.getMaterialCostPerSF();
        laborCostPerSF = product.getLaborCostPerSF();
        materialCost = materialCostPerSF * area;
        laborCost = laborCostPerSF * area;
        subtotal = materialCost + laborCost;
        tax = (taxRate/100) * subtotal;
        total = subtotal + tax;
        myOrder = createOrderObject(0,date ,customerName, state , productType, taxRate, area, materialCostPerSF, laborCostPerSF, materialCost, laborCost, tax, total);
        displayOrderInfo(myOrder);
        while (!validInput) {
            choice = console.getString("Would you like to commit these changes? (Y/N)");
            if ("y".equals(choice.toLowerCase())) {
                orderBook.create(myOrder);
                console.print("Order saved!");
                validInput=true;
            }
            else if ("n".equals(choice.toLowerCase())) {
                console.print("Order discarded!");
                validInput=true;
            }
            else {
                console.print("Invalid choice!");
            }
        }
    }
    private void editOrder() {
        boolean validInput;
        String customerName, state, productType;
        double area, taxRate, materialCostPerSF, laborCostPerSF, materialCost, laborCost, tax, subtotal, total;
        Date date;
        Order order = chooseOrder();
        if (order.getDate() == null) {
            return;
        }
        displayOrderInfo(order);
        console.print("Editing Order... (enter blank to leave current info unchanged)");
        
        Product product;
        date = console.getDateAcceptBlank("Enter order date: ", order.getDate());
        customerName = console.getStringAcceptBlank("Enter Customer Name: ", order.getCustomerName());
        area = console.getDoubleAcceptBlank("Enter Area of Floor in Square Feet: ", order.getArea());
        state= getValidState(true, order);
        taxRate=taxBook.getTaxRate(state);
        productType = getValidProduct(true, order);
        product = productBook.find(productType);
        materialCostPerSF = product.getMaterialCostPerSF();
        laborCostPerSF = product.getLaborCostPerSF();
        materialCost = materialCostPerSF*area;
        laborCost= laborCostPerSF*area;
        subtotal = laborCost + materialCost;
        tax = (taxRate/100)*subtotal;
        total = tax + subtotal;
        order = createOrderObject(order.getOrderNumber(),date ,customerName, state , productType, taxRate, area, materialCostPerSF, laborCostPerSF, materialCost, laborCost, tax, total);
        
        validInput = false;
        String choice;
        while (!validInput) {
            displayOrderInfo(order);
            choice = console.getString("Would you like to commit these changes? (Y/N)");
            if ("Y".equalsIgnoreCase(choice)) {
                orderBook.update(order);
                console.print("Changes saved!");
                validInput = true;
            }
            else if ("N".equalsIgnoreCase(choice)) {
                console.print("Changes discarded!");
                validInput = true;
            }
            else {
                console.print("Invalid choice!");
            }
        }
        
    }

    private List<Date> dateViewOption() {
        List<Date> dateList = orderBook.getAllDates();
        boolean validInput=false;
        while (!validInput) {
            String choice = console.getString("Would you like to view list of available dates? (Y/N)");
            if("Y".equalsIgnoreCase(choice)) {
                console.print("List of Dates:");
                console.print("==============");
                
                for (Date d : dateList) {
                    console.print(sdf.format(d));
                }
                return dateList;
            }
            else if ("N".equalsIgnoreCase(choice)) {
                validInput=true;
            }
            else {
                console.print("Invalid choice!");
            }
        }
        return dateList;
    }
    
    private void removeOrder() {
        String choice;
        boolean validInput = false;
        Order order = chooseOrder();
        if (order.getDate() == null) {
            return;
        }
        displayOrderInfo(order);
        while (!validInput) {
            choice = console.getString("Would you really like to remove this order? (Y/N)");
            if("Y".equalsIgnoreCase(choice)) {
                orderBook.delete(order);
                console.print("Order Removed!");
                validInput = true;
            }
            else if("N".equalsIgnoreCase(choice)) {
                console.print("Action canceled!");
                validInput = true;
            }
            else {
                console.print("Invalid choice");
            }
        }
        
    }
    
    private void saveCurrentWork() {
        if (!test) {
            orderBook.save();
            console.print("Work saved!");
        }
        else {
            console.print("Feature not available in test mode!");
        }
    }
    private String getValidState(boolean edit, Order order) {
        boolean validInput = false;
        String state="";
        while (!validInput) {
            if (edit) {
                state = console.getStringAcceptBlank("Enter State: (type help for list of states)", order.getState());
            }
            else {
                state = console.forceString("Enter State: (type help for list of states)");
            }
            if (!"help".equalsIgnoreCase(state)) {
                validInput = taxBook.containsState(state);
                if (validInput) {
                    state = state.toUpperCase();
                    return state;
                }
            }
            else {
                List<String> stateList=taxBook.getAllStates();
                for (String myState : stateList) {
                    console.print(myState);
                }
            }
            
        }
        return state;
    }
    
    private String getValidProduct(boolean edit, Order order) {
        boolean validInput = false;
        String type="";
        while (!validInput) {
            if (edit) {
               type = console.getStringAcceptBlank("Enter Product Type: (type help for list of product types)", order.getProductType());
            }
            else {
               type = console.forceString("Enter Product Type: (type help for list of product types)");
            }
            if (!"help".equals(type)) {
                validInput = productBook.containsType(type);
                if (validInput) {
                    return type;
                }
            }
            else {
                List<String> typeList=productBook.getAllTypes();
                for (String myType : typeList) {
                    console.print(myType);
                }
            }
            
        }
        return type;
        
    }
    private void setTests() {
        orderBook.setTest(test);
        productBook.setTest(test);
        taxBook.setTest(test);
    }
    
    private boolean config() {
        boolean myTest = true;
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("config.txt")));
            String currentLine = sc.nextLine();
            String[] stringParts = currentLine.split("=");
            sc.reset();
            if ("true".equals(stringParts[1]) && "test".equals(stringParts[0])) {
                return myTest;
            }
            else if ("false".equals(stringParts[1]) && "test".equals(stringParts[0])){
                myTest=false;
                return myTest;
            }
        }
        catch (Exception ex){
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myTest;
    }
    
    private Order createOrderObject(int orderNumber, Date date, String customerName, String state, String productType, double taxRate,  double area, double materialCostPerSF, double laborCostPerSF, double materialCost, double laborCost, double tax, double total) {
        Order myOrder = new Order();
        myOrder.setOrderNumber(orderNumber);
        myOrder.setDate(date);
        myOrder.setCustomerName(customerName);
        myOrder.setState(state);
        myOrder.setTaxRate(taxRate);
        myOrder.setProductType(productType);
        myOrder.setArea(area);
        myOrder.setMaterialCostPerSF(materialCostPerSF);
        myOrder.setLaborCostPerSF(laborCostPerSF);
        myOrder.setMaterialCost(materialCost);
        myOrder.setLaborCost(laborCost);
        myOrder.setTax(tax);
        myOrder.setTotal(total);
        
        return myOrder;
    }
    
    private void displayOrderInfo(Order myOrder) {
        console.print("Order Information:");
        console.print("==================");
        if (myOrder.getOrderNumber() != 0) {
            console.print("Order Number: "+ myOrder.getOrderNumber());
        }
        console.print("Date: " + sdf.format(myOrder.getDate()));
        console.print("Customer Name: " + myOrder.getCustomerName());
        console.print("State: " + myOrder.getState());
        console.print("Product Type: " + myOrder.getProductType());
        console.print("Floor Area: " + myOrder.getArea() + " square feet");
        console.print("Material Cost Per Square Foot: $" + df2.format(myOrder.getMaterialCostPerSF()));
        console.print("Labor Cost Per Square Foot: $" + df2.format(myOrder.getLaborCostPerSF()));
        console.print("Total Material Cost: $" + df2.format(myOrder.getMaterialCost()));
        console.print("Total Labor Cost: $" + df2.format(myOrder.getLaborCost()));
        Double subtotal = myOrder.getLaborCost() + myOrder.getMaterialCost();
        console.print("Subtotal: $" + df2.format(subtotal));
        console.print("Tax: $" + df2.format(myOrder.getTax()));
        console.print("Total: $" + df2.format(myOrder.getTotal()));
        console.print("===================");
    }
    
    private boolean returnToMenuOption() {
        boolean validInput = false;
        String choice;
        while (!validInput) {
            choice = console.getString("Would you like to return to the main menu? (Y/N)");
            if("Y".equalsIgnoreCase(choice)) {
                console.print("Returning to menu...");
                return true;
            }
            else if ("N".equalsIgnoreCase(choice)) {
                return false;
            }
            else {
                console.print("Invalid choice!");
            }
        }
        
        return false;
    }
    private Order chooseOrder() {
        Order order = new Order();
        List<Order> orderList = new ArrayList<>();
        Date date = new Date();
        boolean validInput=false;
        List<Date> dateList = dateViewOption();
        while (!validInput) {
            date = console.getDate("Enter date:");
            if (dateList.contains(date)) {
                orderList = orderBook.getOrdersOnDate(date);
                validInput = true;
            }
            else {
                boolean exit;
                console.print("There are no orders for that date!");
                exit = returnToMenuOption();
                if (exit) {
                    return order;
                }
            }
        }
        console.print("Orders for: " + sdf.format(date));
        for (Order myOrder : orderList) {
            console.print(myOrder.getOrderNumber() + ": " + myOrder.getCustomerName() + ", " + myOrder.getTotal());
        }
        validInput = false;
        int orderChoice =0;
        while (!validInput) {
            orderChoice = console.getInt("Choose an order to edit by entering order number: ");
            for (Order myOrder : orderList) {
                if (orderChoice == myOrder.getOrderNumber()) {
                    validInput = true;
                }
            }
            if (!validInput) {
                console.print("That order number is not on the list!");
            }
        }
        order = orderBook.findOrderByNo(orderChoice);
        return order;
    }

    private void addTax() {
        Tax tax = new Tax();
        String state = "";
        do {
            state=console.getString("Enter a two-letter state abbreviation: ");
            if (taxBook.containsState(state)) {
                console.print("State already exists!");
                boolean exit = returnToMenuOption();
                if (exit) {
                    return;
                }
            }
        } while (state.length() != 2 && !taxBook.containsState(state));
        double taxRate=console.getDouble("Enter the state tax rate: ");
        tax.setState(state);
        tax.setTaxRate(taxRate);
        taxBook.create(tax);
    }

    private void addProduct() {
        String type = "";
        Product product = new Product();
        do {
            type = console.getString("Enter the product type: ");
            if (productBook.containsType(type)) {
                console.print("Product already exists!");
                
            }
        } while (!productBook.containsType(type));
        double materialCost = console.getDouble("Enter the material cost per sq foot: ");
        double laborCost = console.getDouble("Enter the labor cost per sq foot: ");
        product.setType(type);
        product.setMaterialCostPerSF(materialCost);
        product.setLaborCostPerSF(laborCost);
        
        productBook.create(product);
        console.print("Product added!");
    }

    private void editTax() {
        List<Tax> taxes = getTaxes();
        int choice = console.getIntMinMax("Please choose a state to edit: ", 1, taxes.size());
        Tax tax = taxes.get(choice-1);
        Tax oldTax = tax;
        console.print("Editing ... (enter blank to leave unchanged)");
        String state = console.getStringAcceptBlank("Enter the two-letter state abbreviation: ", tax.getState());
        double taxRate = console.getDoubleAcceptBlank("Enter the state tax rate: ", tax.getTaxRate());
        tax.setState(state);
        tax.setTaxRate(taxRate);
        taxBook.update(tax, oldTax);
    }

    private void editProduct() {
        String type;
        List<Product> products = getProducts();
        int choice = console.getIntMinMax("Please choose a product to edit: ", 1, products.size());
        Product product = products.get(choice-1);
        Product oldProduct = product;
        String oldType = product.getType();
        do {
            type = console.getStringAcceptBlank("Enter the product type: ", oldType);
            if (productBook.containsType(type) &&  oldType.equals(type)){
                console.print("Product already exists!");
            }
        } while (!productBook.containsType(type));
        double materialCost = console.getDouble("Enter the material cost per sq foot: ");
        double laborCost = console.getDouble("Enter the labor cost per sq foot: ");
        product.setType(type);
        product.setMaterialCostPerSF(materialCost);
        product.setLaborCostPerSF(laborCost);
        productBook.update(product, oldProduct);
    }

    private void removeTax() {
        List<Tax> taxes = getTaxes();
        int choice = console.getIntMinMax("Please choose a state to remove: ", 1, taxes.size());
        taxBook.delete(taxes.get(choice-1));
        console.print("State removed!");
    }

    

    private void removeProduct() {
        List<Product> products = getProducts();
        int choice = console.getIntMinMax("Please choose a product to remove: ", 1, products.size());
        productBook.delete(products.get(choice-1));
        console.print("Product removed!");
    }
    
    private List<Tax> getTaxes() {
        List<Tax> taxes = taxBook.getAll();
        console.print("List of States:");
        int counter = 1;
        for (Tax myTax : taxes) {
            console.print(counter + ": " + myTax.getState());
            counter++;
        }
        return taxes;
    }
    
    private List<Product> getProducts() {
        List<Product> products = productBook.getAll();
        console.print("List of Products:");
        int counter = 1;
        for (Product myProduct : products) {
            console.print(counter + ": " + myProduct.getType());
            counter++;
        }
        return products;
    }
}
