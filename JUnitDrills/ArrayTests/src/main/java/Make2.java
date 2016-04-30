/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Make2 {
    public int[] make2(int[] a, int[] b) {
        int[] make2 = new int[2];
        for (int i = 0; i<2 ; i++) {
            if (i  < a.length) {
                make2[i] = a[i];
            }
            else {
                make2[i] = b[i-a.length];
            }
        }
        return make2;
    }
}
