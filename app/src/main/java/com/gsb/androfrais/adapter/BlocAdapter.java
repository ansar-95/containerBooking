package com.gsb.androfrais.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gsb.androfrais.R;
import com.gsb.androfrais.classesMetier.Bloc;

import java.util.ArrayList;

public class BlocAdapter extends ArrayAdapter<Bloc> {

    public BlocAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Bloc> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Bloc ficheBloc = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_bloc, parent, false);
        }
        if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.GREEN);
        } else {
            convertView.setBackgroundColor(Color.MAGENTA);
        }

        TextView codeBloc = (TextView) convertView.findViewById(R.id.codeBloc);
        codeBloc.setText(ficheBloc.getCodeBloc());

        return convertView;

    }

}
