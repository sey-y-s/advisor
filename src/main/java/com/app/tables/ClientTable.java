package com.app.tables;
import java.sql.*;
import java.util.*;

import com.app.model.*;
import com.app.repositories.ClientRepository;
import com.app.db.DatabaseManager;
import com.app.enums.Niveau;
import com.app.enums.Role;




public class ClientTable implements ClientRepository {
    private LocaliteTable localiteTable;

    public ClientTable (){}
    
    public ClientTable(LocaliteTable localiteTable){
        this.localiteTable= localiteTable;
    }

      
    @Override
    public void add(Client client) {
        String insert= "INSERT INTO utilisateur (nom, prenom, email, telephone, mot_de_passe, role) VALUES (?, ?, ?, ?, ?, ?)";
        
        try(Connection conn= DatabaseManager.getConnection(); 
            PreparedStatement stmt= conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS )) {
                stmt.setString(1, client.getNom());
                stmt.setString(2, client.getPrenom());
                stmt.setString(3, client.getEmail());
                stmt.setInt(4, client.getTelephone());
                stmt.setString(5, client.getMotDePasse());
                stmt.setString(6, client.getRole().name());
                stmt.executeUpdate();
                int idUSer;
                ResultSet rs= stmt.getGeneratedKeys();
                if(rs.next()){
                    idUSer= rs.getInt(1);
                

                String insert2= "INSERT INTO client(id, niveau, budgetapporte, idlocalite) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt2 = conn.prepareStatement(insert2);
                stmt2.setInt(1, idUSer);
                stmt2.setString(2, client.getNiveau().name());
                stmt2.setDouble(3, client.getBudgetApporte());
                stmt2.setInt(4, client.getLocalite().getId());
                stmt2.executeUpdate();
                System.out.println("Client ajouté avec succès.!!!!!!!!!!");
            }
            
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du client : " + e.getMessage()); 
            e.printStackTrace();
        }
        
    }

    @Override
    public Optional<Client> getById(int id) {
        String selectById= "SELECT * FROM client WHERE id = ?";
       try  (Connection conn= DatabaseManager.getConnection(); 
            PreparedStatement stmt= conn.prepareStatement(selectById)) {
                stmt.setInt(1, id);
                try (ResultSet rs= stmt.executeQuery()) {
                    
                    if (rs.next()) {
                        Localite localite= localiteTable.getById(rs.getInt("idLocalite"));
                        Client client = new Client();
                        client.setIdUtilisateur(rs.getInt("id"));
                        client.setNom(rs.getString("nom"));
                        client.setPrenom(rs.getString("prenom"));
                        client.setEmail(rs.getString("email"));
                        client.setTelephone(rs.getInt("telephone"));
                        client.setMotDePasse(rs.getString("mot_de_passe"));
                        client.setRole(Role.valueOf(rs.getString("role")));
                        client.setNiveau(Niveau.valueOf(rs.getString("niveau")));
                        client.setBudgetApporte(rs.getInt("budget_apporte"));
                        client.setLocalite(localite);

                        return Optional.of(client); 
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Client> getAll() {
        String selectAll= "SELECT * FROM client";
        try(Connection conn= DatabaseManager.getConnection(); 
            PreparedStatement stmt= conn.prepareStatement(selectAll)) {
                try (ResultSet rs= stmt.executeQuery()) {
                    List<Client> clients = new ArrayList<>();
                    while (rs.next()) {
                        Localite localite= localiteTable.getById(rs.getInt("idLocalite"));
                        Client client = new Client();
                        client.setIdUtilisateur((rs.getInt("id")));
                        client.setNom(rs.getString("nom"));
                        client.setPrenom(rs.getString("prenom"));
                        client.setEmail(rs.getString("email"));
                        client.setTelephone(rs.getInt("telephone"));
                        client.setMotDePasse(rs.getString("mot_de_passe"));
                        client.setRole(Role.valueOf(rs.getString("role")));
                        client.setNiveau(Niveau.valueOf(rs.getString("niveau")));
                        client.setBudgetApporte(rs.getInt("budget_apporte"));
                        client.setLocalite(localite);
                        clients.add(client);
                    }
                    return clients; 
                }
            
        } catch (SQLException e) {
            e.printStackTrace();    
        } 
        return null;
    }

    @Override
    public void update(int id) {
         String update= "UPDATE client SET nom = ?, prenom = ?, email = ?, telephone = ?, mot_de_passe = ?, role = ?, niveau = ?, budget_apporte = ?, id_localite = ? WHERE id = ?";
        try(Connection conn= DatabaseManager.getConnection(); 
            PreparedStatement stmt= conn.prepareStatement(update)) {
                stmt.setInt(10, id);
                int ligne= stmt.executeUpdate();
                if (ligne > 0) {
                    System.out.println("Client mis à jour avec succès."); 
                } else {
                    System.out.println("Aucun client trouvé avec l'ID spécifié."); 
                }
            
        } catch (SQLException e) {
            e.printStackTrace();    
        }
       
    }

    @Override
    public void delete(int id) {
        String delete= "DELETE FROM client WHERE id = ?";
        try(Connection conn= DatabaseManager.getConnection(); 
            PreparedStatement stmt= conn.prepareStatement(delete)) {
                stmt.setInt(1, id);
                int ligne= stmt.executeUpdate();
                if (ligne > 0) {
                    System.out.println("Client supprimé avec succès."); 
                } else {
                    System.out.println("Aucun client trouvé avec l'ID spécifié."); 
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public boolean existsByEmail(String email) {
        String query = "SELECT COUNT(*) FROM client WHERE email = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
