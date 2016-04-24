/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.binaryintegerconverter;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class BinaryIntegerConverter {
    public static void main(String[] args) {
        int choice=0, num, pow, total=0;
        double pos;
        String sNum;
        String input="";
        boolean invalidChoice = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Integer-Binary converter.");
        while (invalidChoice == true) {
            System.out.print("Is the original value integer or binary?:");
            input = sc.next();
            if (null != input) switch (input) {
                case "binary":
                    choice = 1;
                    
                    invalidChoice = false;
                    break;
                case "integer":
                    choice = 2;
                    invalidChoice = false;
                    break;
                default:
                    System.out.println("Please enter \"integer\" or \"binary\".");
                    break;
            }
            
        }
        System.out.println("Enter the " + input + " value: ");
        sNum = sc.next();
        switch (choice) {
            case 1:
               for (int i =0; i< sNum.length(); i++) {
                   pow = sNum.length() - i - 1;
                   pos=Math.pow(2, pow);
                   if ('1'== sNum.charAt(i)) {
                       total += pos;
                   }
               }
               System.out.println("Integer: " + total);
               break;
            case 2:
               num = Integer.parseInt(sNum);
               int binary[] = new int [40];
               int index = 0;
               while (num > 0) {
                   binary[index++] = num%2;
                   num = num/2;
               }
               System.out.print("Binary value: ");
                for(int i = index-1; i >= 0; i--){
                   System.out.print("Binary value: " +binary[i]);
               }
                break;
            default:
                break;
        }
        
    }
}
