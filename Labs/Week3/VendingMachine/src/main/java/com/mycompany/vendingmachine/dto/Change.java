/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class Change {
    private int quarters=0;
    private int dimes=0;
    private int nickels=0;
    private int pennies=0;
    
    
    
    public void getChange(double remainder) {
        double r = remainder*100;
        while (r >= 25) {
            quarters++;
            r-=25;
        }
        while (r >= 10) {
            dimes++;
            r-=10;
        }
        while (r >= 5) {
            nickels++;
            r-=5;
        }
        while (r >= 1) {
            pennies++;
            r-=1;
        }
    }

    /**
     * @return the quarters
     */
    public int getQuarters() {
        return quarters;
    }

    /**
     * @return the dimes
     */
    public int getDimes() {
        return dimes;
    }

    /**
     * @return the nickels
     */
    public int getNickels() {
        return nickels;
    }

    /**
     * @return the pennies
     */
    public int getPennies() {
        return pennies;
    }
    
}
