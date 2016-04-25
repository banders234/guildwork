/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worstguessing;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class WorstGuessing {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int guess;
        int secret = 4;
        System.out.println("TEH WORST NUBMER GESSING GAME EVAR!!!!!!!1!");
        System.out.println();
        System.out.print("I\"M THKING OF A NBR FROM 1-10. TRY 2 GESS! " );
        guess =sc.nextInt();
        System.out.println();
        if (guess == secret) {
            System.out.println("LOL!!! U GOT IT! I CANT BELEIVE U GESSED IT WAS " + secret + "!");
        }
        else {
            System.out.println("W00T! U SUX0R!!! I PWN J00!!! IT WAS " + secret +"!");
        }
    }
}
