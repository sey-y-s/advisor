package com.app.model;

import com.app.db.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Domaine{
    private Integer id;
    private String domaine;
    
    
    //Constructeur
    public Domaine(Integer id,String domaine){
        this.id=id;
        this.domaine=domaine;
    }
    //getters
    public String getDomaine(){
        return domaine;
    }
     public Integer getId() {
        return id;
    }

   
    //setters
    public void setDomaine(String domaine){
        this.domaine=domaine;
    }
     public void setId(Integer id) {
        this.id = id;
    }
    //les methodes
    
    public void AjouterDomaine(String domaine){
        String sql="INSERT INTO Domaine (domaine) values(?)";
        try(Connection cnn=DatabaseManager.getConnection();
        PreparedStatement stml=cnn.prepareStatement(sql)){
            stml.setString(1,domaine);
            int rows=stml.executeUpdate();
            System.out.println(rows + "domaine ajouté avec sucess");
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
        
    public void AfficherDomaine(){
        String sql="SELECT * FROM Domaine";
        try( Connection cnn=DatabaseManager.getConnection();
        Statement stml=cnn.createStatement();
            ResultSet rs=stml.executeQuery(sql)){
                while(rs.next()){
                    System.out.println(rs.getInt("id")+" "+rs.getString("domaine"));
                }
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
    
    public void ModifierDomaine(Integer id,String domaine){
       String sql="Update domaine SET domaine=? where id=?";
       try(Connection cnn=DatabaseManager.getConnection();
       PreparedStatement stml=cnn.prepareStatement(sql)){
        stml.setString(1,domaine);
        stml.setInt(2,id);
        int rows=stml.executeUpdate();
        System.out.println(rows+"Domaine a été fait avec succes");
       }
       catch(Exception e){
        e.printStackTrace();
       }
    }
    
    public void SupprimerDomaine(){
        String sql="DELETE FROM Domaine WHERE id=?";
        try(Connection cnn=DatabaseManager.getConnection()
        PreparedStatement stml=cnn.prepareStatement(sql)){
            stml.setInt(1,id);
            int rows=stml.executeUpdate(sql);
             System.out.println(rows+"Domaine est supprimé avec succes");
        }
        catch(Exception e){
            e.printStackTrace();
        }
         
        
    }
}
