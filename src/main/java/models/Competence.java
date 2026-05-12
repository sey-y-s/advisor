package models;

public class Competence {
    private int idCompetence;
    private String nom;

    public Competence(int idCompetence, String nom) {
        this.idCompetence = idCompetence;
        this.nom = nom;
    }

    public Competence(String nom) {
        this.nom = nom;
    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}