/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nextprimenumber;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class NextPrimeNumber {
    public static void main (String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to find the next prime: ");
        num = sc.nextInt();
        boolean notPrime = true;
        while (notPrime == true) {
            num++;
            notPrime = false;
            for(int i = 2; i<num; i++) {
                if (num%i==0)
                    notPrime = true;
            }
            if (notPrime ==  false)
                System.out.println("The next prime is " + num + ".");        
        }
    }
}