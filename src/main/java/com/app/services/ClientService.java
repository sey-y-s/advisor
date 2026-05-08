package com.app.services;
import java.util.*;
import com.app.tables.*;
import com.app.model.Client;

public class ClientService {
    private final ClientTable clientTable;

    public ClientService (ClientTable clientTable) {
        this.clientTable = clientTable;  
    }

    public void addClient(Client client) {
        try {
            if(clientTable.existsByEmail(client.getEmail())) {
                System.out.println("Un client avec cet email existe déjà.");
                return;
            }
            else if(client.getEmail() != null && !client.getEmail().contains("@")) {
                System.out.println("Email invalide.");
                return;
            }
            else if(client.getNom() == null || client.getNom().trim().isEmpty() || client.getPrenom() == null || client.getPrenom().trim().isEmpty() || client.getTelephone() == null  || client.getMotDePasse() == "" || client.getMotDePasse().trim().isEmpty()) {
                System.out.println("Le nom, le prénom, le téléphone et le mot de passe du client sont obligatoires.");
                return;
            }
            else if(client.getBudgetApporte() < 0) {
                System.out.println("Le budget apporté ne peut pas être négatif.");
                return;
            } 
            clientTable.add(client);
            System.out.println("Client ajouté avec succès.");
        } catch (Exception e) {
            System.out.println("Erreur lors de la validation du client : " + e.getMessage());
        }
        
    }

    public void getClientById(int id) {
        try {
            Optional<Client> clientOpt = clientTable.getById(id);
            if (clientOpt.isEmpty()) {
                System.out.println("Aucun client trouvé avec l'ID spécifié.");
            } else {
                System.out.println("Client trouvé : " + clientOpt.get().getNom() + " " + clientOpt.get().getPrenom());
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération du client : " + e.getMessage());

        }
    }

    public void getAllClients() {
        List<Client> clients = clientTable.getAll();
        if(clients.size()==0){
            System.out.println("Il n'y a pas de clients enregistré !!!");
            return;
        } 
        for(Client client : clients){
            System.out.printf("%s %s dans la localité de %s. Tel: %s", client.getNom(), client.getPrenom(), client.getLocalite().getRegionClient(), client.getTelephone());
        }
    }
    public void updateClient(int id) {
          clientTable.update(id);
        }
    
    public void deleteClient(int id) {
       clientTable.delete(id);
    
    }
    public boolean clientExistsByEmail(String email) {
        return clientTable.existsByEmail(email);
    }
}


