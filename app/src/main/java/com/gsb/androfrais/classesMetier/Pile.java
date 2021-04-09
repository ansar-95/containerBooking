package com.gsb.androfrais.classesMetier;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pile {

    private int numPile;
    private ArrayList<Travee> listeTravee;
    private int capacite;

    public int getNumPile() {
        return numPile;
    }

    public ArrayList<Travee> getListeTravee() {
        return listeTravee;
    }

    public int getCapacite() {
        return capacite;
    }

    public Pile(JSONObject jsonObject)
    {
        try {
            JSONArray collectionTravees = jsonObject.getJSONArray("Travees");

            for (int i = 0; i < collectionTravees.length(); i++) {
                JSONObject ligne = null;
                try {
                    ligne = collectionTravees.getJSONObject(i);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(i == 0){
                    numTravee = ligne.optInt("numTravee");
                }

                listeBloc.add(new Bloc(ligne));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    }

}
