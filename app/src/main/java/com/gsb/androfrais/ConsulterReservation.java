package com.gsb.androfrais;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gsb.androfrais.adapter.BlocAdapter;
import com.gsb.androfrais.classesMetier.Bloc;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConsulterReservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_reservation);


        initListBloc();




    }

    public void initListBloc()
    {


        final ArrayList<Bloc> collectionBloc = new ArrayList<Bloc>();
        final BlocAdapter adapter = new BlocAdapter(this,R.layout.item_bloc,collectionBloc);

        ListView listView = (ListView)findViewById(R.id.listeBloc);
        listView.setAdapter(adapter);


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        String url ="http://ws-stockage.portdebarcelona.cat/api/bloc";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            adapter.addAll(Bloc.jsonToArrayListObject(jsonObject.getJSONArray("Blocs")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String err = error.getMessage();
                Log.e("ConsulterFicheFrais", err);

            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }



}