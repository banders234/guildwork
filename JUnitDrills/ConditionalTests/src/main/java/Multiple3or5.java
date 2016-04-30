/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Multiple3or5 {
    public boolean multiple3or5(int number) {
        if (number % 3 == 0 || number % 5 == 0) {
            return true;
        }
        return false;
    }
}
