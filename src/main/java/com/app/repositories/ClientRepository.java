package com.app.repositories;

import java.util.List;
import java.util.Optional;

import com.app.model.Client;

interface ClientRepository {
    
    Client add(Client client);
    Optional<Client> getById(int id);
    List<Client> getAll();
    Client update(int id);
    int delete(int id);
    
} 