import com.app.enums.enum_etape;


public class Etape {
    private int idEtape;
    private String titre;
    private String description;    
    
    //Les getters
    public int getIdEtape() {
        return id;
}   
    public String getTitre() {
        return titre;
}       
    public String getDescription() {
        return description;
}       
    public String getStatut() {
        return statut;
}

        
    //Les setters
    public void setIdEtape(int idEtape) {
        this.idEtape = idEtape;
}
    
    public void setTitre(String titre) {
        this.titre = titre;
}

    public void setDescription(String description) {
        this.description = description;
}

    public void setStatut(String statut) {
        this.statut = statut;
}

     
    //Le constructeur
    public Etape(int idEtape, String titre, String description, Statut statut) {
        this.titre = titre;
        this.description = description;
        this.statut = statut;
    }
    
    //Les methodes 
    public void AjouterEtape() {
        System.out.println("Etape ajoutée avec succes");
    }
    
    public void afficherEtape() {
        System.out.println("");
    }
    
    public void ModifierEtape() {
        System.out.println("Etape modifiée avec succes");
    }
    
    public void SupprimerEtape() {
        System.out.println("Etape supprimée avec succes");
    }
    
    public void suivreProgressionGlobale () {
        System.out.println("");
    }
    
    public void totalDepenseEtape () {
        System.out.println("");
    }

}
