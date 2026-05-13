package models;

import java.util.PrimitiveIterator;

public class Commentaire {
    private Integer id;
    private String messaage;
    private Integer idEtape;
    private Integer idClient;

    //Constructeurs
    public Commentaire(){}

    public Commentaire(Integer id, String messaage, Integer idEtape, Integer idClient){
        this.id = id;
        this.messaage = messaage;
        this.idEtape = idEtape;
        this.idClient = idClient;
    }


    //Getters setters
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getMessaage(){
        return this.messaage;
    }

    public void setMessaage(String messaage) {
        this.messaage = messaage;
    }
    public Integer getIdEtape(){
        return this.idEtape;
    }

    public void setIdEtape(Integer idEtape) {
        this.idEtape = idEtape;
    }
    public Integer getIdClient(){
        return this.idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return ("ID" +id + "message = " +messaage + "ID étape =" +idEtape + "ID client = " +idClient);
    }
}
