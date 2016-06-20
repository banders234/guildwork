/*s
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author apprentice
 */
public class Order {
    private int orderNumber;
    
    @NotEmpty(message="Must enter a customer name!")
    private String customerName;
    
    @NotEmpty(message="Must enter a state!")
    private String state;
    
    private double taxRate;
    
    @NotEmpty(message="Must enter a product type!")
    public String productType;
    
    private Integer productId;
    public Integer taxId;
    
    @NotNull(message="Must enter an area!")
    private Double area;
    
    private double materialCostPerSF;
    private double laborCostPerSF;
    private double materialCost;
    private double laborCost;
    private double tax;
    private double total;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NotNull(message="Must enter a date!")
    private Date date;
    private String dateString;
    /**
     * @return the orderNumber
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
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
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the taxRate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * @return the productType
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId the productType to set
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return the area
     */
    public Double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * @return the materialCostPerSF
     */
    public double getMaterialCostPerSF() {
        return materialCostPerSF;
    }

    /**
     * @param materialCostPerSF the materialCostPerSF to set
     */
    public void setMaterialCostPerSF(double materialCostPerSF) {
        this.materialCostPerSF = materialCostPerSF;
    }

    /**
     * @return the laborCostPerSF
     */
    public double getLaborCostPerSF() {
        return laborCostPerSF;
    }

    /**
     * @param laborCostPerSF the laborCostPerSF to set
     */
    public void setLaborCostPerSF(double laborCostPerSF) {
        this.laborCostPerSF = laborCostPerSF;
    }

    /**
     * @return the materialCost
     */
    public double getMaterialCost() {
        return materialCost;
    }

    /**
     * @param materialCost the materialCost to set
     */
    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    /**
     * @return the laborCost
     */
    public double getLaborCost() {
        return laborCost;
    }

    /**
     * @param laborCost the laborCost to set
     */
    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    /**
     * @return the tax
     */
    public double getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the dateString
     */
    public String getDateString() {
        return dateString;
    }

    /**
     * @param dateString the dateString to set
     */
    public void setDateString(String dateString) {
        this.dateString = dateString;
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
     * @return the taxId
     */
    public Integer getTaxId() {
        return taxId;
    }

    /**
     * @param taxId the taxId to set
     */
    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }
}
