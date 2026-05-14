package DAO;

import models.Competence;
import java.util.List;

public interface CompetenceRepository {

    void ajouterCompetence(Competence competence);

    List<Competence> afficherCompetences();

    Competence getCompetenceById(int id); //

    void modifierCompetence(Competence competence);

    void supprimerCompetence(int id);
}