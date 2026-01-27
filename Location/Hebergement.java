public abstract class Hebergement implements Reservable {
    protected String identifiant;
    protected int capacite;

    public Hebergement(String identifiant, int capacite) {
        this.identifiant = identifiant;
        this.capacite = capacite;
    }

    @Override public String getIdentifiant() { return identifiant; }
    @Override public int getCapacite() { return capacite; }
}