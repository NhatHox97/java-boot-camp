package com.vn.nhat.syntax.oop.account;

public class SavingAccount extends Account {

    public SavingAccount(String accountNumber, String name, String address, String phone, String dob, Double balance) {
        super(accountNumber, name, address, phone, dob, balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }
}

