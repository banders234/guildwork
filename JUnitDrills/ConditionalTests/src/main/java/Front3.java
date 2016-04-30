/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Front3 {
    public String front3(String str) {
        String f3;
        if (str.length() < 3) {
            f3 = str + str + str;
        }
        else {
            f3 = str.substring(0,3) + str.substring(0,3) + str.substring(0,3);
        }
        return f3;
    }
}
