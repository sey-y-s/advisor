package Service;

import java.util.List;
import java.util.Optional;
import Models.Commentaire;

public interface InterfaceCommentaire {

    boolean ajout_commentaire(Commentaire commentaire);
    Optional<Commentaire> rech_commentaire(int id);
    List<Commentaire> tous_les_Commentaires();           // ← Sans paramètre
    boolean mise_a_jour_Commentaire(Commentaire commentaire);
    boolean suppr_commentaire(int id);
    boolean verif_existance(int id);
}