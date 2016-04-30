/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Diff21 {
    public int diff21(int n) {
        int diff;
        if (n > 21) {
            diff = (Math.abs(n - 21))*2;
        }
        else {
            diff = Math.abs(n - 21);
        }
        return diff;
    }
}
