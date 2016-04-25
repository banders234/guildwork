/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alittlequiz;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class ALittleQuiz {
    public static void main (String[] args) {
        int answer1, answer2, answer3;
        int score=0;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Are you ready for a quiz? ");
        keyboard.next();
        System.out.println("Okay, here it comes!");
        System.out.println("");
        System.out.println("Q1) What is the capital of Alaska?");
        System.out.println("  1) Melbourne");
        System.out.println("  2) Anchorage");
        System.out.println("  3) Juneau");
        System.out.println("");
        System.out.print("> ");
        answer1 = keyboard.nextInt();
        if (answer1 == 3) {
            System.out.print("That's right!");
            score++;
        }
        else {
            System.out.print("Wrong!");
        }
        System.out.println("");
        System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?");
        System.out.println("  1) yes");
        System.out.println("  2) no");
        System.out.println("");
        System.out.print("> ");
        answer2 = keyboard.nextInt();
        if (answer2 == 1) {
            System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.");
        }
        else if (answer2 == 2) {
            System.out.println("That's correct!");
            score++;
        }
        else {
            System.out.println("Wrong!");
        }
        System.out.println("");
        System.out.println("Q3) What is the result of 9+6/3");
        System.out.println("  1) 5");
        System.out.println("  2) 11");
        System.out.println("  3) 15/3");
        System.out.println("");
        System.out.print("> ");
        answer3 = keyboard.nextInt();
        if (answer3 == 2) {
            System.out.println("That's correct!");
            score++;
        }
        else {
            System.out.println("That's wrong!");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Overall, you got " + score + " out of 3 correct.");
        System.out.println("Thanks for playing!");
    }
}
