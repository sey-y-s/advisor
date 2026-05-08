package com.app.repositories;

import java.util.List;
import java.util.Optional;

import com.app.model.Etape;


// Interface de repository pour les étapes
public interface EtapeRepository {
    void add(Etape etape);
    Optional<Etape> getById(int id);
    List<Etape> getAll();
    boolean update(Etape etape);
    boolean delete(int id);
    boolean existsById(int id);
}
