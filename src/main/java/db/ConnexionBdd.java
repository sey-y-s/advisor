package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBdd {

    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/advisor";
        String HOST = "root";
        String PASSWORD = "12345";

        try (Connection conn =
                     DriverManager.getConnection(URL, HOST, PASSWORD)) {

            if (conn != null) {

                System.out.println("Connexion réussie à la base de données");

            }

        } catch (SQLException e) {

            System.out.println("Erreur de connexion : " + e.getMessage());

        }
    }

    public static Connection getConnection() {
                return null;
    }
}