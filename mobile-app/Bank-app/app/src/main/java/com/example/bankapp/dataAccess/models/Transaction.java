package com.example.bankapp.dataAccess.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "transactions")
public class Transaction {
    @DatabaseField(columnName = "id", generatedId = true)
    private int id;

    @DatabaseField(foreign = true)
    private Account sender;

    @DatabaseField(foreign = true)
    private Account receiver;

    @DatabaseField(columnName = "amount")
    private int amount;

    @DatabaseField(columnName = "date")
    private Date date;

    public Transaction() {

    }

    public Transaction(Account sender, Account receiver, int amount, Date date) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(int amount, Date date) {
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", sender=" + sender +
                ", receiver=" + receiver +
                ", amount='" + amount + '\'' +
                ", date=" + date +
                '}';
    }
}
