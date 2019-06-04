package com.example.bank_app.dataAccess.models;

import android.text.Editable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "user")
public class User {

    @DatabaseField(id = true)
    private Integer id; //PrimaryKey
    @DatabaseField(index = true, canBeNull = false)
    private String name;
    @DatabaseField(canBeNull = false)
    private Integer password;
    @DatabaseField
    private Integer numberAccount;

    public User() {
    }

    public User(Integer id, String name, Integer password, Integer numberAccount) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.numberAccount = numberAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Integer.parseInt(password);
    }

    public Integer getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Integer numberAccount) {
        this.numberAccount = numberAccount;
    }
}
