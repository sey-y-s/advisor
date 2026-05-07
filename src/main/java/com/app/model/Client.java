package com.app.model;
import com.app.enums.Niveau;
import com.app.model.Utilisateur;
public class Client extends Utilisateur {

    private Niveau niveau= Niveau.DEBUTANT;
    private int budgetApporte; 
    private int idLocalite; 

   
    public Client(Integer id, String nom, String prenom, String email, String motDePasse, Niveau niveau, int budgetApporte, int idLocalite, int telephone, Role role) {
        super(id, nom, prenom, email, motDePasse, telephone, role);
        this.niveau = niveau;
        this.budgetApporte = budgetApporte;
        this.idLocalite = idLocalite;
    }
    
    public void setNiveau(Niveau niveau){
        this.niveau= niveau;
    }
    
     public int getBudgetApporte(){
        return budgetApporte;
    }
    
    public void setBudgetApporte(int budgetApporte){
        this.budgetApporte = budgetApporte;
    }

    public int getIdLocalite(){
        return idLocalite;
    }
    
    public void setIdLocalite(int idlocalite){
        this.idLocalite = idlocalite;
    }
}