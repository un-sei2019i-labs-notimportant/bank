package com.example.bankapp.dataAccess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bankapp.dataAccess.models.Account;
import com.example.bankapp.dataAccess.models.Transaction;
import com.example.bankapp.dataAccess.models.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "transactions.db";
    private static final int DATABASE_VERSION = 1;

    // database access objects
    private Dao<User, Integer> userDao;
    private Dao<Account, Integer> accountDao;
    private Dao<Transaction, Integer> transactionDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, Account.class);
            TableUtils.createTable(connectionSource, Transaction.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.createTable(connectionSource, Account.class);
            TableUtils.createTable(connectionSource, Transaction.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<User, Integer> getUserDao() {
        if (userDao == null) {
            try {
                userDao = getDao(User.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userDao;
    }

    public Dao<Account, Integer> getAccountDao() {
        if (accountDao == null) {
            try {
                accountDao = getDao(Account.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return accountDao;
    }

    public Dao<Transaction, Integer> getTransactionDao() {
        if (transactionDao == null) {
            try {
                transactionDao = getDao(Transaction.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return transactionDao;
    }
}
