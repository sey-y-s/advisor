package com.app.services;

import java.util.Optional;
import com.app.model.Domaine;

public class DomaineService{
    private final DomaineRepository domaineRepository;
    public class Domaine(DomaineRepository domaineRepository){
    this.domaineRepository=domaineRepository
    // Ajouter
    public void ajouter(String nom) {
        Domaine d = new Domaine(null, nom);
        domaineRepository.ajouterDomaine(d);
    }

    // Modifier
    public void modifier(int id, String nom) {
        Domaine d = new Domaine(id, nom);
        domaineRepository.modifierDomaine(d);
    }

    // Supprimer
    public void supprimer(int id) {
        domaineRepository.supprimerDomaine(id);
    }

    // Afficher
    public List<Domaine> afficher() {
        return domaineRepository.afficherDomaine();
    }


    }
}