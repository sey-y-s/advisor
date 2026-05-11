package com.app.model;

//DÉCLARATION DE LA CLASSE
public class Projet {
    private Integer idProjet;
    private String titre;
    private String description;
    private Domaine domaine;
    private float duree;
    private int budget;
    
    //RELATIONS AVEC AUTRES CLASSES
    private Client client;
    // private List<Etape> etapes = new ArrayList<>();
    
    
    // CONSTRUCTEUR
    public Projet(String titre, String description,
    Domaine domaine, float duree, int budget, Client client) { 
        this.titre = titre; 
        this.description = description; 
        this.domaine = domaine; 
        this.duree = duree; 
        this.budget = budget; 
        this.client = client;
   }
    
    // public void ajouterEtape(Etape etape) {
    //     this.etapes.add(etape);
    // }
   
   // AFFICHER LE PROJET
    public void afficherProjet() { 
        System.out.println("ID Projet : " + idProjet); 
        System.out.println("Titre : " + titre); 
        System.out.println("Description : " + description); 
        System.out.println("Durée : " + duree + " mois"); 
        System.out.println("Budget : " + budget + " FCFA");
   }
   
   //MODIFIER LE PROJET
    public void modifierProjet(String titre, String description, float duree, int budget) {
        this.titre = titre;
        this.description = description;
        this.duree = duree;
        this.budget = budget;
   }
   
   //SUPPRIMER LE PROJET 
    public void supprimerProjet() { 
        System.out.println("Projet supprimé : " + titre); 
        
   }
   
   // GETTER
    public Integer getIdProjet() {
        return idProjet;
    }
    public String getTitre() { 
        return titre; 
        
    } 
    public String getDescription() {
        return description;
    }
    public float getDuree() {
        return duree;
    }
    public int getBudget() { 
        return budget; 
        
    } 
    public Client getClient() {
        return client;   
    } 
    public Domaine getDomaine() {
        return domaine;   
    } 

        // public void afficherEtapes() {
        //     for (Etape etape : etapes) { 
                
        //         etape.afficherEtapes(); 
                
        //     }
        // }
        
        // SETTER
        
        public void setIdProjet(Integer idProjet) {
            this.idProjet = idProjet;
        }
        public void setTitre(String titre) { 
            this.titre = titre; 
            
        }
        public void setDescription(String description) {
            this.description = description; 
            
        }
        public void setDuree(float duree) {
            this.duree = duree; 
            
        }
        public void setBudget(int budget) {
            this.budget = budget; 
            
        }
        public void setClient(Client client) {
            this.client = client;
        }
        public void setDomaine(Domaine domaine) {
            this.domaine = domaine;
        }
    }