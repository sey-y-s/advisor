package models;

import models.enums.StatutEtape;

public class Activite {
    // Les Attributs
    private int id;
    private String titre;
    private String description;
    private int duree;
    private StatutEtape statut;
    private Etape etape;

    // Le constructeur

    public Activite(int id, String titre, String description, int duree, StatutEtape statut, Etape etape) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.duree = duree;
        this.statut = statut;
        this.etape = etape;
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

    public StatutEtape getStatut() {
        return statut;
    }

    public void setStatut(StatutEtape statut) {
        this.statut = statut;
    }

    public Etape getEtape() {
        return etape;
    }

    public void setEtape(Etape etape){
        this.etape = etape;
    }
}
