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
public class Rectangle extends Shape {
    private double height;
    private double width;
    
    @Override
    public double perimeter() {
        return (height*2)+(width*2);
    }
    
    @Override
    public double area() {
        
        return height*width;
    }
    /**
     * @return the side1
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the side1 to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the side2
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the side2 to set
     */
    public void setWidth(double width) {
        this.width = width;
    }
    
}
