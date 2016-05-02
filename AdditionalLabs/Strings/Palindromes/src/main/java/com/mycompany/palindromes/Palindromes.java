/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.palindromes;

/**
 *
 * @author apprentice
 */
public class Palindromes {
    public static void main(String[] args) {
        ConsoleIO console = new ConsoleIO();
        String str = console.getString("Enter string to be reversed:");
        String str2 ="";
        String reversed = "";
        for (int i =0; i<str.length(); i++) {
            if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
                str2 += str.charAt(i);
            }
            
        }
        for (int i =0; i<str2.length(); i++) {
                reversed += str2.charAt(str2.length() - 1 - i);
            
        }
        if (reversed.equals(str2)) {
            console.print("String is a palindrome!");
        }
        else {
            console.print("String is not a palindrome!");
        }
    }
}
