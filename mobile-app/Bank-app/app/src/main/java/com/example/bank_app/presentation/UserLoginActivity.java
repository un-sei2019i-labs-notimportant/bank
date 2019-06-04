package com.example.bank_app.presentation;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_app.R;
import com.example.bank_app.dataAccess.database.Database;

public class UserLoginActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);

        et1 = (EditText) findViewById(R.id.idUser);
        et2 = (EditText) findViewById(R.id.passUser);
    }

    public void consulta(View v) {

        Database admin = new Database(this,

                "usuarios", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String idUser = et1.getText().toString();
        String idPass = et2.getText().toString();

        Cursor fila = bd.rawQuery(

                "select id, nombre, password from usuarios where id='" + idUser+"'and password="+ idPass, null);

        if (fila.moveToFirst()) {

            Intent nextActivity = new Intent(UserLoginActivity.this, UserActivity.class);
            startActivity(nextActivity);

        } else

            Toast.makeText(this, "No existe ningún usuario con ese usuario o contraseña",

                    Toast.LENGTH_SHORT).show();

        bd.close();

    }
}
