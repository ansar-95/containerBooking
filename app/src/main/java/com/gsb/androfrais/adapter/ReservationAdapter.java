package com.gsb.androfrais.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gsb.androfrais.R;
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

        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.GREEN);
        } else {
            convertView.setBackgroundColor(Color.MAGENTA);
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
        tvid.setText(idReservation);
        tvdateReservation.setText(dateReservation);
        tvdatePrevueStockage.setText(datePrevueStockage);
        tvnbJoursStockagePrevu.setText(nbJours);
        tvquantite.setText(quantite);
        tvetat.setText(reservation.getEtat());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), reservation.getEtat(), Toast.LENGTH_SHORT).show();
            }
        });




        return convertView;

    }


}
