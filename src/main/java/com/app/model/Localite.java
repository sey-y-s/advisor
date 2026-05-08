package com.app.model;

public class Localite{
    public Integer id;
    public String regionClient;

    public Localite(){
        
    }
    
    public Localite(Integer id, String regionClient){
        this.id = id;
        this.regionClient = regionClient;
    }
    //Les getters
    public Integer getId(){
        return id;
    }
    public String getRegionClient(){
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
    
     public void AjouterLocalite(int id,String regionClient){
        System.out.println("Localite est ajouté avec succès");
    }
        
    public void AfficherLocalite(int id,String regionClient){
        System.out.println("Localite modifié avec succès");
    }
    
    public void ModifierLocalite(int id,String regionClient){
        System.out.println("Localite modifié avec succes");
    }
    
    public void SupprimerLocalite(int id,String regionClient){
        System.out.println("Localite supprimé avec succes");
    }
    }
    
