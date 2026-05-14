package UI;

import models.Admin;

import java.util.Scanner;

public class AdminInterface {
    static Scanner sc = new Scanner(System.in);

    public Admin saisieAdmin () {

        Admin admin = new Admin();
        System.out.println("Nom : ");
        admin.setNom(sc.next());
        System.out.println("Prenom : ");
        admin.setPrenom(sc.next());
        System.out.println("Email : ");
        admin.setEmail(sc.next());
        System.out.println("Password : ");
        admin.setMotDePasse(sc.next());

        return admin;
    }
    public void afficher() {
        Admin admin = saisieAdmin();
        System.out.println("Nom : " + admin.getNom());
        System.out.println("Prenom : " + admin.getPrenom());
        System.out.println("Email : " + admin.getEmail());
    }
}
