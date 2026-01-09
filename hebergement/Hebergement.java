package fr.minibooking.hebergement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.minibooking.reservation.Reservable;
import fr.minibooking.utilisateur.Client;

public abstract class Hebergement implements Reservable, Comparable<Hebergement> {

    protected int id;
    protected String nom;
    protected String adresse;
    protected String type;
    protected int capacite;
    protected double prixParNuit;
    protected String description;

    protected List<String> equipements;
    protected List<Periode> disponibilites;

    protected List<Integer> notes;
    protected double noteMoyenne;

    public Hebergement(int id, String nom, String adresse, String type,
                       int capacite, double prixParNuit, String description) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.capacite = capacite;
        this.prixParNuit = prixParNuit;
        this.description = description;

        this.equipements = new ArrayList<>();
        this.disponibilites = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.noteMoyenne = 0.0;
    }

    /* ================= DISPONIBILITES ================= */

    public void ajouterPeriodeDisponible(Date debut, Date fin) {
        disponibilites.add(new Periode(debut, fin));
    }

    public void supprimerPeriodeDisponible(Date debut, Date fin) {
        disponibilites.removeIf(p ->
                p.getDebut().equals(debut) && p.getFin().equals(fin));
    }

    @Override
    public boolean estDisponible(Date debut, Date fin) {
        for (Periode p : disponibilites) {
            if (p.contient(debut, fin)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean estReservee(Date date) {
        for (Periode p : disponibilites) {
            if (p.contient(date)) {
                return false;
            }
        }
        return true;
    }

    /* ================= PRIX ================= */

    @Override
    public double calculerPrix(Date debut, Date fin, int nbPersonnes) {
        long diff = fin.getTime() - debut.getTime();
        long nuits = diff / (1000 * 60 * 60 * 24);
        return nuits * prixParNuit;
    }

    /* ================= NOTES ================= */

    public void ajouterNote(int note) {
        if (note >= 0 && note <= 5) {
            notes.add(note);
            calculerNoteMoyenne();
        }
    }

    private void calculerNoteMoyenne() {
        int somme = 0;
        for (int n : notes) {
            somme += n;
        }
        noteMoyenne = notes.isEmpty() ? 0 : (double) somme / notes.size();
    }

    public double getNoteMoyenne() {
        return noteMoyenne;
    }

    /* ================= RESERVATION ================= */

    @Override
    public void reserver(Client c, Date debut, Date fin) {
        if (estDisponible(debut, fin)) {
            supprimerPeriodeDisponible(debut, fin);
            System.out.println("Réservation confirmée : " + nom);
        } else {
            System.out.println("Hébergement non disponible");
        }
    }

    @Override
    public void annulerReservation(Client c, Date date) {
        System.out.println("Réservation annulée : " + nom);
    }

    @Override
    public void afficherDetails() {
        System.out.println(this);
    }

    /* ================= COMPARABLE ================= */

    @Override
    public int compareTo(Hebergement h) {
        return Double.compare(this.prixParNuit, h.prixParNuit);
    }

    /* ================= GETTERS ================= */

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getCapacite() {
        return capacite;
    }

    @Override
    public double getPrixParNuit() {
        return prixParNuit;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + nom +
                " | " + adresse +
                " | " + prixParNuit + "€/nuit" +
                " | Capacité : " + capacite +
                " | Note : " + noteMoyenne;
    }
}
