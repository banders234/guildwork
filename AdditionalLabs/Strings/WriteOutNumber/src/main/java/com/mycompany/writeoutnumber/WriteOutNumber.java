/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.writeoutnumber;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class WriteOutNumber {
    public static void main (String[] args) {
        ConsoleIO console = new ConsoleIO();
        double num = console.getDouble("Enter a number to convert it to a string: ");
        String intPart,fracPart;
        String strNum = String.valueOf(num);
        String[] strNumParts = strNum.split("\\.");
        intPart = strNumParts[0];
        fracPart = strNumParts[1];
        String[] wordDigitsArr = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "" };
        List<String> wordDigits = Arrays.asList(wordDigitsArr);
        
        String[] wordTeensArr = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        List<String> wordTeens = Arrays.asList(wordTeensArr);
        
        String[] wordTensArr = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        List<String> wordTens = Arrays.asList(wordTensArr);
        
        String[] digitsArr = {"1", "2", "3", "4", "5", "6","7","8","9","0"};
        List<String> digits = Arrays.asList(digitsArr);
        
        String[] teensArr = {"10", "11", "12", "13", "14", "15", "16", "17", "18", "19"};
        List<String> teens = Arrays.asList(teensArr);
        
        int totalPlaces = intPart.length();
        int places;
        if (totalPlaces >= 4) {
            places = (totalPlaces)%3;
            if (places == 0) {
                places = 3;
            }
        }
        else {
            places = totalPlaces;
        }
        String writtenOutNum = "";
        writtenOutNum = wordNumGenerator(intPart, places, writtenOutNum, wordDigits, digits, wordTeens, teens, wordTens, totalPlaces);
        if (fracPart.length() > 0 && fracPart.charAt(0) != '0') {
            writtenOutNum += " and ";
            writtenOutNum = wordNumGenerator(fracPart, places, writtenOutNum, wordDigits, digits, wordTeens, teens, wordTens, totalPlaces);
            if (fracPart.length() == 1) {
                writtenOutNum += " tenths";
            }
            if (fracPart.length() == 2) {
                writtenOutNum += " hundredths";
            }
            if (fracPart.length() == 3) {
                writtenOutNum += " thousandths";
            }
            
        }
        console.print(writtenOutNum);
    }

    private static String wordNumGenerator(String numPart, int places, String writtenOutNum, List<String> wordDigits, List<String> digits, List<String> wordTeens, List<String> teens, List<String> wordTens, int totalPlaces) {
        for(int i = 0; i<numPart.length(); i++) {
            String digit = numPart.substring(i, i+1);
            if (places == 3) {
                if (!digit.equals("0")) {
                    writtenOutNum += wordDigits.get(digits.indexOf(digit)) + " hundred ";
                }
            }
            if (places == 2) {
                if ("1".equals(digit)) {
                    String teen = numPart.substring(i, i+2);
                    writtenOutNum+=wordTeens.get(teens.indexOf(teen));
                    places--;
                }
                else {
                    if (!digit.equals("0")) {
                        writtenOutNum += wordTens.get(digits.indexOf(digit));
                        if (!"0".equals(numPart.substring(i+1, i+2))) {
                            writtenOutNum += "-";
                        }
                    }
                    
                }
            }
            else if (places == 1) {
                if (!digit.equals("0")) {
                    writtenOutNum+=wordDigits.get(digits.indexOf(digit));
                }
                else if (numPart.length()==1) {
                    writtenOutNum+="zero";
                } 
            }
            if (totalPlaces == 4 && !"0".equals(digit)) {
                writtenOutNum+=" thousand ";
                places=4;
            }
            if (totalPlaces == 7) {
                writtenOutNum+=" million ";
                places=4;
            }
            totalPlaces--;
            places--;
        }
        return writtenOutNum;
    }
}
