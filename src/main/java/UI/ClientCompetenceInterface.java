package UI;

import DAO.ClientCompetenceRepository;
import DAOimplementation.*;

import ServiceImplementation.ClientCompetenceService;
import Models.ClientCompetence;

import java.util.List;
import java.util.Scanner;

public class ClientCompetenceInterface {
private ClientCompetenceService clientCompetenceService;



public ClientCompetenceInterface(ClientCompetenceService clientCompetenceService){
    this.clientCompetenceService=clientCompetenceService;

}
public static void executeMenu(){
    Scanner scanner=new Scanner(System.in);
    scanner.nextLine();
    ClientCompetenceRepository cs=new ClientCompetenceTable();
    ClientCompetenceService cl=new ClientCompetenceService(cs);



    int choix;

    do {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Afficher Competence");
        System.out.println("2. Afficher client");





        System.out.print("Votre choix : ");
        choix = scanner.nextInt();
        scanner.nextLine();
        switch (choix=1){
            case 1:
                List<ClientCompetence> competences=cl.getAll();
               System.out.println("La liste des competences");
                for(int i=0;i<competences.size();i++){
                    System.out.println("Id Competence: " + competences.get(i).getCompetence().getIdCompetence());
                    System.out.println("Nom Competence:"+competences.get(i).getCompetence().getNom());



                }


            case 2:

                List<ClientCompetence> clients=cl.getAll();
                System.out.println("La liste des clients");
                for(int i=0;i<clients.size();i++){
                    System.out.println("Id Client: " + clients.get(i).getClient().getIdUtilisateur());
                    System.out.println("Nom du client:"+clients.get(i).getClient().getNom());
                    System.out.println("Prenom du client:"+clients.get(i).getClient().getPrenom());
                    System.out.println("Localité du client:"+clients.get(i).getClient().getLocalite());



                }

        }
    }while (choix!=0);



    }

}
