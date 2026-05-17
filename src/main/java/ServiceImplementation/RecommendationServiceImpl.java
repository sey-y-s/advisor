package ServiceImplementation;

import DAO.ClientCompetenceRepository;
import DAO.CompetenceProjetRepository;
import DAO.ProjetRepository;

import Models.Projet;
import Models.Client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecommendationServiceImpl {

    ProjetRepository projetRepository;
    CompetenceProjetRepository competenceProjetRepository;
    ClientCompetenceRepository clientCompetenceRepository;

    public RecommendationServiceImpl(ProjetRepository pr, CompetenceProjetRepository cpr, ClientCompetenceRepository ccr) {
        projetRepository = pr;
        competenceProjetRepository = cpr;
        clientCompetenceRepository = ccr;
    }

    public List<Projet> suggererProjets(Client client) throws SQLException {

        List<Projet> projetsRecommandes = new ArrayList<>();
        List<Projet> tousLesProjets = projetRepository.getAll();
        List<Integer> competencesClient = clientCompetenceRepository.getSkillsByClient(client.getIdUtilisateur());

        for (Projet projet : tousLesProjets) {
            if (client.getBudgetApporte() >= projet.getBudgetMin()) {

                List<Integer> competencesProjet = competenceProjetRepository.getSkillsByProjet(projet.getId());

                boolean competenceTrouvee = false;

                // Vérifier si une compétence correspond
                for (Integer competence : competencesProjet) {

                    if (competencesClient.contains(competence)) {
                        competenceTrouvee = true;
                    }
                }

                // Si aucune compétence demandée, on suppose que tout le monde peut faire ce projet
                if (competencesProjet.isEmpty()) {
                    competenceTrouvee = true;
                }

                if (competenceTrouvee) {
                    projetsRecommandes.add(projet);
                }
            }
        }

        return projetsRecommandes;
    }
}
