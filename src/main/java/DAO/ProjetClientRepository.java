package DAO;

import Models.ProjetClient;
import Models.enums.StatutProjet;

import java.util.List;
import java.util.Optional;

public interface ProjetClientRepository {

    void save(ProjetClient projetclient);

    void changerStatut(int id, StatutProjet statutProjet);

    //void delete(int id);

    Optional<ProjetClient> getById(int id);

    List<ProjetClient> getAll();

    List<ProjetClient> getByClient(int idClient);
}
