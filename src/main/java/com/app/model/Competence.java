package com.app.model;

public class Competence {
    private Integer id;
    private String nom;

    public Competence(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Competence(String nom) {
        this.nom = nom;
    }

    // Getters et Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}