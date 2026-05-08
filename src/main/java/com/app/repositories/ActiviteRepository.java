package com.app.repositories;

import java.util.List;
import com.app.model.*;

public interface ActiviteRepository {
    void add(Activite activite);
    Activite getById(int id);
    List<Activite> getAll();
    void update(int id, String activite);
    void delete(int id);
}