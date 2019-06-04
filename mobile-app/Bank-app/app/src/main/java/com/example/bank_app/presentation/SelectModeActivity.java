package com.example.bank_app.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bank_app.R;

public class SelectModeActivity extends AppCompatActivity {

    Button user;
    Button admin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_mode);


        user = findViewById(R.id.btnUser);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SelectModeActivity.this, UserLoginActivity.class);
                startActivity(a);
            }
        });

        admin = findViewById(R.id.btnAdmin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(SelectModeActivity.this, RegisterUser.class);
                startActivity(b);
            }
        });
    }


}
