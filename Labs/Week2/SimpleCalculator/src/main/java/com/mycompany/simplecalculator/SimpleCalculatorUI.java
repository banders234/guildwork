/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplecalculator;

/**
 *
 * @author apprentice
 */
public class SimpleCalculatorUI {
    public static void main(String[] args) {
        ConsoleIO cio = new ConsoleIO();
        double a, b;
        SimpleCalculator calc = new SimpleCalculator();
        int choice;
        double result;
        do {
            choice = cio.getInt("Choose Calculator Operation:\n1. Add    2. Subtract\n3. Multiply 4. Divide\n5. Exit");
            if (choice == 5) {
                break;
            }
            a = cio.getDouble("Enter first operand:");
            b = cio.getDouble("Enter second operand:");
            
            switch(choice) {
                case 1:
                    result = calc.add(a, b);
                    break;
                case 2:
                    result = calc.subtract(a,b);
                    break;
                case 3:
                    result = calc.multiply(a,b);
                    break;
                case 4:
                    result = calc.divide(a,b);
                    break;
                default:
                    result = 0;
            }
            cio.printString("The result is " + result);
        } while(choice != 5);
        cio.printString("Thank you for using Simple Calcualtor! Goodbye!");
        }
}
 