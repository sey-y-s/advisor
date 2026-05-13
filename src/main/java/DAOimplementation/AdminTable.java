package DAOimplementation;

import db.ConnexionBdd;
import models.enums.Role;
import models.*;
import DAO.AdminRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminTable implements AdminRepository {

    @Override
    public void add(Admin admin) {
        // TODO Auto-generated method stub
        String sql="insert into Admin(montant,description,date,activite) VALUES(?,?,?,?)";
        try (Connection conn = ConnexionBdd.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setString(1,admin.getNom());
            ps.setString(2, admin.getPrenom());
            ps.setString(3, admin.getEmail());
            ps.setString(4, admin.getTelephone());
            ps.setString(3, admin.getMotDePasse());
            System.out.println("Admin ajoute");

        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("Erreur lors de l'ajout de l'admin : " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Admin> getById(int id) {
        String sql ="select from Admin where(id=?)";
        try(Connection conn = ConnexionBdd.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,id);
            ps.executeUpdate();

        }
        catch (SQLException e){
            System.out.println("Obtenir le Admin par l'id : "+e.getMessage());
            e.getMessage();

        }

        return null;

    }

    @Override
    public List<Admin> getAll() {
        String sql = "SELECT * FROM utilisateur u JOIN admin c ON u.id = c.id";
        List<Admin> admins = new ArrayList<>();
        try (
                Connection conn = ConnexionBdd.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setIdUtilisateur(rs.getInt("id"));
                admin.setNom(rs.getString("nom"));
                admin.setPrenom(rs.getString("prenom"));
                admin.setEmail(rs.getString("email"));
                admin.setTelephone(rs.getString("telephone"));
                admin.setMotDePasse(rs.getString("motDePasse"));
                admin.setRole(Role.valueOf(rs.getString("role")));
                admins.add(admin);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return admins;
    }

    @Override
    public void update(int id) {

        String sql="update Admin set nom = ?, prenom = ?, email = ?, telephone = ?, motDePasse = ?, WHERE id = ?";
        try(Connection conn = ConnexionBdd.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setInt(5, id);
            int line = ps.executeUpdate();
            if (line > 0) {
                System.out.println("admin modifier avec succès");
            }else{
                System.out.println("admin n'a pas ete modifier");
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de l'admin : "+ e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        String sql="delete from Admin WHERE(id=?)";
        try(Connection conn = ConnexionBdd.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);)
        {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Admin supprimée");

        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'admin : "+ e.getMessage());
            e.printStackTrace();
        }



    }
}