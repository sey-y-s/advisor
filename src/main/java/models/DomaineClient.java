package models;

public class DomaineClient {

    private Integer id;
    private Integer idClient;
    private Integer idDomaine;

    public DomaineClient() {
    }

    public DomaineClient(Integer idClient, Integer idDomaine) {
        this.idClient = idClient;
        this.idDomaine = idDomaine;
    }

    public DomaineClient(Integer id, Integer idClient, Integer idDomaine) {
        this.id = id;
        this.idClient = idClient;
        this.idDomaine = idDomaine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Integer idDomaine) {
        this.idDomaine = idDomaine;
    }
}

