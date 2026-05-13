package models;

import models.enums.StatutEtape;
import models.enums.StatutProjet;
import models.Projet;

public class gEtape {
    private Integer idEtape;
    private String titre;
    private String description;
    private StatutEtape etapeStatut;
    private Projet projet;

    //Le constructeurs
    public Etape() {}


    public Etape(Integer idEtape, String titre, String description, StatutEtape etapeStatut, Projet projet) {
        this.idEtape = idEtape;
        this.titre = titre;
        this.description = description;
        this.etapeStatut = etapeStatut;
        this.projet = projet;
    }


    // Getters et setters
    public Integer getIdEtape(){
        return idEtape;
    }

    public void setIdEtape(Integer idEtape) {
        this.idEtape = idEtape;
    }
    public String getTitre(){
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public StatutEtape getEtapeStatut(){
        return etapeStatut;
    }
    public void  setEtapeStatut(StatutEtape etapeStatut){
        this.etapeStatut = etapeStatut;
    }
    public Projet getProjet(){
        return projet;
    }
    public void setProjet(Projet projet){
        this.projet = projet;
    }

    // Méthode pour valider et créer une étape
    @Override
    public String toString() {
        return "Etape{" +
                "idEtape=" + idEtape +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", statut=" + etapeStatut + '}';
    }
}
