/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.morevariablesandprinting;

/**
 *
 * @author apprentice
 */
public class MoreVariablesAndPrinting {
    public static void main(String[] args) {
        String myName, myEyes,  myTeeth, myHair;
        int myAge, myHeight, myWeight;
    
        myName = "Zed A. Shaw";
        myAge = 35;
        myHeight = 74;
        myWeight = 180;
        myEyes = "Blue";
        myTeeth = "White";
        myHair = "Brown";
    
        System.out.println("Let's talk about "  + myName + ".");
        System.out.println("He's "  + myHeight + ".");
        System.out.println("He's "  + myWeight + ".");
        System.out.println("Actually, that's not too heavy");
        System.out.println("He's got "  + myEyes + " eyes and " + myHair + " hair.");
        System.out.println("His teeth are usually "  + myTeeth + " depending on the coffee.");
    
    }
}
