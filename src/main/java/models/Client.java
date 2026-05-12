package models;
import models.enums.*;

public class Client extends Utilisateur{
    private Niveau niveau = Niveau.DEBUTANT;
    private Localite localite;

    public Client() {

    }

    public Client(String nom, String prenom, String email, String motDePasse, Niveau niveau,
                  Localite localite, String telephone, Role role) {
        super(nom, prenom, email, motDePasse, telephone, role);
        this.niveau = niveau;

        this.localite = localite;

    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }



    public Localite getLocalite() {
        return localite;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }

}
