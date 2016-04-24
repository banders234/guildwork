/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rockpaperscissorsstep4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep4 {
    public static void main (String[] args) {
        int userChoice, pcChoice, rounds, counter = 1, userWins=0, pcWins=0, ties=0;
        boolean invalidChoice, playAgain = true;
        String pa;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        while (playAgain == true) {
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
                        ties++;
                    }
                    else if ((userChoice == 1 && pcChoice == 2) || (userChoice == 2 && pcChoice == 3) || (userChoice == 3 && pcChoice == 1)) {
                        System.out.println("Computer wins!");
                        pcWins++;
                    }   
                    else {
                        System.out.println("User wins!");
                        userWins++;
                    }
                    rounds--;
                    counter ++;
                }
                System.out.println("Games results: ");
                System.out.println("There were " + ties + " ties.");
                System.out.println("You won " + userWins + " rounds.");
                System.out.println("The computer won " + pcWins + " rounds.");
                if (userWins == pcWins) {
                    System.out.println("The game was a tie!");
                }
                else if (userWins > pcWins) {
                    System.out.println("You win the game!");
                }
                else {
                    System.out.println("The computer wins the game!");
                }
                System.out.println("Would you like to play again? (Y or N)");
                pa = sc.next();
                if ("Y".equals(pa)) {
                    System.out.println("Let's play again!");
                }
                else {
                    System.out.println("Goodbye!");
                    playAgain = false;
                }
            }
            else {
                System.out.println("Invalid choice! Program will exit now!");
            }
        }
    }
}
