import DAO.*;
import DAOimplementation.*;
import ServiceImplementation.*;
import UI.*;
import models.Admin;
import models.Client;
import models.Depense;
import models.Domaine;

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