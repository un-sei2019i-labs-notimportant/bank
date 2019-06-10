package com.example.bankapp.businessLogic.controllers;

import android.os.Handler;

import com.example.bankapp.dataAccess.models.Account;
import com.example.bankapp.dataAccess.models.User;
import com.example.bankapp.dataAccess.repositories.AccountRepository;
import com.example.bankapp.dataAccess.repositories.UserRepository;

import java.util.List;

public class InsertFirstValuesController {

    private UserRepository user;
    private AccountRepository account;

    public void createEntries() {

        user = new UserRepository();
        account = new AccountRepository();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                List<User> userList = (List<User>) user.getThemAll();

                if(userList.size()==0) {

                    User one = new User(1116500600, "Juan Carlos", 123456);
                    User two = new User(1115600500, "Pepito Perez", 321654);

                    user.createUser(one);
                    user.createUser(two);

                    Account three = new Account(11223344, one, 500);
                    Account four = new Account(44332211, two, 700);

                    account.createAccount(three);
                    account.createAccount(four);
                }

            }
        }, 500);
    }
}
