import DAO.ClientRepository;
import DAO.LocaliteRepository;
import DAOimplementation.ClientTable;
import DAOimplementation.LocaliteTable;
import ServiceImplementation.ClientService;
import ServiceImplementation.LocaliteService;
import UI.*;
import models.Client;
import models.Domaine;
import DAO.DomaineRepository;
import ServiceImplementation.DomaineService;
import DAOimplementation.DomaineTable;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LocaliteRepository localiteRepository= new LocaliteTable();
        LocaliteService localiteService= new LocaliteService(localiteRepository);

        LocaliteInterface localiteInterface= new LocaliteInterface(localiteService);
        ClientInterface clientInterface= new ClientInterface(localiteInterface);

        ClientRepository clientRepository= new ClientTable();
        ClientService clientService= new ClientService(clientRepository);

        ProjetClientUI projetClientUI= new ProjetClientUI();


        //Client client= clientInterface.saisir();
        //clientInterface.inscrireClient(client);
        //clientInterface.AfficherListeCLient();
       // clientInterface.AfficherCLient(10);
        //projetClientUI.afficherProjetClient();
        //projetClientUI.afficherUnProjetClient(1);
        //DomaineInterface.Afficher();
        ActiviteInterface.affichage();


    }
}