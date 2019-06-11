package com.example.bankapp.businessLogic.controllers;

import com.example.bankapp.dataAccess.models.Account;
import com.example.bankapp.dataAccess.models.Transaction;
import com.example.bankapp.dataAccess.repositories.AccountRepository;
import com.example.bankapp.dataAccess.repositories.TransactionRepository;

import java.util.Date;

public class SendMoneyController {

    private AccountRepository account;
    private TransactionRepository transaction;
    private Account senderAcc;
    private Account receiverAcc;

    public String sendMoney(int sender, int receiver, int amount){
        if(amount==0){
            return "Amount must be greater than zero.";
        }else{
            if(sender==receiver){
                return "Accounts must be different.";
            }else{
                account = new AccountRepository();
                senderAcc = new Account();
                receiverAcc = new Account();
                if(account.getAccountById(sender)==null){
                    return "Sender's account doesn't exist.";
                }else{
                    senderAcc = (Account) account.getAccountById(sender);
                    if(account.getAccountById(receiver)==null){
                        return "Receiver's account doesn't exist.";
                    }else{
                        receiverAcc = (Account) account.getAccountById(receiver);
                        if(senderAcc.getBalance()<amount){
                            return "You don't have enough funds.";
                        }else{
                            String updateSenderFundsMessage = updateSenderFunds(senderAcc, amount);
                            if(updateSenderFundsMessage!=""){
                                return updateSenderFundsMessage;
                            }else{
                                String updateReceiverFundsMessage = updateReceiverFunds(receiverAcc, amount);
                                if(updateReceiverFundsMessage!=""){
                                    return updateReceiverFundsMessage;
                                }else{
                                    String generateBillMessage = generateTransaction(senderAcc, receiverAcc, amount);
                                    if(generateBillMessage!=""){
                                        return generateBillMessage;
                                    }else{
                                        return "Transaction completed!";
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private String updateSenderFunds(Account sender, int amount) {
        String senderUpdateMessage= "";
        try{
            senderAcc.setBalance(senderAcc.getBalance() - amount);
            account.updateAccount(senderAcc);
        }catch(Exception e){
            senderUpdateMessage = "Sender's funds couldn't be updated. Please try again later.";
        }
        return senderUpdateMessage;
    }

    private String updateReceiverFunds(Account receiver, int amount) {
        String receiverUpdateMessage= "";
        try{
            receiverAcc.setBalance(receiverAcc.getBalance() + amount);
            account.updateAccount(receiverAcc);
        }catch(Exception e){
            receiverUpdateMessage = "Receiver's funds couldn't be updated. Please try again later.";
        }
        return receiverUpdateMessage;
    }

    private String generateTransaction(Account sender, Account receiver, int amount) {
        String billMessage= "";
        try{
            transaction = new TransactionRepository();
            Transaction bill = new Transaction(sender, receiver, amount, new Date());
            transaction.createTransaction(bill);
        }catch(Exception e){
            billMessage = "The bill for the transaction cound't be generated. Please try again later.";
        }
        return billMessage;
    }

}
