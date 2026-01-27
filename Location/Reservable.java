import java.time.LocalDate;

public interface Reservable {
    double calculerPrix(LocalDate debut, LocalDate fin, int nbPersonnes);
    void afficherDetails();
    String getIdentifiant();
    String getType();
    int getCapacite();
}