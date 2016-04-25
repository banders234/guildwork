/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.agemessages3;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class AgeMessages3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        System.out.print("Your name: ");
        name = sc.next();
        System.out.print("Your age: ");
        System.out.println();
        age = sc.nextInt();
        if (age < 16) {
            System.out.println("You can't drive, " + name);
        }
        else if (age <= 17 && age >= 16) {
            System.out.println("You can drive but not vote, " + name);
        }
        else if (age >= 18 && age <= 24) {
            System.out.println("You can vote but you can't rent a car, " + name);
        }
        else {
            System.out.println("You can do pretty much anything, " + name);
        }
    }
}
