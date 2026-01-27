public class AncienClient extends Client {

    public AncienClient(String nom, String prenom, String email, String adresse) {
        super(nom, prenom, email, adresse);
    }

    public void seConnecter() {
        System.out.println("Connexion de l'ancien client : " + email);
    }

    @Override
    public boolean aReduction() {
        return reservations.size() >= 5;
    }

    @Override
    public double appliquerReduction(double montant) {
        if (aReduction()) {
            return montant * 0.9; // -10%
        }
        return montant;
    }

    @Override
    public String getTypePersonne() {
        return "AncienClient";
    }
}