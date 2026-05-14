package ServiceImplementation;

import DAOimplementation.CompetenceProjetTable;
import DAOimplementation.ClientCompetenceTable;
import DAOimplementation.ProjetTable;
import models.Projet;
import models.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class RecommendationServiceImpl implements Service.RecommandationService {
    private final ProjetTable projetTable;
    private final CompetenceProjetTable competenceProjetTable;
    private final ClientCompetenceTable clientCompetenceTable;

    public RecommendationServiceImpl(ProjetTable pTable, CompetenceProjetTable pcTable, ClientCompetenceTable ccTable) {
        this.projetTable = pTable;
        this.competenceProjetTable = pcTable;
        this.clientCompetenceTable = ccTable;
    }

    @Override
    public List<Projet> suggererProjets(Client client) throws SQLException {
        List<Projet> tousLesProjets = projetTable.getAll();
        List<Integer> competencesClient = clientCompetenceTable.getSkillsByClient(client.getIdUtilisateur());

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
        List<Integer> competencesRequises = competenceProjetTable.getSkillsByProjet(projet.getId());

        if (competencesRequises.isEmpty()) return true;

        // vérifie s'il y a une intersection entre les deux listes
        return competencesRequises.stream().anyMatch(competencesClient::contains);
    }
}