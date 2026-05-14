package UI;

import DAO.ClientRepository;
import DAOimplementation.ClientTable;
import ServiceImplementation.ClientService;
import models.Client;
import models.Localite;
import models.enums.Niveau;

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

    public Client saisir(){

        Client client= new Client();
        System.out.print("Nom: ");
        client.setNom(clavier.nextLine());
        System.out.print("Prénom: ");
        client.setPrenom(clavier.nextLine());
        System.out.print("Téléphone: ");
        client.setTelephone(clavier.nextLine());
        System.out.print("Email: ");
        client.setEmail(clavier.nextLine());
        System.out.print("Mot de passe: ");
        client.setMotDePasse(clavier.nextLine());
        Localite localite= localiteInterface.choisirLocalite();
        client.setLocalite(localite);
        int choix;
        do {
            System.out.println("Veuillez choisir votre niveau: ");
            System.out.print("1 : DEBUTANT \n 2 : INTERMEDIAIRE \n 3 : EXPERT \n");
            System.out.println("");
            choix= clavier.nextInt();
            switch (choix){
                case 1 -> client.setNiveau(Niveau.DEBUTANT) ;
                case 2 -> client.setNiveau(Niveau.INTERMEDIAIRE) ;
                case 3 -> client.setNiveau(Niveau.EXPERT) ;
                default -> System.out.println("Entrez un chiffre entre 0 et 3");
            }
        } while (choix <1 || choix> 3);
        do {
            System.out.print("Budget(> 100 000 F): ");
            client.setBudgetApporte(clavier.nextInt());
        } while (client.getBudgetApporte()<100000);


        return  client;
    }

    public void inscrireClient(Client client){
        if(clientService.addClient(client)){
            System.out.println("Client inscrit avec succès!!!!");
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
        System.out.println("===========Liste des clients==========");
        clients.forEach(client -> {

            System.out.println("Nom: "+ client.getNom());
            System.out.println("Prénom: "+ client.getPrenom());
            System.out.println("Localité: "+ client.getLocalite().getRegionClient());
            System.out.println("Téléphone: "+ client.getTelephone());
            System.out.println("Email: "+ client.getEmail());
            System.out.println("Niveau: "+ client.getNiveau().toString());
            System.out.println("Budget: "+ client.getBudgetApporte() + " F CFA");
            System.out.println("==============================");
        });
    }

    public void AfficherCLient(int id){
        Optional<Client> clientOpt= clientRepository.getById(id);
        if(clientOpt.isEmpty()){
            System.out.println("Client introuvable !!!!");
        }
        Client client= clientOpt.get();
        System.out.println("===========Informations du client==========");

            System.out.println("Nom: "+ client.getNom());
            System.out.println("Prénom: "+ client.getPrenom());
            System.out.println("Localité: "+ client.getLocalite().getRegionClient());
            System.out.println("Téléphone: "+ client.getTelephone());
            System.out.println("Email: "+ client.getEmail());
            System.out.println("Niveau: "+ client.getNiveau().toString());
            System.out.println("Budget: "+ client.getBudgetApporte() + " F CFA");


    }



}
