 package DAOimplementation;

import DAO.CompetenceRepository;
import db.ConnexionBdd;
import models.Competence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompetenceTable implements CompetenceRepository {

    public void creerTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS competences (
                    id_competence INT PRIMARY KEY AUTO_INCREMENT,
                    nom VARCHAR(100) NOT NULL
                )
                """;
        try (Connection conn = ConnexionBdd.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'competences' prête.");
        } catch (SQLException e) {
            System.out.println("Erreur création table : " + e.getMessage());
        }
    }

    @Override
    public void ajouterCompetence(Competence competence) {
        String sql = "INSERT INTO competences (nom) VALUES (?)";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, competence.getNom());
            ps.executeUpdate();
            System.out.println("Compétence ajoutée.");
        } catch (SQLException e) {
            System.out.println("Erreur ajouterCompetence : " + e.getMessage());
        }
    }

    @Override
    public Competence getCompetenceById(int id) {
        String sql = "SELECT * FROM competences WHERE id_competence = ?";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Competence(
                        rs.getInt("id_competence"),
                        rs.getString("nom")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur getCompetenceById : " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Competence> afficherCompetences() {
        String sql = "SELECT * FROM competences";
        List<Competence> competences = new ArrayList<>();
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Competence competence = new Competence(
                        rs.getInt("id_competence"),
                        rs.getString("nom")
                );
                competences.add(competence);
            }
        } catch (SQLException e) {
            System.out.println("Erreur afficherCompetences : " + e.getMessage());
        }
        return competences;
    }

    @Override
    public void modifierCompetence(Competence competence) { //  objet complet, pas juste un String
        String sql = "UPDATE competences SET nom = ? WHERE id_competence = ?";
        //  pas de virgule avant WHERE
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, competence.getNom());  //  tous les paramètres définis
            ps.setInt(2, competence.getIdCompetence());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Compétence modifiée avec succès.");
            } else {
                System.out.println("Compétence introuvable.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur modifierCompetence : " + e.getMessage());
        }
    }

    @Override
    public void supprimerCompetence(int id) {
        String sql = "DELETE FROM competences WHERE id_competence = ?";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Compétence supprimée.");
        } catch (SQLException e) {
            System.out.println("Erreur supprimerCompetence : " + e.getMessage());
        }
    }

}

