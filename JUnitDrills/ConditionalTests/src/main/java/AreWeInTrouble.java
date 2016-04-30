/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class AreWeInTrouble {
    public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile == true && bSmile == true) {
            return true;
        }
        else if (aSmile == true || bSmile == true) {
            return false;
        }
        else {
            return true;
        }
    }
            
}
