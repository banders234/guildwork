/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class NotString {
    public String notString(String s) {
        String notString;
        if (s.length() < 3) {
            notString = "not " + s;
        }
        else if ("not".equals(s.substring(0, 3))) {
            notString = s;
        }
        else {
            notString = "not " + s;
        }
        return notString;
    }
}
