package ServiceImplementation;

import java.util.List;
import java.util.Optional;
import models.Projet; // Aligné sur votre package de modèle
import models.ProjetClient;
import com.app.repositories.ProjetRepository;

public class ProjetService {
    private final ProjetRepository projetRepository;

    public ProjetService(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    public void addProjet(Projet projet) {
        try {
            if(projetRepository.existsByTitre(projet.getTitre())) {
                System.out.println("Un projet avec ce titre existe déjà.");
                return;
            }
            if(projet.getTitre() == null || projet.getTitre().trim().isEmpty() ||
                    projet.getDescription() == null || projet.getDescription().trim().isEmpty()) {
                System.out.println("Le titre et la description du projet sont obligatoires.");
                return;
            }
            if(projet.getDuree() <= 0) {
                System.out.println("La durée du projet doit être supérieure à 0.");
                return;
            }
            // Adaptation : Vérification sur budgetMin et budgetMax
            if(projet.getBudgetMin() < 0 || projet.getBudgetMax() < 0) {
                System.out.println("Les budgets du projet ne peuvent pas être négatifs.");
                return;
            }
            if(projet.getBudgetMax() < projet.getBudgetMin()) {
                System.out.println("Le budget maximum ne peut pas être inférieur au budget minimum.");
                return;
            }
            // Adaptation : Vérification de l'existence d'une relation client (via la liste de liaisons)
            if(projet.getRealisations() == null || projet.getRealisations().isEmpty()) {
                System.out.println("Un client doit être associé au projet via une réalisation.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la validation du projet : " + e.getMessage());
        }

        projetRepository.add(projet);
        System.out.println("Projet ajouté avec succès.");
    }

    public void getProjetById(int id) {
        try {
            Optional<Projet> projetOpt = projetRepository.getById(id);
            if (projetOpt.isEmpty()) {
                System.out.println("Aucun projet trouvé avec l'ID spécifié.");
            } else {
                System.out.println("Projet trouvé : " + projetOpt.get().getTitre());
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération du projet : " + e.getMessage());
        }
    }

    public void getAllProjets() {
        List<Projet> projets = projetRepository.getAll();
        if(projets.isEmpty()) {
            System.out.println("Il n'y a pas de projets enregistrés !!!");
            return;
        }
        for(Projet projet : projets) {
            // Adaptation : Lecture de budgetMin/budgetMax et extraction du nom du client via la classe d'association
            String nomClient = "Inconnu";
            if (!projet.getRealisations().isEmpty()) {
                // On récupère le client lié à la première réalisation trouvée
                nomClient = projet.getRealisations().get(0).getClient().getNom();
            }

            System.out.printf("Titre: %s, Durée: %.1f mois, Budget: [%.2f - %.2f] FCFA, Client: %s\n",
                    projet.getTitre(), projet.getDuree(), projet.getBudgetMin(), projet.getBudgetMax(), nomClient);
        }
    }

    public void updateProjet(int id) {
        projetRepository.update(id);
    }

    public int deleteProjet(int id) {
        return projetRepository.delete(id);
    }

    public boolean projetExistsByTitre(String titre) {
        return projetRepository.existsByTitre(titre);
    }

    public void getProjetsByClient(int clientId) {
        List<Projet> projets = projetRepository.getProjetsByClient(clientId);
        if(projets.isEmpty()) {
            System.out.println("Aucun projet trouvé pour ce client.");
            return;
        }
        System.out.println("Projets du client:");
        for(Projet projet : projets) {
            // Adaptation : Remplacement de getBudget() par la plage budgétaire
            System.out.printf("- %s (Durée: %.1f mois, Budget: [%.2f - %.2f] FCFA)\n",
                    projet.getTitre(), projet.getDuree(), projet.getBudgetMin(), projet.getBudgetMax());
        }
    }
}
