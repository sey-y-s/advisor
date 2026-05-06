package com.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://postgres.avzframhhoditooyexkr:advisor_databas@aws-0-eu-west-1.pooler.supabase.com:6543/postgres";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
