/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Fix23 {
    public int[] fix23(int[] numbers) {
        int[] fix23 = new int[3];
        for (int i=0; i<3; i++) {
            if (numbers[i] == 2) {
                if (numbers[i+1] == 3) {
                    fix23[i+1] = 0;
                    fix23[i] = numbers[i];
                }
                else {
                    fix23[i] = numbers[i]; 
                }
            }
            else if (i==0) {
                fix23[i] = numbers[i];
            }
            else if (numbers[i] != 3 && numbers[i-1] != 2) {
                fix23[i] = numbers[i];
            }
        }
        return fix23;
    }
}
