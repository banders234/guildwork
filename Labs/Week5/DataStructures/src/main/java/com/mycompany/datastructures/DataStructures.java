/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.datastructures;

/**
 *
 * @author apprentice
 */
public class DataStructures {
    public static void main (String[] args) {
        
        Stack<String> stringStack = new StackArrayImpl();
        Queue<String> stringQueue = new QueueArrayImpl<>();
        stringStack.push("Bill");
        stringStack.push("Jones");
        int counter = 0;
        System.out.println(6%10);
        while (counter < 10000) {
            stringQueue.enqueue("Shaq");
            stringQueue.enqueue("Kobe");
            stringQueue.enqueue("LeBron");
            stringQueue.enqueue("Jordan");
            counter++;
        }
        counter = 1;
        while (!stringQueue.isEmpty()){
            System.out.println(counter + " " + stringQueue.dequeue());
            counter++;
        }
    }
}
