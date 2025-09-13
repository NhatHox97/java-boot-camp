package com.vn.nhat.syntax.oop.account;

import java.util.Objects;

public class LoanAccount extends Account {

    public void payEMI(double amount) {
        balance = balance + amount;
    }

    public void repay(double amount) {
        if (Objects.equals(balance, amount)) {
            balance = 0.0;
        }
    }

}