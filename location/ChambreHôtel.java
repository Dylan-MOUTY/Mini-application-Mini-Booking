public class ChambreHotel extends Hebergement {

    private double prixParNuit;

    public ChambreHotel(String id, int capacite, double prixParNuit) {
        super(id, capacite);
        this.prixParNuit = prixParNuit;
    }

    @Override
    public double calculerPrix(Date debut, Date fin, int nbPersonnes) {
        long nbNuits = (fin.getTime() - debut.getTime()) / (1000 * 60 * 60 * 24);
        return nbNuits * prixParNuit;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Chambre d'hôtel " + identifiant +
                " | Capacité : " + capacite +
                " | Prix/nuit : " + prixParNuit);
    }

    @Override
    public String getType() {
        return "ChambreHotel";
    }
}