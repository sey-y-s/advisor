package UI;

import DAO.ProjetClientRepository;
import DAO.ProjetRepository;
import DAOimplementation.ClientProjetTable;
import Service.ProjetClientInterface;
import ServiceImplementation.ProjetClientService;
import models.ProjetClient;

import java.util.List;
import java.util.Optional;

public class ProjetClientUI {
   // ProjetClientRepository projetClientRepository= new ClientProjetTable();
    private static ProjetClientInterface projetClientInterface= new ProjetClientService(new ClientProjetTable());

    public static void afficherProjetClient() {
        List<ProjetClient> projetClients = projetClientInterface.getAll();
        if (projetClients.isEmpty()) {
            System.out.println("Aucun client ne travaille sur un projet !!!");
        }
        System.out.println("==========Liste des affectations===============");
        projetClients.forEach(projetClient -> {




            System.out.println("Client: " + projetClient.getClient().getPrenom() + " " + projetClient.getClient().getNom());
            System.out.println("Localité: " + projetClient.getClient().getLocalite().getRegionClient());
            System.out.println("Titre du projet: " + projetClient.getProjet().getTitre());
            System.out.println("Date de début: " + projetClient.getDebut());
            System.out.println("Statut du projet: " + projetClient.getStatut());

            System.out.println("======================================");
        });
    }
    public void afficherUnProjetClient(int id){
            Optional<ProjetClient> projetClientOpt= projetClientInterface.getById(id);
            if(projetClientOpt.isEmpty()  ){
                System.out.println("Aucune affectation n'a été rétrouvé avec cet ID !!!");
            }
            ProjetClient projetClient= projetClientOpt.get();
            System.out.println("==========Informations de l'affectation===============");

            System.out.println("Client: "+ projetClient.getClient().getPrenom() + " "+ projetClient.getClient().getNom());
            System.out.println("Localité: "+ projetClient.getClient().getLocalite().getRegionClient());
            System.out.println("Titre du projet: "+ projetClient.getProjet().getTitre());
            System.out.println("Date de début: "+ projetClient.getDebut());
            System.out.println("Statut du projet: "+ projetClient.getStatut());

            System.out.println("======================================");

    }
}
