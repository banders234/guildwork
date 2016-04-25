/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moreuserinputofdata;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class MoreUserInputofData {
    public static void main (String[] args)  {
        String firstName, lastName, login;
        int grade, studentID;
        double gpa;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the following data so I can sell it for a profit!");
        System.out.println("");
        System.out.print("First name: ");
        firstName = keyboard.next();
        System.out.print("Last name: ");
        lastName = keyboard.next();
        System.out.print("Grade (9-12): ");
        grade = keyboard.nextInt();
        System.out.print("Student ID: ");
        studentID = keyboard.nextInt();
        System.out.print("Login: ");
        login = keyboard.next();
        System.out.print("GPA (0.0-40): ");
        gpa = keyboard.nextDouble();
        System.out.println("Your information:");
        System.out.println("    Login: " + login);
        System.out.println("    ID:    " + studentID);
        System.out.println("    Name:  " + lastName + ", " + firstName);
        System.out.println("    GPA:   " + gpa);
        System.out.println("    Grade: " + grade);
        
    }
}
