/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.commondenominators;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author apprentice
 */
public class CommonDenominators {
    public static void main (String[] args) {
        int f1d, f1n, f2d, f2n, nd, counter = 1;
        int num, dGCD, lcm, dLCM, nGCD, dLCD;
        ArrayList<Integer> f1df = new ArrayList<>();
        ArrayList<Integer> f2df = new ArrayList<>();
        ArrayList<Integer> f1nf = new ArrayList<>();
        ArrayList<Integer> f2nf = new ArrayList<>();
        ArrayList<Integer> dCommon = new ArrayList<>();
        ArrayList<Integer> nCommon = new ArrayList<>();
        String f1, f2;
        String f1a[], f2a[];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two fractions. (Example: 1/2)");
        System.out.print("Enter fraction 1: ");
        f1 = sc.nextLine();
        f1a=f1.split("/");
        System.out.print("Enter fraction 2: ");
        f2 = sc.nextLine();
        f2a=f2.split("/");
        f1n = Integer.parseInt(f1a[0]);
        f1d = Integer.parseInt(f1a[1]);
        f2n = Integer.parseInt(f2a[0]);
        f2d = Integer.parseInt(f2a[1]);
        while (counter <= f1d) {
            if (f1d % counter == 0) {
                f1df.add(counter);
            }
            counter++;
        }
        counter = 1;
        while (counter <= f2d) {
            if (f2d % counter == 0) {
                f2df.add(counter);
            }
            counter++;
        }
        counter = 1;
        while (counter <= f1n) {
            if (f1n % counter == 0) {
                f1nf.add(counter);
            }
            counter++;
        }
        counter = 1;
        while (counter <= f2n) {
            if (f2n % counter == 0) {
                f2nf.add(counter);
            }
            counter++;
        }
        for (int i = 0; i < f1df.size(); i++) {
            num = f1df.get(i);
            if (f2df.contains(num)) {
                dCommon.add(num);
            }
        }
        for (int i = 0; i < f1nf.size(); i++) {
            num = f1nf.get(i);
            if (f2nf.contains(num)) {
                nCommon.add(num);
            }
        }
        dGCD = dCommon.get(dCommon.size() - 1);
        dLCD = dCommon.get(0);
        dLCM = Math.abs(f1d * f2d)/dGCD;
        nGCD = nCommon.get(nCommon.size() - 1);
        System.out.println("GCD: " + dGCD);
        System.out.println("LCD:" + dLCD);
    }
}
 