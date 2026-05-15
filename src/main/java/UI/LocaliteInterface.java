package UI;

import DAO.LocaliteRepository;
import DAOimplementation.LocaliteTable;
import ServiceImplementation.LocaliteService;
import models.Localite;

import java.util.List;
import java.util.Scanner;

public class LocaliteInterface {
    static Scanner clavier = new Scanner(System.in);
    private LocaliteService localiteService;

    public LocaliteInterface(LocaliteService localiteService) {
        this.localiteService = localiteService;
    }

    public static void Afficher() {

        LocaliteRepository localiteRepository = new LocaliteTable();
        LocaliteService service = new LocaliteService(localiteRepository);

        int choix;

        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║          GESTION DES LOCALITÉS       ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.println("║ 1 ➜ Ajouter une localité             ║");
            System.out.println("║ 2 ➜ Modifier une localité            ║");
            System.out.println("║ 3 ➜ Afficher les localités           ║");
            System.out.println("║ 4 ➜ Supprimer une localité           ║");
            System.out.println("║ 5 ➜ Rechercher une localité par ID   ║");
            System.out.println("║ 0 ➜ Quitter                          ║");
            System.out.println("╚══════════════════════════════════════╝");

            System.out.print("Votre choix : ");
            choix = clavier.nextInt();
            clavier.nextLine();

            switch (choix) {

                // Ajouter une localité
                case 1:
                    System.out.print("Entrer la région du client : ");
                    String region = clavier.nextLine();

                    Localite localite = new Localite();
                    localite.setRegionClient(region);

                    service.addLocalite(localite);
                    break;

                // Modifier une localité
                case 2:
                    System.out.print("Entrer l'id de la localité à modifier : ");
                    int idModif = clavier.nextInt();
                    clavier.nextLine();

                    System.out.print("Entrer le nouveau nom de la région : ");
                    String nouvelleRegion = clavier.nextLine();

                    service.updateLocalite(idModif, nouvelleRegion);
                    System.out.println("Localité modifiée avec succès.");
                    break;

                // Afficher les localités
                case 3:
                    List<Localite> localites = service.getAllLocalites();

                    if (localites == null || localites.isEmpty()) {
                        System.out.println("Aucune localité enregistrée.");
                    } else {
                        System.out.println("\n===== LISTE DES LOCALITÉS =====");
                        for (Localite l : localites) {
                            System.out.println(
                                    "ID : " + l.getId() +
                                            " | Région : " + l.getRegionClient()
                            );
                        }
                    }
                    break;

                // Supprimer une localité
                case 4:
                    System.out.print("Entrer l'id de la localité à supprimer : ");
                    int idSup = clavier.nextInt();
                    clavier.nextLine();

                    service.deleteLocalite(idSup);
                    System.out.println("Localité supprimée avec succès.");
                    break;

                // Rechercher par ID
                case 5:
                    System.out.print("Entrer l'id de la localité : ");
                    int idRecherche = clavier.nextInt();
                    clavier.nextLine();

                    service.getLocaliteById(idRecherche);
                    break;

                // Quitter
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }

        } while (choix != 0);
    }

    /**
     * Permet de choisir une localité parmi la liste existante.
     * Utilisé par d'autres interfaces (ex: ClientInterface).
     */
    public Localite choisirLocalite() {
        List<Localite> localites = localiteService.getAllLocalites();

        if (localites == null || localites.isEmpty()) {
            System.out.println("Il n'y a aucune localité enregistrée !!!");
            return null;
        }

        int choix;
        do {
            System.out.println("\n=========== Liste des localités ===========");
            for (int i = 0; i < localites.size(); i++) {
                System.out.println((i + 1) + " ➜ " + localites.get(i).getRegionClient());
            }

            System.out.print("Choisissez une localité : ");
            choix = clavier.nextInt();
            clavier.nextLine();
        } while (choix < 1 || choix > localites.size());

        return localites.get(choix - 1);
    }
}
