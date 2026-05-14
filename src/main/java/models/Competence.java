package models;

public class Competence {

    private int idCompetence;
    private String nom;


    public Competence() {
    }

    public Competence(int idCompetence, String nom) {
        this.idCompetence = idCompetence;
        this.nom = nom;
    }
    public Competence(){

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
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Nom invalide");
        }
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Competence{" +
                "idCompetence=" + idCompetence +
                ", nom='" + nom + '\'' +
                '}';
    }
}