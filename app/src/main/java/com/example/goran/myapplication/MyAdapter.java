package com.example.goran.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

    public void setItems (List<Users> users) {
        usersList = users;
    }

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context1 = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context1);

        View view = inflater.inflate(R.layout.recycler__view_row,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {

        users = usersList.get(position);

        holder.tekst.setText(users.getUsername());

        holder.tekst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity origin = (Main3Activity)context;
                Intent edituser = new Intent(origin, Main2Activity.class);
                edituser.putExtra("Edituser", "Edituser");
                edituser.putExtra("Adding", "Adding");
                edituser.putExtra("Edit", users);
                origin.startActivityForResult(edituser, 1000);
            }
        });



    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textv)TextView tekst;
        @BindView(R.id.textv2)Button tekst2;

        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);



        }
    }

    @OnClick(R.id.textv2)
    public void EditUser(){





    }
}
