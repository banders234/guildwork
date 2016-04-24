/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fibonaccisequence;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class FibonacciSequence {
    public static void main (String[] args) {
        int f1 = 1, f2 = 1, counter, fib;
        Scanner sc = new Scanner(System.in);
        System.out.println(" How many numbers of the fibonacci sequence would you like?");
        counter = sc.nextInt();
        System.out.println("Printing sequence: ");
        if (counter >= 1) {
            System.out.println(0);
        }
        if (counter >= 2) {
            System.out.println(1);
        }
        if (counter >= 3) {
            System.out.println(1);
        }
        while (counter > 3) {
            fib = f1 + f2;
            System.out.println(fib);
            f2 = f1;
            f1 = fib;
            counter --;
        }
    }
}
