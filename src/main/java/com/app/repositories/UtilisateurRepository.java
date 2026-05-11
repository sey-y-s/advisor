package com.app.repositories;

import java.util.List;
import java.util.Optional;
import com.app.model.Utilisateur;
import com.app.enums.Role;

public interface UtilisateurRepository {
    
    void add(Utilisateur utilisateur);
    Optional<Utilisateur> getById(int id);
    Optional<Utilisateur> getByEmail(String email);
    List<Utilisateur> getAll();
    List<Utilisateur> getByRole(Role role);
    void update(int id, String nom, String prenom, String email, Integer telephone);
    void updateMotDePasse(int id, String nouveauMotDePasse);
    int delete(int id);
    boolean existsByEmail(String email);
}
