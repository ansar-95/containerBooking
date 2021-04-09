package com.gsb.androfrais.classesMetier;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Bloc {

    private String codeBloc;



    public String getCodeBloc() {
        return codeBloc;
    }

    public Bloc(JSONObject jsonObject){
        try {
            codeBloc = jsonObject.getString("Codebloc");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Bloc> jsonToArrayListObject(JSONArray jsonArray){
        ArrayList<Bloc> collectionBloc = new ArrayList<Bloc>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                collectionBloc.add(new Bloc(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return collectionBloc;
    }





}
