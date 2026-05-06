package com.app.model;
import java.util.*;



// ENUM ROLE
enum Role {
    ADMIN,
    CLIENT
}

// CLASSE ABSTRAITE
abstract class Utilisateur {

    protected Integer idUtilisateur;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;
    protected Integer telephone;
    protected Role role;

    // LISTE PARTAGÉE
    protected static List<Utilisateur> utilisateurs = new ArrayList<>();

    public Utilisateur(Integer id, String nom, String prenom, String email, String motDePasse, Integer telephone, Role role) {
        this.idUtilisateur = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.role = role;
    }

    // AJOUT
    public static void ajouterUtilisateur(Utilisateur utilisateur) {
        if (utilisateur != null) {
            utilisateurs.add(utilisateur);
        }
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
    }
}

// CLASSE CLIENT
// class Client extends Utilisateur {

//     public Client(Integer id, String nom, String prenom, String email, String motDePasse, Integer telephone) {
//         super(id, nom, prenom, email, motDePasse, telephone, Role.CLIENT);
//     }
// }
