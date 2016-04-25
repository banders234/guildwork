/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twentyquestions;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class TwentyQuestions {
    public static void main (String[] args) {
        String answer1, answer2, guess="";
        Scanner sc = new Scanner(System.in);
        System.out.println("TWO QUESTIONS!");
        System.out.println("Think of an object, and I'll try to guess it.");
        System.out.println("Question 1) Is it animal, vegetable, or mineral?");
        System.out.print("> ");
        answer1 = sc.next();
        System.out.println("Question 2)  Is it bigger than a breadbox?");
        System.out.print("> ");
        answer2 = sc.next();
        if ("animal".equals(answer1)) {
            if ("no".equals(answer2)) {
                guess = "squirrel";
            }
            else if ("yes".equals(answer2)) {
                guess = "moose";
            }
        }
        else if ("vegetable".equals(answer1)) {
            if ("no".equals(answer2)) {
                guess = "carrot";
            }
            else if ("yes".equals(answer2)) {
                guess = "watermelon";
            }
        }
        else if ("mineral".equals(answer1)) {
            if ("no".equals(answer2)) {
                guess = "paper clip";
            }
            else if ("yes".equals(answer2)) {
                guess = "Camaro";
            }
        }
        System.out.println("My guess is that you are thinking of a " + guess + ".");
        System.out.println("I would ask you if I'm right, but I don't actually care.");
    }
}
