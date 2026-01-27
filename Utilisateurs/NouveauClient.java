package Utilisateurs;

public class NouveauClient extends Client {

    private String motDePasse;

    public NouveauClient(String nom, String prenom, String email,
                         String adresse, String motDePasse) {
        super(nom, prenom, email, adresse);
        this.motDePasse = motDePasse;
    }

    public void inscription() {
        System.out.println("Inscription du nouveau client : " + email);
    }

    @Override
    public boolean aReduction() {
        return false;
    }

    @Override
    public double appliquerReduction(double montant) {
        return montant;
    }

    @Override
    public String getTypePersonne() {
        return "NouveauClient";
    }
}