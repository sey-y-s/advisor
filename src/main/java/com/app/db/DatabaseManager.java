package com.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://aws-0-eu-west-1.pooler.supabase.com:6543/postgres?user=postgres.avzframhhoditooyexkr&password=advisor_databas";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

}
