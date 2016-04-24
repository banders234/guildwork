/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tipcalculator;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author apprentice
 */
public class TipCalculator {
    private static DecimalFormat df2 = new DecimalFormat("#.00");
    public static void main (String[] args) {
        double tipPer, sTotal, total, tip;
        String displayTotal, displaySTotal, displayTip;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your pre-tip bill total.");
        sTotal = sc.nextDouble();
        System.out.println("Enter the percent you want to tip.");
        tipPer = sc.nextDouble()/100;
        tip = sTotal*tipPer;
        total = sTotal + tip;
        displayTip=("$"+df2.format(tip));
        displaySTotal=("$"+df2.format(sTotal));
        displayTotal=("$"+df2.format(total));
        System.out.println("Amount:"+displaySTotal);
        System.out.println("Tip:   "+displayTip);
        System.out.println("Total  "+displayTotal);
        
    }
}
