/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class MissingChar {
    public String missingChar(String str, int n) {
        String mc = str.substring(0, n) + str.substring(n + 1, str.length());
        return mc;
    }
}
