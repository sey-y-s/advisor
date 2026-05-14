package Service;

import models.Activite;

import java.util.List;

public interface ActiviteServiceDao {
    void ajouterActivite(Activite activite);
    List<Activite> afficherActivite();
    void marqueTermine(int id);
    void supprimerActivite(int id);
}
