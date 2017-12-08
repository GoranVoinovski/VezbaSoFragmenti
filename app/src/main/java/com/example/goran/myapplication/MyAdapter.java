package com.example.goran.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by goran on 8.12.17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    Users users;
    List<Users> usersList = new ArrayList<>();

    public void setItems(List<Users> users) {
        usersList = users;
    }

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context1);

        View view = inflater.inflate(R.layout.recycler__view_row, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder holder, final int position) {

        users = usersList.get(position);


        holder.tekst.setText(users.getUsername());
        holder.name.setText(users.getName());
        holder.lastname.setText(users.getLastname());


        if (users.gender == 'M'){

            Picasso.with(context).load("http://www.hjakober.ch/wp-content/uploads/nobody_m_1024x1024.jpg").centerInside().fit().into(holder.slika);

        }else {

            Picasso.with(context).load("http://fie-conference.org/sites/fie-conference.org/files/styles/large/public/placeholder_female1.jpg?itok=PmIExjHS").centerInside().fit().into(holder.slika);

        }

        holder.tekst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users = (Users) usersList.get(position);
                int user = usersList.indexOf(users);
                Activity origin = (Main3Activity) context;
                Intent edituser = new Intent(origin, Main2Activity.class);
                edituser.putExtra("Edituser", "Edituser");
                edituser.putExtra("Adding", "Adding");
                edituser.putExtra("Edit", users);
                edituser.putExtra("Pozicija", user);
                origin.startActivityForResult(edituser, 1000);
            }
        });


    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textv)
        TextView tekst;
        @BindView(R.id.ime)
        TextView name;
        @BindView(R.id.prezime)
        TextView lastname;
        @BindView(R.id.textv2)
        Button tekst2;
        @BindView(R.id.pic)
        ImageView slika;

        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);


        }
    }

}