/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class EveryNth {
    public String EveryNth(String str, int n) {
        String ns = "";
        for (int i =  0; i<str.length(); i+=n) {
            ns += str.substring(i, i+1);
        }
        return ns;
    }
}
