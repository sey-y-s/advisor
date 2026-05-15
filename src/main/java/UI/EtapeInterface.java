package UI;

import DAO.EtapeRepository;
import DAOimplementation.EtapeTable;
import ServiceImplementation.EtapeService;
import Service.InterfaceEtape;
import models.enums.StatutEtape;
import models.Etape;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EtapeInterface {

    // Injection
    static EtapeRepository etapeRepository = new EtapeTable();
    static EtapeService etapeService = new EtapeService(etapeRepository);

    static Scanner scanner = new Scanner(System.in);

    public static void EtapeMenu() {
        int choix;

        do {
            System.out.println("\n=== GESTION DES ÉTAPES ===");
            System.out.println("1. Ajouter une étape");
            System.out.println("2. Afficher toutes les étapes");
            System.out.println("3. Rechercher une étape spécifique");
            System.out.println("4. Modifier une étape");
            System.out.println("5. Supprimer une étape");
            System.out.println("0. Quitter");
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1: // Ajouter une étape
                    ajouterEtape();
                    break;

                case 2: // Afficher toutes les étapes
                    afficherEtapes();
                    break;

                case 3: // Rechercher une étape spécifique
                    rechercherEtape();
                    break;

                case 4: // Modifier une étape
                    modifierEtape();
                    break;

                case 5: // Supprimer une étape
                    System.out.print("Entrer l'ID de l'étape à supprimer : ");
                    int idSup = scanner.nextInt();
                    scanner.nextLine();
                    etapeService.suppression(idSup);
                    break;

                case 0:
                    System.out.println("Retour au menu principal...");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }
        } while (choix != 0);

        scanner.close();
    }

    public static void ajouterEtape() {
        Scanner scanner = new Scanner(System.in);
        Etape etape = new Etape();

        System.out.print("Entrer le titre : ");
        etape.setTitre(scanner.nextLine());

        System.out.print("Entrer la description : ");
        etape.setDescription(scanner.nextLine());

        // Statut obligatoire selon l'étape
        System.out.print("Entrer le statut (Ex : A_FAIRE, EN_COURS, TERMINE): ");
        String statutStr = scanner.nextLine();
        try {
            etape.setEtapeStatut(models.enums.StatutEtape.valueOf(statutStr.toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.println("Statut invalide !");
        }

        etapeService.ajoutt(etape);
    }

    public static void afficherEtapes() {

        List<Etape> etapes = etapeService.Les_etapes();
        if (etapes.isEmpty()) {
            System.out.println("Aucune étape trouvée.");
        } else {
            for (Etape e : etapes) {
                System.out.println("ID : " + e.getIdEtape()
                        + " | Titre : " + e.getTitre()
                        + " | Description : " + e.getDescription()
                        + " | Statut : " + e.getEtapeStatut());
            }
        }
    }

    public static void rechercherEtape() {

        System.out.print("Entrer l'ID de l'étape : ");
        int idRecherche = scanner.nextInt();
        scanner.nextLine();

        Optional<Etape> existe = etapeService.etape(idRecherche);
        if (existe.isPresent()) {
            System.out.println("L'étape avec l'ID " + idRecherche + " existe.");
        } else {
            System.out.println("Aucune étape trouvée avec cet ID.");
        }
    }

    public static void modifierEtape() {
        System.out.print("Entrer l'ID de l'étape à modifier : ");
        int idModif = scanner.nextInt();
        scanner.nextLine();

        // Vérification existence
        if (!etapeService.verification(idModif)) {
            System.out.println("Aucune étape trouvée avec cet ID.");
            return;
        }

        Etape etapeModif = new Etape();
        etapeModif.setIdEtape(idModif);

        System.out.print("Nouveau titre : ");
        etapeModif.setTitre(scanner.nextLine());

        System.out.print("Nouvelle description : ");
        etapeModif.setDescription(scanner.nextLine());

        System.out.print("Nouveau statut : ");
        String newStatut = scanner.nextLine();
        try {
            etapeModif.setEtapeStatut(models.enums.StatutEtape.valueOf(newStatut.toUpperCase()));
        } catch (Exception e) {
            System.out.println("Statut invalide.");
            return;
        }

        etapeService.miseAjour(etapeModif);
    }
}