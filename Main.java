import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Reservable> hebergements = new ArrayList<>();

        hebergements.add(new ChambreHotel("CH1", 2, 80));
        hebergements.add(new Appartement("A1", 4, 120));
        hebergements.add(new Villa("V1", 8, 900));

        Date debut = new Date();
        Date fin = new Date(debut.getTime() + 3 * 24 * 60 * 60 * 1000);

        for (Reservable r : hebergements) {
            r.afficherDetails();
            System.out.println("Prix : " +
                r.calculerPrix(debut, fin, 2));
            System.out.println();
        }
    }
}