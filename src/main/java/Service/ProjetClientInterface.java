package Service;

import Models.ProjetClient;
import Models.enums.StatutProjet;

import java.util.List;
import java.util.Optional;

public interface ProjetClientInterface {
    void add(ProjetClient projetClient);
    void changerStatut(int id, StatutProjet statutProjet);
    Optional<ProjetClient> getById(int id);
    List<ProjetClient> getAll();
    List<ProjetClient> getByClient(int idClient);
}
