package UI;

import DAO.ClientRepository;
import DAOimplementation.ClientTable;
import ServiceImplementation.ClientService;
import Models.Client;
import Models.Localite;
import Models.enums.Niveau;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClientInterface {
    static Scanner clavier= new Scanner(System.in);
    private LocaliteInterface localiteInterface;
     ClientRepository clientRepository= new ClientTable();
     ClientService clientService= new ClientService(clientRepository);

    public ClientInterface(LocaliteInterface localiteInterface){
        this.localiteInterface= localiteInterface;
    }

    public Client saisir() {

        Client client = new Client();

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        ENREGISTREMENT CLIENT         ║");
        System.out.println("╚══════════════════════════════════════╝");



        System.out.print("➜ Prénom      :");
        client.setPrenom(clavier.nextLine());

        System.out.print("➜ Nom         : ");
        client.setNom(clavier.nextLine());

        System.out.print("➜ Téléphone   : ");
        client.setTelephone(clavier.nextLine());

        System.out.print("➜ Email       : ");
        client.setEmail(clavier.nextLine());

        System.out.print("➜ Mot de passe: ");
        client.setMotDePasse(clavier.nextLine());

        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        CHOIX DE LA LOCALITÉ          ║");
        System.out.println("╚══════════════════════════════════════╝");

        Localite localite = localiteInterface.choisirLocalite();
        client.setLocalite(localite);

        int choix;

        do {

            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║         CHOIX DU NIVEAU              ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1 ➜ DEBUTANT                         ║");
            System.out.println("║ 2 ➜ INTERMEDIAIRE                    ║");
            System.out.println("║ 3 ➜ EXPERT                           ║");
            System.out.println("╚══════════════════════════════════════╝");

            System.out.print("➜ Votre choix : ");
            choix = clavier.nextInt();

            switch (choix) {

                case 1 -> client.setNiveau(Niveau.DEBUTANT);

                case 2 -> client.setNiveau(Niveau.INTERMEDIAIRE);

                case 3 -> client.setNiveau(Niveau.EXPERT);

                default -> System.out.println(" Veuillez entrer un chiffre entre 1 et 3 !");
            }

        } while (choix < 1 || choix > 3);

        do {

            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║         SAISIE DU BUDGET             ║");
            System.out.println("╚══════════════════════════════════════╝");

            System.out.print("➜ Budget (> 100 000 F CFA) : ");
            client.setBudgetApporte(clavier.nextInt());

            if (client.getBudgetApporte() < 100000) {
                System.out.println(" Le budget minimum est de 100 000 F CFA !");
            }

        } while (client.getBudgetApporte() < 100000);



        return client;
    }

    public void inscrireClient(Client client){
        if(clientService.addClient(client)){
            System.out.println();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║   ✔ CLIENT ENREGISTRÉ AVEC SUCCÈS    ║");
            System.out.println("╚══════════════════════════════════════╝");
        }
        else {
            System.out.println("Erreur lors de l'inscription du client!!!!");
        }
    }

    public void AfficherListeCLient(){
        List<Client> clients= clientRepository.getAll();
        if(clients.isEmpty()){
            System.out.println("Il n'y pas de clients enregistré !!!!");
        }
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         LISTE DES CLIENTS            ║");
        System.out.println("╚══════════════════════════════════════╝");

        clients.forEach(client -> {

            System.out.println("┌──────────────────────────────────────┐");
            System.out.printf ("│ Nom        : %-23s │%n", client.getNom());
            System.out.printf ("│ Prénom     : %-23s │%n", client.getPrenom());
            System.out.printf ("│ Localité   : %-23s │%n", client.getLocalite().getRegionClient());
            System.out.printf ("│ Téléphone  : %-23s │%n", client.getTelephone());
            System.out.printf ("│ Email      : %-23s │%n", client.getEmail());
            System.out.printf ("│ Niveau     : %-23s │%n", client.getNiveau());
            System.out.printf ("│ Budget     : %-23s │%n", client.getBudgetApporte() + " F CFA");
            System.out.println("└──────────────────────────────────────┘");
        });
    }

    public void AfficherCLient(int id){
        Optional<Client> clientOpt= clientRepository.getById(id);
        if(clientOpt.isEmpty()){
            System.out.println("Client introuvable !!!!");
        }
        Client client= clientOpt.get();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         INFORMATIONS DU CLIENT       ║");
        System.out.println("╚══════════════════════════════════════╝");


        System.out.println("┌──────────────────────────────────────┐");
        System.out.printf ("│ Nom        : %-23s │%n", client.getNom());
        System.out.printf ("│ Prénom     : %-23s │%n", client.getPrenom());
        System.out.printf ("│ Localité   : %-23s │%n", client.getLocalite().getRegionClient());
        System.out.printf ("│ Téléphone  : %-23s │%n", client.getTelephone());
        System.out.printf ("│ Email      : %-23s │%n", client.getEmail());
        System.out.printf ("│ Niveau     : %-23s │%n", client.getNiveau());
        System.out.printf ("│ Budget     : %-23s │%n", client.getBudgetApporte() + " F CFA");
        System.out.println("└──────────────────────────────────────┘");


    }


    public void menuCLient(){
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║            COMPTE CLIENT             ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("║ 1 ➜ S'INSCRIRE                       ║");
        System.out.println("║ 2 ➜ MODIFIER MON PROFIL              ║");
        System.out.println("║ 3 ➜ OBTENIR DES RECOMMANDATIONS      ║");
        System.out.println("║ 4 ➜ VOIR MES PROJETS                 ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Choisis !!!");

        int choix= clavier.nextInt();
        switch (choix){

            case 1 -> {
                Client client= saisir();
                inscrireClient(client);
            }
            case 2 -> System.out.println("Non fait");

        }
    }



}
