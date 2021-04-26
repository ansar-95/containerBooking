package com.gsb.androfrais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gsb.androfrais.classesMetier.Reservation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class ReservationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_detail);

        Intent intent = getIntent();
        String str = "";
        if (intent != null){

            if (intent.hasExtra("idReservation")){
                str = intent.getStringExtra("idReservation");
            }

        }

        initReservation(str);
    }

    private  void initReservation(String id){


        final TextView numerodeReservation =  (TextView) findViewById(R.id.numerodeReservation);
        final TextView debutDeReservation = (TextView)findViewById(R.id.debutDeReservation);
        final TextView debutDeStockage = (TextView)findViewById(R.id.debutDeStockage);
        final TextView quantite = (TextView)findViewById(R.id.quantiteContainer);
        final TextView etat = (TextView)findViewById(R.id.etatContainer);


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest sr = new StringRequest(Request.Method.GET,
                "https://217.167.171.231/ws-zstockage/public/index.php/api/reservation/"+id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonObject = null;
                        try {

                            jsonObject = new JSONObject(response);
                            JSONArray collectionReservation = jsonObject.getJSONArray("Reservations");
                            JSONObject reservationJSONObject = collectionReservation.getJSONObject(0);
                            Reservation reservation = new Reservation(reservationJSONObject);
                            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

                            numerodeReservation.setText(Integer.toString(reservation.getId()));
                            debutDeReservation.setText(dateFormat.format(reservation.getDateReservation()));
                            debutDeStockage.setText(dateFormat.format(reservation.getDatePrevueStockage()));
                            quantite.setText(Integer.toString(reservation.getQuantite()));
                            etat.setText(reservation.getEtat());



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

    public void supprimer(View aView){
        final TextView numerodeReservation =  (TextView) findViewById(R.id.numerodeReservation);


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest sr = new StringRequest(Request.Method.DELETE,
                "https://217.167.171.231/ws-zstockage/public/index.php/api/reservation/"+numerodeReservation.getText(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject deleted = null;
                        try {

                            deleted = new JSONObject(response);
                            boolean state = deleted.getBoolean("isDeleted");
                            if (state) {
                                Intent myIntent = new Intent(ReservationDetailActivity.this, ConsulterReservation.class);
                                startActivity(myIntent);
                            }

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

    public void miseajour(View aView){

        final TextView numerodeReservation =  (TextView) findViewById(R.id.numerodeReservation);
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest sr = new StringRequest(Request.Method.PUT,
                "https://217.167.171.231/ws-zstockage/public/index.php/api/reservation/"+numerodeReservation.getText(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject updated = null;
                        try {

                            updated = new JSONObject(response);
                            boolean state = updated.getBoolean("isUpdated");
                            if (state) {
                                Intent myIntent = new Intent(ReservationDetailActivity.this, HomeActivty.class);
                                startActivity(myIntent);
                            }


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