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
public class QueueArrayImpl<T> implements Queue<T>{
    
    private T[] queueArray;
    private int first;
    private int last;
    private int currentSize;
    
    public QueueArrayImpl() {
        queueArray = (T[]) new Object[2];
        currentSize = 0;
        first = 0;
        last = 0;
    }
    
    @Override
    public void enqueue(T element) {
        if (currentSize == queueArray.length) {
            resize(2*queueArray.length); //double 
        }
        queueArray[last++] = element; // move up last and
        if (last == queueArray.length) {
            last = 0; //wrap around
        }
        currentSize++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        else {
            T element = queueArray[first];
            queueArray[first] = null;
            currentSize--;
            first++;
            if (first == queueArray.length) {
                first = 0; //wrap around
            }
            if (currentSize > 0 && currentSize == queueArray.length/4) {
                resize(queueArray.length/2);
            }
            return element;
        }
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
        for (int i = 0; i < currentSize; i++) {
            //resized array must start at first and wrap around
            temp[i] = queueArray[(first + i) % queueArray.length];
        }
        queueArray = temp;
        //reset array
        first = 0;
        last = currentSize;
    }
    
}
