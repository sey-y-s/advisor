package ServiceImplementation;

import models.Competence;
import DAO.CompetenceRepository;
import java.util.List;

public class CompetenceService {
    private final CompetenceRepository competenceRepository;

    public CompetenceService(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    public void ajouter(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("Le nom de la compétence est obligatoire.");
            return;
        }
        Competence c = new Competence(nom);
        competenceRepository.ajouterCompetence(c);
    }

    public void modifier(int id, String nom) {
        if (id < 0) {
            System.out.println("ID invalide.");
            return;
        }
        Competence c = new Competence(id, nom);
        competenceRepository.modifierCompetence(c);
    }

    public void supprimer(int id) {
        competenceRepository.supprimerCompetence(id);
    }

    public List<Competence> afficher() {
        return competenceRepository.afficherCompetences();
    }
}