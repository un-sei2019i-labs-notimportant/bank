package com.example.bankapp.dataAccess.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName = "users")
public class User {

    @DatabaseField(columnName = "idNumber", id = true)
    private int idNumber;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "password")
    private int password;

    public User() {}

    public User(int idNumber, String name, int password) {
        this.idNumber = idNumber;
        this.name = name;
        this.password = password;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "idNumber=" + idNumber +
                ", name='" + name + '\'' +
                ", password=" + password +
                '}';
    }
}
