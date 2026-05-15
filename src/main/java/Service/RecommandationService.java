package Service;

import Models.Client;
import Models.Projet;

import java.sql.SQLException;
import java.util.List;

public interface RecommandationService {
    List<Projet> suggererProjets(Client client) throws SQLException;
}
