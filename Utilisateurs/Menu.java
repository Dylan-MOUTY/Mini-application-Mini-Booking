package Utilisateurs;
import java.util.*;

public class Menu {
    private GestionnaireReservations g;
    private Scanner s;

    public Menu() { g = new GestionnaireReservations(); s = new Scanner(System.in); }

    public void demarrer() {
        int c;
        do {
            System.out.println("\n=== MINI-BOOKING ===\n1. Hébergements\n2. Créer client");
            System.out.println("3. Réserver\n4. Voir clients\n0. Quitter");
            System.out.print("Choix: "); c = s.nextInt(); s.nextLine();
            if (c == 1) g.afficherHebergements();
            else if (c == 2) { System.out.print("Nom: "); String n = s.nextLine();
                System.out.print("Prénom: "); String p = s.nextLine();
                System.out.print("Adresse: "); String a = s.nextLine();
                g.ajouterClient(n, p, a);
            } else if (c == 3) { g.afficherClients();
                System.out.print("Client #: "); int cl = s.nextInt();
                g.afficherHebergements();
                System.out.print("Hébergement #: "); int h = s.nextInt();
                System.out.print("Jours: "); int j = s.nextInt();
                System.out.print("Personnes: "); int pe = s.nextInt();
                g.reserver(cl, h, j, pe);
            } else if (c == 4) g.afficherClients();
            else if (c == 0) System.out.println("Au revoir!");
        } while (c != 0);
    }
}
