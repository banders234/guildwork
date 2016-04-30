/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Max {
    public int max(int a, int b, int c) {
       if (a > b && a > c) {
           return a;
       }
       else if (b > a && b > c) {
           return b;
       }
       else {
           return c;
       }
    }
}
