/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.controllers;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class ConsoleIO {
    Scanner sc = new Scanner(System.in);
    public int getInt(String prompt) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(prompt);
                value = Integer.parseInt(sc.nextLine());
                valid = true;
            } catch(Exception e) {
                System.out.println("Invalid entry!");
            }
        }
        return value;
    }
    
    public int getIntOneLine(String prompt) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine());
                valid = true;
            } catch(Exception e) {
                System.out.println("Invalid entry!");
            }
        }
        return value;
    }
    
    public int getIntAcceptPassword(String prompt) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);
                String str = sc.nextLine();
                Integer.parseInt(str);
                valid = true;
            } catch(Exception e) {
                System.out.println("Invalid entry!");
                sc.nextLine();
            }
        }
        return value;
    }
    public int getIntWithDef(String prompt, int def) {
        System.out.println(prompt);
        try {
            int value = Integer.parseInt(sc.next());
            sc.nextLine();
            return value;
        }
        catch (Exception e) {
            return def;
        }
}
    public int getIntMinMax(String prompt, int min, int max) {
        int value = 0;
        try {
            do {
                System.out.print(prompt);
                value = Integer.parseInt(sc.nextLine());
                if (value > max) {
                    System.out.println("Value entered is too high!");
                }
                else if (value < min) {
                    System.out.println("Value entered is too low!");
                }
            } while (value > max || value < min);
            return value;
        }
        catch (Exception e) {
          
            System.out.println("Invalid entry!");
        }
        return value;
    }
    public String getString(String prompt) {
        System.out.println(prompt);
        String value = sc.nextLine();
        return value;
    }
    public String forceString(String prompt) {
        System.out.print(prompt);
        String value = "";
        while("".equals(value)) {
            value = sc.nextLine();
            if ("".equals(value)) {
                System.out.println("This field may not be empty!");
            }
        }
        return value;
    }
    public String getStringOneLine(String prompt) {
        System.out.print(prompt);
        String value = sc.nextLine();
        return value;
    } 
    public float getFloatMinMax(String prompt, float min, float max) {
        float value = 0;
        System.out.println(prompt);
        do {
            value = sc.nextFloat();
        } while (value < max && value > min);
        return value;
    }
    public double getDouble(String prompt) {
        double value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(prompt);
                value = Double.parseDouble(sc.nextLine());
                valid = true;
            } catch(Exception e) {
                System.out.println("Invalid entry!");
            }
        }
        return value;
    }
    public double getDoubleAcceptBlank(String prompt) {
        String input;
        double value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println(prompt);
                input = sc.nextLine();
                if ("".equals(input)) {
                    value = -1;
                }
                else {
                    value = Double.parseDouble(input);
                }
                valid = true;
            } catch(Exception e) {
                System.out.println("Invalid entry!");
                sc.nextLine();
            }
        }
        return value;
    }
    public double getDoubleMinMax(String prompt, double min, double max) {
        double value = 0;
        System.out.println(prompt);
        do {
            value = sc.nextDouble();
        } while (value < max && value > min);
        return value;
    }
    public void print(String prompt) {
        System.out.println(prompt);
    }
}
