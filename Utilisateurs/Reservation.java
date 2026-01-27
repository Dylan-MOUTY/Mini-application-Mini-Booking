package Utilisateurs;

import location.Reservable;
import java.util.Date;

public class Reservation {
    private Client client;
    private Reservable hebergement;
    private Date debut;
    private Date fin;
    private int nbPersonnes;

    public Reservation(Client client, Reservable hebergement, Date debut, Date fin, int nbPersonnes) {
        this.client = client;
        this.hebergement = hebergement;
        this.debut = debut;
        this.fin = fin;
        this.nbPersonnes = nbPersonnes;
    }

    public double calculerPrix() {
        return hebergement.calculerPrix(debut, fin, nbPersonnes);
    }

    public Client getClient() {
        return client;
    }

    public Reservable getHebergement() {
        return hebergement;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }
}
