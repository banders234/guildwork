/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankaccountmanager.controller;

import com.mycompany.bankaccountmanager.dao.BankAccountDao;
import com.mycompany.bankaccountmanager.dto.Account;
import com.mycompany.bankaccountmanager.dto.Checking;
import com.mycompany.bankaccountmanager.dto.Savings;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class BankAccountController {
    ConsoleIO console = new ConsoleIO();
    BankAccountDao accountInfo = new BankAccountDao();
    DecimalFormat df2 = new DecimalFormat("0.00");
    public void run() {
        boolean exit=false;
        do {
            String pin = console.getString("Enter your four-digit PIN:");
            if (pin.equals("0000")) {
                adminMenuChoice();
            }
            else {
                List<Account> myAccounts = accountInfo.find(pin);
                if (myAccounts.isEmpty()) {
                    console.print("Account not found!");
                }
                else {
                    typeMenuChoice(myAccounts);

                }
            }
        } while(!exit);
    }
    
    public void adminMenuChoice() {
        String pin;
        int savingsBalance, checkingBalance;
        
        adminMenuDisplay();
        int choice=console.getInt("Enter choice: ");
        switch(choice) {
            case 1:
                Account savings = new Savings();
                Account checking = new Checking();
                pin=console.getString("Enter a 4-digit pin: ");
                checkingBalance=console.getInt("Enter checking balance: ");
                savingsBalance=console.getInt("Enter savings balance: ");
                savings.setPin(pin);
                checking.setPin(pin);
                checking.setBalance(checkingBalance);
                savings.setBalance(savingsBalance);
                accountInfo.create(checking, savings);
                break;
            case 2:
                break;
            default:
                console.print("Invlaid choice!");
                break;
        }
    }
    public void adminMenuDisplay() {
        console.print("1. Add Account");
    }
    public void accountMenuChoice(Account account) {
        double amount;
        accountMenuDisplay();
        int choice = console.getInt("Enter choice: ");
        switch(choice) {
            case 1:
                console.print("Your balance is " + df2.format(account.getBalance()) + ".");
                break;
            case 2:
                amount = console.getDouble("Enter amount to deposit: ");
                account.deposit(amount);
                accountInfo.update(account);
                break;
            case 3:
                amount = console.getDouble("Enter amount to withdraw: ");
                account.withdraw(amount);
                accountInfo.update(account);
                break;
            default:
                console.print("Invalid choice!");
                break;
        }
    }
    
    private void typeMenuChoice(List<Account> accounts) {
        Account savings = new Savings();
        Account checking = new Checking();
        typeMenuDisplay();
        for (Account a : accounts) {
            if (a.getType().equals("savings")){
                savings = a;
            }
            if (a.getType().equals("checking")){
                checking = a;
            }
        }
        int choice = console.getInt("Choose account type:");
        switch(choice) {
            case 1:
                accountMenuChoice(checking);
                break;
            case 2:
                accountMenuChoice(savings);
                break;
            default:
                console.print("Invalid choice!");
                break;
                
        }
    }
    
    private void accountMenuDisplay() {
        console.print("1. View Balance");
        console.print("2. Deposit");
        console.print("3. Withdraw");
    }
    
    private void typeMenuDisplay() {
        console.print("1. Checking");
        console.print("2. Savings");
    }
}
