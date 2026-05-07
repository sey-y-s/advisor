package com.app.model;

import com.app.enums.Statut;


public class Activite{
    // Les Attributs
    
    private int id;
    private String titre;
    private String description;
    private int duree;
    private Statut statut;
    
    // Le constructeur

    public Activite(int id, String titre, String description, int duree, Statut statut) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.duree = duree;
        this.statut = statut;
    }
    
    // Les getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    // Les methodes
    
    public void afficherActivite() {
        System.out.println("id : " + id + " , Activité : " + titre + " , description : " + description + " , durée : " + duree + " jour.s"+ " , Statut : " + statut);
        
    }
    
    public void ajouterActivite() {
        System.out.println("Activité ajoutée avec succès !");
    }
    
    public void modifierActivite() {
        System.out.println("Activité modifiée avec succès ! ");
    }
    
    public void supprimerActivite() {
        System.out.println("Activité supprimer avec succès !");
    }
}