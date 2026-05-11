package com.app.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Depense {

    private Integer idDepense;
    private double montant;
    private String description;
    private Date date;
    private Activite activite;

    public Depense(Integer idDepense, double montant, String description, Date date,Activite activite) {
        this.idDepense = idDepense;
        this.montant = montant;
        this.description = description;
        this.date = date;
        this.activite=activite;
    }

    public Integer getIdDepense() {
        return idDepense;
    }

    public double getMontant() {
        return montant;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }
    public Activite getActivite(){
        return activite;
    }

    public void setMontant(double montant) {
        if (montant >= 0) {
            this.montant = montant;
        } else {
            System.out.println("montant negatif");
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setActivite(Activite activite){
        this.activite=activite;
    }
    public void setDate(Date date) {
        this.date = date;
    }

     
    public void afficherDepense() {

        System.out.println("ID : " + idDepense);
        System.out.println("Montant : " + montant);
        System.out.println("Description : " + description);
        System.out.println("Date : " + date);
    }


    // TODO : Implémenter ces méthodes dans les services

    private List<Depense> listeDeDepense = new ArrayList<>();

    public void ajouterDepense(Depense d) {
        this.listeDeDepense.add(d);
        System.out.println("la depense a ete ajoutee");
    }

    public void supprimerDepense(Integer idRecherche) {

        for (int i = 0; i < listeDeDepense.size(); i++) {

            Depense d = listeDeDepense.get(i);

            if (d.getIdDepense().equals(idRecherche)) {

                listeDeDepense.remove(i);
                System.out.println("la depense " + idRecherche + " a bien ete supprimee");
                return;
            }
        }

        System.out.println("depense non trouvee");
    }
}