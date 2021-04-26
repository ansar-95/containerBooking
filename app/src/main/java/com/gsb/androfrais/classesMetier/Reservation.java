package com.gsb.androfrais.classesMetier;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.ClientInfoStatus;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public Reservation (JSONObject jsonObject)
    {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
            id = jsonObject.getInt("Id");

            try {

                dateReservation = formatter.parse(jsonObject.getString("Datereservation"));
                datePrevueStockage = formatter.parse(jsonObject.getString("Dateprevuestockage"));

            } catch (ParseException e){
                e.printStackTrace();
            }
            nbJoursStockagePrevue = jsonObject.getInt("Nbjoursdestockageprevu");
            quantite = jsonObject.getInt("Quantite");
            etat = jsonObject.getString("Etat");
            client =  new Utilisateur(jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Reservation> jsonToArrayListObject(JSONArray jsonArray){
        ArrayList<Reservation> collectionReservation = new ArrayList<Reservation>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                collectionReservation.add(new Reservation(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return collectionReservation;
    }

}
