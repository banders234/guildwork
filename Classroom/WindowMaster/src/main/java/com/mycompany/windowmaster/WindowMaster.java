/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.windowmaster;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WindowMaster {
    public static void main(String args[]) {
        int height = 0, width = 0;
        int amountOfWindows;
        double area, perimeter;
        double trimCost;
        double glassCost;
        double totalGlassCost, totalTrimCost, totalWindowCost, totalCost;
        final double maxHeight = 25.5;
        final double maxWidth = 18.75;
        final double minWidth = 1.0;
        final double minHeight = 1.0;
        boolean outOfBoundsHeight = true;
        boolean outOfBoundsWidth = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("How much would you like to pay for the glass? (in dollars and cents)");
        glassCost =Double.parseDouble(sc.nextLine());
        System.out.println("How much would you like to pay for the trim? (in dollars and cents)");
        trimCost = Double.parseDouble(sc.nextLine());
        while (outOfBoundsHeight == true) {
            System.out.println("What is the height of the window in inches?");
            height=Integer.parseInt(sc.nextLine())/12;
            if (height < minHeight) {
                System.out.println("That height is too small!");
            }
            else if (height > maxHeight) {
                System.out.println("That height is too big!");
            }
            else {
                outOfBoundsHeight = false;
            }
        }
        while (outOfBoundsWidth == true) {
            System.out.println("What is the width of the window in inches?");
            width=Integer.parseInt(sc.nextLine())/12;
            if (width < minWidth) {
                System.out.println("That width is too small!");
            }
            else if (width > maxWidth) {
                System.out.println("That width is too big!");
            }
            else {
                outOfBoundsWidth = false;
            }
        }
        System.out.println("How many of these windows would you like?");
        amountOfWindows=Integer.parseInt(sc.nextLine());
        area= height * width;
        perimeter = (2* height) + (2 * width);
        totalGlassCost = (area * glassCost);
        totalTrimCost = (perimeter * trimCost);
        totalWindowCost = totalGlassCost + totalTrimCost;
        totalCost = totalWindowCost * amountOfWindows;
        System.out.println("The perimeter of the window is " + perimeter + " feet.");
        System.out.println("The area of the window is " + area + " square feet.");
        System.out.println("The cost of the glass is " + totalGlassCost + " dollars.");
        System.out.println("The cost of the trim is " + totalTrimCost + " dollars.");
        System.out.println("The cost of a window is " + totalWindowCost + " dollars.");
        System.out.println("The total cost of your order is " + totalCost + " dollars.");
    }
}
