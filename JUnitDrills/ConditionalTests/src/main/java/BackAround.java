/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class BackAround {
    public String backAround(String str) {
        String lastCharacter= str.substring(str.length() - 1);
        String ba = lastCharacter + str +lastCharacter;
        return ba;
    }
}
