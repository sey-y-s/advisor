package Service;

import models.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminServiceDao {
    void add(Admin admin);
    Optional<Admin> getById(int id);
    List<Admin> getAll();
    void update (int id);
    void delete(int id);
}
