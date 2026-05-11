package com.app.tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.app.model.Utilisateur;
import com.app.model.Client;
import com.app.model.Admin;
import com.app.repositories.UtilisateurRepository;
import com.app.enums.Role;
import com.app.enums.Niveau;
import com.app.db.DatabaseManager;

public class UtilisateurTable implements UtilisateurRepository {

    @Override
    public void add(Utilisateur utilisateur) {
        String insert = "INSERT INTO utilisateur (nom, prenom, email, telephone, mot_de_passe, role) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection conn = DatabaseManager.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(insert)) {
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setInt(4, utilisateur.getTelephone() != null ? utilisateur.getTelephone() : 0);
            stmt.setString(5, utilisateur.getMotDePasse());
            stmt.setString(6, utilisateur.getRole().name());
            int ligne = stmt.executeUpdate();
            if(ligne > 0) {
                System.out.println("Utilisateur ajouté avec succès.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage()); 
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Utilisateur> getById(int id) {
        String selectById = "SELECT * FROM utilisateur WHERE id_utilisateur = ?";
        try (Connection conn = DatabaseManager.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(selectById)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Utilisateur utilisateur = createUtilisateurFromResultSet(rs);
                    return Optional.of(utilisateur); 
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de l'utilisateur : " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Utilisateur> getByEmail(String email) {
        String selectByEmail = "SELECT * FROM utilisateur WHERE email = ?";
        try (Connection conn = DatabaseManager.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(selectByEmail)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Utilisateur utilisateur = createUtilisateurFromResultSet(rs);
                    return Optional.of(utilisateur); 
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche par email : " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Utilisateur> getAll() {
        String selectAll = "SELECT * FROM utilisateur";
        try(Connection conn = DatabaseManager.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(selectAll)) {
            try (ResultSet rs = stmt.executeQuery()) {
                List<Utilisateur> utilisateurs = new ArrayList<>();
                while (rs.next()) {
                    Utilisateur utilisateur = createUtilisateurFromResultSet(rs);
                    utilisateurs.add(utilisateur);
                }
                return utilisateurs; 
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
            e.printStackTrace();    
        }
        return new ArrayList<>();
    }

    @Override
    public List<Utilisateur> getByRole(Role role) {
        String selectByRole = "SELECT * FROM utilisateur WHERE role = ?";
        try(Connection conn = DatabaseManager.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(selectByRole)) {
            stmt.setString(1, role.name());
            try (ResultSet rs = stmt.executeQuery()) {
                List<Utilisateur> utilisateurs = new ArrayList<>();
                while (rs.next()) {
                    Utilisateur utilisateur = createUtilisateurFromResultSet(rs);
                    utilisateurs.add(utilisateur);
                }
                return utilisateurs; 
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des utilisateurs par rôle : " + e.getMessage());
            e.printStackTrace();    
        }
        return new ArrayList<>();
    }

    @Override
    public void update(int id, String nom, String prenom, String email, Integer telephone) {
        String update = "UPDATE utilisateur SET nom = ?, prenom = ?, email = ?, telephone = ? WHERE id_utilisateur = ?";
        try(Connection conn = DatabaseManager.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(update)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, email);
            stmt.setInt(4, telephone != null ? telephone : 0);
            stmt.setInt(5, id);
            int ligne = stmt.executeUpdate();
            if (ligne > 0) {
                System.out.println("Utilisateur mis à jour avec succès."); 
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID spécifié."); 
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
            e.printStackTrace();    
        }
    }

    @Override
    public void updateMotDePasse(int id, String nouveauMotDePasse) {
        String updatePassword = "UPDATE utilisateur SET mot_de_passe = ? WHERE id_utilisateur = ?";
        try(Connection conn = DatabaseManager.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(updatePassword)) {
            stmt.setString(1, nouveauMotDePasse);
            stmt.setInt(2, id);
            int ligne = stmt.executeUpdate();
            if (ligne > 0) {
                System.out.println("Mot de passe mis à jour avec succès."); 
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID spécifié."); 
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour du mot de passe : " + e.getMessage());
            e.printStackTrace();    
        }
    }

    @Override
    public int delete(int id) {
        String delete = "DELETE FROM utilisateur WHERE id_utilisateur = ?";
        try(Connection conn = DatabaseManager.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(delete)) {
            stmt.setInt(1, id);
            int ligne = stmt.executeUpdate();
            if (ligne > 0) {
                System.out.println("Utilisateur supprimé avec succès."); 
            } else {
                System.out.println("Aucun utilisateur trouvé avec l'ID spécifié."); 
            }
            return ligne;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'utilisateur : " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean existsByEmail(String email) {
        String query = "SELECT COUNT(*) FROM utilisateur WHERE email = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la vérification de l'email : " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Méthode utilitaire pour créer un Utilisateur à partir d'un ResultSet
     */
    private Utilisateur createUtilisateurFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_utilisateur");
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");
        String email = rs.getString("email");
        Integer telephone = rs.getInt("telephone");
        String motDePasse = rs.getString("mot_de_passe");
        Role role = Role.valueOf(rs.getString("role"));

        Utilisateur utilisateur;
        
        // Créer l'instance appropriée selon le rôle
        if(role.equals(Role.ADMIN)) {
            utilisateur = new Admin(nom, prenom, email, motDePasse, telephone, role);
        } else {
            // Pour CLIENT ou autres rôles
            utilisateur = new Client(nom, prenom, email, motDePasse, Niveau.DEBUTANT, 0, null, telephone, role);
        }
        
        utilisateur.setIdUtilisateur(id);
        return utilisateur;
    }
}
