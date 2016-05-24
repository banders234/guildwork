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
public class Shirt extends Product {
    public Shirt() {
        super.type="shirt";
        sizeList.add("S");
        sizeList.add("M");
        sizeList.add("L");
        sizeList.add("XL");
    }

}
