/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ageinfiveyears;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class AgeInFiveYears {
    public static void main (String[] args) {
        String name;
        int age, ageIn5, age5Ago;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Hello. What is your name? ");
        name = keyboard.next();
        System.out.print("Hi, " + name + "! How old are you?");
        age = keyboard.nextInt();
        ageIn5 = age + 5;
        age5Ago = age - 5;
        System.out.println("");
        System.out.println("Did you that in five years you will be " + ageIn5 + " years old?");
        System.out.println("And five years ago you were " + age5Ago + "! Imagine that!");
    }
    
}
