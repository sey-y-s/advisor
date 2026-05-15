package Service;

import java.util.Optional;

import Models.enums.Role;
import Models.Utilisateur;

public interface ServiceUtilisateur {
    void addUtilisateur(Utilisateur utilisateur);

    Optional<Utilisateur> getUtilisateurById(int id);

    void getAllUtilisateurs();

    Optional<Utilisateur> getUtilisateurByEmail(String email);

    void getUtilisateursByRole(Role role);

    boolean authentifierUtilisateur(String email, String motDePasse);

    void updateUtilisateur(int id, String nom, String prenom, String email, Integer telephone);

    boolean changerMotDePasse(int id, String ancienMotDePasse, String nouveauMotDePasse);

    int deleteUtilisateur(int id);

    boolean utilisateurExistsByEmail(String email);

    void afficherDetailsUtilisateur(int id);
}

