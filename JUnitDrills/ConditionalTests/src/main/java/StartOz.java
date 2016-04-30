/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class StartOz {
    public String startOz(String str) {
        String so = "";
        if ("o".equals(str.substring(0, 1))) {
            so+= "o";
        }
        if ("z".equals(str.substring(1, 2))) {
            so += "z";
        }
        return so;
    }
}
