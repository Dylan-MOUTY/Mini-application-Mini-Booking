import java.util.*;
import java.util.stream.Collectors;

public class CollectionHebergements {

    private ArrayList<Reservable> hebergements;

    public CollectionHebergements() {
        this.hebergements = new ArrayList<>();
    }

    /**
     * Ajoute un hébergement à la collection
     */
    public void ajouter(Reservable h) {
        if (h != null) {
            hebergements.add(h);
        }
    }

    /**
     * Recherche par capacité minimale
     */
    public List<Reservable> rechercherParCapaciteMin(int capaciteMin) {
        return hebergements.stream()
                .filter(h -> h.getCapacite() >= capaciteMin)
                .collect(Collectors.toList());
    }

    /**
     * Recherche par type d'hébergement
     */
    public List<Reservable> rechercherParType(String type) {
        return hebergements.stream()
                .filter(h -> h.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    /**
     * Recherche par disponibilité
     */
    public List<Reservable> rechercherDisponibles(Date debut, Date fin) {
        return hebergements.stream()
                .filter(h -> h.estDisponible(debut, fin))
                .collect(Collectors.toList());
    }

    /**
     * Recherche par identifiant
     */
    public Reservable rechercherParIdentifiant(String id) {
        return hebergements.stream()
                .filter(h -> h.getIdentifiant().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Suppression d'un hébergement
     */
    public void supprimer(Reservable h) {
        hebergements.remove(h);
    }

    /**
     * Accès à la collection complète
     */
    public List<Reservable> getHebergements() {
        return new ArrayList<>(hebergements);
    }

    /**
     * Affiche tous les hébergements
     */
    public void afficherTous() {
        for (Reservable h : hebergements) {
            h.afficherDetails();
        }
    }
}
