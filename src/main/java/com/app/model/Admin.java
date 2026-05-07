package com.app.model;

public class Admin extends Utilisateur {
    
    public Admin(Integer id, String nom, String prenom, String email, String motDePasse, Integer telephone) {
      
        super(id, nom, prenom, email, motDePasse, telephone);
    }
}

//Methodes
public void voirFeedback(){
    systeme.out.println("");
}

public void voirStatistiques(){
    systeme.out.println("");
}