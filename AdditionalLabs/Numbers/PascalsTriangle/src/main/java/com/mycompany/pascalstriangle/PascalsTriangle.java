/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pascalstriangle;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class PascalsTriangle {
    public static void main (String[] args) {
        int num;
        int [] previousRow;
        int [] currentRow = {1};
        Scanner sc = new Scanner(System.in);
        System.out.println("Pascal's Triangle!");
        System.out.print("Enter number of rows to be printed: ");
        num = sc.nextInt();
        printArray(currentRow);
        previousRow = currentRow;
        for(int i= 2; i <= num; i++) {
            currentRow = new int[i];
            currentRow[0] = 1;
            currentRow[i - 1] = 1;
            for (int j = 0; j <= i - 3; j++) {
                currentRow[j + 1] = previousRow[j] + previousRow[j + 1];
            }
            printArray(currentRow);
            previousRow = currentRow;
            
        }
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
