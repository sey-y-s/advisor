package DAO;

import Models.ClientCompetence;

import java.sql.SQLException;
import java.util.List;

public interface ClientCompetenceRepository {

        void add(ClientCompetence clientCompetence);
        List<ClientCompetence> getAll();
        void update(ClientCompetence clientCompetence);
        void delete(int id);
        List<Integer> getSkillsByClient(int idClient) throws SQLException;

}
