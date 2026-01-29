package Utilisateurs;

public class NouveauClient extends Client {

    public NouveauClient(String nom, String prenom, String adresse) {
        super(nom, prenom, adresse);
    }

    public void inscription() {
        System.out.println("Inscription du nouveau client : " + prenom + " " + nom);
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