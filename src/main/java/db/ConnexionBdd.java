package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBdd {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/advisor";
        String utilisateur = "root";
        String motDePasse = "";

        try (Connection conn = DriverManager.getConnection(url, utilisateur, motDePasse)) {

            if (conn != null) {
                System.out.println("Connexion réussie à la base de données !");
            }

        } catch (SQLException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
            e.printStackTrace();
        }
    }
}


