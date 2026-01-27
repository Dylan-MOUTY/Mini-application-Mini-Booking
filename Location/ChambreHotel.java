import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChambreHotel extends Hebergement {

    private double prixNuit;

    public ChambreHotel(String id, int capacite, double prixNuit) {
        super(id, capacite);
        this.prixNuit = prixNuit;
    }

    @Override
    public double calculerPrix(LocalDate debut, LocalDate fin, int nbPersonnes) {
        long nuits = ChronoUnit.DAYS.between(debut, fin);
        return nuits * prixNuit;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Chambre d'hôtel " + identifiant +
                " | Capacité : " + capacite +
                " | Prix/nuit : " + prixNuit);
    }

    @Override
    public String getType() { return "ChambreHotel"; }
}