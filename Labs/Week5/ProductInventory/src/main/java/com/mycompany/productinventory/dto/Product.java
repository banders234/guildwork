/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productinventory.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public abstract class Product {
    protected int id;
    protected double price;
    protected int stock;
    public int warning;
    protected String type;
    protected String name;
    protected List<String> sizeList = new ArrayList();
    protected String size;
    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }


    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the productType
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the productType to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the sizeList
     */
    public List<String> getSizeList() {
        return sizeList;
    }

    /**
     * @param sizeList the sizeList to set
     */
    public void setSizeList(List<String> sizeList) {
        this.sizeList = sizeList;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the warning
     */
    public int getWarning() {
        return warning;
    }

    /**
     * @param warning the warning to set
     */
    public void setWarning(int warning) {
        this.warning = warning;
    }
    
    
}
