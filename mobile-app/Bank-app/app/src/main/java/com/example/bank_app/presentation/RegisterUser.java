package com.example.bank_app.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bank_app.R;
import com.example.bank_app.dataAccess.database.Database;
import com.example.bank_app.dataAccess.models.User;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class RegisterUser  extends AppCompatActivity {

    private EditText et1, et2, et3;
    Database dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);

        et1 = (EditText) findViewById(R.id.registerUserName);
        et2 = (EditText) findViewById(R.id.registerIdUser);
        et3 = (EditText) findViewById(R.id.registerPassUser);
    }


    public void createContact (View v){

        dbHelper = OpenHelperManager.getHelper(this, Database.class);
        RuntimeExceptionDao<User, Integer> userDao= dbHelper.getUserRuntimeDAO();

        User user = new User();
        user.setId(et2.getText().toString());
        user.setName(et1.getText().toString());
        user.setPassword(et3.getText().toString());

        userDao.create(user);


        Toast.makeText(this, "Usuario "+ user.getName() + " registrado",

                Toast.LENGTH_SHORT).show();


        Intent nextActivity = new Intent(RegisterUser.this, SelectModeActivity.class);
        startActivity(nextActivity);

    }


}
