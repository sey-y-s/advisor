package com.app.model;

public class Utilisateur {
    private int id;
    private String nom;
    private String email;

    // Constructeur utilisé par votre Main.java
    public Utilisateur(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    // Méthode appelée par u.nom() dans votre Main
    public String nom() {
        return this.nom;
    }

    public String email() {
        return this.email;
    }

    public int id() {
        return this.id;
    }

    // --- Ajoutez ici vos méthodes métier (ajouter, seConnecter, etc.) ---
    
    public void ajouterUtilisateur() {
        // ... votre code JDBC
    }

    public boolean seConnecter() {
        // ... votre code JDBC
        return false; 
    }
}
