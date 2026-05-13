package ServiceImplementation;

import DAO.DepenseRepository;
import models.Depense;

public class DepenseService {
    private DepenseRepository depenseRepository;

    public DepenseService(DepenseRepository depenseRepository) {
        this.depenseRepository = depenseRepository;
    }

    public void addDepense(Depense depense) {
        if (depense.getMontant() <= 0){
            System.out.println("Le montant doit être supérieur à 0.");
            return;
        }
        depenseRepository.add(depense);
    }
    public void deleteDepense(Depense depense) {
        if (depense.getIdDepense() < 0) {
            System.out.println("Le id-depense est obligatoire.");
            return;
        }
        depenseRepository.delete(depense.getIdDepense());
    }
    public void updateDepense(Depense depense) {
        if (depense.getIdDepense() < 0) {
            System.out.println("Le id-depense est obligatoire.");
        }
        depenseRepository.update(depense.getIdDepense());
    }
}
