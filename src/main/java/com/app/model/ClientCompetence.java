public class ClientCompetence{
     private competence idcompetence;
     private client idclient;
     
    
     //Les getters
    public int getIdCompetence() {
        return idcompetence;
}

    public int getIdclient() {
        return idclient;
}

//Concstructeur

    public ClientCompetence(competence idcompetence, client idclient) {
        this.idClient = idClient;
        this.idcompetence = idcompetence;
        
    }
}