/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Double23 {
    public boolean double23(int[] numbers) {
        int count2=0, count3=0;
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] == 2) {
                count2++;
            }
            else if (numbers[i] == 3) {
                count3++;
            }
        }
        if (count2 == 2 || count3 == 2) {
            return true;
        }
        return false;
    }
}
