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
import com.app.model.Domaine;
import com.app.repositories.DomaineRepository;

public class DomaineTable implements DomaineRepository{
    @Override
    public void AjouterDomaine(Domaine domaine){
        String sql="INSERT INTO Domaine(domaine) VALUES(?)";
        try(Connection cnn=DatabaseManager.getConnection();
        prepareStatement stml=cnn.prepareStatement(sql)){
            stml.setString(1,domaine.getDomaine());
            stml.executeUpdate();
            System.out.println("Domaine ajouté avec succès");

        }
        catch(Exception e){
            e.printStackTrace();

        }
       
    }
    @Override 
      
    public List<Domaine> AfficherDomaine() {
        List<Domaine> list = new ArrayList<>();
        String sql = "SELECT * FROM Domaine";

        try (Connection cnn = DatabaseManager.getConnection();
             Statement st = cnn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Domaine d = new Domaine(
                    rs.getInt(1,"id"),
                    rs.getString(2,"domaine")
                );

                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
     @Override
     public void ModifierDomaine(Domaine domaine){
        String sql="UPDATE Domaine SET domaine=? WHERE id=?";
        try(Connection cnn=DatabaseManager.getConnection()
        PreparedStatement stml=cnn.PreparedStatement(sql)){
            stml.setString(1,domaine.getDomaine());
            stml.setInt(2,domaine.getId());
            stmt.executeUpdate();
            System.out.println("Domaine modifié avec succes");

        }
        catch(Exception e){
            e.printStackTrace();
        }
     }
    @Override
    public void SupprimerDomaine(int id){
        String sql="DELETE FROM Domaine WHERE id=?";
        try(Connection cnn=DatabaseManager.getConnection()
        PreparedStatement stml=cnn.PreparedStatement(sql)){
            stml.setInt(1,id);
            stml.executeUpdate();
            System.out.println("Domaine supprimé avec succes");

        }
        catch(Exception e){
            e.printStackTrace();

        }
    }


}