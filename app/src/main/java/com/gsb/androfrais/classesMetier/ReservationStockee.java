package com.gsb.androfrais.classesMetier;

import java.util.ArrayList;
import java.util.Date;

public class ReservationStockee {

    private Reservation uneReservation;
    private ArrayList<Pile> listePile;
    private int emplacementDepart;
    private int quantite;
    private Date dateDebutEffective;
    private Date dateFinEffective;

    public Reservation getUneReservation() {
        return uneReservation;
    }

    public ArrayList<Pile> getListePile() {
        return listePile;
    }

    public int getEmplacementDepart() {
        return emplacementDepart;
    }

    public int getQuantite() {
        return quantite;
    }

    public Date getDateDebutEffective() {
        return dateDebutEffective;
    }

    public Date getDateFinEffective() {
        return dateFinEffective;
    }
}
