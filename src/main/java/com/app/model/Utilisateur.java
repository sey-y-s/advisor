import java.util.*;
package model;

public abstract class Utilisateur {

    protected Integer idUtilisateur;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;
    protected Integer telephone;
   
  
    public Utilisateur(Integer id, String nom, String prenom, String email, String motDePasse, Integer telephone, Role role) {
        this.idUtilisateur = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        this.role = role;   
    }

    
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        this.utilisateurs.add(utilisateur);   
    }

  
    public boolean seConnecter(String email, String motDePasse) {
        return this.email != null && this.email.equals(email)
                && this.motDePasse != null && this.motDePasse.equals(motDePasse);
    }

    
    public void modifierUtilisateur(String nom, String prenom, String email, Integer telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

  
    public void afficherUtilisateur() {
        System.out.println("ID: " + idUtilisateur);
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Email: " + email);
        System.out.println("Téléphone: " + telephone);
        System.out.println("Rôle: " + role);
    }

    
    public void supprimerUtilisateur() {
        utilisateurs.remove(this);
    }
}import java.util.*;

public abstract class Utilisateur {

    protected Integer idUtilisateur;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;
    protected Integer telephone;
   
  
    public Utilisateur(Integer id, String nom, String prenom, String email, String motDePasse, Integer telephone, Role role) {
        this.idUtilisateur = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.telephone = telephone;
        
    }

    
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        this.utilisateurs.add(utilisateur);
    }

  
    public boolean seConnecter(String email, String motDePasse) {
        return this.email != null && this.email.equals(email)
                && this.motDePasse != null && this.motDePasse.equals(motDePasse);
    }

    
    public void modifierUtilisateur(String nom, String prenom, String email, Integer telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

  
    public void afficherUtilisateur() {
        System.out.println("ID: " + idUtilisateur);
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Email: " + email);
        System.out.println("Téléphone: " + telephone);
        System.out.println("Rôle: " + role);
    }

    
    public void supprimerUtilisateur() {
        utilisateurs.remove(this);
    }
}
