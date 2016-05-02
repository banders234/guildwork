/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unitconverter;

/**
 *
 * @author apprentice
 */
public class UnitConverter {
    static ConsoleIO console = new ConsoleIO();
    public static void main(String[] args) {
        console.print("Choose conversion type");
        console.print("1. Temperature");
        console.print("2. Length");
        console.print("3. Mass");
        int choice = console.getInt("Enter choice:");
        switch(choice) {
            case 1:
                temp();
                break;
            case 2:
                length();
                break;
            case 3:
                mass();
                break;
            default:
                console.print("Invalid choice!");
                break;
        }
    }
    public static void temp() {
        double celsius, fahrenheit;
        console.print("Choose original unit");
        console.print("1. Celsius");
        console.print("2. Fahrenheit");
        int choice=console.getInt("Enter choice: ");
        switch (choice) {
            case 1:
                celsius=console.getDouble("Enter amount:");
                fahrenheit = (9/5)*celsius + 32;
                console.print(celsius + " Celsius equals " + fahrenheit + " Fahrenheit.");
                break;
            case 2:
                fahrenheit = console.getDouble("Enter amount:");
                celsius = (fahrenheit-32)*(5/9);
                console.print(fahrenheit + " Fahrenheit equals " + celsius + " Celsius.");
                break;
            default:
                console.getDouble("Invalid choice!:");
                break;
        }
    }
    public static void length() {
        double meter, foot;
        console.print("Choose original unit");
        console.print("1. Meter");
        console.print("2. Foot");
        int choice=console.getInt("Enter choice: ");
        switch (choice) {
            case 1:
                meter=console.getDouble("Enter amount:");
                foot = 3.28*meter;
                console.print(meter + " meters equal " + foot + " feet.");
                break;
            case 2:
                foot = console.getDouble("Enter amount:");
                meter = foot/3.28;
                console.print(foot + " feet equal " + meter + " meters.");
                break;
            default:
                console.getDouble("Invalid choice!:");
                break;
        }
    }
    public static void mass() {
        double pound;
        double kg;
        console.print("Choose original unit");
        console.print("1. Pound");
        console.print("2. Kilogram");
        int choice=console.getInt("Enter choice: ");
        switch (choice) {
            case 1:
                pound=console.getDouble("Enter amount:");
                kg = 2.2*pound;
                console.print(pound + " pounds equal " + kg + " kgs.");
                break;
            case 2:
                kg = console.getDouble("Enter amount:");
                pound = kg/2.2;
                console.print(kg + " kgs equal " + pound + " pounds.");
                break;
            default:
                console.getDouble("Invalid choice!:");
                break;
        }
    }
}
