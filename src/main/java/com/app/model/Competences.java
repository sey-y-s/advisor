public class Competence {
    //Attributs
    private int idCompetence;
    private String nom;
    //constructeurs
    public Competence(int idCompetence, String nom) {
        this.idCompetence = idCompetence;
        this.nom = nom;
    }
    //getters et setters
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
    //methodes
    public void ajouterCompétence() {
        System.out.println("Compétence ajoutée.");
    }

    public void afficherCompétence() {
        System.out.println("ID: " + idCompetence + ", Nom: " + nom);
    }

    public void modifierCompétence() {
        System.out.println("Compétence modifiée.");
    }

    public void supprimerCompétence() {
        System.out.println("Compétence supprimée.");
    }
}