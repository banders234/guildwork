/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;


public class OrderCommandObject {
    private int id;
    @NotEmpty(message = "You must input a customer name")
    private String customerName;
    @NotEmpty(message = "You must select a product type")
    private String productType;
    @NotNull(message = "Area must be more than 1 square foot")
    @Min(value = 1, message = "Area must be more than 1 square foot")
    private Double area;
    @NotEmpty(message = "You must selct a state")
    private String state;
    @NotEmpty(message = "You must select a date")
    private String date;

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
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
}