package UI;

import DAOimplementation.CompetenceTable;
import DAO.CompetenceRepository;
import ServiceImplementation.CompetenceServiceImpl;
import models.Competence;
import java.util.List;
import java.util.Scanner;

public class CompetenceInterface {

    public static void Afficher() {
        CompetenceRepository repo = new CompetenceTable();
        CompetenceServiceImpl service = new CompetenceServiceImpl(repo);
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n===== MENU COMPÉTENCES =====");
            System.out.println("1. Ajouter une compétence");
            System.out.println("2. Modifier une compétence");
            System.out.println("3. Afficher les compétences");
            System.out.println("4. Supprimer une compétence");
            System.out.println("0. Quitter");

            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {

                // ajout d'une compétence
                case 1:
                    System.out.print("Entrer le nom de la compétence : ");
                    String nom = scanner.nextLine();
                    service.ajouter(nom);
                    break;

                // modification d'une compétence
                case 2:
                    System.out.print("Entrer l'id de la compétence : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrer le nouveau nom : ");
                    String nouveauNom = scanner.nextLine();
                    service.modifier(id, nouveauNom);
                    break;

                // affichage des compétences
                case 3:
                    List<Competence> competences = service.afficher();
                    for (Competence c : competences) {
                        System.out.println(
                                "ID : " + c.getIdCompetence() +
                                        " | Nom : " + c.getNom()
                        );
                    }
                    break;

                // suppression d'une compétence
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