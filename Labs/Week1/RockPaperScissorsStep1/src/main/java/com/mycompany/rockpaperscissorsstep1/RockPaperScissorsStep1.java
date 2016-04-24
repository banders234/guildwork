/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rockpaperscissorsstep1;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep1 {
    public static void main (String[] args) {
        int userChoice, pcChoice;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose number to play Rock, Paper, Scissors:");
        userChoice = sc.nextInt();
        pcChoice = rand.nextInt(3)+1;
        if (userChoice == pcChoice) {
            System.out.println("It's a tie!");
        }
        else if ((userChoice == 1 && pcChoice == 2) || (userChoice == 2 && pcChoice == 3) || (userChoice == 3 && pcChoice == 1)) {
            System.out.println("Computer wins!");
        }
        else {
            System.out.println("User wins!");
        }
    }
}
