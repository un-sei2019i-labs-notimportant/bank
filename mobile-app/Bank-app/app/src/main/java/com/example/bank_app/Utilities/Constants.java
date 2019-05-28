package com.example.bank_app.Utilities;

public class Constants {

    public static final String USER_TABLE = "user";
    public static final String ID_FIELD = "id";
    public static final String USERNAME_FIELD = "username";
    public static final String PASSWORD_FIELD = "password";

    public static final String CREATE_USER_TABLE = "CREATE TABLE "+USER_TABLE+"("+ID_FIELD+" INTEGER PRIMARY KEY AUTOINCREMENT, "+USERNAME_FIELD+" TEXT(20) not null unique, "+PASSWORD_FIELD+" INTEGER not null)";
    public static final String INSERT_FIRST_USER = "INSERT INTO "+USER_TABLE+"("+USERNAME_FIELD+", "+PASSWORD_FIELD+") VALUES('jucnunezgom', 123456)";


}
