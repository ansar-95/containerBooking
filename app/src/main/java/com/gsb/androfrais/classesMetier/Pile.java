package com.gsb.androfrais.classesMetier;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pile {

    private Integer numPile;
    private Travee travee;
    private int capacite;

    public int getNumPile() {
        return numPile;
    }

    public Travee getTravee() {
        return travee;
    }

    public int getCapacite() {
        return capacite;
    }

    public Pile(JSONObject jsonObject)
    {
        try {
            numPile = jsonObject.getInt("NumPile");
            travee = new Travee(jsonObject);
            capacite = jsonObject.getInt("capacite");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Pile> jsonToArrayListObject(JSONArray jsonArray){
        ArrayList<Pile> collectionPile = new ArrayList<Pile>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                collectionPile.add(new Pile(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return collectionPile;
    }






}
