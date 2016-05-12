/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dto;

/**
 *
 * @author apprentice
 */
public class Product {
    private String type;
    private double materialCostPerSF;
    private double laborCostPerSF;

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
}
