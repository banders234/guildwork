/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class CommonEnd {
    public boolean commonEnd (int[] a, int[] b) {
        if (a[0]  == b[0] || a[a.length - 1] == b[b.length - 1]) {
            return true;
        }
        return false;
    }
}
