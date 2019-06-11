package com.example.bankapp.dataAccess.repositories;

import com.example.bankapp.dataAccess.database.DatabaseHelper;
import com.example.bankapp.dataAccess.database.DatabaseManager;
import com.example.bankapp.dataAccess.models.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountRepository {

    private DatabaseHelper helper;

    public AccountRepository() {
        this.helper = DatabaseManager.getInstance().getHelper();
    }


    public int createAccount(Object item) {

        int index = -1;
        Account object = (Account) item;

        try {
            index = helper.getAccountDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }


    public int updateAccount(Object item) {

        int index = -1;
        Account object = (Account) item;

        try {
            index = helper.getAccountDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }


    public int deleteAccount(Object item) {

        int index = -1;
        Account object = (Account) item;

        try {
            index = helper.getAccountDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }


    public Object getAccountById(int id) {

        Account object = null;

        try {
            object = helper.getAccountDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }


    public List<?> getThemAll() {

        List<Account> items = null;

        try {
            items = helper.getAccountDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
