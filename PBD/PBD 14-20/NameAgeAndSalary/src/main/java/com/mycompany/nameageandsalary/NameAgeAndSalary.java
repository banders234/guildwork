/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nameageandsalary;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class NameAgeAndSalary {
    public static void main(String[] args)  {
        String name;
        int age;
        double wage;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hello. What is your name?");
        name = keyboard.next();
        System.out.println("Hi, " + name + "! How old are you?");
        age = keyboard.nextInt();
        System.out.println("So you're " + age + ", eh? That's not old at all!");
        System.out.println("How much do you make, Dennis?");
        wage= keyboard.nextDouble();
        System.out.println(wage + "! I hope that's per hour and not per year! LOL!");
        
    }
}
