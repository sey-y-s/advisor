package DAOimplementation;

import db.ConnexionBdd;
import models.enums.Role;
import models.*;
import DAO.AdminRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminTable implements AdminRepository {

    @Override
    public boolean add(Admin admin) {
        // TODO Auto-generated method stub
        String sql="INSERT INTO utilisateur (nom, prenom, email, telephone, motDePasse, role) VALUES (?, ?, ?, ?, ?, ?)";
        try( Connection conn=ConnexionBdd.getConnection();
             PreparedStatement stmt= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, admin.getNom());
            stmt.setString(2, admin.getPrenom());
            stmt.setString(3, admin.getEmail());
            stmt.setString(4, admin.getTelephone());
            stmt.setString(5, admin.getMotDePasse());
            stmt.setString(6, Role.ADMIN.name());
            int affected= stmt.executeUpdate();
            // System.out.println("Utilisateur enregistré !!!!");
            if(affected==0){
                throw new SQLException("Enregistrement echoué!!");
            }
            int idUSer;
            try(ResultSet rs= stmt.getGeneratedKeys()){
                if(!rs.next()){
                    throw new SQLException("Aucun ID retrouvé!!");
                }
                idUSer= rs.getInt(1);
                admin.setIdUtilisateur(idUSer);
            }

    } catch (SQLException e) {
        e.printStackTrace(System.out);
    }

        return false;
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