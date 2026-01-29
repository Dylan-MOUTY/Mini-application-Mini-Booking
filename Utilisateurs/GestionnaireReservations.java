package Utilisateurs;
import location.*;
import hebergement.*;
import java.util.*;

public class GestionnaireReservations {
    private List<Reservable> hebergements = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    public GestionnaireReservations() {
        hebergements.add(new ChambreHotel("CH1", 2, 80));
        hebergements.add(new ChambreHotel("CH2", 4, 120));
        hebergements.add(new Appartement("A1", 4, 120));
        hebergements.add(new Villa("V1", 8, 900));
    }
    public void afficherHebergements() {
        System.out.println("\n=== HEBERGEMENTS ===");
        for (int i = 0; i < hebergements.size(); i++) {
            System.out.print(i + ". "); hebergements.get(i).afficherDetails();
        }
    }
    public void afficherClients() {
        System.out.println("\n=== CLIENTS ===");
        for (int i = 0; i < clients.size(); i++)
            System.out.println(i + ". " + clients.get(i).getPrenom() + " " + clients.get(i).getNom());
    }
    public void ajouterClient(String n, String p, String a) {
        NouveauClient c = new NouveauClient(n, p, a);
        c.inscription(); clients.add(c);
    }
    public void reserver(int cIdx, int hIdx, int jours, int nb) {
        Client c = clients.get(cIdx);
        Reservable h = hebergements.get(hIdx);
        Date d1 = new Date(), d2 = new Date(d1.getTime() + jours * 86400000L);
        if (h.estDisponible(d1, d2)) {
            c.reserver(h, d1, d2, nb);
            Reservation r = c.reservations.get(c.reservations.size() - 1);
            r.afficherDetails(); c.afficherFacture(r);
        } else System.out.println("Non disponible");
    }
}
