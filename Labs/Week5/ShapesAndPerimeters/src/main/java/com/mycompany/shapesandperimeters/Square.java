/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shapesandperimeters;

/**
 *
 * @author apprentice
 */
public class Square extends Shape {
    private double side;
    
    @Override
    public double area() {
        return getSide()*getSide();
    }
    
    @Override
    public double perimeter() {
        return getSide()*4;
    }

    /**
     * @return the side
     */
    public double getSide() {
        return side;
    }

    /**
     * @param side the side to set
     */
    public void setSide(double side) {
        this.side = side;
    }
}
