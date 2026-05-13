package Service; // tu peux choisir le package qui te convient

import models.Competence;
import java.util.List;

public interface CompetenceService {
    void ajouter(String nom);
    void modifier(int id, String nom);
    void supprimer(int id);
    List<Competence> afficher();
}