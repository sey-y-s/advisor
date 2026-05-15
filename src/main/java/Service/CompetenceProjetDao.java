package Service;

import models.CompetenceProjet;
import java.util.List;
import java.util.Optional;

public interface CompetenceProjetDao {

    boolean ajouter(CompetenceProjet competenceProjet);
    Optional<CompetenceProjet> rechercher(int id);
    List<CompetenceProjet> lister();
    boolean mettre_a_jour(CompetenceProjet competenceProjet);
    boolean supprime(int id);
    boolean verification(int id);
}