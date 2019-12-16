package com.example.final_assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<Info> {
    private Context mContext;
    int mResource;

    public InfoAdapter(@NonNull Context context, int resource, ArrayList<Info> objects) {
        super(context, resource, (ArrayList<Info>) objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String PVM = getItem(position).getPVM();
        String description = getItem(position).getDescription();
        String url = getItem(position).getURL();

        Info info = new Info(name, PVM, description, url);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvNAME = (TextView) convertView.findViewById(R.id.adapter_name);
        TextView tvPVM = (TextView) convertView.findViewById(R.id.adapter_pvm);
        TextView tvURL = (TextView) convertView.findViewById(R.id.adapter_provider);
        TextView tvDESC = (TextView) convertView.findViewById(R.id.adapter_desc);

        tvNAME.setText(name);
        tvPVM.setText(PVM);
        tvURL.setText(url);
        tvDESC.setText(description);

        return convertView;
    }
}
