/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gendergame;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class GenderGame {
    public static void main (String args[]) {
        String firstName, lastName, gender, married;
        int age;
        Scanner sc = new Scanner(System.in);
        System.out.print("What is your gender (M or F): ");
        gender = sc.next();
        System.out.print("First name: ");
        firstName = sc.next();
        System.out.print("Last name: ");
        lastName = sc.next();
        System.out.print("Age: ");
        age = sc.nextInt();
        if (age >= 20 && "F".equals(gender)) {
            System.out.print("Are you married, " + firstName + "(y or n)? ");
            married = sc.next();
            if ("y".equals(married)) {
                System.out.println("Then I shall call you Mrs. " + lastName);
            }
            else {
                System.out.println("Then I shall you call you Ms. " + lastName);
            }
        }
        else if (age >= 20 && "M".equals(gender)) {
            System.out.println("Then I shall call you Mr. " + lastName);
        }
        else {
            System.out.println("Then I shall call you " + firstName + " " + lastName);
        }
    }
}
