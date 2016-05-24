/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productinventory.dto;

/**
 *
 * @author apprentice
 */
public class Pants extends Product {
    public Pants() {
        super.type="pants";
        sizeList.add("S");
        sizeList.add("M");
        sizeList.add("L");
        sizeList.add("XL");
    }
}
