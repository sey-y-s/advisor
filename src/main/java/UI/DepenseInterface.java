package UI;

import Models.Activite;
import Models.Depense;
import Models.Etape;
import Models.ProjetClient;
import Models.enums.StatutEtape;
import Models.enums.StatutProjet;





import java.util.List;
import java.util.Scanner;

public class DepenseInterface {

    private Scanner sc = new Scanner(System.in);

    public Depense enregistrerDepense(List<ProjetClient> projetClients) {

        if (projetClients.isEmpty()) {
            System.out.println("Aucun projet client disponible.");
            return null;
        }
        System.out.println("===== LISTE DES PROJETS =====");
        for (int i = 0; i < projetClients.size(); i++) {
            ProjetClient pc = projetClients.get(i);
            System.out.println((i + 1) + " - " + pc.getProjet().getTitre());
        }
        System.out.print("Choisir un projet : ");
        int choixProjet = sc.nextInt();
        sc.nextLine();
        if (choixProjet < 1 || choixProjet > projetClients.size()) {
            System.out.println("Choix invalide.");
            return null;
        }
        ProjetClient projetClient = projetClients.get(choixProjet - 1);

        if (projetClient.getStatut() != StatutProjet.ENCOURS) {

            System.out.println("Impossible d'ajouter une dépense. Le projet n'est pas en cours.");
            return null;
        }

        Etape etapeActive = null;

        List<Etape> etapes = projetClient
                .getProjet()
                .getEtapes();

        for (Etape e : etapes) {

            if (e.getEtapeStatut() == StatutEtape.ENCOURS) {
                etapeActive = e;
                break;
            }
        }

        if (etapeActive == null) {

            System.out.println("Aucune étape active.");
            return null;
        }

        System.out.println("Etape actuelle : " + etapeActive.getTitre());


        List<Activite> activites = etapeActive.getActivites();

        if (activites.isEmpty()) {
            System.out.println("Aucune activité dans cette étape.");
            return null;
        }

        System.out.println("===== ACTIVITES =====");

        for (int i = 0; i < activites.size(); i++) {
            Activite a = activites.get(i);

            System.out.println((i + 1) + " - " + a.getTitre());
        }
        System.out.print("Choisir une activité : ");

        int choixActivite = sc.nextInt();
        sc.nextLine();

        if (choixActivite < 1 || choixActivite > activites.size()) {
            System.out.println("Choix invalide.");
            return null;
        }

        Activite activiteChoisie = activites.get(choixActivite - 1);

        Depense depense = new Depense();

        System.out.println("===== SAISIE DEPENSE =====");
        System.out.print("Montant : ");
        depense.setMontant(sc.nextDouble());
        sc.nextLine();
        System.out.print("Description : ");
        depense.setDescription(sc.nextLine());
        System.out.print("Date (AAAA-MM-JJ) : ");
       // depense.setDate(Date.parse(sc.nextLine()));
        depense.setActivite(activiteChoisie);
        System.out.println("Dépense enregistrée avec succès.");
        return depense;
    }


    public void afficherDepense(Depense depense) {

        if (depense == null) {
            System.out.println("Aucune dépense.");
            return;
        }
        System.out.println("===== DEPENSE N° " + depense.getIdDepense() + " =====");
        System.out.println("Montant : "+ depense.getMontant());
        System.out.println("Description : "+ depense.getDescription());
        System.out.println("Date : " + depense.getDate());
        if (depense.getActivite() != null) {
            System.out.println("Activité : "+ depense.getActivite().getTitre());
        }
    }
}