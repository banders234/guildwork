/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class HasEven {
    public boolean hasEven(int[] numbers) {
        
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] % 2 ==0) {
                return true;
            }
        }
        return false;
    }
}
