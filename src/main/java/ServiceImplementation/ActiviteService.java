package ServiceImplementation;

import DAO.ActiviteRepository;
import Service.ActiviteServiceDao;
import models.Activite;
import models.enums.StatutEtape;

import java.util.List;

public class ActiviteService implements ActiviteServiceDao {
    public final ActiviteRepository activiteRepository;

    public ActiviteService(ActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    @Override
    public void ajouterActivite(Activite activite) {
        if (activite.getTitre() == null || activite.getTitre().trim().isEmpty()){
            System.out.println("Entrez correctement le titre s'il vous plaît !");
            return;
        }
        if (activite.getDescription() == null || activite.getDescription().trim().isEmpty()){
            System.out.println("Veuillez entrez une description valide de l'activité merci ! ");
            return;
        }
        if (activite.getDuree() <= 0) {
            System.out.println("Durée invalide, la durée de l'activité ne peut être négative !");
            return;
        }
        //if (activite.getEtape().getIdEtape() <= 0){
            //System.out.println("L'id de l'étape doit être supérieur à 0 !");
            //return;
        //}
        activiteRepository.add(activite);
        System.out.println("Activité ajoutée ! ");

    }

    @Override
    public List<Activite> afficherActivite() {
        return activiteRepository.getAll();
    }

    @Override
    public void marqueTermine(int id) {
        Activite activite = activiteRepository.getById(id);
        if (id <= 0){
            System.out.println("L'id de l'activité doit être supérieur à 0 !");
            return;
        }
        if (activite == null){
            System.out.println("Activité introuvable ! ");
            return;
        }
        activiteRepository.update(id, StatutEtape.TERMINE);
        System.out.println("Activité marquée comme terminée ! ");
    }

    @Override
    public void supprimerActivite(int id) {
        Activite activite = activiteRepository.getById(id);
        if (id <= 0){
            System.out.println("L'id un incorrecte ! ");
            return;
        }
        if (activite == null){
            System.out.println("Activité introuvable ! ");
            return;
        }
        activiteRepository.delete(id);
        System.out.println("Activité supprimée ! ");

    }
}
