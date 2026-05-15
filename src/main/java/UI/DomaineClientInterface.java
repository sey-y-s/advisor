package UI;

import java.util.List;
import java.util.Scanner;

import Models.Client;
import Models.DomaineClient;
import Models.Domaine;
import ServiceImplementation.ClientService;
import ServiceImplementation.DomaineClientService;

import java.lang.Integer;


/**
 * Interface console (style Scanner + sélection) pour créer une association DomaineClient.
 * <p>
 * IMPORTANT : dans ton projet actuel, il n'existe pas encore de DomaineService.
 * Donc cette interface nécessite que tu me fournisse/ajoutes une méthode pour récupérer
 * la liste des {@link Domaine}.
 * </p>
 */
public class DomaineClientInterface {

    private static final Scanner clavier = new Scanner(System.in);

    private final ClientService clientService;
    private final DomaineClientService domaineClientService;

    public DomaineClientInterface(ClientService clientService, DomaineClientService domaineClientService) {
        this.clientService = clientService;
        this.domaineClientService = domaineClientService;
    }

  
    public DomaineClient saisir(List<Domaine> domaines) {
        Client client = choisirClient();
        Domaine domaine = choisirDomaine(domaines);


        // On suppose que l'UI utilisera seulement le texte du domaine et l'association se fera par idDomaine.
        // Donc pour l'instant, on demande directement idDomaine à l'utilisateur.
        System.out.print("Entrez idDomaine: ");
        int idDomaine = Integer.parseInt(clavier.nextLine());

        DomaineClient dc = new DomaineClient(null, client.getIdUtilisateur(), idDomaine);
        return dc;
    }

    private Client choisirClient() {


        System.out.print("Entrez idClient: ");
        int idClient = Integer.parseInt(clavier.nextLine());

        Client c = new Client();
        c.setIdUtilisateur(idClient);
        return c;
    }

    private Domaine choisirDomaine(List<Domaine> domaines) {
        if (domaines == null || domaines.isEmpty()) {
            System.out.println("Aucun domaine disponible.");
            return new Domaine(null, null);
        }

        System.out.println("=========== Liste des domaines ===========");
        for (int i = 0; i < domaines.size(); i++) {
            Domaine d = domaines.get(i);
            // Domaine n'expose pas getId() dans ton modèle actuel.
            System.out.println((i + 1) + " = " + d.getDomaine());
        }

        int choix;
        do {
            System.out.print("Choisissez un domaine (1.." + domaines.size() + "): ");
            choix = Integer.parseInt(clavier.nextLine());
        } while (choix < 1 || choix > domaines.size());

        return domaines.get(choix - 1);
    }

    public void ajouterAssociation(List<Domaine> domaines) {
        DomaineClient dc = saisir(domaines);
        domaineClientService.add(dc);
    }
}

