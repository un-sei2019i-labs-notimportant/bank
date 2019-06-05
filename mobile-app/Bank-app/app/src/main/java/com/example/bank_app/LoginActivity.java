package com.example.bank_app;

import android.arch.persistence.room.Room;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_app.Dao.ItemDAO;
import com.example.bank_app.Database.AppDatabase;
import com.example.bank_app.Database.DBHelper;
import com.example.bank_app.Models.Item;
import com.example.bank_app.Utilities.Constants;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText et_username, et_password;

    DBHelper conn;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        conn = new DBHelper(getApplicationContext(), "userdb", null, 1);

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

        //Room Database
        database = Room.databaseBuilder(this, AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();



    }



    public void crearUsuario(View view)
    {
        ItemDAO itemDAO = database.getItemDAO();
        Item item = new Item();
        item.setName("Item001");
        item.setDescription("Item 001");
        Long sq = (long) 1000;
        item.setQuantity(sq);

        itemDAO.insert(item);
        List<Item> items = itemDAO.getItems();
        System.out.println(items);
        Toast.makeText(getApplicationContext(), "items!: " + items.size(), Toast.LENGTH_SHORT).show();
    }

    public void login(View view){
        SQLiteDatabase db = conn.getReadableDatabase();
        String form_username = et_username.getText().toString();
        String form_password = et_password.getText().toString();
        try{
            Cursor cursor = db.rawQuery("SELECT username FROM user WHERE username='"+form_username+"' AND password='"+form_password+"'", null);
            cursor.moveToFirst();
            if(cursor.moveToFirst()==true){
                String returned_user = cursor.getString(0);
                Toast.makeText(getApplicationContext(), "You are now logged in, "+returned_user+"!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "The data you have entered is not valid.", Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Toast.makeText(getApplicationContext(), "The data you have entered is not valid.", Toast.LENGTH_SHORT).show();
        }
    }


}
