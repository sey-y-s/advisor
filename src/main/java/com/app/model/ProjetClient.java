
package com.app.model;
import java.util.Date;

public enum Statut {
    Afaire, EnCours, Termine
}

public enum Satisfaction {
    TresInsatisfait, Insatisfait, Neutre, Satisfait, TresSatisfait
}

public class ProjetClient {
    private Integer id;
    private Client client; // Relation
    private Projet projet; // Relation
    private Date debut;
    private Date fin;
    private Statut statut;
    private Satisfaction satisfaction;

    public ProjetClient(Integer id, Client client, Projet projet, Date debut, Date fin, Statut statut, Satisfaction satisfaction) {
        this.id = id;
        this.client = client;
        this.projet = projet;
        this.debut = debut;
        this.fin = fin;
        this.statut = statut;
        this.satisfaction = satisfaction;
    }

    // Getters et Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Projet getProjet() { return projet; }
    public void setProjet(Projet projet) { this.projet = projet; }

    public Date getDebut() { return debut; }
    public void setDebut(Date debut) { this.debut = debut; }

    public Date getFin() { return fin; }
    public void setFin(Date fin) { this.fin = fin; }

    public Statut getStatut() { return statut; }
    public void setStatut(Statut statut) { this.statut = statut; }

    public Satisfaction getSatisfaction() { return satisfaction; }
    public void setSatisfaction(Satisfaction satisfaction) { this.satisfaction = satisfaction; }
}