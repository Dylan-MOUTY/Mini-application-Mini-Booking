import java.util.Date;

public abstract class Hebergement implements Reservable {

    protected String identifiant;
    protected int capacite;

    public Hebergement(String identifiant, int capacite) {
        this.identifiant = identifiant;
        this.capacite = capacite;
    }

    @Override
    public boolean estDisponible(Date debut, Date fin) {
        return true;
    }

    @Override
    public void reserver(Client c, Date debut, Date fin) {
        System.out.println("Réservation confirmée : " + identifiant);
    }

    @Override
    public void annulerReservation(Client c, Date date) {
        System.out.println("Réservation annulée : " + identifiant);
    }

    @Override
    public boolean estReservee(Date date) {
        return false;
    }

    @Override
    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public int getCapacite() {
        return capacite;
    }
}
