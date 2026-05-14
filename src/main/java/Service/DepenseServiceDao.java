package Service;

import models.Depense;

import java.util.List;
import java.util.Optional;

public interface DepenseServiceDao {
    void add(Depense depense);
    Optional<Depense> getById(int id);
    List<Depense> getAll();
    void update (int id);
    void delete(int id);
}
