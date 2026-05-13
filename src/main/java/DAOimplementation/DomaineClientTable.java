package DAOimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import db.ConnexionBdd;
import models.DomaineClient;
import DAO.DomaineClientRepository;

public class DomaineClientTable implements DomaineClientRepository {

    private static final String TABLE = "domaine_client";

    @Override
    public void add(DomaineClient domaineClient) {
        // Hypothèse: table de jointure (id_client, id_domaine) avec PK id.
        String insert = "INSERT INTO " + TABLE + " (id_client, id_domaine) VALUES (?, ?)";

        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, domaineClient.getIdClient());
            stmt.setInt(2, domaineClient.getIdDomaine());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout DomaineClient : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Optional<DomaineClient> getById(int id) {
        String selectById = "SELECT * FROM " + TABLE + " WHERE id = ?";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement stmt = conn.prepareStatement(selectById)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    DomaineClient dc = new DomaineClient();
                    dc.setId(rs.getInt("id"));
                    dc.setIdClient(rs.getInt("id_client"));
                    dc.setIdDomaine(rs.getInt("id_domaine"));
                    return Optional.of(dc);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération DomaineClient par id : " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<DomaineClient> getAll() {
        String selectAll = "SELECT * FROM " + TABLE;
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement stmt = conn.prepareStatement(selectAll);
             ResultSet rs = stmt.executeQuery()) {

            List<DomaineClient> result = new ArrayList<>();
            while (rs.next()) {
                DomaineClient dc = new DomaineClient();
                dc.setId(rs.getInt("id"));
                dc.setIdClient(rs.getInt("id_client"));
                dc.setIdDomaine(rs.getInt("id_domaine"));
                result.add(dc);
            }
            return result;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la liste DomaineClient : " + e.getMessage());
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void delete(int id) {
        String delete = "DELETE FROM " + TABLE + " WHERE id = ?";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement stmt = conn.prepareStatement(delete)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression DomaineClient : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public boolean exists(int idClient, int idDomaine) {
        // Vérifie existence paire (id_client, id_domaine)
        String query = "SELECT COUNT(*) FROM " + TABLE + " WHERE id_client = ? AND id_domaine = ?";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idClient);
            stmt.setInt(2, idDomaine);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la vérification d'existence DomaineClient : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}

