package com.app.tables;

import java.util.*;

import com.app.enums.Statut;
import com.app.model.*;
import com.app.repositories.ActiviteRepository;
import com.app.db.DatabaseManager;
import com.app.repositories.EtapeRepository;

import java.sql.*;

public class ActiviteTable implements ActiviteRepository{
    @Override
    public void add(Activite activite){
        String sql = "INSERT INTO activite(titre, description, duree, statut, etape) VALUES(?, ?, ?, ?, ?)";
        try(Connection connection = DatabaseManager.getConnection();
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
        try (Connection connection = DatabaseManager.getConnection();
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
                            Statut.valueOf(rs.getString("statut")),
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
        
    }

    @Override
    public void update(int id, String activite) {
        
    }

    @Override
    public void delete(int id) {
        
    }
}
