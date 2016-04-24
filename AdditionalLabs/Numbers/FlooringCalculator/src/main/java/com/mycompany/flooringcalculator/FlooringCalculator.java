/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringcalculator;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class FlooringCalculator {
    public static void main (String[] args) {
    final int lc = 86;
    double tc, a, cpu, time, tlc, btime, w, l;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the width of your floor in inches.");
    w = sc.nextDouble()/12;
    System.out.println("Enter the length of your floor in inches.");
    l = sc.nextDouble()/12;
    System.out.println("Enter the cost for 1 unit of flooring.");
    cpu = sc.nextDouble();
    a = w * l;
    tc = cpu * a;
    System.out.println("Your floor's total cost is " + tc + " dollars.");
    time = a/20;
    btime = Math.ceil(time * 4f)/4f;
    System.out.println(btime);
    }
}
