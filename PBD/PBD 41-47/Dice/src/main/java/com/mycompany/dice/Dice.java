/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dice;
import java.util.Random;
/**
 *
 * @author apprentice
 */
public class Dice {
    public static void main (String[] args) {
        Random r = new Random();
        int r1 = r.nextInt(6) + 1;
        int r2 = r.nextInt(6) + 1;
        System.out.println("HERE COMES THE DICE!");
        System.out.println();
        System.out.println("Roll #1: " + r1);
        System.out.println("Roll #2: " + r2);
        int total = r1 + r2;
        System.out.println("The total is " + total + "!");
    }
}
