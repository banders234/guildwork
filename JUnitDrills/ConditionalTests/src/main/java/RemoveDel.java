/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class RemoveDel {
    public String removeDel(String str) {
        String rd;
        if ("del".equals(str.substring(1,4))) {
            rd = str.substring(0,1) + str.substring(4);
        }
        else {
            rd = str;
        }
        return rd;
    }
}
