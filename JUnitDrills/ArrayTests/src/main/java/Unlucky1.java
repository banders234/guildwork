/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Unlucky1 {
    public boolean unlucky1(int[] numbers) {
        for(int i=0; i<numbers.length; i++) {
            if (numbers[i] == 1 && (i != numbers.length -1)) {
                if (numbers[i+1] == 3 && ((i<=1) || (i>= numbers.length-2))) {
                    return true;
                }
            }
        }
        return false;
    }
}
