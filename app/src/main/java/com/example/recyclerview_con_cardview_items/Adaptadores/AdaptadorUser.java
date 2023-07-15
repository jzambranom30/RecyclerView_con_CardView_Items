package com.example.recyclerview_con_cardview_items.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerview_con_cardview_items.Modelos.User;
import com.example.recyclerview_con_cardview_items.R;

import java.util.ArrayList;

public class AdaptadorUser extends ArrayAdapter<User> {

    public AdaptadorUser(Context context, ArrayList<User> data){
        super(context, R.layout.ly_items_users, data);
    }

    public View getView(int position, View convertView,  ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.ly_items_users,   null);

        TextView lblName = (TextView) view.findViewById(R.id.lblNames);
        lblName.setText("Nombre: " + getItem(position).getName());

        TextView lblEmail = (TextView) view.findViewById(R.id.lblEmail);
        lblEmail.setText("Email: " + getItem(position).getEmail());

        TextView lblPhone = (TextView) view.findViewById(R.id.lblPhone);
        lblPhone.setText("Teléfono: " + getItem(position).getPhone());

        TextView lblUniversity = (TextView) view.findViewById(R.id.lblUniversity);
        lblUniversity.setText("Universidad: " + getItem(position).getUniversity());

        ImageView imgUser = (ImageView) view.findViewById(R.id.imgUser);
        Glide.with(this.getContext()).load(getItem(position).getImage()).into(imgUser);

        return (view);
    }
}
