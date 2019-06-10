package com.example.bankapp.presentation.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.bankapp.R;
import com.example.bankapp.businessLogic.controllers.InsertFirstValuesController;
import com.example.bankapp.businessLogic.controllers.LoginController;
import com.example.bankapp.dataAccess.database.DatabaseManager;

public class LoginActivity extends AppCompatActivity {

    private LoginController loginController;
    private EditText et_idnumber;
    private EditText et_password;
    private InsertFirstValuesController insertFirstValuesController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DatabaseManager.init(LoginActivity.this);

        insertFirstValuesController = new InsertFirstValuesController();
        insertFirstValuesController.createEntries();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Banky");

        et_idnumber = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);

        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginController = new LoginController();
                try{
                    int idNum = Integer.parseInt(et_idnumber.getText().toString());
                    int pass = Integer.parseInt(et_password.getText().toString());
                    try{
                        int matchedAccount = loginController.loginNow(idNum, pass);
                        if(matchedAccount==0){
                            Toast.makeText(getApplicationContext(), "The data you have entered is incorrect.", Toast.LENGTH_SHORT).show();
                        }else{
                            et_idnumber.setText("");
                            et_password.setText("");
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("currentAccount", String.valueOf(matchedAccount));
                            startActivity(intent);
                            finish();
                        }
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), "There was a problem with our servers. Please try again later.", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "All fields must be filled.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
