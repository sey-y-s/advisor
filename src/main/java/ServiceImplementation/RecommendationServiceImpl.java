package ServiceImplementation;

import DAO.ClientCompetenceRepository;
import DAO.CompetenceProjetRepository;
import DAO.ProjetRepository;
import DAOimplementation.CompetenceProjetTable;
import DAOimplementation.ClientCompetenceTable;
import DAOimplementation.ProjetTable;
import Models.Projet;
import Models.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendationServiceImpl implements Service.RecommandationService {

    ProjetRepository projetRepository;
    CompetenceProjetRepository competenceProjetRepository;
    ClientCompetenceRepository clientCompetenceRepository;



    public RecommendationServiceImpl(ProjetRepository pr, CompetenceProjetRepository cpr, ClientCompetenceRepository ccr) {
        this.projetRepository = pr;
        this.competenceProjetRepository = cpr;
        this.clientCompetenceRepository = ccr;
    }

    @Override
    public List<Projet> suggererProjets(Client client) throws SQLException {
        List<Projet> tousLesProjets = projetRepository.getAll();
        List<Integer> competencesClient = clientCompetenceRepository.getSkillsByClient(client.getIdUtilisateur());

        return tousLesProjets.stream()
                .filter(p -> budgetCompatible(client, p))
                .filter(p -> competencesCompatibles(p, competencesClient))
                .collect(Collectors.toList());
    }

    // RÈGLE 1 : Le budget du client doit couvrir le budget MIN du projet
    private boolean budgetCompatible(Client client, Projet projet) {
        return client.getBudgetApporte() >= projet.getBudgetMin();
    }


    // RÈGLE 2 : Le client possède au moins une des compétences clés du projet
    private boolean competencesCompatibles(Projet projet, List<Integer> competencesClient) {
        List<Integer> competencesRequises = competenceProjetRepository.getSkillsByProjet(projet.getId());

        if (competencesRequises.isEmpty()) return true;

        // vérifie s'il y a une intersection entre les deux listes
        return competencesRequises.stream().anyMatch(competencesClient::contains);
    }
}