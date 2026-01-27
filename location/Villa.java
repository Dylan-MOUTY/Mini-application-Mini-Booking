import java.util.Date;

public class Villa extends Hebergement {

    private double prixSemaine;

    public Villa(String id, int capacite, double prixSemaine) {
        super(id, capacite);
        this.prixSemaine = prixSemaine;
    }

    @Override
    public double calculerPrix(Date debut, Date fin, int nbPersonnes) {
        return prixSemaine + (nbPersonnes * 50);
    }

    @Override
    public void afficherDetails() {
        System.out.println("Villa " + identifiant +
                " | Capacité : " + capacite +
                " | Prix/semaine : " + prixSemaine);
    }

    @Override
    public String getType() {
        return "Villa";
    }
}