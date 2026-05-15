package DAO;

import java.util.List;
import java.util.Optional;

import Models.DomaineClient;

public interface DomaineClientRepository {

    void add(DomaineClient domaineClient);

    Optional<DomaineClient> getById(int id);

    List<DomaineClient> getAll();

    void delete(int id);

    boolean exists(int idClient, int idDomaine);
}

