package com.gsb.androfrais.classesMetier;


import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Travee {

    public int numTravee;
    private ArrayList<Bloc> listeBloc;


    public ArrayList<Bloc> getListeBloc() {
        return listeBloc;
    }

    public int getNumTravee() {
        return numTravee;
    }


    public Travee(JSONObject jsonObject) {

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
