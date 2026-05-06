

public class Client extends Utilisateur {

    private Niveau niveau= Niveau.DEBUTANT;
    private int budgetApporte; 
    private int idLocalite; 
    
    public Niveau getNiveau(){
        return niveau;
    }
    
    public void setNiveau(Niveau niveau){
        this.niveau= niveau;
    }
    
     public int getBudgetApporte(){
        return budgetApporte;
    }
    
    public void setBudgetApporte(int budgetApporte){
        this.budgetApporte= budgetApporte;
    }

    public int getIdLocalite(){
        return idLocalite;
    }
    
    public void setIdLocalite(int idlocalite){
        this.idLocalite = idlocalite;
    }
}