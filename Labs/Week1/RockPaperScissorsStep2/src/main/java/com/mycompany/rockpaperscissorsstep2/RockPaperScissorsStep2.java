/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rockpaperscissorsstep2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep2 {
    public static void main (String[] args) {
        int userChoice, pcChoice, rounds, counter = 1;
        boolean invalidChoice = false;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("How many rounds would you like to play? (1-10)");
        rounds = sc.nextInt();
        if (rounds <= 1 || rounds >= 10) {
            while (rounds > 0) {
                System.out.println("Round " + counter);
                System.out.println("Choose number to play Rock, Paper, Scissors:");
                do {
                    System.out.println("1: Rock 2. Paper 3. Scissors");
                    userChoice = sc.nextInt();
                    switch (userChoice) {
                        case 1:
                            System.out.println("User chooses rock");
                            invalidChoice = false;
                            break;
                        case 2:
                            System.out.println("User chooses paper");
                            invalidChoice = false;
                            break;
                        case 3:
                            System.out.println("User chooses scissors");
                            invalidChoice = false;
                            break;
                        default:
                            invalidChoice = true;
                            System.out.println("Invalid choice!");
                            break;
                    }
                } while (invalidChoice == true);
                pcChoice = rand.nextInt(3)+1;
                switch (pcChoice) {
                    case 1:
                        System.out.println("Computer chooses rock");
                        break;
                    case 2:
                        System.out.println("Computer chooses paper");
                        break;
                    case 3:
                        System.out.println("Computer chooses scissors");
                        break;
                }
                if (userChoice == pcChoice) {
                    System.out.println("It's a tie!");
                }
                else if ((userChoice == 1 && pcChoice == 2) || (userChoice == 2 && pcChoice == 3) || (userChoice == 3 && pcChoice == 1)) {
                    System.out.println("Computer wins!");
                }
                else {
                    System.out.println("User wins!");
                }
                rounds--;
                counter ++;
            }
        }
        else {
            System.out.println("Invalid choice!");
        }
    }
}
