package com.app.model;

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
    public getDomaine(String domaine){
        return domaine;
    }
    //setters
    public setDomaine(String domaine){
        this.domaine=domaine;
    }
    //les methodes
    
    public String AjouterDomaine(intString domaine){
        String sql="INSERT INTO Domaine (id,domaine) values(?,?)";
        try(Connection cnn=Geeks.getConnection();
        PreparedStatement stml=cnn.prepareStatement(sql)){
            stml.setString(1,id);
            stml.setString(2,domaine);
            int rows=stml.executeUpdate();
            System.out.println(rows + "domaine ajouté avec sucess");
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
        
    public String AfficherDomaine(){
        String sql="SELECT * FROM Domaine";
        try( Connection cnn=Geeks.getConnection();
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
    public String ModifierDomaine(Integer id,String domaine){
       String sql="Update domaine SET domaine=? where id=?";
       try(Connection cnn=Geeks.getConnection();
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
    public String SupprimerDomaine(){
        String sql="DELETE FROM Domaine WHERE id=?";
        try(Connection cnn=Geeks.getConnection();
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
