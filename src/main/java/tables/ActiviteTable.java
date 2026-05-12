package tables;

import db.ConnexionBdd;
import models.*;
import models.enums.StatutEtape;
import repositories.ActiviteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActiviteTable implements ActiviteRepository {

    @Override
    public void add(Activite activite){
        String sql = "INSERT INTO activite(titre, description, duree, statut, etape) VALUES(?, ?, ?, ?, ?)";
        try(Connection connection = ConnexionBdd.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, activite.getTitre());
            ps.setString(2, activite.getDescription());
            ps.setInt(3, activite.getDuree());
            ps.setString(4, activite.getStatut().name());
            ps.setInt(5, activite.getEtape().getIdEtape());
            ps.executeUpdate();
            System.out.println("Activité ajoutée avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'activité !");
        }
    }

    @Override
    public Activite getById(int id) {
        String sql = "SELECT * FROM activite WHERE id = ?";
        try (Connection connection = ConnexionBdd.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){

                    //int idEtape = rs.getInt("etape_id");
                    //Etape etape = EtapeRepository.getIdEtape(idEtape);

                    int idEtape = rs.getInt("etape_id");

                    Etape etape = new Etape();
                    etape.setIdEtape(idEtape);

                    Activite activite = new Activite(
                            rs.getInt("id"),
                            rs.getString("titre"),
                            rs.getString("description"),
                            rs.getInt("duree"),
                            StatutEtape.valueOf(rs.getString("statut")),
                            etape
                    );
                    return activite;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Activite> getAll() {
        String sql = "SELECT * FROM Activite";
        List<Activite> activites = new ArrayList<>();
        try(Connection connection = ConnexionBdd.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Etape etape= new Etape();
                etape.setTitre(rs.getString("titre"));
                Activite activite = new Activite(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getInt("duree"),
                        StatutEtape.valueOf(rs.getString("statut")),
                        rs.getString("etape")
                );
                activites.add(activite);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(int id, String activite) {

    }

    @Override
    public void delete(int id) {

    }

}


"SELECT u.id AS user_id," +
        " u.nom, u.prenom," +
        " u.telephone," +
        " u.role AS role," +
        " u.email, c.niveau," +
        " l.id AS id_localite, l.regionClient AS region " +
    "FROM utilisateur u " +
        "JOIN client c ON u.id= c.id " +
        "JOIN localite l ON l.id=c.idlocalite";
