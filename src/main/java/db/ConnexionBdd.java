package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBdd {
    public static Connection getConnection () throws SQLException {
        String URL="jdbc:mysql://localhost:3306/advisor";
         String USER="root";
         String PASSWORD="diallacoul";
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
