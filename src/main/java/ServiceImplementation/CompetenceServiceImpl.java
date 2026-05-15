package ServiceImplementation;

import DAO.CompetenceRepository;
import Service.CompetenceService;
import Models.Competence;

import java.util.List;
public class CompetenceServiceImpl implements CompetenceService {
    private final CompetenceRepository competenceRepository;

    public CompetenceServiceImpl(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    @Override
    public void ajouter(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("Erreur : le nom de la compétence est vide.");
            return;
        }
        competenceRepository.ajouterCompetence(new Competence(nom.trim()));
    }

    @Override
    public void modifier(int id, String nom) {
        if (id <= 0) {
            System.out.println("Erreur : ID invalide.");
            return;
        }
        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("Erreur : le nom est vide.");
            return;
        }
        Competence competence = competenceRepository.getCompetenceById(id);
        if (competence == null) {
            System.out.println("Erreur : compétence introuvable.");
            return;
        }
        competence.setNom(nom.trim());
        competenceRepository.modifierCompetence(competence);
    }

    @Override
    public void supprimer(int id) {
        if (id <= 0) {
            System.out.println("Erreur : ID invalide.");
            return;
        }
        Competence competence = competenceRepository.getCompetenceById(id);
        if (competence == null) {
            System.out.println("Erreur : compétence introuvable.");
            return;
        }
        competenceRepository.supprimerCompetence(id);
    }

    @Override
    public List<Competence> afficher() {
        return competenceRepository.afficherCompetences();
    }
}