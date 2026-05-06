package com.app;

import com.app.db.DatabaseManager;
import com.app.model.Utilisateur;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Utilisateur> users = new ArrayList<>();

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM utilisateurs")) {

            while (rs.next()) {
                users.add(new Utilisateur(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("email")
                ));
            }

            users.forEach(u -> System.out.println("Utilisateur trouvé : " + u.nom()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
