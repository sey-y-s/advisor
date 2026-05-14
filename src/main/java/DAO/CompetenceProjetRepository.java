package DAO;

import Service.CompetenceProjetDao;
import models.CompetenceProjet;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CompetenceProjetRepository {

    boolean ajout(CompetenceProjet competenceProjet);
    Optional<CompetenceProjet> rech_competence(int id);
    List<CompetenceProjet> tous_les_competences();
    boolean mise_a_jour(CompetenceProjet competenceProjet);
    boolean supprimer(int id);
    boolean verifier_existance(int id);
    List<Integer> getSkillsByProjet(int idProjet);
}
