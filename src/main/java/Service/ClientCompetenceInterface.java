package Service;

import Models.ClientCompetence;

import java.util.List;


public interface ClientCompetenceInterface {

    void add(ClientCompetence clientCompetence);

    List<ClientCompetence> getAll();

    void update(ClientCompetence clientCompetence);

    void delete(int id);
}
