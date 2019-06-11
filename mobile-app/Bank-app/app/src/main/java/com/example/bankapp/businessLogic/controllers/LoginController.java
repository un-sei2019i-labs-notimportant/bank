package com.example.bankapp.businessLogic.controllers;

import com.example.bankapp.dataAccess.models.Account;
import com.example.bankapp.dataAccess.models.User;
import com.example.bankapp.dataAccess.repositories.AccountRepository;
import com.example.bankapp.dataAccess.repositories.UserRepository;

import java.util.List;

public class LoginController {

    private AccountRepository accountRepository;
    private UserRepository userRepository;
    private User user = new User();

    public int loginNow(int idNumber, int password){
        int accountLoggedIn = 0;
        userRepository = new UserRepository();
        user = (User) userRepository.getUserById(idNumber);
        if(user==null){
            return accountLoggedIn;
        }else{
            int pass = user.getPassword();
            if(pass!=password){
                return accountLoggedIn;
            }else{
                accountRepository = new AccountRepository();
                List<Account> accountList = (List<Account>) accountRepository.getThemAll();
                for(Account accs: accountList){
                    int accountNumberToMatch = accs.getOwner().getIdNumber();
                    if(user.getIdNumber()==accountNumberToMatch){
                        accountLoggedIn = accs.getAccountNumber();
                        return accountLoggedIn;
                    }
                }
                return accountLoggedIn;
            }
        }
    }
}
