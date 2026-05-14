package ServiceImplementation;

import java.util.List;
import java.util.Optional;
import Service.InterfaceCommentaire;
import models.Commentaire;


//Service pour gérer les opérations liées aux commentaires
public class CommentaireService implements InterfaceCommentaire {

    private final InterfaceCommentaire interfaceCommentaire;

    public CommentaireService(InterfaceCommentaire interfaceCommentaire) {
        this.interfaceCommentaire = interfaceCommentaire;
    }

    @Override
    public boolean ajout_commentaire(Commentaire commentaire) {
        if (commentaire == null) {
            System.out.println("Le commentaire ne peut pas être nul.");
            return false;
        }
        if (commentaire.getMessaage() == null || commentaire.getMessaage().trim().isEmpty()) {
            System.out.println("Le message du commentaire est obligatoire.");
            return false;
        }
        if (commentaire.getIdEtape() == null || commentaire.getIdEtape() <= 0) {
            System.out.println("L'ID de l'étape est obligatoire et doit être positif.");
            return false;
        }
        if (commentaire.getIdClient() == null || commentaire.getIdClient() <= 0) {
            System.out.println("L'ID du client est obligatoire et doit être positif.");
            return false;
        }

        boolean result = interfaceCommentaire.ajout_commentaire(commentaire);
        System.out.println(result ? "Commentaire ajouté avec succès." : "Échec de l'ajout du commentaire.");
        return result;
    }

    @Override
    public Optional<Commentaire> rech_commentaire(int id) {
        if (id <= 0) {
            System.out.println("L'ID du commentaire doit être un entier positif.");
            return Optional.empty();
        }
        return interfaceCommentaire.rech_commentaire(id);
    }

    @Override
    public List<Commentaire> tous_les_Commentaires() {
        return interfaceCommentaire.tous_les_Commentaires();
    }

    @Override
    public boolean mise_a_jour_Commentaire(Commentaire commentaire) {
        if (commentaire == null || commentaire.getId() == null || commentaire.getId() <= 0) {
            System.out.println("L'ID du commentaire est obligatoire pour la mise à jour.");
            return false;
        }
        if (commentaire.getMessaage() == null || commentaire.getMessaage().trim().isEmpty()) {
            System.out.println("Le message du commentaire est obligatoire.");
            return false;
        }

        if (!interfaceCommentaire.verif_existance(commentaire.getId())) {
            System.out.println("Aucun commentaire trouvé avec l'ID spécifié.");
            return false;
        }

        boolean updated = interfaceCommentaire.mise_a_jour_Commentaire(commentaire);
        System.out.println(updated ? "Commentaire mis à jour avec succès." : "Erreur lors de la mise à jour du commentaire.");
        return updated;
    }

    @Override
    public boolean suppr_commentaire(int id) {
        if (id <= 0) {
            System.out.println("L'ID du commentaire doit être un entier positif.");
            return false;
        }

        if (!interfaceCommentaire.verif_existance(id)) {
            System.out.println("Aucun commentaire trouvé avec l'ID spécifié.");
            return false;
        }

        boolean deleted = interfaceCommentaire.suppr_commentaire(id);
        System.out.println(deleted ? "Commentaire supprimé avec succès." : "Erreur lors de la suppression du commentaire.");
        return deleted;
    }

    @Override
    public boolean verif_existance(int id) {
        return interfaceCommentaire.verif_existance(id);
    }
}