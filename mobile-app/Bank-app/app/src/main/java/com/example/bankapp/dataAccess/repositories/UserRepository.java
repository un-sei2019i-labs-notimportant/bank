package com.example.bankapp.dataAccess.repositories;

import com.example.bankapp.dataAccess.database.DatabaseHelper;
import com.example.bankapp.dataAccess.database.DatabaseManager;
import com.example.bankapp.dataAccess.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserRepository {

    private DatabaseHelper helper;

    public UserRepository() {
        this.helper = DatabaseManager.getInstance().getHelper();
    }


    public int createUser(Object item) {

        int index = -1;
        User object = (User) item;

        try {
            index = helper.getUserDao().create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }


    public int updateUser(Object item) {

        int index = -1;
        User object = (User) item;

        try {
            index = helper.getUserDao().update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }


    public int deleteUser(Object item) {

        int index = -1;
        User object = (User) item;

        try {
            index = helper.getUserDao().delete(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }


    public Object getUserById(int id) {

        User object = null;

        try {
            object = helper.getUserDao().queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return object;
    }


    public List<?> getThemAll() {

        List<User> items = null;

        try {
            items = helper.getUserDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
