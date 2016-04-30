/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class FrontBack {
    public String frontBack(String str) {
        String fb;
        if (str.length() == 1) {
            fb = str;
        }
        else {
            fb = str.substring(str.length() - 1) + str.substring(1, str.length() -1) + str.substring(0,1);
        }
        return fb;
    }
}
