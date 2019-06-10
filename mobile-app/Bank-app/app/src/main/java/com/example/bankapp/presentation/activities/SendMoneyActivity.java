package com.example.bankapp.presentation.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bankapp.R;
import com.example.bankapp.businessLogic.controllers.SendMoneyController;

public class SendMoneyActivity extends AppCompatActivity {

    private EditText et_receiver;
    private EditText et_amount;
    private TextView tv_account;
    private TextView tv_currentAccount;
    private SendMoneyController sendMoneyController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Send Money");

        et_receiver = (EditText) findViewById(R.id.et_receiver);
        et_amount = (EditText) findViewById(R.id.et_amount);
        tv_account = (TextView) findViewById(R.id.tv_account);
        tv_currentAccount = (TextView) findViewById(R.id.tv_currentAccount);

        Bundle extras = this.getIntent().getExtras();
        final String sender = extras.getString("sender");
        tv_currentAccount.setText(sender);

        Button btn_sendmoney = findViewById(R.id.btn_sendmoney);
        btn_sendmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMoneyController = new SendMoneyController();
                try{
                    int receiver = Integer.parseInt(et_receiver.getText().toString());
                    int amount = Integer.parseInt(et_amount.getText().toString());
                    try{
                        String appResponseTransaction = sendMoneyController.sendMoney(Integer.parseInt(sender), receiver, amount);
                        Toast.makeText(getApplicationContext(), appResponseTransaction, Toast.LENGTH_SHORT).show();
                    }catch(Exception e){
                        Toast.makeText(getApplicationContext(), "There was a problem with our servers. Please try again later.", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "All fields must be filled.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMoneyActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
