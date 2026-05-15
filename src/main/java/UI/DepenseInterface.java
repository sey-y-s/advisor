package UI;

import ServiceImplementation.DepenseService;
import models.Depense;
import java.util.Date;
import java.util.Scanner;

public class DepenseInterface {
    static Scanner sc = new Scanner(System.in);

    public DepenseInterface(DepenseService depenseService) {
    }


    public Depense saisieDepense (){

        Depense depense = new Depense();
        System.out.println("Montant : ");
        depense.setMontant(sc.nextDouble());
        System.out.println("Description : ");
        depense.setDescription(sc.next());
        //System.out.println("Date (AAAA-MM-JJ) : ");
        //depense.setDate(Date.parse(sc.nextLine()));


        return depense;
    }
    public void AfficherDepense (Depense depense){

        System.out.println("===== les info du Depense N°"+depense.getIdDepense()+" =====");
        System.out.println("Montant : "+depense.getMontant());
        System.out.println("Description : "+depense.getDescription());
        System.out.println("Date : "+depense.getDate());
    }
}
