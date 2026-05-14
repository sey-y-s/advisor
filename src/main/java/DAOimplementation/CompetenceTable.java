 package DAOimplementation;



import DAO.CompetenceRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompetenceTable implements CompetenceRepository {

    // ✅ Création de la table
    public void creerTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS competences (
                    id_competence INT PRIMARY KEY AUTO_INCREMENT,
                    nom VARCHAR(100) NOT NULL
                )
                """;
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'competences' prête.");
        } catch (SQLException e) {
            System.out.println("Erreur création table : " + e.getMessage());
        }
    }

    @Override
    public void add(Competence competence) {
        String sql = "INSERT INTO competences (id_competence, nom) VALUES (?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, competence.getIdCompetence());
            ps.setString(2, competence.getNom());
            ps.executeUpdate();
            System.out.println("Compétence ajoutée.");
        } catch (SQLException e) {
            System.out.println("Erreur add : " + e.getMessage());
        }
    }

    @Override
    public Optional<Competence> getById(int id) {
        String sql = "SELECT * FROM competences WHERE id_competence = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(); // ✅ executeQuery pas executeUpdate
            if (rs.next()) {
                Competence competence = new Competence(
                        rs.getInt("id_competence"),
                        rs.getString("nom")
                );
                return Optional.of(competence);
            }
        } catch (SQLException e) {
            System.out.println("Erreur getById : " + e.getMessage());
        }
        return Optional.empty(); // ✅ pas null
    }

    @Override
    public List<Competence> getAll() {
        String sql = "SELECT * FROM competences"; // ✅ SELECT * pas SELECT all
        List<Competence> competences = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Competence competence = new Competence(
                        rs.getInt("id_competence"),  // ✅ nom de colonne, pas variable sql
                        rs.getString("nom")
                );
                competences.add(competence); // ✅ ajout à la liste
            }
        } catch (SQLException e) {
            System.out.println("Erreur getAll : " + e.getMessage());
        }
        return competences; // ✅ retourner la liste, pas null
    }

    @Override
    public void update(Competence competence) { // ✅ objet complet, pas juste un String
        String sql = "UPDATE competences SET nom = ? WHERE id_competence = ?";
        // ✅ pas de virgule avant WHERE
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, competence.getNom());  // ✅ tous les paramètres définis
            ps.setInt(2, competence.getIdCompetence());
            int line = ps.executeUpdate();
            if (line > 0) {
                System.out.println("Compétence modifiée avec succès.");
            } else {
                System.out.println("Compétence introuvable.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur update : " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM competences WHERE id_competence = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Compétence supprimée.");
        } catch (SQLException e) {
            System.out.println("Erreur delete : " + e.getMessage());
        }
    }

}

