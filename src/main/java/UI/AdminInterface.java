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
}
