package Service;

import models.Domaine;

import java.util.List;

public interface DomaineServiceDao {
    public void ajouter(String domaine);
    public void modifier(int id , String domaine);
    public  void supprimer(int id);
    public List<Domaine> afficher();

}
