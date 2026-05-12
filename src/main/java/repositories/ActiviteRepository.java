package repositories;

import models.*;
import java.util.List;


public interface ActiviteRepository {
    void add(Activite activite);
    Activite getById(int id);
    List<Activite> getAll();
    void update(int id, String activite);
    void delete(int id);
}
