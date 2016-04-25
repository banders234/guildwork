/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spaceboxing;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class SpaceBoxing {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int planetNumber = 0; 
        int earthWeight;
        double relativeGravity = 1, newWeight;
        System.out.print("Please enter your current earth weight: ");
        earthWeight = keyboard.nextInt();
        System.out.println("");
        System.out.println("I have information for the following planets:");
        System.out.println("   1. Venus   2. Mars     3. Jupiter");
        System.out.println("   4. Saturn  5. Uranus   6. Neptune");
        System.out.println("");
        while (planetNumber < 1 || planetNumber > 6) {
            System.out.print("Which planet are you visiting?");
            planetNumber = keyboard.nextInt();
            if (planetNumber < 1 || planetNumber > 6) {
                System.out.println("Invalid choice!");
            }
        }
        
        switch (planetNumber) {
            case 1:
                relativeGravity = 0.78;
                break;
            case 2:
                relativeGravity = 0.39;
                break;
            case 3:
                relativeGravity = 2.65;
                break;
            case 4:
                relativeGravity = 1.17;
                break;
            case 5:
                relativeGravity = 1.05;
                break;
            case 6:
                relativeGravity = 1.23;
                break;
        }
        newWeight = earthWeight * relativeGravity;
        System.out.println("");
        System.out.println("Your weight would be " + newWeight + " pounds on that planet.");
    }
}
