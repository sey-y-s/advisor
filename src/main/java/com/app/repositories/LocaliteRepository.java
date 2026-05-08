 package com.app.repositories;
import java.util.List;

import com.app.model.*;

public interface LocaliteRepository {
    void add(Localite localite);
    Localite getById(int id);
    List<Localite> getAll();
    void update(int id, String localite);
    void delete(int id); 

}




