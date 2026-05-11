package com.app.repositories;

import java.util.List;
import java.util.Optional;

import com.app.model.Client;

public interface ClientRepository {
    
    void add(Client client);
    Optional<Client> getById(int id);
    List<Client> getAll();
    void update(int id);
    void delete(int id);
    boolean existsByEmail(String email);
}









