package DAO;


import models.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {

    void add(Admin admin);
    Optional<Admin> getById(int id);
    List<Admin> getAll();
    void update (int id);
    void delete(int id);

}