package Utilisateurs;

import location.Reservable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Reservation {
    private Client client;
    private Reservable hebergement;
    private Date debut, fin, dateReservation;
    private int nbPersonnes;
    private String statut;

    public Reservation(Client client, Reservable hebergement, Date debut, Date fin, int nbPersonnes) {
        this.client = client;
        this.hebergement = hebergement;
        this.debut = debut;
        this.fin = fin;
        this.nbPersonnes = nbPersonnes;
        this.statut = "Confirmée";
        this.dateReservation = new Date();
    }

    public double calculerPrix() {
        return hebergement.calculerPrix(debut, fin, nbPersonnes);
    }

    public void afficherDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("=== RESERVATION ===");
        System.out.println("Client: " + client.getPrenom() + " " + client.getNom());
        System.out.println("Hébergement: " + hebergement.getType() + " - " + hebergement.getIdentifiant());
        System.out.println("Date réservation: " + sdf.format(dateReservation));
        System.out.println("Du " + sdf.format(debut) + " au " + sdf.format(fin));
        System.out.println("Nb personnes: " + nbPersonnes);
        System.out.println("Prix: " + calculerPrix() + " €");
        System.out.println("Statut: " + statut);
        System.out.println("==================");
    }

    public void annuler() {
        this.statut = "Annulée";
        hebergement.annulerReservation(client, debut);
    }

    public Client getClient() { return client; }
    public Reservable getHebergement() { return hebergement; }
    public Date getDebut() { return debut; }
    public Date getFin() { return fin; }
}
