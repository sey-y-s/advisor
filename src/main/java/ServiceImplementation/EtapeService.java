package ServiceImplementation;

import java.util.List;
import Service.InterfaceEtape;
import Models.Etape;

//Service pour gérer les opérations liées aux étapes

public class EtapeService implements InterfaceEtape {

    private final InterfaceEtape etapeService;

    public EtapeService(InterfaceEtape etapeService) {
        this.etapeService = etapeService;
    }

    //Ajouter une nouvelle étape
    @Override
    public boolean ajout(Etape etape) {
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

        boolean result = etapeService.ajout(etape);
        System.out.println(result ? "Étape ajoutée avec succès." : "Échec de l'ajout de l'étape.");
        return result;
    }

    //Rechercher une étape specifique
    @Override
    public boolean etape_specifique(int idEtape) {
        if (idEtape <= 0) {
            System.out.println("L'ID de l'étape doit être un entier positif.");
            return false;
        }
        return etapeService.etape_specifique(idEtape);
    }

    //Liste des étapes
    @Override
    public List<Etape> Les_etapes() {
        return etapeService.Les_etapes();
    }

    //Mettre à jour une étape
    @Override
    public boolean mise_a_jour(Etape etape) {
        if ((etape == null) || (etape.getIdEtape() <= 0)) {
            System.out.println("L'ID de l'étape est obligatoire pour la mise à jour.");
            return false;
        }
        if (etape.getTitre() == null || etape.getTitre().trim().isEmpty()) {
            System.out.println("Le titre de l'étape est obligatoire.");
            return false;
        }

        if (!etapeService.etape_specifique(etape.getIdEtape())) {
            System.out.println("Aucune étape trouvée avec l'ID spécifié.");
            return false;
        }

        boolean updated = etapeService.mise_a_jour(etape);
        System.out.println(updated ? "Étape mise à jour avec succès." : "Erreur lors de la mise à jour de l'étape.");
        return updated;
    }

    //Supprimer une étape
    @Override
    public boolean supprimer_etape(int idEtape) {
        if (idEtape <= 0) {
            System.out.println("L'ID de l'étape doit être un entier positif.");
            return false;
        }

        if (!etapeService.verifier_etape(idEtape)) {
            System.out.println("Aucune étape trouvée avec l'ID spécifié.");
            return false;
        }

        boolean deleted = etapeService.supprimer_etape(idEtape);
        System.out.println(deleted ? "Étape supprimée avec succès." : "Erreur lors de la suppression de l'étape.");
        return deleted;
    }

    //Verifier l'existance d'une étape
    @Override
    public boolean verifier_etape(int idEtape) {
        return etapeService.verifier_etape(idEtape);
    }
}