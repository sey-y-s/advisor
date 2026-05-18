package UI;


import Service.ProjetClientInterface;



import java.util.Scanner;

public class AdminMenu {
    static Scanner clavier= new Scanner(System.in);
    static ClientInterface clientInterface= new ClientInterface();

    public static void menuAdmin(int idAdmin){
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║            COMPTE ADMIN              ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("║ 1 ➜ DOMAINE                          ║");
        System.out.println("║ 2 ➜ COMPETENCE                       ║");
        System.out.println("║ 3 ➜ LOCALITE                         ║");
        System.out.println("║ 4 ➜ PROJET                           ║");
        System.out.println("║ 5 ➜ VOIR LES CLIENTS                 ║");
        System.out.println("║ 6 ➜ VOIR LES AFFECTATIONS DE PROJETS ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Choisis !!!");

        int choix = clavier.nextInt();
        switch (choix){

            case 1 -> {
                DomaineInterface.Afficher();
            }
            case 2 -> System.out.println("Non fait");
            case 5 -> clientInterface.AfficherListeCLient();
            case 6 -> ProjetClientUI.afficherProjetClient();
        }
    }
}
