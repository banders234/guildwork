/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.changereturnprogram;
import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author apprentice
 */
public class ChangeReturnProgram {
    private static DecimalFormat df2 = new DecimalFormat("#.00");
    public static void main (String[] args) {
        int choice, quarters=0, nickels=0, dimes=0, pennies=0;
        int price = 0, cash, change;
        boolean badChoice = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to my vending machine!");
        System.out.println("Enter number to choose item:");
        System.out.println("1. Chips: $0.50   2. Soda: 0.75 3. Honey Bun $1.00");
        System.out.println("4. Twizzlers: $0.75 5. Pop Tarts 0.75 6. Skittles $0.60");
        while (badChoice == true) {
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    price = 50;
                    badChoice = false;
                    break;
                case 2:
                    price = 75;
                    badChoice = false;
                    break;
                case 3:
                    price = 100;
                    badChoice = false;
                    break;
                case 4:
                    price = 75;
                    badChoice = false;
                    break;
                case 5:
                    price = 75;
                    badChoice = false;
                    break;
                case 6:
                    price = 60;
                    badChoice = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
            System.out.println("Your chosen item costs " + price + " cents.");
            System.out.println("Enter the amount to give vending machine. (in cents)");
            cash = sc.nextInt();
            change = cash - price;
            System.out.println(change);
            while (change >= 25) {
                quarters++;
                change -= 25;
            }
            while (change >= 10) {
                dimes++;
                change -= 10;
            }
            while (change >= 5) {
                nickels++;
                change -= 5;
            }
            while (change > 0) {
                pennies++;
                change -= 1;
            }
            System.out.println("Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, and " + pennies + " pennies.");       
    }
}
