package com.app.model;

public class Admin extends Utilisateur {
    
    public Admin(Integer id, String nom, String prenom, String email, String motDePasse, Integer telephone, Role role) {
      
        super(id, nom, prenom, email, motDePasse, telephone, role);
    }

    //Methodes
    public void voirFeedback(){
        System.out.println("");
    }

    public void voirStatistiques(){
        System.out.println("");
    }
}

