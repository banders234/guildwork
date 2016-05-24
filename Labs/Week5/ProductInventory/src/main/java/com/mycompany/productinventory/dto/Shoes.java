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
public class Shoes extends Product {
    public Shoes() {
        super.type="shoe";
        int counter = 5;
        while (counter <= 15) {
            super.sizeList.add(String.valueOf(id));
            counter++;
        }
    }
}
