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
public class Triangle {
    private double height;
    private double base;
    private double side1;
    private double side2;
    private double side3;
    public double area() {
        return (getHeight()*getBase())/2;
        
    }
    
    public double perimeter() {
        return getSide1()+getSide2()+getSide3();
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the base
     */
    public double getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * @return the side1
     */
    public double getSide1() {
        return side1;
    }

    /**
     * @param side1 the side1 to set
     */
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    /**
     * @return the side2
     */
    public double getSide2() {
        return side2;
    }

    /**
     * @param side2 the side2 to set
     */
    public void setSide2(double side2) {
        this.side2 = side2;
    }

    /**
     * @return the side3
     */
    public double getSide3() {
        return side3;
    }

    /**
     * @param side3 the side3 to set
     */
    public void setSide3(double side3) {
        this.side3 = side3;
    }
}
