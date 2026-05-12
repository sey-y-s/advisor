import models.Domaine;
import repositories.DomaineRepository;
import services.DomaineService;
import tables.DomaineTable;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DomaineRepository dom = new DomaineTable();

        DomaineService service = new DomaineService(dom);

        Scanner scanner = new Scanner(System.in);

        int choix;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Ajouter un domaine");
            System.out.println("2. Modifier un domaine");
            System.out.println("3. Afficher les domaines");
            System.out.println("4. Supprimer un domaine");
            System.out.println("0. Quitter");

            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {

                // ajout d'un domaine
                case 1:

                    System.out.print("Entrer le nom du domaine : ");
                    String nom = scanner.nextLine();

                    service.ajouter(nom);

                    break;

                // modification d'un domaine
                case 2:

                    System.out.print("Entrer l'id du domaine : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Entrer le nouveau nom : ");
                    String domaine = scanner.nextLine();

                    service.modifier(id, domaine);

                    break;

                // affichage d'un domaine
                case 3:

                    List<Domaine> domaines = service.afficher();

                    for (Domaine d : domaines) {

                        System.out.println(
                                "ID : " + d.getId() +
                                        " | Nom : " + d.getDomaine()
                        );
                    }

                    break;

                // supprimer un domaine
                case 4:

                    System.out.print("Entrer l'id à supprimer : ");
                    int idSup = scanner.nextInt();

                    service.supprimer(idSup);

                    break;

                case 0:

                    System.out.println("Tu as quitté le menu");
                    break;

                default:

                    System.out.println("Choix invalide !");
            }

        } while (choix != 0);

        scanner.close();
    }
}