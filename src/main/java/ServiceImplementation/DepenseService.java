package ServiceImplementation;

import DAO.DepenseRepository;
import Service.DepenseServiceDao;
import Models.Depense;

import java.util.List;
import java.util.Optional;

public class DepenseService implements DepenseServiceDao {
    private DepenseRepository depenseRepository;

    public DepenseService(DepenseRepository depenseRepository) {
        this.depenseRepository = depenseRepository;
    }

    @Override
    public void add(Depense depense) {
        if (depense.getMontant() <= 0){
            System.out.println("Le montant doit être supérieur à 0.");
            return;
        }
        depenseRepository.add(depense);
    }

    @Override
    public Optional<Depense> getById(int id) {
        if (id < 0) {
            System.out.println("Le id-depense est obligatoire.");
        }
        depenseRepository.getById(id);
        return Optional.empty();
    }

    @Override
    public List<Depense> getAll() {
        return depenseRepository.getAll();
    }

    @Override
    public void update(int id) {
        if (id < 0) {
            System.out.println("Le id-depense est obligatoire.");
        }
        depenseRepository.update(id);
    }

    @Override
    public void delete(int id) {
        if (id < 0) {
            System.out.println("Le id-depense est obligatoire.");
            return;
        }
        depenseRepository.delete(id);
    }
}
