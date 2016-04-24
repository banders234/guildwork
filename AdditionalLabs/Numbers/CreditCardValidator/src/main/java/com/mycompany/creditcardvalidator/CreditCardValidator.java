/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.creditcardvalidator;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class CreditCardValidator {
    public static void main (String[] args) {
        int choice;
        String cardNumber;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose type of credit card: ");
        System.out.println("1. Visa 2. Mastercard");
        System.out.println("3. American Express 4. Discover");
        System.out.print("> ");
        choice = sc.nextInt();
        System.out.print("Enter card number (no dashes or spaces): ");
        cardNumber=sc.next();
        switch (choice) {
            case 1:
                visa(cardNumber);
                break;
            case 2:
                masterCard(cardNumber);
                break;
            case 3:
                amExpress(cardNumber);
                break;
            case 4:
                discover(cardNumber);
                break;
            default:
                System.out.println("Not a valid choice!");
                break;
        }
    }
    public static void visa(String ccNumber) {
        int ccLength = ccNumber.length();
        if (ccNumber.length() != 13 && ccNumber.length() !=  16 && ccNumber.length() != 19) {
            System.out.println("Invalid card number!");
        }
        else if ("4".equals(ccNumber.substring(0,1))){
            luhnAlgorithm(ccNumber, ccLength);
        }
        else {
            System.out.println("Invalid card number! (wrong prefix)");
        }
    }
    public static void masterCard(String ccNumber) {
        int prefix = Integer.parseInt(ccNumber.substring(0,1));
        int ccLength = ccNumber.length();
        if (ccNumber.length() != 16) {
            System.out.println("Invalid card number!");
        }
        else if (prefix <= 55 && prefix >= 51){
            luhnAlgorithm(ccNumber, ccLength);
        }
        else {
            System.out.println("Invalid card number! (wrong prefix)");
        }
    }
    public static void discover(String ccNumber) {
        int ccLength = ccNumber.length();
        String first2 = ccNumber.substring(0,2);
        String first4 = ccNumber.substring(0,4);
        boolean first4check = ("6011".equals(first4));
        int first6 = Integer.parseInt(ccNumber.substring(0,6));
        boolean first6check = (first6 >= 622126) && (first6 <= 622925);
        int first3 = Integer.parseInt(ccNumber.substring(0,3));
        boolean first3check = (first3 >= 644) && (first3 <= 649);
        if (ccNumber.length() !=  16 && ccNumber.length() != 19) {
            System.out.println("Invalid card number!");
        }
        else if (first6check || "65".equals(first2) || first3check || first4check ){
            luhnAlgorithm(ccNumber, ccLength);
        }
        else {
            System.out.println("Invalid card number! (wrong prefix)");
        }
    }
    public static void amExpress(String ccNumber) {
        int ccLength = ccNumber.length();
        System.out.println(ccNumber.substring(0,1));
        if (ccLength != 15) {
            System.out.println("Invalid card number! (not the right number of digits)");
        }
        else if ("34".equals(ccNumber.substring(0,2)) || "37".equals(ccNumber.substring(0,2))){
            luhnAlgorithm(ccNumber, ccLength);
        }
        else {
            System.out.println("Invalid card number! (wrong prefix)");
        }
    }
    public static void luhnAlgorithm(String ccNumber, int ccLength) {
        int a;
        int total = 0;
        for (int i = 0; i<ccLength; i++) {
                if (i % 2 != 0) {
                    a=Character.getNumericValue(ccNumber.charAt(ccLength-i-1));
                    a = a * 2;
                    if (a > 9) {
                        a = 1+ (a%10); 
                    }
                    total += a;
                }
                else {
                    total += Character.getNumericValue(ccNumber.charAt(ccLength-i-1));
                }
            }
            if (total % 10 == 0) {
                System.out.println("Valid card number! Yay!");
            }
            else  {
                System.out.println("Invalid card number! (fails check!)");
            }
    }
}
