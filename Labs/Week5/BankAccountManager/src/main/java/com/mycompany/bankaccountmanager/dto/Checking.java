/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankaccountmanager.dto;

/**
 *
 * @author apprentice
 */
public class Checking extends Account {
    public Checking() {
        type="checking";
    }
    @Override
    public String withdraw(double amount) {
        if (!withdrawLock) {
            if (balance > 0) {
                if ((balance - amount) < -100) {
                    return "You cannot withdraw below -100.00!";
                }
                else if ((balance - amount) < 0) {
                    balance = (balance - amount) - 10;
                    return "You were charged a $10 overdraft fee.";
                }
                else {
                    balance = balance - amount;
                    return "Successful withdrawal!";
                }
                
            }
        }
        return "Your account is on hold!";
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }
}
