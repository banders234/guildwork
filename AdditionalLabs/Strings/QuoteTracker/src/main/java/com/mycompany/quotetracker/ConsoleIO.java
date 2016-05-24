/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quotetracker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Date getDate(String prompt) {
        Date date = null;
        while (date == null) {
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                sdf.setLenient(true);
                Date future=sdf.parse("01/01/3000");
                System.out.print(prompt);
                String value=sc.nextLine();
                date = sdf.parse(value);
                if (!value.equals(sdf.format(date))) {
                    date = null;
                }
                else if (date.after(future)) {
                    System.out.println("That date is too far in the future!");
                    date = null;
                }
            
            }
            catch (ParseException ex) {
                System.out.println("Invalid entry!");
            }
            if (date == null) {
                System.out.println("Must enter date in the valid format! \"mm/dd/yyyy\"");
            }
            
        }
        return date;
    }
    public Date getDateAcceptBlank(String prompt, Date currentValue) {
        Date date = null;
        while (date == null) {
            try{
                System.out.print(prompt);
                String value=sc.nextLine();
                if ("".equals(value)) {
                    return currentValue;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                sdf.setLenient(true);
                Date future=sdf.parse("01/01/3000");
                date = sdf.parse(value);
                if (!value.equals(sdf.format(date))) {
                    date = null;
                }
                else if (date.after(future)) {
                    System.out.println("That date is too far in the future!");
                    date = null;
                }
            }
            catch (ParseException ex) {
                System.out.println("Invalid entry!");
            }
            if (date == null) {
                System.out.println("Must enter date in the valid format! \"mm/dd/yyyy\"");
            }
            
        }
        return date;
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
        do {
            try {
                    System.out.print(prompt);
                    value = Integer.parseInt(sc.nextLine());
                    if (value > max) {
                        System.out.println("Value entered is too high!");
                    }
                    else if (value < min) {
                        System.out.println("Value entered is too low!");
                    }

            }
            catch (Exception e) {

                System.out.println("Invalid entry!");
            }
        } while (value > max || value < min);
        return value;
    }
    public String getString(String prompt) {
        System.out.println(prompt);
        String value = sc.nextLine();
        return value;
    }
    
    public String getStringAcceptBlank(String prompt, String currentValue) {
        System.out.println(prompt);
        String value = sc.nextLine();
        if ("".equals(value)) {
            return currentValue;
        }
        return value;
    }
    public String forceString(String prompt) {
        String value = "";
        while("".equals(value)) {
            System.out.print(prompt);
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
    public double getDoubleAcceptBlank(String prompt, double currentValue) {
        String input;
        double value = 0;
        boolean valid = false;
        while (!valid) {
            
            try {
                System.out.println(prompt);
                input = sc.nextLine();
                if ("".equals(input)) {
                    return currentValue;
                }
                else {
                    value = Double.parseDouble(input);
                    return value;
                }
            } catch(Exception e) {
                System.out.println("Invalid entry!");
                sc.nextLine();
            }
        }
        return value;
    }
    public double getDoubleMinMax(String prompt, double min, double max) {
        double value = 0;
        String str;
        System.out.println(prompt);
        do {
            try {
                str = sc.nextLine();
                value = Double.parseDouble(str);
                if (value >= max) {
                    System.out.print("Value is too large!");
                }
                else if (value <= min) {
                    System.out.println("Value is too small!");
                }
            }
            catch (Exception e) {
                System.out.println("Please enter a valid number!");
                }
        } while (value >= max || value <= min);
        
        return value;
    }
        
    
    public double getDoubleMinMaxAcceptBlank(String prompt, double min, double max) {
        double value = 0;
        boolean valid = false;
        String str;
        System.out.println(prompt);
        do {
            try {
                str = sc.nextLine();
                value = Double.parseDouble(str);
                if (value >= max) {
                    System.out.print("Value is too large!");
                }
                else if (value <= min) {
                    System.out.println("Value is too small!");
                }
                else {
                    valid = true;
                }
            } catch(Exception e) {
                System.out.println("Please enter valid number!");
            }
        } while ((value > max || value < min) && !valid);
        return value;
    }
    
    public void print(String prompt) {
        String message = prompt;
        System.out.println(message);
    }
}
