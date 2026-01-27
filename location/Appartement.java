package location;

import hebergement.Hebergement;
import java.util.Date;

public class Appartement extends Hebergement {

    private double prixJour;

    public Appartement(String id, int capacite, double prixJour) {
        super(id, capacite);
        this.prixJour = prixJour;
    }

    @Override
    public double calculerPrix(Date debut, Date fin, int nbPersonnes) {
        long jours = (fin.getTime() - debut.getTime()) / (1000 * 60 * 60 * 24);
        return jours * prixJour * 0.9; // réduction
    }

    @Override
    public void afficherDetails() {
        System.out.println("Appartement " + identifiant +
                " | Capacité : " + capacite +
                " | Prix/jour : " + prixJour);
    }

    @Override
    public String getType() {
        return "Appartement";
    }
}