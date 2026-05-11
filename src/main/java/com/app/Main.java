package com.app;

// import com.app.db.DatabaseManager;
// import com.app.model.Utilisateur;
import com.app.services.ClientService;
import com.app.enums.Niveau;
import com.app.model.Client;
// import com.app.model.Domaine;
// import java.sql.*;
// import java.util.ArrayList;
// import java.util.List;
import java.util.Scanner;
import com.app.tables.*;

public class Main {
    public static void main(String[] args) {
        ClientService clientService= new ClientService(new ClientTable());
        Client client= new Client();

        Scanner clavier = new Scanner(System.in);
        System.out.print("Entrez votre nom: ");

        client.setNom(clavier.nextLine());
        System.out.print("Entrez votre prenom: ");

        client.setPrenom(clavier.nextLine());

        System.out.print("Entrez votre email: ");
        client.setEmail(clavier.nextLine());

        System.out.print("Entrez votre téléphone: ");
        client.setTelephone(clavier.nextInt());

        System.out.println("Entrez votre mot de passe: ");
        client.setMotDePasse(clavier.next());

        System.out.print("Entrez votre budget: ");
        client.setBudgetApporte(clavier.nextInt());
        clavier.nextLine(); 

        System.out.println("Choisissez un niveau: \n 1 = DEBUTANT \n 2 = INTERMEDIAIRE \n 3 = EXPERT");
        int niveau= clavier.nextInt();
        switch (niveau) {
            case 1:
                client.setNiveau(Niveau.DEBUTANT);
                break;
            case 2:
                client.setNiveau(Niveau.INTERMEDIAIRE);
                break;
            case 3:
                client.setNiveau(Niveau.EXPERT);
                break;
            default:
                System.out.println("Vous devrez choisir entre 1 et 3 !!!!");
                break;
        }
                 // 1. Création du repository (DAO)
        DomaineRepository repo = new DomaineRepository();

        // 2. Injection dans le service
        DomaineService service = new DomaineService(repo);

        // 3. AJOUTER
        service.ajouter("Informatique");
        service.ajouter("Gestion");

        // 4. AFFICHER
        System.out.println("Liste des domaines :");

        for (Domaine d : service.afficher()) {
            System.out.println(d.getId() + " - " + d.getDomaine());
        }

        // 5. MODIFIER
        service.modifier(1, "Développement");

        // 6. SUPPRIMER
        service.supprimer(2);


        
        




       
        clientService.addClient(client);
    }
}
        

