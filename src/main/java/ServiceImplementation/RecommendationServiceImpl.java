package ServiceImplementation;

import Service.RecommandationService;
import DAOimplementation.ClientCompetenceTable;
import DAOimplementation.ProjetTable;
import models.Projet;
import models.Client;

import java.sql.SQLException;
import java.util.List;

public class RecommendationServiceImpl implements RecommendationService {
    private final ProjetTable projetTable;
    private final ProjetCompetenceTable projetCompetenceTable;
    private final ClientCompetenceTable clientCompetenceTable;

    public RecommendationServiceImpl(ProjetTable pTable, ProjetCompetenceTable pcTable, ClientCompetenceTable ccTable) {
        this.projetTable = pTable;
        this.projetCompetenceTable = pcTable;
        this.clientCompetenceTable = ccTable;
    }

    @Override
    public List<Projet> suggererProjets(Client client) throws SQLException {
        List<Projet> tousLesProjets = projetTable.findAll();
        List<Integer> competencesClient = clientCompetenceTable.getSkillsByClient(client.getId());

        return tousLesProjets.stream()
                .filter(p -> budgetEstCompatible(client, p))
                .filter(p -> localiteEstCompatible(client, p))
                .filter(p -> competencesSontCompatibles(p, competencesClient))
                .collect(Collectors.toList());
    }

    // RÈGLE 1 : Le budget apporté par le client doit couvrir le budget MIN du projet
    private boolean budgetEstCompatible(Client client, Projet projet) {
        return client.getBudgetApporte() >= projet.getBudgetMin();
    }

    // RÈGLE 2 : Même localité (si le projet est lié à une zone précise)
    private boolean localiteEstCompatible(Client client, Projet projet) {
        // Si le projet n'a pas de contrainte de localité, il est compatible partout
        if (projet.getIdLocalite() == 0) return true;
        return client.getIdLocalite() == projet.getIdLocalite();
    }

    // RÈGLE 3 : Le client possède au moins une des compétences clés du projet
    private boolean competencesSontCompatibles(Projet projet, List<Integer> competencesClient) throws SQLException {
        List<Integer> competencesRequises = projetCompetenceTable.getSkillsByProject(projet.getId());

        // Si le projet ne demande aucune compétence spécifique, tout le monde peut le faire
        if (competencesRequises.isEmpty()) return true;

        // On vérifie s'il y a une intersection entre les deux listes
        return competencesRequises.stream().anyMatch(competencesClient::contains);
    }
}