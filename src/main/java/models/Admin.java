package models;
import models.enums.Role;

public class Admin extends Utilisateur {

    public Admin(String nom, String prenom, String email, String motDePasse, String telephone, Role role) {
        super(nom, prenom, email, motDePasse, telephone, role);
    }

    public Admin() {

    }

    //Methodes
    public void voirFeedback(){
        System.out.println("");
    }

    public void voirStatistiques(){
        System.out.println("");
    }
}

