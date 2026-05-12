package services;

import java.util.List;
import java.util.Optional;

import models.Etape;
import repositories.EtapeRepository;


// Service pour gérer les opérations liées aux étapes
public class EtapeService {
    private final EtapeRepository etapeRepository;

    public EtapeService(EtapeRepository etapeRepository) {
        this.etapeRepository = etapeRepository;
    }
//Methode d'ajout
    public boolean createEtape(Etape etape) {
        if (etape == null) {
            System.out.println("L'étape ne peut pas être nulle.");
            return false;
        }

        if (etape.getTitre() == null || etape.getTitre().trim().isEmpty()) {
            System.out.println("Le titre de l'étape est obligatoire.");
            return false;
        }

        if (etape.getDescription() == null || etape.getDescription().trim().isEmpty()) {
            System.out.println("La description de l'étape est obligatoire.");
            return false;
        }

        if (etape.getEtapeStatut() == null) {
            System.out.println("Le statut de l'étape est obligatoire.");
            return false;
        }

        etapeRepository.add(etape);
        System.out.println("Étape ajoutée avec succès.");
        return true;
    }


    // Méthode pour récupérer une étape par son ID
    public Optional<Etape> getEtapeById(int idEtape) {
        if (idEtape <= 0) {
            System.out.println("L'ID de l'étape doit être un entier positif.");
            return Optional.empty();
        }
        return etapeRepository.getById(idEtape);
    }


    // Méthode pour récupérer toutes les étapes
    public List<Etape> getAllEtapes() {
        return etapeRepository.getAll();
    }


    // Méthode pour mettre à jour une étape
    public boolean updateEtape(Etape etape) {
        if (etape == null || etape.getIdEtape() == null || etape.getIdEtape() <= 0) {
            System.out.println("L'ID de l'étape est obligatoire pour la mise à jour.");
            return false;
        }

        if (!etapeRepository.existsById(etape.getIdEtape())) {
            System.out.println("Aucune étape trouvée avec l'ID spécifié.");
            return false;
        }

        boolean updated = etapeRepository.update(etape);
        System.out.println(updated ? "Étape mise à jour avec succès." : "Erreur lors de la mise à jour de l'étape.");
        return updated;
    }

    // Méthode pour supprimer une étape
    public boolean deleteEtape(int idEtape) {
        if (idEtape <= 0) {
            System.out.println("L'ID de l'étape doit être un entier positif.");
            return false;
        }

        if (!etapeRepository.existsById(idEtape)) {
            System.out.println("Aucune étape trouvée avec l'ID spécifié.");
            return false;
        }

        boolean deleted = etapeRepository.delete(idEtape);
        System.out.println(deleted ? "Étape supprimée avec succès." : "Erreur lors de la suppression de l'étape.");
        return deleted;
    }
}
