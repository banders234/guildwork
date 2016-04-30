/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class NearHundred {
    public boolean nearHundred(int n) {
        if ((n>=90 && n<=110) || (n>=190 && n<=210)) {
            return true;
        }
        return false;
    }
}
