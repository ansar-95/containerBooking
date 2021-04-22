package com.gsb.androfrais.classesMetier;


import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Travee {

    private int numTravee;
    private Bloc bloc;


    public int getNumTravee() {
        return numTravee;
    }

    public Bloc getBloc() {
        return bloc;
    }



    public Travee(JSONObject jsonObject) {

        try {

            numTravee = jsonObject.getInt("Numtravee");
            bloc = new Bloc(jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public static ArrayList<Travee> jsonToArrayListObject(JSONArray jsonArray){
        ArrayList<Travee> collectionTravee = new ArrayList<Travee>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                collectionTravee.add(new Travee(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return collectionTravee;
    }
}
