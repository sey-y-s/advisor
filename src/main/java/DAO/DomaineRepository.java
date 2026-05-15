package DAO;

import Models.Domaine;

import java.util.List;

public interface DomaineRepository {
    public void ajoutDomaine(Domaine domaine);
    List<Domaine> afficherDomaine();
    public void  modifierDomaine(Domaine domaine);
    public void supprimerDomaine(int id);
}
