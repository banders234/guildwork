/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oneshothilo;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author apprentice
 */
public class OneShotHiLo {
    public static void main (String[] args) {
        Random r = new Random();
        int guess, num;
        num = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("I'm thinking of a number between 1-100. Try to guess it.");
        System.out.print("> ");
        guess = sc.nextInt();
        System.out.println();
        if (guess > num) {
            System.out.println("Sorry you are too high. I was thinking of " + num + ".");
        }
        else if (guess < num) {
            System.out.println("Sorry, you are too low. I was thinking of " + num + ".");
        }
        else if (guess == num) {
            System.out.println("You guessed it! What are the odds?!?");
        }
    }
}
