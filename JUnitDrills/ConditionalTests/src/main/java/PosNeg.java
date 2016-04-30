/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class PosNeg {
    public boolean posNeg(int a, int b, boolean negative) {
        if (negative == true && a<0 && b<0) {
            return true;
        }
        else if (a>0 && b>0 ) {
            return false;
        }
        else if (negative == false && (a >0 || b > 0)) {
            return true;
        }
        return false;
    }
}
