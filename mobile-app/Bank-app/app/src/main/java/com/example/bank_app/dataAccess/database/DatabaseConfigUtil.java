package com.example.bank_app.dataAccess.database;

import com.example.bank_app.dataAccess.models.User;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {


    private static final Class<?>[]  classes = new Class[]{User.class};

    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile("ormlite_config.txt");
    }
}
