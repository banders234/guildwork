/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wordcounting;

/**
 *
 * @author apprentice
 */
public class WordCounting {
    public static ConsoleIO console = new ConsoleIO();
    public static void main(String[] args) {
        String str = console.getString("Enter phrase to count words:");
        String[]str2 = str.split("\\s+");
        int wordCount = str2.length;
        console.print("There are " + wordCount + " words in that phrase.");
    }
}
