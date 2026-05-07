import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientTable implements ClientRepository {

    String insert= "INSERT INTO client (nom, prenom, email, telephone, mot_de_passe, role, niveau budget_apporte, id_localite) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    String selectById= "SELECT * FROM client WHERE id = ?";

    String selectAll= "SELECT * FROM client";
    
    String update= "UPDATE client SET nom = ?, prenom = ?, email = ?, telephone = ?, mot_de_passe = ?, role = ?, niveau = ?, budget_apporte = ?, id_localite = ? WHERE id = ?";

    String delete= "DELETE FROM client WHERE id = ?"; 
      
    @Override
    public void add(Client client) {
        try(Connection conn= databaseManager.getConnection(); 
            PreparedStatement stmt= conn.prepareStatement(insert)) {
                stmt.setString(1, client.getNom());
                stmt.setString(2, client.getPrenom());
                stmt.setString(3, client.getEmail());
                stmt.setString(4, client.getTelephone());
                stmt.setString(5, client.getMotDePasse());
                stmt.setString(6, client.getRole().name());
                stmt.setString(7, client.getNiveau().name());
                stmt.setDouble(8, client.getBudgetApporte());
                stmt.setInt(9, client.getIdLocalite());
                int ligne= stmt.executeUpdate();
                System.out.println("Client ajouté avec succès.!!!!!!!!!!");
            
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du client : " + e.getMessage()); 
            e.printStackTrace();
        }
        
    }

    @Override
    public Optional<Client> getById(int id) {
       try  (Connection conn= databaseManager.getConnection(); 
            PreparedStatement stmt= conn.prepareStatement(selectById)) {
                stmt.setInt(1, id);
                try (ResultSet rs= stmt.executeQuery()) {
                    if (rs.next()) {
                        Client client = new Client();
                        client.setId(rs.getInt("id"));
                        client.setNom(rs.getString("nom"));
                        client.setPrenom(rs.getString("prenom"));
                        client.setEmail(rs.getString("email"));
                        client.setTelephone(rs.getString("telephone"));
                        client.setMotDePasse(rs.getString("mot_de_passe"));
                        client.setRole(Role.valueOf(rs.getString("role")));
                        client.setNiveau(Niveau.valueOf(rs.getString("niveau")));
                        client.setBudgetApporte(rs.getInt("budget_apporte"));
                        client.setIdLocalite(rs.getInt("id_localite"));
                        return Optional.of(client); 
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
    }

    @Override
    public List<Client> getAll() {
        try(Connection conn= databaseManager.getConnection(); 
            PreparedStatement stmt= conn.prepareStatement(selectAll)) {
                try (ResultSet rs= stmt.executeQuery()) {
                    List<Client> clients = new ArrayList<>();
                    while (rs.next()) {
                        Client client = new Client();
                        client.setId(rs.getInt("id"));
                        client.setNom(rs.getString("nom"));
                        client.setPrenom(rs.getString("prenom"));
                        client.setEmail(rs.getString("email"));
                        client.setTelephone(rs.getString("telephone"));
                        client.setMotDePasse(rs.getString("mot_de_passe"));
                        client.setRole(Role.valueOf(rs.getString("role")));
                        client.setNiveau(Niveau.valueOf(rs.getString("niveau")));
                        client.setBudgetApporte(rs.getInt("budget_apporte"));
                        client.setIdLocalite(rs.getInt("id_localite"));
                        clients.add(client);
                    }
                    return clients; 
                }
            
        } catch (SQLException e) {
            e.printStackTrace();    
        } 
    }

    @Override
    public void update(int id) {
        try(Connection conn= databaseManager.getConnection(); 
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
        try(Connection conn= databaseManager.getConnection(); 
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
        try (Connection conn = databaseManager.getConnection();
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