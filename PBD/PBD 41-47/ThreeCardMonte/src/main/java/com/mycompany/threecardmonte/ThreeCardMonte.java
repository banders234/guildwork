/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.threecardmonte;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author apprentice
 */
public class ThreeCardMonte {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int num = r.nextInt(3) + 1;
        int guess;
        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.");
        System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
        System.out.println("He lays down three cards.");
        System.out.println();
        System.out.println("Which one is the ace?");
        System.out.println();
        System.out.println("      ## ## ##");
        System.out.println("      ## ## ##");
        System.out.println("      1  2  3 ");
        System.out.println();
        System.out.print("> ");
        guess = sc.nextInt();
        System.out.println();
        if (num == guess) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        }
        else {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + num + ".");
        }
        System.out.println();
        if (num == 1) {
            System.out.println("      AA ## ##");
            System.out.println("      AA ## ##");
            System.out.println("      1  2  3 ");
        }
        else if (num == 2) {
            System.out.println("      ## AA ##");
            System.out.println("      ## AA ##");
            System.out.println("      1  2  3 ");
        }
        else if (num == 3) {
            System.out.println("      ## ## AA");
            System.out.println("      ## ## AA");
            System.out.println("      1  2  3 ");
        }
    }
}
