package ServiceImplementation;

import DAO.ClientRepository;
import DAO.ProjetClientRepository;
import DAO.ProjetRepository;
import DAOimplementation.ClientProjetTable;
import DAOimplementation.ClientTable;
import Service.ProjetClientInterface;
import models.ProjetClient;
import models.enums.StatutProjet;

import java.util.List;

public class ProjetClientService implements ProjetClientInterface {
    private ProjetClientRepository projetClientRepository= new ClientProjetTable();


    public ProjetClientService(ClientProjetTable clientProjetTable){
        this.projetClientRepository= clientProjetTable;
    }



    @Override
    public void add(ProjetClient projetClient) {
        projetClientRepository.save(projetClient);
    }

    @Override
    public void changerStatut(int id, StatutProjet statutProjet) {
        projetClientRepository.changerStatut(id, statutProjet);
    }

    @Override
    public List<ProjetClient> getAll() {
        return projetClientRepository.getAll();
    }

    @Override
    public ProjetClient getById(int id) {
        return projetClientRepository.getById(id);
    }
}
