/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankaccountmanager.dao;

import com.mycompany.bankaccountmanager.dto.Account;
import com.mycompany.bankaccountmanager.dto.Checking;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class BankAccountDao {
    List<Account> accounts = new ArrayList();

    public boolean create(Account checking, Account savings) {
        List<String> pinList = new ArrayList();
        for(Account a : accounts) {
            pinList.add(a.getPin());
        }
        if (!pinList.contains(checking.getPin())) {
            accounts.add(checking);
            accounts.add(savings);
            return true;
        }
        return false;
    }
    public void delete(Account account) {
        accounts.remove(account);
    }
    
    public List<Account> find(String pin) {
        List<Account> myAccounts = new ArrayList();
        for (Account a : accounts) {
            if (a.getPin().equals(pin)) {
                myAccounts.add(a);
            }
        }
        return myAccounts;
    }
    
    public void update(Account account) {
        for (Account a: accounts) {
            if (a.getPin() == account.getPin()) {
                accounts.add(account);
                accounts.remove(a);
            }
        }
    }
}
