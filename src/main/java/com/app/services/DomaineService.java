package com.app.services;

import java.util.List;
import com.app.model.Domaine;
import com.app.repositories.DomaineRepository;

public class DomaineService {

    private final DomaineRepository domaineRepository;

   
    public Domaine(DomaineRepository domaineRepository) {
        this.domaineRepository = domaineRepository;
    }

    // AJOUTER
    public void ajouter(String nom) {

        if (nom == null || nom.trim().isEmpty()) {
            System.out.println("Nom obligatoire !");
            return;
        }

        Domaine d = new Domaine(null, nom);
        domaineRepository.ajouterDomaine(d);
    }

   
    public void modifier(int id, String nom) {

        if (id <= 0) {
            System.out.println("ID invalide !");
            return;
        }

        Domaine d = new Domaine(id, nom);
        domaineRepository.modifierDomaine(d);
    }

  
    public void supprimer(int id) {
        domaineRepository.supprimerDomaine(id);
    }

   
    public List<Domaine> afficher() {
        return domaineRepository.afficherDomaine();
    }
}