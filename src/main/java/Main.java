import DAO.*;
import DAOimplementation.*;
import ServiceImplementation.*;
import UI.*;
import models.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner clavier= new Scanner(System.in);
        LocaliteRepository localiteRepository= new LocaliteTable();
        LocaliteService localiteService= new LocaliteService(localiteRepository);

        LocaliteInterface localiteInterface= new LocaliteInterface(localiteService);
        ClientInterface clientInterface= new ClientInterface(localiteInterface);

        ClientRepository clientRepository= new ClientTable();
        ClientService clientService= new ClientService(clientRepository);

        AuthentificationUI authentificationUI= new AuthentificationUI();

       ProjetClientUI projetClientUI= new ProjetClientUI();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         Bienvenue sur ADVISOR        ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("║ 1 ➜ SE CONNECTER                     ║");
        System.out.println("║ 2 ➜ S'INSCRIRE                       ║");
        System.out.println("╚══════════════════════════════════════╝");
        int choix= clavier.nextInt();
        switch (choix){
            case 1 -> {
                authentificationUI.seConncecter();
                break;
            }
            case 2 -> {
                clientInterface.menuCLient();
                break;

            }
            case 3 -> {
                AdminMenu.menuAdmin();
            }

        }
        CompetenceInterface.Afficher();


        //Client client= clientInterface.saisir();
        //clientInterface.inscrireClient(client);
        //clientInterface.AfficherListeCLient();
       // clientInterface.AfficherCLient(10);
        //projetClientUI.afficherProjetClient();
        //projetClientUI.afficherUnProjetClient(1);
        //DomaineInterface.Afficher();
        //ActiviteInterface.affichage();

       /* AdminRepository adminRepository= new AdminTable();
        AdminService adminService= new AdminService(adminRepository);
        AdminInterface adminInterface= new AdminInterface(adminService);
        Admin admin = adminInterface.saisieAdmin();
        adminInterface.afficher(admin);

        DepenseRepository depenseRepository= new DepenseTable();
        DepenseService depenseService= new DepenseService(depenseRepository);
        DepenseInterface depenseInterface= new DepenseInterface(depenseService);
        Depense depense = depenseInterface.saisieDepense();
        depenseInterface.AfficherDepense(depense);*/
        //

    }
}