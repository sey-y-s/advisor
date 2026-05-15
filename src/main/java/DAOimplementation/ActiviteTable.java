package DAOimplementation;

import BD.ConnexionBdd;
import Models.*;
import Models.enums.StatutEtape;
import DAO.ActiviteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActiviteTable implements ActiviteRepository {

    @Override
    public void add(Activite activite){
        String sql = "INSERT INTO activite(titre, description, duree, idEtape) VALUES(?, ?, ?, ?)";
        try(Connection connection = ConnexionBdd.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, activite.getTitre());
            ps.setString(2, activite.getDescription());
            ps.setInt(3, activite.getDuree());
            ps.setInt(4, activite.getEtape().getIdEtape());
            ps.executeUpdate();
            System.out.println("Activité ajoutée avec succès !");
        } catch (SQLException e){
            throw new RuntimeException(e);
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
        String sql = "SELECT * FROM Activite JOIN Etape ON Activite.id = Etape.id";
        List<Activite> activites = new ArrayList<>();
        try(Connection connection = ConnexionBdd.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Etape etape= new Etape();
                etape.setTitre(rs.getString("titre"));
                etape.setTitre(rs.getString("titre"));
                Activite activite = new Activite(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getInt("duree"),
                        StatutEtape.valueOf(rs.getString("statut")),
                        etape
                );
                activites.add(activite);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return activites;
    }

    @Override
    public void update(int id, StatutEtape statut) {
        String sql = "UPDATE activite SET statut=? WHERE id=?";
        try(Connection connection = ConnexionBdd.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, String.valueOf(statut));
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Statut de l'activité modifié !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM activite WHERE id = ?";
        try(Connection connection = ConnexionBdd.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Activité supprimée !");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
