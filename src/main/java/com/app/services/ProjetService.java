package com.app.services;

import java.util.List;
import java.util.Optional;

import com.app.model.Projet;
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
            else if(projet.getTitre() == null || projet.getTitre().trim().isEmpty() || 
                    projet.getDescription() == null || projet.getDescription().trim().isEmpty()) {
                System.out.println("Le titre et la description du projet sont obligatoires.");
                return;
            }
            else if(projet.getDuree() <= 0) {
                System.out.println("La durée du projet doit être supérieure à 0.");
                return;
            }
            else if(projet.getBudget() < 0) {
                System.out.println("Le budget du projet ne peut pas être négatif.");
                return;
            }
            else if(projet.getClient() == null) {
                System.out.println("Un client doit être associé au projet.");
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
        if(projets.size() == 0) {
            System.out.println("Il n'y a pas de projets enregistrés !!!");
            return;
        }
        for(Projet projet : projets) {
            System.out.printf("Titre: %s, Durée: %.1f mois, Budget: %d FCSA, Client: %s\n", 
                projet.getTitre(), projet.getDuree(), projet.getBudget(), projet.getClient().getNom());
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
        if(projets.size() == 0) {
            System.out.println("Aucun projet trouvé pour ce client.");
            return;
        }
        System.out.println("Projets du client:");
        for(Projet projet : projets) {
            System.out.printf("- %s (Durée: %.1f mois, Budget: %d FCFA)\n", 
                projet.getTitre(), projet.getDuree(), projet.getBudget());
        }
    }
}
