package com.app.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.app.db.DatabaseManager;
import com.app.enums.Statut;
import com.app.model.Etape;
import com.app.repositories.EtapeRepository;

public class EtapeTable implements EtapeRepository {
    private static final String INSERT_SQL = "INSERT INTO etape (titre, description, statut, id_projet) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM etape WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM etape";
    private static final String UPDATE_SQL = "UPDATE etape SET titre = ?, description = ?, statut = ?, id_projet = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM etape WHERE id = ?";
    private static final String EXISTS_SQL = "SELECT COUNT(*) FROM etape WHERE id = ?";

    @Override
    public void add(Etape etape) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, etape.getTitre());
            stmt.setString(2, etape.getDescription());
            stmt.setString(3, etape.getStatut().name());
            if (etape.getProjet() != null && etape.getProjet().getIdProjet() != null) {
                stmt.setInt(4, etape.getProjet().getIdProjet());
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'étape : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Etape> getById(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_SQL)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRowToEtape(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la lecture de l'étape : " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Etape> getAll() {
        List<Etape> etapes = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                etapes.add(mapRowToEtape(rs));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des étapes : " + e.getMessage());
            e.printStackTrace();
        }
        return etapes;
    }

    @Override
    public boolean update(Etape etape) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
            stmt.setString(1, etape.getTitre());
            stmt.setString(2, etape.getDescription());
            stmt.setString(3, etape.getStatut().name());
            if (etape.getProjet() != null && etape.getProjet().getIdProjet() != null) {
                stmt.setInt(4, etape.getProjet().getIdProjet());
            } else {
                stmt.setNull(4, java.sql.Types.INTEGER);
            }
            stmt.setInt(5, etape.getIdEtape());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'étape : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_SQL)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'étape : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean existsById(int id) {
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(EXISTS_SQL)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la vérification de l'existence de l'étape : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private Etape mapRowToEtape(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");
        String titre = rs.getString("titre");
        String description = rs.getString("description");
        Statut statut = Statut.valueOf(rs.getString("statut"));
        Etape etape = new Etape(id, titre, description, statut, null);
        return etape;
    }
}
