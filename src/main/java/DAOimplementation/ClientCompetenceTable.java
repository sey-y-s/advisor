package DAOimplementation;

import DAO.ClientCompetenceRepository;
import db.ConnexionBdd;
import models.ClientCompetence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientCompetenceTable implements ClientCompetenceRepository {

    @Override
    public void add(models.ClientCompetence clientCompetence) {

        String sql = "INSERT INTO ClientCompetence (idClient, idCompetence) VALUES (?, ?)";

        try (Connection cnn = ConnexionBdd.getConnection();
             PreparedStatement stml = cnn.prepareStatement(sql)) {

            stml.setInt(1, clientCompetence.getClient().getId());

            stml.setInt(2, clientCompetence.getCompetence().getId());

            stml.executeUpdate();

            System.out.println("ClientCompetence ajouté avec succès");

        } catch (SQLException e) {

            System.out.println("Erreur lors de l'ajout");
        }
    }

    @Override
    public List<ClientCompetence> getAll() {

        List<models.ClientCompetence> list = new ArrayList<>();

        String sql = "SELECT * FROM ClientCompetence";

        try (Connection cnn = ConnexionBdd.getConnection();
             PreparedStatement stml = cnn.prepareStatement(sql);
             ResultSet rs = stml.executeQuery()) {

            while (rs.next()) {

                models.ClientCompetence cc = new models.ClientCompetence();

                cc.setId(rs.getInt("id"));

                list.add(cc);
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void update(ClientCompetence clientCompetence){
        String sql = "UPDATE ClientCompetence " +
                "SET idClient = ?, idCompetence = ? " +
                "WHERE id = ?";
        try (Connection cnn = ConnexionBdd.getConnection();
             PreparedStatement stml = cnn.prepareStatement(sql)) {

            stml.setInt(1, clientCompetence.getClient().getId());

            stml.setInt(2, clientCompetence.getCompetence().getId());

            stml.setInt(3, clientCompetence.getId());

            stml.executeUpdate();

            System.out.println("Modification réussie");

        } catch (SQLException e) {

            System.out.println("Erreur lors de la modification");
        }
    };

    @Override
    public void delete(int id) {

        String sql = "DELETE FROM ClientCompetence WHERE id = ?";

        try (Connection cnn = ConnexionBdd.getConnection();
             PreparedStatement stml = cnn.prepareStatement(sql)) {

            stml.setInt(1, id);

            stml.executeUpdate();

            System.out.println("Suppression réussie");

        } catch (SQLException e) {

            System.out.println("Erreur lors de la suppression");
        }
    }
