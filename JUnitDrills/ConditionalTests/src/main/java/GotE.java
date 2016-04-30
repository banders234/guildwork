/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class GotE {
    public boolean gotE(String str) {
        int total = 0;
        for (int i=0; i<str.length(); i++) {
            if ('e' == str.charAt(i)) {
                total+=1;
            }
        }
        if (total>=1 && total<= 3) {
            return true;
        }
        return false;
    }
}
