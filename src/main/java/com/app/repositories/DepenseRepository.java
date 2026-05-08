package com.app.repositories;

import java.util.List;
import java.util.Optional;

import com.app.model.Depense;

public interface DepenseRepository {

    void add(Depense depense);
    Optional<Depense> getById(int id);
    List<Depense> getAll();
    void update (int id);
    void delete(int id);
    
}