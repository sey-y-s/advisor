package DAO;
import java.util.List;
import java.util.Optional;
import models.enums.*;
import models.Client;

public interface ClientRepository {
    boolean add(Client client);
    Optional<Client> getById(int id);
    List<Client> getAll();
    boolean update(int id, String nom, String prenom, String telephone, Niveau niveau ,int idlocalite);
    boolean delete(int id);
    boolean existsByEmail(String email);

}
