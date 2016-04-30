/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class StartHi {
    public boolean startHi(String str) {
        if ("hi".equals(str)) {
            return true;
        }
        else if ("hi ".equals(str.substring(0,3))) {
            return true;
        }
        return false;
    }
}
