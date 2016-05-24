/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.morsecodemaker;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class MorseCodeMaker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] alpha = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0", " " };
        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "|" };
        String a, m, mstr="";
        int index;
        for (int i = 0; i < str.length(); i++) {
            
            if (Arrays.asList(alpha).contains(Character.toString(str.charAt(i)))) {
                a = Character.toString(str.charAt(i));
                index=Arrays.asList(alpha).indexOf(a);
                m = morse[index];
                mstr += m;
            }
        }
        System.out.println(mstr);
    }
    
    
}
