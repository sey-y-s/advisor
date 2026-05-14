package ServiceImplementation;

import java.util.List;
import java.util.Optional;

import DAO.DomaineClientRepository;
import Service.DomaineClientService;
import models.DomaineClient;

public class DomaineClientServiceImpl implements DomaineClientService {

    private final DomaineClientRepository domaineClientRepository;

    public DomaineClientServiceImpl(DomaineClientRepository domaineClientRepository) {
        this.domaineClientRepository = domaineClientRepository;
    }

    @Override
    public void add(DomaineClient domaineClient) {

        if (domaineClient == null) {
            System.out.println("DomaineClient est requis.");
            return;
        }

        if (domaineClient.getIdClient() == null || domaineClient.getIdClient() <= 0) {
            System.out.println("idClient invalide.");
            return;
        }

        if (domaineClient.getIdDomaine() == null || domaineClient.getIdDomaine() <= 0) {
            System.out.println("idDomaine invalide.");
            return;
        }

        if (domaineClientRepository.exists(
                domaineClient.getIdClient(),
                domaineClient.getIdDomaine())) {

            System.out.println("Ce domaine est déjà associé à ce client.");
            return;
        }

        domaineClientRepository.add(domaineClient);

        System.out.println("Association DomaineClient ajoutée avec succès.");
    }

    @Override
    public Optional<DomaineClient> getById(int id) {

        if (id <= 0) {
            System.out.println("ID invalide.");
            return Optional.empty();
        }

        return domaineClientRepository.getById(id);
    }

    @Override
    public List<DomaineClient> getAll() {
        return domaineClientRepository.getAll();
    }

    @Override
    public void delete(int id) {

        if (id <= 0) {
            System.out.println("ID invalide.");
            return;
        }

        domaineClientRepository.delete(id);

        System.out.println("Association DomaineClient supprimée.");
    }
}