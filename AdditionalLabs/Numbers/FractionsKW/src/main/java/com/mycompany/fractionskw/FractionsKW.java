/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fractionskw;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author apprentice
 */
public class FractionsKW {
    public static void main (String[] args) {
        int choice, numFractions;
        Scanner sc = new Scanner(System.in);
        System.out.println("Fraction operations!");
        System.out.println("What would you like to do?");
        System.out.println("1. Add 2. Subtract 3. Multiply 4. Divide");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                addFractions();
                break;
            case 2:
                subtractFractions();
                break;
            case 3:
                multiplyFractions();
                break;
            case 4:
                divideFractions();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }        
    }
    public static int numFractions () {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many fractions are you inputting?");
        int numFractions = sc.nextInt();
        return numFractions;
    }
    public static String inputFractions(int num) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter fraction: " + num);
        String fractions = sc.nextLine();
        return fractions;
    }
    public static void addFractions() {
        ArrayList<Integer> ndArray = getNDArray();
        ArrayList<Integer> newNArray = new ArrayList<>();
        int denom = ndArray.get(1);
        for (int i=3; i<ndArray.size(); i+=2) {
            denom = denom*ndArray.get(i);
        }
        for (int i=0; i<ndArray.size(); i+=2) {
            newNArray.add((ndArray.get(i) * denom)/ndArray.get(i+1));
        }
        int numer= newNArray.get(0);
        for (int i=1; i<newNArray.size(); i++) {
            numer += newNArray.get(i);
        }
        simplify(numer,denom);
    }
    public static void subtractFractions() {
        ArrayList<Integer> ndArray = getNDArray();
        ArrayList<Integer> newNArray = new ArrayList<>();
        int denom = ndArray.get(1);
        for (int i=3; i<ndArray.size(); i+=2) {
            denom = denom*ndArray.get(i);
        }
        for (int i=0; i<ndArray.size(); i+=2) {
            newNArray.add((ndArray.get(i) * denom)/ndArray.get(i+1));
        }
        int numer= newNArray.get(0);
        for (int i=1; i<newNArray.size(); i++) {
            numer -= newNArray.get(i);
        }
        simplify(numer, denom);
    }
    public static void multiplyFractions () {
        // array to split fraction into
        //arrayList of alternating numerators and denominators
        ArrayList<Integer> ndArray = getNDArray();

        int previousN = ndArray.get(0);
        int previousD = ndArray.get(1);
        int currentN=0, currentD=0;
        for (int i = 2; i<ndArray.size(); i++) {
            if ((i % 2 == 0)) {
                currentN = ndArray.get(i);
                currentN = currentN * previousN;
                previousN = currentN;
            }
            else {
                currentD = ndArray.get(i);
                currentD = currentD * previousD;
                previousD = currentD;
            }
        }
        simplify(currentN, currentD);
    }
    public static void divideFractions () {
        ArrayList<Integer> ndArray = getNDArray();
        int fN = ndArray.get(0);
        int fD = ndArray.get(1);
        int sN = ndArray.get(2);
        int sD = ndArray.get(3);
        int numer = fN * sD;
        int denom = fD * sN;
        System.out.println(numer);
        System.out.println(denom);
        for (int i = 4; i<ndArray.size(); i++) {
            if ((i % 2 == 0)) {
                numer = ndArray.get(i+1) * numer;
            }
            else {
                denom = ndArray.get(i-1) * denom;
            }
        }
        System.out.println(numer + "/" + denom);
        simplify(numer, denom);
        
    }
    public static void simplify(int n, int d) {
        int gcd = findGCD(n, d);
        n /= gcd;
        d /= gcd;
        if (d == 1) {
            System.out.println(n);
        }
        else {
            System.out.println(n + "/" + d);
        }
    }
    public static int findGCD(int a, int b) {
        int counter = 1, gcd =1, num;
        ArrayList<Integer> aFactors = new ArrayList<>();
        ArrayList<Integer> bFactors = new ArrayList<>();
        ArrayList<Integer> common = new ArrayList<>();
        while (counter <=a) {
            if (a % counter == 0) {
                aFactors.add(counter);
            }
            counter++;
        }
        counter = 1;
        while (counter <= b) {
            if (b % counter == 0) {
                bFactors.add(counter);
            }
            counter++;
        }
        for (int i = 0; i < aFactors.size(); i++) {
            num = aFactors.get(i);
            if (bFactors.contains(num)) {
                common.add(num);
            }
        }
        if (common.size() > 0) {
            gcd = common.get(common.size() -1);
        }
        return gcd;
    }
    public static ArrayList<Integer> getNDArray()  {
        ArrayList<Integer> ndarray = new ArrayList<>();
        ArrayList<String> fractionList = new ArrayList<>();
        String fArray[];
        int counter = 1;
        int num = numFractions();
        // numerator and denominator
        while (counter <= num) {
            String input = inputFractions(counter);
            fractionList.add(input);
            counter++;
        }
        for (String fraction : fractionList) {
            fArray=fraction.split("/");
            for (String part: fArray) {
                ndarray.add(Integer.parseInt(part));
            }
        }
        return ndarray;
    }
}

