package UI;

import models.Depense;
import java.util.Scanner;

public class DepenseInterface {
    static Scanner sc = new Scanner(System.in);

    public Depense saisieDepense (){

        Depense depense = new Depense();
        System.out.println("Montant : ");
        depense.setMontant(sc.nextDouble());
        System.out.println("Description : ");
        depense.setDescription(sc.next());

        return depense;
    }
}
