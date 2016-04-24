/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interestcalculator;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author apprentice
 */
public class InterestCalculator {
    private static DecimalFormat df2 = new DecimalFormat("#.00");
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int years, counter = 0, quarters;
        double qi, ePrincipal, sPrincipal, interest;
        System.out.println("What is the interest rate?");
        qi= sc.nextInt()/4 ;
        System.out.println("What is the initial amount of principal?");
        sPrincipal = sc.nextInt();
        System.out.println("And how many years is the money supposed to stay in the fund?");
        years = sc.nextInt();
        quarters = years * 4;
        ePrincipal = sPrincipal;
        boolean oneLoop = false;
        while (quarters >= 0) {
            ePrincipal = ePrincipal * (1 + (qi/100));
            if (((quarters % 4) == 0) && oneLoop == true) {
                counter++;
                interest = ePrincipal - sPrincipal;
                System.out.println("In year " + counter + " you:");
                System.out.println("Had " + df2.format(sPrincipal) + " dollars at the beginning of the year.");
                System.out.println("Gained " + df2.format(interest) + " dollars of interest.");
                System.out.println("Had " + df2.format(ePrincipal) + " dollars at the end of the year.");
                sPrincipal = ePrincipal;
            }
            quarters --;
            oneLoop = true;
        }
    }
}
