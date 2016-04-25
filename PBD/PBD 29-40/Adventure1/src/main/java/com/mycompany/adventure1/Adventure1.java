/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adventure1;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class Adventure1 {
    public static void main (String[] args) {
        String answer;
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO BRANDON'S TINY ADVENTURE");
        System.out.println();
        System.out.println("You are in a creepy house! Would you like to go \"upstairs\" or into the \"kitchen\"?");
        System.out.print("> ");
        answer = sc.next();
        if ("kitchen".equals(answer)) {
            System.out.println("There is a long countertop with dirty dishes everywhere. Off to one side there is, as you'd expect, a refrigerator. You may open the \"refrigerator\" or look in a \"cabinet\".");
            System.out.print("> ");
            answer = sc.next();
            if (("refrigerator").equals(answer)) { 
                System.out.println("There is rotten food. Eat it? \"yes\" or \"no\"");
                if (("yes").equals(answer)) {
                    System.out.println("You die of food poisoning.");
                }
                else if (("no").equals(answer)) {
                    System.out.println("You die of starvation.");
                }
            }
            else if (("cabinet").equals(answer)) {
                System.out.println("There is a mouse! Grab it? \"yes\" or \"no\"");
                if (("yes").equals(answer)) {
                    System.out.println("It bites you and you die of rabies.");
                }
                else if (("no").equals(answer)) {
                    System.out.println("It jumps on and bites you. You die of rabies.");
                }
            }
        }
        else if ("upstairs".equals(answer)) {
            System.out.println("Upstairs you see a hallway. At the end of the hallway is the master \"bedroom\". There is also a \"bathroom\" off the hallway. Where would you like to go?");
            System.out.print("> ");
            answer = sc.next();
            if (("bedroom").equals(answer)) {
                System.out.println("Open the closet door? \"yes\" or \"no\"?");
                if (("yes").equals(answer)) {
                    System.out.println("It's R. Kelly!");
                }
                else if (("no").equals(answer)) {
                    System.out.print("Now you'll never know what was in there.");
                }
            }
            else if (("bathroom").equals(answer)) {
                System.out.println("Pull back the shower curtain? \"yes\" or \"no\"");
                if (("yes").equals(answer)) {
                    System.out.print("Nothing there.");
                }
                else if (("no").equals(answer)) {
                    System.out.println("Suddenly it turns on. You run away.");
                }
            }
        }
    }
}
