/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fortunecookie;
import java.util.Random;
/**
 *
 * @author apprentice
 */
public class FortuneCookie {
    public static void main (String[] args) {
        Random r = new Random();
        int num = 1 + r.nextInt(6);
        int l1 = 1 + r.nextInt(54);
        int l2 = 1 + r.nextInt(54);
        int l3 = 1 + r.nextInt(54);
        int l4 = 1 + r.nextInt(54);
        int l5 = 1 + r.nextInt(54);
        int l6 = 1 + r.nextInt(54);
        System.out.print("Fortune cookie says: ");
        switch (num) {
            case 1:
                System.out.println("Good things take time.");
                break;
            case 2:
                System.out.println("Your hiddent talents will reveal themselves.");
                break;
            case 3:
                System.out.print("Your principles spell success.");
                break;
            case 4:
                System.out.println("You have change in your future.");
                break;
            case 5:
                System.out.println("Stay true to your heart!");
                break;
            case 6:
                System.out.println("Don't worry, be happy!");
                break;
            default:
                System.out.println("Error!");
                break;
        }
        System.out.println("    " + l1 + " - " + l2 + " - " + l3 + " - " + l4 + " - " + l5 + " - " + l6);
    }
}
