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
public class Savings extends Account {
    public Savings() {
        type = "savings";
    }
    @Override
    public String withdraw(double amount) {
        if (!withdrawLock) {
            amount = amount*0.01;
            balance -= amount;
            return "Your withdrawal was a success!";
        }
        return "Your account is on hold!";
    }

    @Override
    public void deposit(double amount) {
        balance += amount*0.01;
        if (amount > 10000) {
            withdrawLock=true;
        }
    }
}
