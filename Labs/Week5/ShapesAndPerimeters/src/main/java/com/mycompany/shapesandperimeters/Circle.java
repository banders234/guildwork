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
public class Circle {
    private double radius;
    
    public double area() {
        double pi = Math.PI;
        return pi*(radius*radius);
    }
    
    public double perimeter() {
        double pi = Math.PI;
        return pi*2*radius;
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
