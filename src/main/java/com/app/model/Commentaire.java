package com.app.model;

public class Commentaire {
    private Integer id;
    private String message;
    private Etape etape; // Relation

    public Commentaire(Integer id, String message, Etape etape) {
        this.id = id;
        this.message = message;
        this.etape = etape;
    }

    // Getters et Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Etape getEtape() { return etape; }
    public void setEtape(Etape etape) { this.etape = etape; }
}

