/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datastructures;


/**
 *
 * @author apprentice
 * @param <T>
 */
public class StackArrayImpl<T> implements Stack<T> {
    private T[] stackArray;
    private int currentSize;
    
    public StackArrayImpl() {
        stackArray = (T[]) new Object[2];
        currentSize=0;
    }
    @Override
    public void push(T element) {
        if (currentSize == stackArray.length) {
            resize(2*stackArray.length);
        }
        stackArray[currentSize++] = element;
    }
    
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T element = stackArray[currentSize-1];
        currentSize--;
        if (currentSize > 0 && currentSize ==stackArray.length/4) {
            resize(stackArray.length/2);
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }


    @Override
    public int size() {
        return currentSize;
    }
    
    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0;  i < currentSize; i++) {
            temp[i] = stackArray[i];
        }
        stackArray = temp;
    }
    
    

   
    
}
