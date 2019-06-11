package com.example.bankapp.dataAccess.repositories;

import com.example.bankapp.dataAccess.database.DatabaseHelper;
import com.example.bankapp.dataAccess.database.DatabaseManager;
import com.example.bankapp.dataAccess.models.Transaction;

import java.sql.SQLException;
import java.util.List;

public class TransactionRepository {

    private DatabaseHelper helper;

    public TransactionRepository() {
        this.helper = DatabaseManager.getInstance().getHelper();
    }


    public int createTransaction(Object item) {

        int index = -1;
        Transaction object = (Transaction) item;

        try {
            index = helper.getTransactionDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }


    public int updateTransaction(Object item) {

        int index = -1;
        Transaction object = (Transaction) item;

        try {
            index = helper.getTransactionDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }


    public int deleteTransaction(Object item) {

        int index = -1;
        Transaction object = (Transaction) item;

        try {
            index = helper.getTransactionDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }


    public Object getTransactionById(int id) {

        Transaction object = null;

        try {
            object = helper.getTransactionDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }


    public List<?> getThemAll() {

        List<Transaction> items = null;

        try {
            items = helper.getTransactionDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}

