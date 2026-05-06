package com.app.model;
import java.util.ArrayList;
import java.util.List;

public class depense {
    
    private Integer idDepense;
    private double montant;
    private String description;
    private LocalDate date;
    
    public depense(Integer idDepense,double montant,String description,LocalDate date){
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
    
    public void setIdDepense(Integer idDepense){
        this.idDepense = idDepense;
    }
    
    public void setMontant(double montant){
        if(montant >= 0){
            this.montant = montant;
        }else{
            System.out.println("montant negative");
        }
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void afficherDepense(){
        
    System.out.println("ID : " + idDepense);
    System.out.println("Montant : " + montant);
    System.out.println("Description : " + description);
    System.out.println("Date : " + date);
    
  }
}


public class gestionnaireDepense {
    
    private List<depense> listeDeDepense = new ArrayList<>();
    
    public void ajouterDepense(Depense d){
        this.listeDeDepenses.add(d);
        System.out.println("la depense a ete ajouter");
    }
    
    public void supprimierDepense (Integer idRecherche){
        for(int i=0; i < listeDeDepense.size(); i++){
            
            Depense d = listeDeDepense.get(i);
            
            if(d.getIdDepense().equals(idRecherche)){
                
                listeDeDepense.remove(i);
                System.out.println("la depense "+ idRecherche +" a bien ete suprimier");
                return;
            }
        }
        
        System.out.println("depense non trouvé");
    }
    
}
