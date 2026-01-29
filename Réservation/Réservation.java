import java.util.*;

public class Reservation {

    private Long id;
    private Client client;
    private Reservable reservable;
    private Date dateArrivee;
    private Date dateDepart;
    private int nbPersonnes;
    private double prixTotal;
    private Date dateCreation;

    public Reservation(Client client, Reservable reservable,
                       Date dateArrivee, Date dateDepart, int nbPersonnes) {
        this.client = client;
        this.reservable = reservable;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.nbPersonnes = nbPersonnes;
        this.dateCreation = new Date();
        this.prixTotal = calculerPrix();
    }

    /**
     * Calcul du prix total selon l'hébergement et les paramètres
     */
    public double calculerPrix() {
        return reservable.calculerPrix(dateArrivee, dateDepart, nbPersonnes);
    }

    /**
     * Vérifie si la réservation est en cours
     */
    public boolean estEnCours() {
        Date aujourdHui = new Date();
        return aujourdHui.after(dateArrivee) && aujourdHui.before(dateDepart);
    }

    /**
     * Annule la réservation
     */
    public void annuler() {
        client.annulerReservation(this);
    }

    // Getters
    public Client getClient() {
        return client;
    }

    public Reservable getReservable() {
        return reservable;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public Date getDateCreation() {
        return dateCreation;
    }
}
