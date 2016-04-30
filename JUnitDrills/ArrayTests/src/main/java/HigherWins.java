/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class HigherWins {
    public int[] higherWins(int[] numbers) {
        int[] higherWins = new int[numbers.length];
        int highest=0;
        if (numbers[0] > numbers[numbers.length - 1]) {
            highest = numbers[0];
        }
        else {
            highest = numbers[numbers.length - 1];
        }
        
        for (int i = 0; i<numbers.length; i++) {
            higherWins[i] = highest;
        }
        return higherWins;
    }
}
