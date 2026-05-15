package UI;

import DAO.UtilisateurRepository;
import DAOimplementation.UtilisateurTable;
import ServiceImplementation.UtilisateurService;
import models.Utilisateur;
import models.enums.Role;

import java.util.Scanner;

public class AuthentificationUI {
    UtilisateurRepository utilisateurRepository= new UtilisateurTable();
    UtilisateurService utilisateurService= new UtilisateurService(utilisateurRepository);
    Scanner clavier= new Scanner(System.in);
    ClientInterface clientInterface= new ClientInterface();
    public void seConncecter(){

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║              CONNEXION               ║");
        System.out.println("╚══════════════════════════════════════╝");


        System.out.print("➜ Email      :");
        String email= clavier.nextLine();
        System.out.print("➜ MOT DE PASSE         : ");
        String password= clavier.nextLine();
        Object response= utilisateurService.authentifierUtilisateur(email, password);

        if(response.getClass()!=Boolean.class){
            Utilisateur utilisateur= (Utilisateur) response;
            System.out.println("nol: "+ utilisateur.getNom() + " " + utilisateur.getRole().toString());
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║   ✔ CONNEXION REUSSIE AVEC SUCCÈS    ║");
            System.out.println("╚══════════════════════════════════════╝");
            if(utilisateur.getRole()==Role.ADMIN){
                AdminMenu.menuAdmin(utilisateur.getIdUtilisateur());
            }
            else clientInterface.menuCLient(utilisateur.getIdUtilisateur());
        }


    }
}
