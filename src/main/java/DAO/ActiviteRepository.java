package DAO;

import models.*;
import models.enums.StatutEtape;

import java.util.List;


public interface ActiviteRepository {
    void add(Activite activite);
    Activite getById(int id);
    List<Activite> getAll();
    void update(int id, StatutEtape statut);
    void delete(int id);
}
