import java.util.Optional;

import com.app.model.Client;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService (ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Client client) {
        try {
            if(clientRepository.existsByEmail(client.getEmail())) {
                System.out.println("Un client avec cet email existe déjà.");
                return;
            }
            else if(!client.getEmail().contains("@")) {
                System.out.println("Email invalide.");
                return;
            }
            else if(client.getNom() == null || client.getNom().trim().isEmpty() || client.getPrenom() == null || client.getPrenom().trim().isEmpty() || client.getTelephone() == null || client.getTelephone().trim().isEmpty() || client.getMotDePasse() == null || client.getMotDePasse().trim().isEmpty()) {
                System.out.println("Le nom, le prénom, le téléphone et le mot de passe du client sont obligatoires.");
                return;
            }
            else if(client.getBudgetApporte() < 0) {
                System.out.println("Le budget apporté ne peut pas être négatif.");
                return;
            } 
        } catch (Exception e) {
            System.out.println("Erreur lors de la validation du client : " + e.getMessage());
        }
        clientRepository.add(client);
        System.out.println("Client ajouté avec succès.");
    }

    public Optional<Client> getClientById(int id) {
        try {
            Optional<Client> clientOpt = clientRepository.getById(id);
            if (clientOpt.isEmpty()) {
                System.out.println("Aucun client trouvé avec l'ID spécifié.");
            } else {
                System.out.println("Client trouvé : " + clientOpt.get().getNom() + " " + clientOpt.get().getPrenom());
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération du client : " + e.getMessage());

        }
        return clientRepository.getById(id);
    }

    public List<Client> getAllClients() {
        return clientRepository.getAll();
    }
    public void updateClient(int id) {
        clientRepository.update(id);
    
    }
    public int deleteClient(int id) {
        return clientRepository.delete(id);
    
    }
    public boolean clientExistsByEmail(String email) {
        return clientRepository.existsByEmail(email);
    }
}
