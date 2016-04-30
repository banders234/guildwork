/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.firstlast6;

/**
 *
 * @author apprentice
 */
public class FirstLast6 {
    public boolean FirstLast6(int[] numbers) {
        if (numbers[0] == 6 || numbers[numbers.length - 1 ] == 6) {
            return true;
        }
        else{
            return false;
        }
    }
}
