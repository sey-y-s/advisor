package com.app.repositories;

import com.app.model.Admin;
import com.app.model.Depense;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {

    void add(Admin admin);
    Optional<Admin> getById(int id);
    List<Admin> getAll();
    void update (int id);
    void delete(int id);
    
}