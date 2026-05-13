package DAO;

import models.ClientCompetence;

import java.util.List;

public interface ClientCompetenceRepository {

        void add(ClientCompetence clientCompetence);
        List<ClientCompetence> getAll();
        void update(ClientCompetence clientCompetence);
        void delete(int id);

}
