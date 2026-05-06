package com.app.model;

public class Localite {
    public class Localite{
    public Integer id;
    public String regionClient;
    
    public Localite(Integer id, String regionClient){
        this.id = id;
        this.regionClient = region.client;
    }
    //Les getters
    public getId(){
        return id;
    }
    public getRegionClient(){
        return regionClient;
    }
    
    //Les setters
    public void setId(Integer id){
        this.id = id;
    }
    public void setRegionClient(String regionClient){
        this.regionClient = regionClient;
    }
    
    //Les méthodes
    
     Public AjouterLocalite(int id,String regionClient){
        System.out.println("Localite est ajouté avec succes");
    }
        
    Public AfficherLocalite(int id,String regionClient){
        System.out.println("Localite modifié avec succes");
    }
    
    Public ModifierLocalite(int id,String regionClient){
        System.out.println("Localite modifié avec succes");
    }
    
    Public SupprimerLocalite(int id,String regionClient){
        System.out.println("Localite supprimé avec succes");
    }
    }
    
}
