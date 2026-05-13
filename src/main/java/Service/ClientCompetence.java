package Service;

import java.util.List;

public class ClientCompetence {

    public interface ClientCompetenceRepository {

        void add(ClientCompetence clientCompetence);

        List<ClientCompetence> getAll();

        void update(ClientCompetence clientCompetence);

        void delete(int id);
}

    }
