/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blackjack;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class ConsoleIO {
    public int getInt(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        int value = sc.nextInt();
        return value;
    }
    public int getIntMinMax(String prompt, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int value = 0;
        System.out.println(prompt);
        do {
            value = sc.nextInt();
        } while (value < max && value > min);
        return value;
    }
    public String getString(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        String value = sc.nextLine();
        return value;
    }
    public float getFloatMinMax(String prompt, float min, float max) {
        Scanner sc = new Scanner(System.in);
        float value = 0;
        System.out.println(prompt);
        do {
            value = sc.nextFloat();
        } while (value < max && value > min);
        return value;
    }
    public double getDouble(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        double value = sc.nextDouble();
        return value;
    }
    public double getDoubleMinMax(String prompt, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double value = 0;
        System.out.println(prompt);
        do {
            value = sc.nextDouble();
        } while (value < max && value > min);
        return value;
    }
    public void printString(String prompt) {
        System.out.println(prompt);
    }
}
