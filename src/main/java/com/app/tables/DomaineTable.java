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

public class DomaineEtape implements DomaineRepository{
    @Override
    public void AjouterDomaine(Domaine domaine){
        String sql="INSERT INTO Domaine(domaine) VALUES(?)";
        try(Connection cnn=DatabaseManager.getConnection();
        prepareStatement stml=cnn.prepareStatement(sql)){
            stml.setString(1,domaine.getDomaine())
            stml.executeUpdate();
            System.out.println("Domaine ajouté avec succès");

        }
        catch(Exception e){
            e.printStackTrace();

        }
       
    }
    @Override 
    public List<Domaine> AfficherDomaine(){
        String sql="SELECT * FROM Domaine";
        try(Connection cnn=DatabaseManager.getConnection();
        PreparedStatement stml=cnn.prepareStatement(sql)){
            ResultSet rs=stmt.executeQuery();
              List<Domaine> listDomaine=ArrayList<>();
              while(rs.next()){
                Domaine domaine=createStatemen(rs);
                listDomaine.add(domaine);
              }
            

        }
        catch(Exception e){
            e.printStackTrace();

        }
        return new ArrayList<>();
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