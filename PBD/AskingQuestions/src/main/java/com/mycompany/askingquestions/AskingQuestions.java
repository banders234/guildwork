/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.askingquestions;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AskingQuestions {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int age;
        int feet, inches;
        double weight;
        
        System.out.print( "How old are you?" );
        age = keyboard.nextInt();
        System.out.print( "How many feet tall are you?" );
        feet = keyboard.nextInt();
        System.out.print("And how many inches?");
        inches = keyboard.nextInt();
        System.out.print("How much do you weigh in pounds?");
        weight =  keyboard.nextDouble();
        
        System.out.println("So you're " + age + " years old, " + feet + "'" + inches + "\"" +  " tall and " + weight + " pounds.");
    }
}
