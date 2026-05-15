package DAOimplementation;

import DAO.EtapeRepository;
import BD.ConnexionBdd;
import Models.Etape;
import Models.Projet;
import Models.enums.StatutEtape;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EtapeTable implements EtapeRepository {

    //Ajouter une nouvelle étape
    @Override
    public void ajout_etape(Etape etape) {
        String sql = "INSERT INTO etape (titre, description, etapeStatut, projet) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, etape.getTitre());
            stmt.setString(2, etape.getDescription());
            stmt.setObject(3, etape.getEtapeStatut());
            stmt.setObject(4, etape.getProjet());

            stmt.executeUpdate();
            System.out.println("Étape ajoutée avec succès !");

        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de l'étape !");
            e.printStackTrace();
        }
    }

    //Rechercher une étape spécifique
    @Override
    public Optional<Etape> rech_etape(int idEtape) {
        String sql = "SELECT * FROM etape WHERE idEtape = ?";

        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEtape);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Etape etape = new Etape();
                etape.setIdEtape(rs.getInt("idEtape"));
                etape.setTitre(rs.getString("titre"));
                etape.setDescription(rs.getString("description"));
                String statut = rs.getString("etapeStatut");
                if (statut != null) {
                    etape.setEtapeStatut(StatutEtape.valueOf(statut));
                }
                Projet projet = new Projet();
                projet.setId(rs.getInt("projet"));
                etape.setProjet(projet);

                return Optional.of(etape);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la recherche de l'étape : " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    //Liste de toutes les étapes
    @Override
    public List<Etape> Liste_etape() {
        String sql = "SELECT * FROM etape";
        List<Etape> etapeList = new ArrayList<>();

        try (Connection conn = ConnexionBdd.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Etape e = new Etape();
                e.setIdEtape(rs.getInt("idEtape"));
                e.setTitre(rs.getString("titre"));
                e.setDescription(rs.getString("description"));
                String statut = rs.getString("etapeStatut");
                if (statut != null) {
                    e.setEtapeStatut(StatutEtape.valueOf(statut));
                }
                Projet projet = new Projet();
                projet.setId(rs.getInt("projet"));
                e.setProjet(projet);

                etapeList.add(e);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération de la liste des étapes !");
            e.printStackTrace();
        }
        return etapeList;
    }

    //Mise à jour d'une étape
    @Override
    public boolean mise_a_jour_etape(Etape etape) {
        String sql = "UPDATE etape SET titre = ?, description = ?, etapeStatut = ?, projet = ? WHERE idEtape = ?";

        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, etape.getTitre());
            stmt.setString(2, etape.getDescription());
            stmt.setObject(3, etape.getEtapeStatut());
            stmt.setObject(4, etape.getProjet());
            stmt.setInt(5, etape.getIdEtape());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Étape mise à jour avec succès !");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la mise à jour de l'étape !");
            e.printStackTrace();
        }
        return false;
    }

    //Suppression d'une étape
    @Override
    public boolean suppr_etape(int idEtape) {
        String sql = "DELETE FROM etape WHERE idEtape = ?";

        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEtape);
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Étape supprimée avec succès !");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression de l'étape !");
            e.printStackTrace();
        }
        return false;
    }

    //Verifier l'existance d'une étape
    @Override
    public boolean verif_etape(int idEtape) {
        String sql = "SELECT 1 FROM etape WHERE idEtape = ?";

        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEtape);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("Erreur lors de la vérification de l'étape : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}

