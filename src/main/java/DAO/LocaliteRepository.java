package DAO;
import java.util.List;
import Models.Localite;

public interface LocaliteRepository {
        void add(Localite localite);
        Localite getById(int id);
        List<Localite> getAll();
        void update(int id, String regionClient);
        void delete(int id);
}
