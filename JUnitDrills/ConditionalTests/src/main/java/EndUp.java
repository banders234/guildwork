/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class EndUp {
    public String endUp (String str) {
        String eu;
        if (str.length() >= 3) {
            eu=  str.substring(0,str.length() -3) + str.substring(str.length() - 3).toUpperCase();
        }
        else {
            eu= str.toUpperCase();
        }
        return eu;
    }
}
