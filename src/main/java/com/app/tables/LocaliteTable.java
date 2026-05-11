package com.app.tables;

import java.util.*;

import com.app.model.Localite;
import com.app.repositories.LocaliteRepository;
import com.app.db.DatabaseManager;
import java.sql.*; 

public class LocaliteTable implements LocaliteRepository{

    @Override
    public void add(Localite localite) {
        String sql= "INSERT INTO localite(regionclient) VALUES(?)";
        try(Connection connection= DatabaseManager.getConnection(); 
            PreparedStatement ps= connection.prepareStatement(sql)) {
                ps.setString(1, localite.getRegionClient());
                ps.executeUpdate();
                System.out.println("Localité ajoutée avec succès !!!!!!");
         
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'enregistrement"+ e.getMessage());
        }
            
    }


    @Override
    public void delete(int id) {
        String sql= "DELETE FROM localite WHERE(id=?)";
        try(Connection connection= DatabaseManager.getConnection(); 
            PreparedStatement ps= connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
                 System.out.println("Localité supprimée avec succès !!!!!!");
              
            
        } catch (SQLException e) {
             System.out.println("Erreur lors de la suppression"+ e.getMessage());
        }
    }

     @Override
     public List<Localite> getAll() {
         String sql= "SELECT * FROM localite";
         try(Connection connection= DatabaseManager.getConnection();
          PreparedStatement ps= connection.prepareStatement(sql)) {
            try(ResultSet rs= ps.executeQuery()){
                List<Localite> localites= new ArrayList<>();
                while (rs.next()) {
                    Localite localite= new Localite();
                    localite.setId(rs.getInt("id"));
                    localite.setRegionClient(rs.getString("regionClient"));
                    localites.add(localite);   
                } 
                return localites;
            }    
         } catch (SQLException e) {
            System.out.println("Erreur lors de la recuperation de la liste des localités");
         }
         return null;
     }

     @Override
     public Localite getById(int id) {
         String sql= "SELECT * FROM localite WHERE(id=?)";
         try(Connection connection= DatabaseManager.getConnection();
          PreparedStatement ps= connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try(ResultSet rs= ps.executeQuery()){
                if(rs.next()){
                    Localite localite = new Localite(
                        rs.getInt("id"), 
                        rs.getString("regionClient"));
                        return localite;
            }
                } 
         } catch (SQLException e) {
           System.out.println("Erreur lors de la recuperation du client"+ e.getMessage());
         }
         return null;
     }
     @Override
     public void update(int id, String regionClient) {
        String sql= "UPDATE Localite SET regionClient=? WHERE(id=?)";
        try(Connection connection= DatabaseManager.getConnection();
            PreparedStatement ps= connection.prepareStatement(sql)) {
            ps.setString(1, regionClient);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Localité modifié avec succès !!!!!");
       
        } catch (SQLException e) {
           System.out.println("Erreur lors de la modification de la localité "+ e.getMessage());

        }
         
     }
}


















