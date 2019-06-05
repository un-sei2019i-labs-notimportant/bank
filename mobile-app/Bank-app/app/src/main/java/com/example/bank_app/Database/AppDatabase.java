package com.example.bank_app.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.bank_app.Dao.ItemDAO;
import com.example.bank_app.Models.Item;


@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract ItemDAO getItemDAO();
}
