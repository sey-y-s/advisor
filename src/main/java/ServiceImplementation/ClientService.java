package ServiceImplementation;
import java.util.List;
import java.util.Optional;

import DAO.ClientRepository;
import Models.Client;
import Models.enums.Niveau;


public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService (ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public boolean addClient(Client client) {
        try {
            if(clientRepository.existsByEmail(client.getEmail())) {
                System.out.println("Un client avec cet email existe déjà.");
                return false;
            }
            else if(client.getEmail() != null && !client.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                System.out.println("Email invalide.");
                return false;
            }
            else if(client.getNom() == null || client.getNom().trim().isEmpty() || client.getPrenom() == null || client.getPrenom().trim().isEmpty() || client.getTelephone() == null || client.getMotDePasse()==null || client.getMotDePasse().trim().isEmpty() || client.getLocalite()==null) {
                System.out.println("Le nom, le prénom, le téléphone et le mot de passe du client sont obligatoires.");
                return false;
            }
            return clientRepository.add(client);
        } catch (Exception e) {
            System.out.println("Erreur lors de la validation du client : " + e.getMessage());
        }
        return false;
    }

    public Optional<Client> getClientById(int id) {
        return clientRepository.getById(id);
    }

    public List<Client> getAllClients() {
        return  clientRepository.getAll();
    }

    public boolean updateClient(int id, String nom, String prenom, String telephone, Niveau niveau , int idlocalite, int budget) {
        if(nom.isEmpty() ||  prenom.isEmpty()  ||  telephone.isEmpty() ||  niveau.name().isEmpty() ){
            System.out.println("Remplissez correctement les champs!!!");
            return false;
        }
        if(budget<100000){
            System.out.println("Le budget ne pas peut être inferieur a 100.000 F");
        }
        return clientRepository.update(id, nom, prenom, telephone, niveau, idlocalite, budget);
    }

    public boolean deleteClient(int id) {
        return clientRepository.delete(id);
    }

    public boolean clientExistsByEmail(String email) {
        return clientRepository.existsByEmail(email);
    }

}
