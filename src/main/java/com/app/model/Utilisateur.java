package com.app.model;
import java.util.*;
import com.app.enums.Role;


// CLASSE ABSTRAITE
public abstract class Utilisateur {

    protected Integer idUtilisateur;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;
    protected Integer telephone;
    protected Role role;

    // LISTE PARTAGÉE
    protected static List<Utilisateur> utilisateurs = new ArrayList<>();

    public Utilisateur(String nom, String prenom, String email, String motDePasse, Integer telephone, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.role = role;
    }

    public Utilisateur(){}


    // Getters
    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public Role getRole() {
        return role;
    }

    // Setters
    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // SUPPRESSION
    public void supprimerUtilisateur() {
        utilisateurs.remove(this);
    }

    // CONNEXION
    public boolean seConnecter(String email, String motDePasse) {
        return this.email.equals(email) && this.motDePasse.equals(motDePasse);
    }

    // MODIFIER
    public void modifierUtilisateur(String nom, String prenom, String email, Integer telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

    // AFFICHER
    public void afficherUtilisateur() {
        System.out.println("ID: " + idUtilisateur);
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Email: " + email);
        System.out.println("Téléphone: " + telephone);
        System.out.println("Rôle: " + role);
        System.out.println("----------------------");
    }}