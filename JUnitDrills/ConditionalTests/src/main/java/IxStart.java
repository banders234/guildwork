

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class IxStart {
    public boolean ixStart(String str) {
        if ("ix".equals(str.substring(1,3))) {
            return true;
        }
        return false;
    }
}
