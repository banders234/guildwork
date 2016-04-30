/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Reverse {
    public int[] reverse(int[] numbers) {
        int[] reversed = new int[numbers.length];
        int counter = 0;
        for (int i = numbers.length -1; i>=0; i--) {
            reversed[counter] = numbers[i];
            counter++;
        }
        
        return reversed;
    }
          
}
