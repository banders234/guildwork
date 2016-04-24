/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alarmclock;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class AlarmClock {
    public static void main (String[] args) throws ParseException {
        String alarmS, dMsg, dateS = "";
        Scanner sc = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        System.out.println("The current time is " + dateFormat.format(date));
        System.out.println("Enter your alarm time and display message: ");
        System.out.print("Alarm time (HH:mm format): ");
        alarmS = sc.nextLine();
        System.out.print("Enter display message: ");
        dMsg = sc.nextLine();
        while (!dateS.equals(alarmS)) {
            date = new Date();
            dateS = dateFormat.format(date);
            if (dateS.equals(alarmS)) {
                System.out.println("Ring! Ring! It's " + dateS + "!");
                System.out.println(dMsg);
            }
        }
    }
}
