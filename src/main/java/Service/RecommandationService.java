package Service;

import models.Client;
import models.Projet;

import java.sql.SQLException;
import java.util.List;

public interface RecommandationService {
    List<Projet> suggererProjets(Client client) throws SQLException;
}
