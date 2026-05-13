package repositories;

import java.util.List;
import java.util.Optional;

import models.Depense;

public interface DepenseRepository {

    void add(Depense depense);
    Optional<Depense> getById(int id);
    List<Depense> getAll();
    void update (int id);
    void delete(int id);

}