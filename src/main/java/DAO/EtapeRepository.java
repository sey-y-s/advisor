package DAO;

import java.util.List;
import java.util.Optional;

import models.Etape;


// Interface de repository pour les étapes
public interface EtapeRepository {
    void add(Etape etape);
    Optional<Etape> getById(int idEtape);
    List<Etape> getAll();
    boolean update(Etape etape);
    boolean delete(int idEtape);
    boolean existsById(int idEtape);
}
