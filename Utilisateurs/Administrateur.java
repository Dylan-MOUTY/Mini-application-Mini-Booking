package Utilisateurs;

import location.Reservable;
import java.util.List;

public class Administrateur extends Personne {

    public Administrateur(String nom, String prenom) {
        super(nom, prenom);
    }

    public void ajouterHebergement(List<Reservable> hebergements, Reservable r) {
        hebergements.add(r);
    }

    public void supprimerHebergement(List<Reservable> hebergements, Reservable r) {
        hebergements.remove(r);
    }

    public void modifierHebergement(Reservable r) {
        System.out.println("Modification de l'hébergement : " + r.getIdentifiant());
    }

    public void consulterClients(List<Client> clients) {
        for (Client c : clients) {
            System.out.println(c.getPrenom() + " " + c.getNom());
        }
    }

    @Override
    public String getTypePersonne() {
        return "Administrateur";
    }
}