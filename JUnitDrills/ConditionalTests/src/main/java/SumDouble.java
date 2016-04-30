/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class SumDouble {
    public int sumDouble(int a, int b){
        int sum;
        if (a == b) {
            sum = (a+b)*2;
        }
        else {
            sum = a+b;
        }
        return sum;
    }
}
