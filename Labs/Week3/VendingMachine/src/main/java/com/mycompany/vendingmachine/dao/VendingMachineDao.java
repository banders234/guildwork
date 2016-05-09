/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.controllers.App;
import com.mycompany.vendingmachine.dto.VendingItem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class VendingMachineDao {
    private List<VendingItem> items = decode();
    private int nextId = 1;
    
    public VendingItem create(VendingItem item) {
        boolean valid=false;
        List<Integer> idList = new ArrayList<>();
        for (VendingItem myItem : items) {
            idList.add(myItem.getId());
        }
        while (!valid) {
            if (!idList.contains(nextId)) {
                item.setId(nextId);
                valid=true;
            }
            else{
                nextId++;
            }
        }
        nextId++;
        items.add(item);
        encode();
        return item;
    }
    
    public void delete(VendingItem item) {
        items.remove(item);
        encode();
    }
    
    public void update(VendingItem myItem) {
        for (VendingItem item : items)  {
            if (myItem.getId() == item.getId()) {
                items.remove(item);
                items.add(myItem);
                break;
            }
        }
        encode();
    }
    
    public List<VendingItem> find(String name) {
        List<VendingItem> iteml = new ArrayList<>();
        VendingItem item = new VendingItem();
        for (VendingItem a : items) {
            if ((a.getName()).equals(name)) {
                iteml.add(a);
            }
        }
        return iteml;
    }
    

    
    public int getCount() {
        return items.size();
    }
    
    public List<VendingItem>  getAll() {
        
        return items;
    }
    
    public List<VendingItem> getAllInStock() {
        List<VendingItem> allInStock = new ArrayList<>();
        for (VendingItem item : items) {
            if (item.getInventory() > 0) {
                allInStock.add(item);
            }
        }
        
        return allInStock;
    }
    
    private void encode() {
        final String TOKEN = "::";

        try {
                PrintWriter out = new PrintWriter(new FileWriter("items.txt"));
                for (VendingItem myItem : items) {
                    out.print(myItem.getId());
                    out.print(TOKEN);
                                        
                    out.print(myItem.getName());
                    out.print(TOKEN);
                    
                    out.print(myItem.getCost());
                    out.print(TOKEN);

                    out.print(myItem.getInventory());
                    out.println();
                      
                }
                out.flush();
                out.close();

            } catch(IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }


    }
    
    private List<VendingItem> decode() {
        List<VendingItem> itemList = new ArrayList();
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("items.txt")));

            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] stringParts= currentLine.split("::");
                VendingItem myItem = new VendingItem();

                int id = Integer.parseInt(stringParts[0]);

                myItem.setId(id);
                myItem.setName(stringParts[1]);
                myItem.setCost(Double.parseDouble(stringParts[2]));
                myItem.setInventory(Integer.parseInt(stringParts[3]));


                itemList.add(myItem);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemList;
    }
}
