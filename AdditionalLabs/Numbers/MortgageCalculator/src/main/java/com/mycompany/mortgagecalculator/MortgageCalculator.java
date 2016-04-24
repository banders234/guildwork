/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mortgagecalculator;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class MortgageCalculator {
    public static void main (String[] args) {
        int p, t;
        double c, i, a, mi;
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter the principal of the loan: ");
        p = sc.nextInt();
        System.out.println("Enter the interest rate of the loan: ");
        i = sc.nextDouble()/100;
        mi = i/12;
        System.out.println("Enter the term of the loan (in months): ");
        t = sc.nextInt();
        a=Math.pow((1+mi), (t * -1));
        System.out.println(1+mi);
        c= (mi * p)/(1-a);
        c = Math.round(c*100.0)/100.0;
        System.out.println("Your monthly payment is $" + c + ".");
    }
}
