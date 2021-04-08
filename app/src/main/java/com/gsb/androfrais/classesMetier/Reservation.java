package com.gsb.androfrais.classesMetier;

import java.util.Date;

public class Reservation {
    private int id;
    private Date dateReservation;
    private Date datePrevueStockage;
    private int nbJoursStockagePrevue;
    private int quantite;
    private String etat;
    private Utilisateur client;


    public int getId() {
        return id;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public Date getDatePrevueStockage() {
        return datePrevueStockage;
    }

    public int getNbJoursStockagePrevue() {
        return nbJoursStockagePrevue;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getEtat() {
        return etat;
    }

    public Utilisateur getClient() {
        return client;
    }
}
