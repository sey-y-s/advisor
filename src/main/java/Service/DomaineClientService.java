package Service;

import java.util.List;
import java.util.Optional;

import models.DomaineClient;

public interface DomaineClientService {

    void add(DomaineClient domaineClient);

    Optional<DomaineClient> getById(int id);

    List<DomaineClient> getAll();

    default void delete(int id) {

    }
}