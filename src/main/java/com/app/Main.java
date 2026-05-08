package com.app;

// import com.app.db.DatabaseManager;
// import com.app.model.Utilisateur;
import com.app.services.ClientService;
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
        Scanner clavier= new Scanner(System.in);
        System.out.println("Entrez votre nom: ");
        client.setNom(clavier.nextLine());

        System.out.println("Entrez votre prenom: ");
        client.setPrenom(clavier.nextLine());
       
        clientService.addClient(client);
       
    }
    
}
