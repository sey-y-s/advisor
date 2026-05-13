package DAOimplementation;

import DAO.CompetenceRepository;
import models.Competence;
import com.app.db.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompetenceTable implements CompetenceRepository {

    // 🔧 Création table
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ CREATE
    @Override
    public void ajouterCompetence(Competence competence) {
        String sql = "INSERT INTO competences (nom) VALUES (?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, competence.getNom());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ READ ALL
    @Override
    public List<Competence> afficherCompetences() {
        List<Competence> list = new ArrayList<>();
        String sql = "SELECT * FROM competences";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Competence c = new Competence(
                        rs.getInt("id_competence"),
                        rs.getString("nom")
                );
                list.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✅ READ BY ID
    @Override
    public Competence getCompetenceById(int id) {
        String sql = "SELECT * FROM competences WHERE id_competence = ?";

        try (Connection conn = DatabaseManager.getConnection();
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
            e.printStackTrace();
        }

        return null;
    }

    // ✅ UPDATE
    @Override
    public void modifierCompetence(Competence competence) {
        String sql = "UPDATE competences SET nom = ? WHERE id_competence = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, competence.getNom());
            ps.setInt(2, competence.getIdCompetence());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ DELETE
    @Override
    public void supprimerCompetence(int id) {
        String sql = "DELETE FROM competences WHERE id_competence = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}