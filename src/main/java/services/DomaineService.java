package services;

import models.Domaine;
import repositories.DomaineRepository;

import java.util.List;

public class DomaineService {
    public final DomaineRepository domaineRepository;
    public DomaineService(DomaineRepository domaineRepository){
        this.domaineRepository=domaineRepository;
    }
    public void ajouter(String domaine){
        if(domaine==null||domaine.trim().isEmpty()){
            System.out.println("nom du domaine obligatoire");
            return;
        }
        Domaine d=new Domaine(domaine);
        domaineRepository.ajoutDomaine(d);




    }
    public void modifier(int id,String domaine){
        if(id<0){
            System.out.println("id obligatoire");
            return;
        }
        Domaine d=new Domaine(id,domaine);
        domaineRepository.modifierDomaine(d);
    }
    public void supprimer(int id) {
        domaineRepository.supprimerDomaine(id);
    }


    public List<Domaine> afficher() {
        return domaineRepository.afficherDomaine();
    }
}
