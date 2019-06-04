package com.example.bank_app.dataAccess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.bank_app.R;
import com.example.bank_app.dataAccess.models.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Database extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "Bank_App";
    private static final int DATABASE_VERSION = 1;

    //Objetos DAO que se utilizaran para acceder a la tabla User
    private Dao<User, Integer> userDAO = null;
    private RuntimeExceptionDao<User, Integer> userRuntimeDAO = null;




    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource source) {
        try {
            Log.i(Database.class.getSimpleName(), "onCreate");
            TableUtils.clearTable(source, User.class);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource source, int oldVersion, int newVersion) {
        try {
            Log.i(Database.class.getSimpleName(), "onUpgrade");
            TableUtils.dropTable(source, User.class, true );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(db, source);
    }

    public Dao<User, Integer> getUserDAO() throws SQLException {
        if (userDAO == null)userDAO = getDao(User.class);
        return userDAO;
    }

    public RuntimeExceptionDao<User, Integer> getUserRuntimeDAO() {
        if (userDAO==null) userRuntimeDAO = getRuntimeExceptionDao(User.class);
        return userRuntimeDAO;
    }

    @Override
    public void close(){
        super.close();;
        userDAO = null;
        userRuntimeDAO = null;
    }
}