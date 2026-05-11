package com.app;

import com.app.controllers.EtapeController;
import com.app.db.DatabaseManager;
import com.app.enums.Statut;
import com.app.model.Domaine;
import com.app.model.Etape;
import com.app.model.Projet;
import com.app.model.Utilisateur;
import com.app.services.DomaineService;
import com.app.services.EtapeService;
import com.app.tables.EtapeTable;
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
                 // 1. Création du repository (DAO)
        DomaineRepository repo = new DomaineRepository();

        // 2. Injection dans le service
        DomaineService service = new DomaineService(repo);

        // 3. AJOUTER
        service.ajouter("Informatique");
        service.ajouter("Gestion");

        // 4. AFFICHER
        System.out.println("Liste des domaines :");

        for (Domaine d : service.afficher()) {
            System.out.println(d.getId() + " - " + d.getDomaine());
        }

        // 5. MODIFIER
        service.modifier(1, "Développement");

        // 6. SUPPRIMER
        service.supprimer(2);


        
    }
}
