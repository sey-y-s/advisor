package com.app;

import com.app.db.DatabaseManager;
import com.app.model.Utilisateur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Utilisateur> users = new ArrayList<>();

        System.out.println("Test");

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Utilisateur")) {

            while (rs.next()) {
                users.add(new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("email")
                ));
            }

            users.forEach(u -> System.out.println("Utilisateur trouvé : " + u.email()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
