package Service;

import java.util.List;

import Models.Etape;


//Interface de Service pour gérer les opérations liées aux étapes
public interface InterfaceEtape {

    boolean ajout(Etape etape);
    boolean etape_specifique(int idEtape);
    List<Etape> Les_etapes();
    boolean mise_a_jour(Etape etape);
    boolean supprimer_etape(int idEtape);
    boolean verifier_etape(int idEtape);

}
