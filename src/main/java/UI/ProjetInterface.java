package UI;

import DAO.ProjetRepository;
import DAOimplementation.*;
import Models.Client;
import Models.Projet;
import Service.RecommandationService;
import ServiceImplementation.*;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ProjetInterface {
    private final Scanner scanner;
    private final ProjetService projetService;
    private final EtapeService etapeService;
    private final ActiviteService activiteService;
    private final DepenseService depenseService;
    // private final RecommandationService recommandationService;
    private Client currentClient;
    private ProjetRepository projetRepository;

    public ProjetInterface(Client client) {
        this.currentClient = client;
        this.scanner = new Scanner(System.in);
        // Initialisation des services avec leurs repositories (implémentations table)
        this.projetService = new ProjetService(projetRepository);
        this.etapeService = new EtapeService(new EtapeTable());
        this.activiteService = new ActiviteService(new ActiviteTable());
        this.depenseService = new DepenseService(new DepenseTable());
        // this.recommandationService = new RecommandationService();
    }

    public static void afficherProjet(Projet p, int x) {
        System.out.println();

        System.out.printf("Projet %d: ", x);
        System.out.println("Titre: "+ p.getTitre());
        System.out.println("Description: "+p.getDescription());
    }

    /*
    public void afficherMenuPrincipal() {
        int choix;
        do {
            System.out.println("\n=== GESTION DES PROJETS ===");
            System.out.println("1. Voir mes projets");
            System.out.println("2. Créer un projet à partir d'une recommandation");
            System.out.println("3. Suivre un projet (étapes/dépenses)");
            System.out.println("4. Retour au menu principal");
            System.out.print("Votre choix : ");
            choix = lireEntier();
            switch (choix) {
                case 1 -> listerMesProjets();
                case 2 -> creerProjetDepuisRecommandation();
                case 3 -> suivreProjet();
                case 4 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 4);
    }

    private void listerMesProjets() {
        List<Projet> projets = projetService.getProjetsByClient(currentClient.getIdUtilisateur());
        if (projets.isEmpty()) {
            System.out.println("Vous n'avez aucun projet.");
            return;
        }
        System.out.println("\n=== VOS PROJETS ===");
        for (Projet p : projets) {
            System.out.printf("- %s (Statut: %s, Progression: %.0f%%)\n",
                    p.getTitre(), p.getProjetStatut(), calculerProgression(p));
        }
    }

    private void creerProjetDepuisRecommandation() {
        // Appel au moteur de recommandation
        List<Projet> recommandations = recommandationService.recommander(currentClient);
        if (recommandations.isEmpty()) {
            System.out.println("Aucune recommandation disponible pour votre profil.");
            return;
        }
        System.out.println("\n=== PROJETS RECOMMANDÉS ===");
        for (int i = 0; i < recommandations.size(); i++) {
            Projet p = recommandations.get(i);
            System.out.printf("%d. %s - Budget estimé: [%.0f - %.0f] FCFA\n",
                    i+1, p.getTitre(), p.getBudgetMin(), p.getBudgetMax());
        }
        System.out.print("Choisissez un projet à créer (0 pour annuler) : ");
        int choix = lireEntier();
        if (choix >= 1 && choix <= recommandations.size()) {
            Projet projetChoisi = recommandations.get(choix-1);
            // Associer le client via ProjetClient
            ProjetClient liaison = new ProjetClient(projetChoisi, currentClient);
            projetChoisi.getRealisations().add(liaison);
            projetService.addProjet(projetChoisi);
            System.out.println("Projet \"" + projetChoisi.getTitre() + "\" créé avec succès !");
        } else {
            System.out.println("Création annulée.");
        }
    }

    private void suivreProjet() {
        List<Projet> projets = projetService.getProjetsByClient(currentClient.getIdUtilisateur());
        if (projets.isEmpty()) {
            System.out.println("Aucun projet à suivre.");
            return;
        }
        System.out.println("\nSélectionnez un projet :");
        for (int i = 0; i < projets.size(); i++) {
            System.out.printf("%d. %s\n", i+1, projets.get(i).getTitre());
        }
        System.out.print("Votre choix : ");
        int idx = lireEntier() - 1;
        if (idx < 0 || idx >= projets.size()) {
            System.out.println("Choix invalide.");
            return;
        }
        Projet projet = projets.get(idx);
        gererSuiviProjet(projet);
    }

    private void gererSuiviProjet(Projet projet) {
        int choix;
        do {
            System.out.println("\n--- Suivi du projet : " + projet.getTitre() + " ---");
            System.out.println("Progression globale : " + calculerProgression(projet) + "%");
            System.out.println("1. Voir les étapes");
            System.out.println("2. Marquer une étape terminée");
            System.out.println("3. Enregistrer une dépense");
            System.out.println("4. Suivi budgétaire");
            System.out.println("5. Retour");
            System.out.print("Choix : ");
            choix = lireEntier();
            switch (choix) {
                case 1 -> afficherEtapes(projet);
                case 2 -> marquerEtapeTerminee(projet);
                case 3 -> enregistrerDepense(projet);
                case 4 -> suiviBudgetaire(projet);
                case 5 -> System.out.println("Retour.");
                default -> System.out.println("Choix invalide.");
            }
        } while (choix != 5);
    }

    private void afficherEtapes(Projet projet) {
        List<Etape> etapes = etapeService.getAllEtapesByProjet(projet.getId());
        if (etapes.isEmpty()) {
            System.out.println("Aucune étape définie pour ce projet.");
            return;
        }
        System.out.println("\n=== ÉTAPES DU PROJET ===");
        for (Etape e : etapes) {
            System.out.printf("ID: %d - %s [%s]\n", e.getIdEtape(), e.getTitre(), e.getEtapeStatut());
            // Afficher les activités de l'étape
            List<Activite> activites = activiteService.getActivitesByEtape(e.getIdEtape());
            for (Activite a : activites) {
                System.out.printf("   ↳ Activité: %s - %s\n", a.getTitre(), a.getStatut());
            }
        }
    }

    private void marquerEtapeTerminee(Projet projet) {
        afficherEtapes(projet);
        System.out.print("ID de l'étape à marquer terminée : ");
        int idEtape = lireEntier();
        Optional<Etape> opt = etapeService.getEtapeById(idEtape);
        if (opt.isEmpty() || opt.get().getProjet().getId() != projet.getId()) {
            System.out.println("Étape invalide.");
            return;
        }
        Etape e = opt.get();
        e.setEtapeStatut(StatutEtape.TERMINE);
        etapeService.updateEtape(e);
        System.out.println("Étape marquée terminée. Progression mise à jour.");
    }

    private void enregistrerDepense(Projet projet) {
        System.out.print("ID de l'activité concernée : ");
        int idActivite = lireEntier();
        Optional<Activite> optAct = activiteService.getActiviteById(idActivite);
        if (optAct.isEmpty()) {
            System.out.println("Activité non trouvée.");
            return;
        }
        Activite activite = optAct.get();
        System.out.print("Montant (FCFA) : ");
        double montant = lireDouble();
        scanner.nextLine(); // consommer retour
        System.out.print("Description : ");
        String desc = scanner.nextLine();
        System.out.print("Date (yyyy-mm-dd) : ");
        String dateStr = scanner.nextLine();
        Date date = Date.valueOf(dateStr);
        Depense depense = new Depense(null, montant, desc, date, activite);
        depenseService.addDepense(depense);
        System.out.println("Dépense enregistrée.");
    }

    private void suiviBudgetaire(Projet projet) {
        double totalDepenses = depenseService.getTotalDepensesByProjet(projet.getId());
        System.out.printf("Budget prévu : [%.2f - %.2f] FCFA\n", projet.getBudgetMin(), projet.getBudgetMax());
        System.out.printf("Dépenses réalisées : %.2f FCFA\n", totalDepenses);
        if (totalDepenses > projet.getBudgetMax()) {
            System.out.println("⚠️ Dépassement de budget !");
        } else if (totalDepenses > projet.getBudgetMin()) {
            System.out.println("Budget proche du maximum prévu.");
        } else {
            System.out.println("Budget sous contrôle.");
        }
    }

    private double calculerProgression(Projet projet) {
        List<Etape> etapes = etapeService.getAllEtapesByProjet(projet.getId());
        if (etapes.isEmpty()) return 0;
        long terminees = etapes.stream().filter(e -> e.getEtapeStatut() == StatutEtape.TERMINE).count();
        return (terminees * 100.0) / etapes.size();
    }

    private int lireEntier() {
        while (!scanner.hasNextInt()) {
            System.out.print("Veuillez entrer un nombre : ");
            scanner.next();
        }
        int val = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        return val;
    }

    private double lireDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Veuillez entrer un nombre décimal : ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
    */
}