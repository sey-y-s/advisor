package com.app.repositories;

import java.util.List;
import java.util.Optional;

import com.app.model.Projet;

public interface ProjetRepository {

    void add(Projet projet);
    Optional<Projet> getById(int id);
    List<Projet> getAll();
    void update(int id);
    int delete(int id);
    boolean existsByTitre(String titre);
    List<Projet> getProjetsByClient(int clientId);
}
