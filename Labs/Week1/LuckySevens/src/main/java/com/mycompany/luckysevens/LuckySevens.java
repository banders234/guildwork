/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luckysevens;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class LuckySevens {
    public static void main (String[] args) {
        int rolls=0, maxDollars = 0, maxRolls = 0, dollars, dice;
        Scanner sc = new Scanner(System.in);
        Random rand= new Random();
        System.out.print("Enter the amount of dollars you would like to bet: ");
        dollars = sc.nextInt();
        maxDollars = dollars;
        while (dollars > 0 ) {
            dice=rand.nextInt(11)+2;
            if (dollars > maxDollars) {
                maxDollars = dollars;
                maxRolls = rolls;
            }
            if (dice == 7) {
                dollars += 4;
            } 
            else {
                dollars -= 1;
            }
            rolls++;
        }
        System.out.println("You are broke after " + rolls + " rolls.");
        System.out.println("You should have quit after " + maxRolls + " rolls when you had $" +  maxDollars);
    }
}
