/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class KeepLast {
    public int[] keepLast(int[] numbers) {
        int[] keepLast = new int[numbers.length * 2];
        keepLast[keepLast.length - 1] = numbers[numbers.length -1];
        return keepLast;
    }
}
