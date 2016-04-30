/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Closer {
    public int closer(int a, int b) {
        int aclose = Math.abs(a -10);
        int bclose = Math.abs(b - 10);
        if (aclose == bclose) {
            return 0;
        }
        else if (aclose > bclose) {
            return b;
        }
        else {
            return a;
        }
    }
}
