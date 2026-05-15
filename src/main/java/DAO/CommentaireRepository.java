package DAO;

import java.util.List;
import java.util.Optional;
import models.Commentaire;

public interface CommentaireRepository {

    boolean ajout(Commentaire commentaire);

    Optional<Commentaire> rech_com(int id);

    List<Commentaire> liste_Commentaires();

    boolean mise_a_jour(Commentaire commentaire);

    boolean suppr_com(int id);

    boolean verif_com(int id);
}