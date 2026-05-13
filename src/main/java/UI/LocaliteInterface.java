package UI;

import ServiceImplementation.LocaliteService;
import models.Localite;

import java.util.List;
import java.util.Scanner;

public class LocaliteInterface {
    static Scanner clavier= new Scanner(System.in);
    private LocaliteService localiteService;

    public LocaliteInterface(LocaliteService localiteService){
        this.localiteService= localiteService;
    }


    public Localite choisirLocalite(){
        List<Localite> localites= localiteService.getAllLocalites();
        if(localites == null || localites.isEmpty()){
            System.out.println("Il n'y a aucune localité enregistré !!!");
        }
        System.out.println("=========== Liste des localités ===========");
        for (int i=0; i<localites.size(); i++){
            System.out.println(i+1 + " = "+ localites.get(i).getRegionClient());
        }
        int choix;
        System.out.println("Choisissez!!!!!!!");
        choix= clavier.nextInt();
        do {
            System.out.println("Entrez le bon numéro");
        } while (choix<1 || choix>localites.size());

        return localites.get(choix - 1);
    }
}
