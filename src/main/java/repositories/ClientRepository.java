package repositories;
import java.util.List;
import java.util.Optional;
import models.enums.*;
import models.Client;

public interface ClientRepository {
    void add(Client client);
    Optional<Client> getById(int id);
    List<Client> getAll();
    void update(int id, String nom, String prenom, String email, String telephone, Niveau niveau ,int idlocalite);
    void delete(int id);
    boolean existsByEmail(String email);

}
