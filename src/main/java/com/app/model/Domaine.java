package com.app.model;
public class Domaine{
    private Integer id;
    private String domaine;
    
    
    //Constructeur
    public Domaine(Integer id,String domaine){
        this.id=id;
        this.domaine=doamine;
    }
    //getters
    public getDomaine(String domaine){
        return domaine
    }
    //setters
    public setDomaine(Sring domaine){
        this.domaine=domaine
    }
    //les methodes
    
    public String AjouterDomaine(int id,String domaine){
        System.out.println('Votre domaine est ajouté avec succes')
    }
        
    public String AfficherDomaine(){
        
        System.out.println('Votre domaine est:'+ domaine)
    }
    public String ModifierDomaine(){
       System.out.println('Votre domaine est modifier avec succes')  
    }
    public String SupprimerDomaine(){
          System.out.println('Votre domaine est supprimé avec succes')
        
    }
}
