/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author apprentice
 */
public class Product {
    
    
    @NotEmpty
    private String type;
    
    @Min(0)
    @NotNull
    private Double materialCostPerSF;
    
    @Min(0)
    @NotNull
    private Double laborCostPerSF;

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
    public Double getMaterialCostPerSF() {
        return materialCostPerSF;
    }

    /**
     * @param materialCostPerSF the materialCostPerSF to set
     */
    public void setMaterialCostPerSF(Double materialCostPerSF) {
        this.materialCostPerSF = materialCostPerSF;
    }

    /**
     * @return the laborCostPerSF
     */
    public Double getLaborCostPerSF() {
        return laborCostPerSF;
    }

    /**
     * @param laborCostPerSF the laborCostPerSF to set
     */
    public void setLaborCostPerSF(Double laborCostPerSF) {
        this.laborCostPerSF = laborCostPerSF;
    }
}
