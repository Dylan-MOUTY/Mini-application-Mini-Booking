package fr.minibooking.hebergement;

import java.util.Date;

public class Periode {

    private Date debut;
    private Date fin;

    public Periode(Date debut, Date fin) {
        this.debut = debut;
        this.fin = fin;
    }

    public boolean contient(Date date) {
        return !date.before(debut) && !date.after(fin);
    }

    public boolean contient(Date d1, Date d2) {
        return !d1.before(debut) && !d2.after(fin);
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }
}