package com.app.model;

import com.app.enums.Niveau;
import com.app.enums.Role;

public class Client extends Utilisateur {

    private Niveau niveau = Niveau.DEBUTANT;
    private int budgetApporte;
    private Localite localite;

    public Client() {

    }

    public Client(String nom, String prenom, String email, String motDePasse, Niveau niveau, int budgetApporte,
            Localite localite, int telephone, Role role) {
        super(nom, prenom, email, motDePasse, telephone, role);
        this.niveau = niveau;
        this.budgetApporte = budgetApporte;
        this.localite = localite;

    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public int getBudgetApporte() {
        return budgetApporte;
    }

    public void setBudgetApporte(int budgetApporte) {
        this.budgetApporte = budgetApporte;
    }

    // public int getIdLocalite(){
    // return idLocalite;
    // }

    // public void setIdLocalite(int idlocalite){
    // this.idLocalite = idlocalite;
    // }

    public Localite getLocalite() {
        return localite;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }

}