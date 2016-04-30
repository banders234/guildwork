/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class CanSleepIn {
    public boolean canSleepIn (boolean isWeekday, boolean isVacation) {
        if (isWeekday == true && isVacation == false) {
            return false;
        }
        return true;
    }
}
