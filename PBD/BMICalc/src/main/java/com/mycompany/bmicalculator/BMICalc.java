/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bmicalculator;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class BMICalc {
    public static void main (String[] args) {
        double height, bmi;
        int weight;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Your height in m: ");
        height = keyboard.nextDouble();
        System.out.println("Your weight in kg: ");
        weight = keyboard.nextInt();
        System.out.println("" );
        bmi = weight / (height * height);
        System.out.println("Your BMI is " + bmi);
    }
}
