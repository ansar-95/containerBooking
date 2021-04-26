package com.gsb.androfrais.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gsb.androfrais.R;
import com.gsb.androfrais.ReservationDetailActivity;
import com.gsb.androfrais.classesMetier.Reservation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ReservationAdapter extends ArrayAdapter<Reservation> {

    public ReservationAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Reservation> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Reservation reservation = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_reservation, parent, false);
        }



        TextView tvid = (TextView) convertView.findViewById(R.id.idReservation);
        TextView tvdateReservation = (TextView) convertView.findViewById(R.id.dateReservation);
        TextView tvdatePrevueStockage = (TextView) convertView.findViewById(R.id.datePrevueStockage);
        TextView tvnbJoursStockagePrevu = (TextView) convertView.findViewById(R.id.nbJoursStockagePrevu);
        TextView tvquantite = (TextView) convertView.findViewById(R.id.quantite);
        TextView tvetat = (TextView) convertView.findViewById(R.id.etat);


        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String idReservation = Integer.toString(reservation.getId());
        String dateReservation = dateFormat.format(reservation.getDateReservation());
        String datePrevueStockage = dateFormat.format(reservation.getDatePrevueStockage());
        String nbJours = Integer.toString(reservation.getNbJoursStockagePrevue());
        String quantite = Integer.toString(reservation.getQuantite());

        tvid.setText("Id Reservation : " + idReservation);
        tvdateReservation.setText("Date de Reservation : " + dateReservation);
        tvdatePrevueStockage.setText("Date début de stockage : " + datePrevueStockage);
//        tvnbJoursStockagePrevu.setText(nbJours);
//        tvquantite.setText(quantite);
//        tvetat.setText(reservation.getEtat());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ReservationDetailActivity.class);
                intent.putExtra("idReservation", idReservation);
                getContext().startActivity(intent);
            }
        });




        return convertView;

    }


}
