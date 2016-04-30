/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class RotateLeft {
    public int[] rotateLeft(int[] numbers)  {
        int[] rotated = new int[numbers.length];
        int index;
        rotated[numbers.length-1]=numbers[0];
        for (int i = 0; i<numbers.length - 1; i++) {
            index = i+1;
            rotated[i]=numbers[index];
        }
        return rotated;
    }
}
 