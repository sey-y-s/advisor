Public Class Domaine{
    Private Integer id;
    Private String domaine;
    
    //Constructeur
    Public Domaine(Integer id,String domaine){
        this.id=id;
        this.domaine=doamine;
    }
    //getters
    Public getDomaine(String domaine){
        return domaine
    }
    //setters
    Public setDomaine(Sring domaine){
        this.domaine=domaine
    }
    //les methodes
    
    Public AjouterDomaine(int id,String domaine){
        System.out.println('Votre domaine est ajouté avec succes')
    }
        
     Public AfficherDomaine(){
        
        System.out.println('Votre domaine est:'+ domaine)
    }
     Public ModifierDomaine(){
       System.out.println('Votre domaine est modifier avec succes')  
    }
     Public SupprimerDomaine(){
          System.out.println('Votre domaine est supprimé avec succes')
        
    }
}
