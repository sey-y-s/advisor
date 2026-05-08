package com.app.model;

import com.app.enums.Statut;


public class Etape {
    private Integer idEtape;
    private String titre;
    private String description;
    private Statut statut;  
    private Projet projet;

     //Le constructeur
    public Etape(String titre, String description, Statut statut, Projet projet) {
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.projet = projet;
    }
   
    //Les getters
    public Integer getIdEtape() {
        return idEtape;
    }   
    public String getTitre() {
        return titre;
    }       
    public String getDescription() {
        return description;
    }       
    public Statut getStatut() {
        return statut;
    }    
    public Projet getProjet() {
        return projet;
    }

        
    //Les setters
    public void setIdEtape(int idEtape) {
        this.idEtape = idEtape;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public void setProjet(Statut projet) {
        this.statut = projet;
    }

    
    //Les methodes 
    public void AjouterEtape() {
        System.out.println("Etape ajoutée avec succes");
    }
    
    public void afficherEtape() {
        System.out.println("");
    }
    
    public void ModifierEtape() {
        System.out.println("Etape modifiée avec succes");
    }
    
    public void SupprimerEtape() {
        System.out.println("Etape supprimée avec succes");
    }
    
    public void suivreProgressionGlobale () {
        System.out.println("");
    }
    
    public void totalDepenseEtape () {
        System.out.println("");
    }

}
