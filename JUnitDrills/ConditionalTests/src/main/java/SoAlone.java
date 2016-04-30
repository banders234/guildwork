/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class SoAlone {
    public boolean soAlone(int a, int b) {
        boolean ateen = a>=13 && a<=19;
        boolean bteen = b>=13 && b<=19;
        if (ateen & bteen) {
            return false;
        }
        else if ( ateen || bteen) {
            return true;
        }
        return false;
    }
}
