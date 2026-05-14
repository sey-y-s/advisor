package UI;

import DAO.ActiviteRepository;
import DAOimplementation.ActiviteTable;
import ServiceImplementation.ActiviteService;
import models.Activite;
import models.Etape;

import java.util.List;
import java.util.Scanner;

public class ActiviteInterface {
    public static void affichage(){
        ActiviteRepository activiteRepository = new ActiviteTable();
        ActiviteService activiteService = new ActiviteService(activiteRepository);
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            System.out.println("ACTIVITE");
            System.out.println("1. Ajouter une activité");
            System.out.println("2. Afficher les activité");
            System.out.println("3. Marquer une activité comme terminée");
            System.out.println("4. Supprimer une activité");
            System.out.println("0. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                // Ajouter une activité
                case 1:
                    Activite activite = new Activite();

                    System.out.print("Entrer le titre : ");
                    activite.setTitre(scanner.nextLine());

                    System.out.print("Entrer la description : ");
                    activite.setDescription(scanner.nextLine());

                    System.out.print("Entrer la durée : ");
                    activite.setDuree(scanner.nextInt());

                    System.out.print("Entrer l'id de l'étape : ");
                    int idEtape = scanner.nextInt();
                    scanner.nextLine();

                    Etape etape = new Etape();
                    etape.setIdEtape(etape.getIdEtape());

                    activiteService.ajouterActivite(activite);
                    break;

                    // Afficher les activités
                case 2:

                    List<Activite> activites = activiteService.afficherActivite();
                    for (Activite a : activites) {
                        System.out.println("ID : " + a.getId() + "Titre : " + a.getTitre() + "Description : " + a.getDescription() + "Durée : " + a.getDuree() + "Statut : " + a.getStatut());
                    }
                    break;

                    // Marquer Terminée
                case 3:
                    System.out.print("Entrer l'id de l'activité pour marquer comme terminée : ");
                    int id = scanner.nextInt();

                    activiteService.marqueTermine(id);

                    break;

                    // Supprimer une activité
                case 4:

                    System.out.print("Entrer l'id à supprimer : ");
                    int idSup = scanner.nextInt();

                    activiteService.supprimerActivite(idSup);
                    break;
                    // Quitter
                case 0:
                    System.out.println("Au revoir ! ");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }while (choix != 0);
        scanner.close();
    }
}
