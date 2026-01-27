package Utilisateurs;

import location.Reservable;
import java.util.*;

public abstract class Client extends Personne {

    protected String adresse;
    protected Date dateInscription;
    protected List<Reservation> reservations;

    public Client(String nom, String prenom, String email, String adresse) {
        super(nom, prenom, email);
        this.adresse = adresse;
        this.dateInscription = new Date();
        this.reservations = new ArrayList<>();
    }

    // Recherche (simplifiée)
    public void rechercherHebergements(List<Reservable> hebergements) {
        for (Reservable r : hebergements) {
            r.afficherDetails(); // polymorphisme
        }
    }

    public void reserver(Reservable r, Date debut, Date fin, int nbPersonnes) {
        if (r.estDisponible(debut, fin)) {
            r.reserver(this, debut, fin);
            reservations.add(new Reservation(this, r, debut, fin, nbPersonnes));
        }
    }

    public void annulerReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public abstract boolean aReduction();

    public abstract double appliquerReduction(double montant);

    public void afficherFacture(Reservation r) {
        double prix = r.calculerPrix();
        double prixFinal = appliquerReduction(prix);

        System.out.println("Facture pour " + prenom + " " + nom);
        System.out.println("Prix initial : " + prix);
        System.out.println("Prix final : " + prixFinal);
    }

    @Override
    public String getTypePersonne() {
        return "Client";
    }
}