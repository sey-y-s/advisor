package UI;

import models.Client;
import models.Localite;

import java.util.List;
import java.util.Scanner;

public class ClientInterface {
    static Scanner clavier= new Scanner(System.in);
    private LocaliteInterface localiteInterface;

    public ClientInterface(LocaliteInterface localiteInterface){
        this.localiteInterface= localiteInterface;
    }

    public  Client saisir(){

        Client client= new Client();
        System.out.print("Nom: ");
        client.setNom(clavier.nextLine());
        System.out.print("Prénom: ");
        client.setPrenom(clavier.nextLine());
        System.out.print("Téléphone: ");
        client.setTelephone(clavier.nextLine());
        System.out.print("Email: ");
        client.setEmail(clavier.nextLine());
        System.out.print("Veuillez choisir une localité: ");
        client.setNom(clavier.nextLine());
        System.out.print("Prénom: ");
        client.setPrenom(clavier.nextLine());
        Localite localite= localiteInterface.choisirLocalite();
        client.setLocalite(localite);
        return  client;
    }



}
