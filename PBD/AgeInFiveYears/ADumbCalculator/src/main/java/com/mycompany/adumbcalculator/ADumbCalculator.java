/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adumbcalculator;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class ADumbCalculator {
    public static void main (String[] args)  {
        double firstNumber, secondNumber, thirdNumber, answer;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is your first number? ");
        firstNumber = keyboard.nextDouble();
        System.out.print("What is your second number? ");
        secondNumber = keyboard.nextDouble();
        System.out.print("What is your third number? ");
        thirdNumber = keyboard.nextDouble();
        answer = (firstNumber + secondNumber + thirdNumber) / 2;
        System.out.println("( " + firstNumber + " + " + secondNumber + " + " + thirdNumber + " ) / 2 is... " + answer);
        
    }
}
