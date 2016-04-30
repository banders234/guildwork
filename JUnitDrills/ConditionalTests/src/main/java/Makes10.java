/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Makes10 {
    public boolean makes10(int a, int b) {
        if ((a == 10 || b==10) || a+b == 10) {
            return true;
        }
        return false;
    }
}
