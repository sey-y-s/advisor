package Service;

import models.ProjetClient;
import models.enums.StatutProjet;

import java.util.List;

public interface ProjetClientInterface {
    void add(ProjetClient projetClient);
    void changerStatut(int id, StatutProjet statutProjet);
    ProjetClient getById(int id);
    List<ProjetClient> getAll();
}
