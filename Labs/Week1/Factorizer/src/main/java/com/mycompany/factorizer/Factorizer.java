/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorizer;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class Factorizer {
    public static void main (String[] args) {
            int num, counter=1, factorCount = 0, factorSum = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number to find factors: ");
            num = sc.nextInt();
            while (counter < num) {
                if (num % counter == 0) {
                    factorCount++;
                    System.out.println(counter);
                    factorSum += counter;
                }
                counter++;
            }
            if (factorCount == 1) {
                System.out.println(num + " is a prime number!");
            }
            else {
                System.out.println(num + " is not a prime number!");
            }
            if (factorSum == num) {
                System.out.println(num + " is a perfect number!");
            }
            else {
                System.out.println(num + " is not a perfect number!");
            }
    } 
}
