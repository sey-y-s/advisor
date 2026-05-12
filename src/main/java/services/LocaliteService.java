package services;
import java.util.List;
import models.Localite;
import repositories.LocaliteRepository;

public class LocaliteService {

        private final LocaliteRepository localiteRepository;

        public LocaliteService(LocaliteRepository localiteRepository) {
            this.localiteRepository = localiteRepository;
        }

        public void addLocalite(Localite localite) {
            try {
                if (localite.getRegionClient() == null || localite.getRegionClient().trim().isEmpty()) {
                    System.out.println("La région du client est obligatoire.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de la validation de la localité : " + e.getMessage());
            }
            localiteRepository.add(localite);
            System.out.println("Localité ajoutée avec succès.");
        }

        public void getLocaliteById(int id) {
            try {
                Localite localite = localiteRepository.getById(id);
                if (localite == null) {
                    System.out.println("Aucune localité trouvée avec l'ID spécifié.");
                } else {
                    System.out.println("Localité trouvée : " + localite.getRegionClient());
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de la récupération de la localité : " + e.getMessage());
            }
        }

        public List<Localite> getAllLocalites() {
            return localiteRepository.getAll();
        }

        public void updateLocalite(int id, String regionClient) {
            localiteRepository.update(id, regionClient);
        }

        public void deleteLocalite(int id) {
            localiteRepository.delete(id);
        }
    }
