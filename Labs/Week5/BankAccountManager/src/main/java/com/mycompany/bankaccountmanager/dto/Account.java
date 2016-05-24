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
public abstract class Account {
    protected String pin;
    protected String type;
    protected double balance;
    protected boolean withdrawLock=false;
            
    public abstract void deposit(double amount);
    public abstract String withdraw(double amount);

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the id
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the id to set
     */
    public void setPin(String pin) {
        this.pin = pin;
    }
    
    public String getType() {
        return type;
    }
}