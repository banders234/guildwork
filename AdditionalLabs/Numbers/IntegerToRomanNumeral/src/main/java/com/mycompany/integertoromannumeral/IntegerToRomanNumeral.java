/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.integertoromannumeral;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class IntegerToRomanNumeral {
    public static void main (String[] args) {
        int num;
        System.out.print("Enter number to be converted to roman numeral: ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        System.out.print("Roman numeral: ");
        while (num >= 1000) {
            System.out.print("M");
            num -= 1000;
        }
        while (num >= 900) {
            System.out.print("CM");
            num -= 900;
        }
        while (num >= 500) {
            System.out.print("D");
            num-= 500;
        }
        while (num >= 400) {
            System.out.print("CD");
            num-= 400;
        }
        while (num >= 100) {
            System.out.print("C");
            num-= 100;
        }
        while (num >= 90) {
            System.out.print("XC");
            num-= 90;
        }
        while (num >= 50) {
            System.out.print("L");
            num -= 50;
        }
        while (num >= 40) {
            System.out.print("XL");
            num -= 40;
        }
        while (num >= 10) {
            System.out.print("X");
            num -= 10;
        }
        while (num >= 9) {
            System.out.print("IX");
            num -= 9;
        }
        while (num >= 5) {
            System.out.print("V");
            num -= 5;
        }
        while (num >= 4) {
            System.out.print("IV");
            num -= 4;
        }
        while (num >= 1) {
            System.out.print("I");
            num -= 1;
        }
    }
}
