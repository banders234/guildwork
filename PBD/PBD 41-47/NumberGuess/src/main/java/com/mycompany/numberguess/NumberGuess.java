/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.numberguess;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author apprentice
 */
public class NumberGuess {
    public static void main (String[] args) {
        Random r = new Random();
        int num = r.nextInt(10) + 1;
        int guess;
        System.out.println("I'm thinking of a number from 1 to 10.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Your guess: ");
        guess = sc.nextInt();
        System.out.println();
        if (guess == num) {
            System.out.println("That's right! My secret number was " + num + "!");
        }
        else {
            System.out.println("Sorry, but I was really thinking of " + num + ".");
        }
        
    }
    
}
