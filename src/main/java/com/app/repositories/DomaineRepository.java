package com.app.repositories;
import com.app.model.Domaine;
import java.util.List;
public Interface DomaineRepository{
    void public AjouterDomaine(Domaine domaine);
    void public ModifierDomaine(Domaine domaine);
    void public SupprimerDomaine(int id);
    List<Domaine> AfficherDomaine()
}