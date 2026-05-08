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

    public Etape(Integer idEtape, String titre, String description, Statut statut, Projet projet) {
        this.idEtape = idEtape;
        this.titre = titre;
        this.description = description;
        this.statut = statut;
        this.projet = projet;
    }


    // Getters et setters
    public Integer getIdEtape() {
        return idEtape;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
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

    // Méthode pour valider et créer une étape
    @Override
    public String toString() {
        return "Etape{" +
                "idEtape=" + idEtape +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", statut=" + statut +
                ", projet=" + (projet != null ? projet.getTitre() : "null") +
                '}';
    }
}
