package DAOimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import BD.ConnexionBdd;
import Models.Commentaire;
import DAO.CommentaireRepository;

public class CommentaireTable implements CommentaireRepository {

    @Override
    public boolean ajout(Commentaire commentaire) {
        String sql = "INSERT INTO Commentaire (messaage, idEtape, idClient) VALUES (?, ?, ?)";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, commentaire.getMessaage());
            ps.setInt(2, commentaire.getIdEtape());
            ps.setInt(3, commentaire.getIdClient());

            int rows = ps.executeUpdate();
            System.out.println("Commentaire ajouté avec succès.");
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du commentaire : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Commentaire> rech_com(int id) {
        String sql = "SELECT * FROM Commentaire WHERE id = ?";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Commentaire c = new Commentaire();
                c.setId(rs.getInt("id"));
                c.setMessaage(rs.getString("messaage"));
                c.setIdEtape(rs.getInt("idEtape"));
                c.setIdClient(rs.getInt("idClient"));
                return Optional.of(c);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération du commentaire : " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Commentaire> liste_Commentaires() {
        String sql = "SELECT * FROM Commentaire";
        List<Commentaire> commentaires = new ArrayList<>();

        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Commentaire c = new Commentaire();
                c.setId(rs.getInt("id"));
                c.setMessaage(rs.getString("messaage"));
                c.setIdEtape(rs.getInt("idEtape"));
                c.setIdClient(rs.getInt("idClient"));
                commentaires.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des commentaires : " + e.getMessage());
            e.printStackTrace();
        }
        return commentaires;
    }

    @Override
    public boolean mise_a_jour(Commentaire commentaire) {
        String sql = "UPDATE Commentaire SET messaage = ?, idEtape = ?, idClient = ? WHERE id = ?";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, commentaire.getMessaage());
            ps.setInt(2, commentaire.getIdEtape());
            ps.setInt(3, commentaire.getIdClient());
            ps.setInt(4, commentaire.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Commentaire mis à jour avec succès.");
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean suppr_com(int id) {
        String sql = "DELETE FROM Commentaire WHERE id = ?";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Commentaire supprimé avec succès.");
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean verif_com(int id) {
        String sql = "SELECT 1 FROM Commentaire WHERE id = ?";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la vérification : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}