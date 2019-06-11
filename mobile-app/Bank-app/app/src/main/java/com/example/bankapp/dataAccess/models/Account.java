package com.example.bankapp.dataAccess.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "accounts")
public class Account {
    @DatabaseField(columnName = "accountNumber", id = true)
    private int AccountNumber;

    @DatabaseField(foreign = true)
    private User owner;

    @DatabaseField(columnName = "balance")
    private int balance;

    public Account() {

    }

    public Account(int accountNumber, User owner, int balance) {
        AccountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public Account(int accountNumber, int balance) {
        AccountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountNumber=" + AccountNumber +
                ", owner=" + owner +
                ", balance=" + balance +
                '}';
    }
}
