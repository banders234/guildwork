/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alphabeticalorder;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class AlphabeticalOrder {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.print("What's your last name? ");
        name = sc.next();
        if ((name).compareTo("Carswell") <= 0) {
            System.out.println("You don't have to wait long, " + name + ".");
        }
        else if ((name).compareTo("Jones") <= 0) {
            System.out.println("It's not a bad wait, " + name + ".");
        }
        else if ((name).compareTo("Smith") <= 0) {
            System.out.println("Looks like a bit of a wait, " + name + ".");
        }
        else if ((name).compareTo("Young") <= 0) {
            System.out.println("It's gonna be a while, " + name + ".");
        }
        else {
            System.out.println("Not going anywhere for a while, " + name + "?");
        }
    }
}
