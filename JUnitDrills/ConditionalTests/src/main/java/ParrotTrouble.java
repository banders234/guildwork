/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class ParrotTrouble {
    public boolean parrotTrouble(boolean isTalking, int hour) {
        if (isTalking == true && (hour < 7 || hour > 20)) {
            return true;
        }
        return false;
    }
}
