package location;

import Utilisateurs.Client;
import java.util.Date;

public interface Reservable {

    boolean estDisponible(Date debut, Date fin);

    double calculerPrix(Date debut, Date fin, int nbPersonnes);

    void reserver(Client c, Date debut, Date fin);

    void annulerReservation(Client c, Date date);

    boolean estReservee(Date date);

    void afficherDetails();

    String getIdentifiant();
    String getType();
    int getCapacite();
}