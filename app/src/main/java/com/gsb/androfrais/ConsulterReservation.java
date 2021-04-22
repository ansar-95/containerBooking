package com.gsb.androfrais;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.gsb.androfrais.adapter.ReservationAdapter;

import com.gsb.androfrais.classesMetier.Reservation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ConsulterReservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_reservation);
        initListReservation();

    }

    public void initListReservation()
    {
        final ArrayList<Reservation> collectionReservation= new ArrayList<Reservation>();
        final ReservationAdapter adapter = new ReservationAdapter(this,R.layout.item_reservation,collectionReservation);

        ListView listView = (ListView)findViewById(R.id.listeReservation);
        listView.setAdapter(adapter);


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest sr = new StringRequest(Request.Method.GET,
                "http://ws-stockage.portdebarcelona.cat/api/reservation",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        try {

                             jsonObject = new JSONObject(response);
                            collectionReservation.addAll(Reservation.jsonToArrayListObject(jsonObject.getJSONArray("Reservations")));
                            adapter.addAll(collectionReservation);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    String err = error.getMessage();
                    Log.e("ConsulterReservation", err);
                }
            }) ;//fin stringRequest

            queue.add(sr);


    }





}