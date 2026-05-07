package com.app.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Depense {

    private Integer idDepense;
    private double montant;
    private String description;
    private LocalDate date;

    public Depense(Integer idDepense, double montant, String description, LocalDate date) {
        this.idDepense = idDepense;
        this.montant = montant;
        this.description = description;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setIdDepense(Integer idDepense) {
        this.idDepense = idDepense;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void afficherDepense() {

        System.out.println("ID : " + idDepense);
        System.out.println("Montant : " + montant);
        System.out.println("Description : " + description);
        System.out.println("Date : " + date);
    }

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