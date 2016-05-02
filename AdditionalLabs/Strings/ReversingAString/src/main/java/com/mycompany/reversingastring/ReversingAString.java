/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reversingastring;

/**
 *
 * @author apprentice
 */
public class ReversingAString {
    public static void main(String[] args) {
        ConsoleIO console = new ConsoleIO();
        String str = console.getString("Enter string to be reversed:");
        String reversed = "";
        for (int i =0; i<str.length(); i++) {
            reversed += str.charAt(str.length() - 1 - i);
        }
        console.print(reversed);
    }
}
