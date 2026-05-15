package Service;

import java.util.List;
import java.util.Optional;

import Models.Etape;


//Interface de Service pour gérer les opérations liées aux étapes
public interface InterfaceEtape {

    boolean ajoutt(Etape etape);
    Optional<Etape> etape(int idEtape);
    List<Etape> Les_etapes();
    boolean miseAjour(Etape etape);
    boolean suppression(int idEtape);
    boolean verification(int idEtape);

}
