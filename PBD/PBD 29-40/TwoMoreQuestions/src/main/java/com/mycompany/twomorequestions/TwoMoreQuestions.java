/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twomorequestions;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class TwoMoreQuestions {
    public static void main(String[] args) {
        String answer1, answer2, guess="";
        Scanner sc = new Scanner(System.in);
        System.out.println("TWO MORE QUESTIONS, BABY!");
        System.out.println();
        System.out.print("Question 1) Does it stay inside or outside or both? ");
        answer1 = sc.next();
        System.out.print("Question 2) Is it a living thing? ");
        answer2 = sc.next();
        if ("outside".equals(answer1) && "yes".equals(answer2)) {
            guess = "bison";
        }
        if ("inside".equals(answer1) && "yes".equals(answer2)) {
            guess = "houseplant";
        }
        if ("both".equals(answer1) && "yes".equals(answer2)) {
            guess = "dog";
        }
        if ("outside".equals(answer1) && "no".equals(answer2)) {
            guess = "billboard";
        }
        if ("inside".equals(answer1) && "no".equals(answer2)) {
            guess = "shower curtain";
        }
        if ("both".equals(answer1) && "no".equals(answer2)) {
            guess = "cell phone";
        }
        System.out.println("You're thinking of a " + guess + "!");
    }
}
