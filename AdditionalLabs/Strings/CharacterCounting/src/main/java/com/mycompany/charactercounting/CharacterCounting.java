/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.charactercounting;
/**
 *
 * @author apprentice
 */
public class CharacterCounting {
    public static void main(String[] args) {
        int vowels=0, spaces = 0, consonants = 0;
        char c;
        ConsoleIO console = new ConsoleIO();
        String str = console.getString("Enter string to count vowels, consonants and spaces:");
        for(int i = 0; i<str.length(); i++) {
            c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            }
            else if (c == ' ' || c == '\n' || c == '\t') {
               spaces++;
            }
            else if ((c>= 'a' && c <= 'z') || (c>='A' && c<= 'Z')) {
                consonants++;
            }
        }
        console.print("There are " + vowels + " vowels.");
        console.print("There are " + consonants + " consonants.");
        console.print("There are " + spaces + " spaces.");
    }
}
