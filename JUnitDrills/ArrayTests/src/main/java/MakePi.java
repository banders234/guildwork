/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class MakePi {
    public int[] MakePi(int n) {
        double pi = Math.PI;
        int[] piArray = new int[n];
        for (int i = 0; i < n; i++) {
            piArray[i] = (int) Math.floor(pi);
            pi -= piArray[i];
            pi *= 10;
        }
        return piArray;
    }
}
