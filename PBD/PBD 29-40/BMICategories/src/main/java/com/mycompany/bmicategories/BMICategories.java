/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bmicategories;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BMICategories {
    public static void main (String[] args) {
        double height, bmi;
        int weight;
        String bmiCat = "unknown";
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Your height in m: ");
        height = keyboard.nextDouble();
        System.out.println("Your weight in kg: ");
        weight = keyboard.nextInt();
        System.out.println("" );
        bmi = weight / (height * height);
        System.out.println("Your BMI is " + bmi);
        if (bmi < 18.5) {
            bmiCat = "underweight";
        }
        if (bmi >= 18.5 && bmi <= 24.9) {
            bmiCat = "normal weight";
        }
        if (bmi >= 25.0 && bmi <= 29.9) {
            bmiCat = "overweight";
        }
        if (bmi >= 30.0) {
            bmiCat = "obese";
        }
        System.out.println("BMI Category: " + bmiCat);
    }
}
