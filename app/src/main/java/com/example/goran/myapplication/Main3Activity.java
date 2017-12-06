package com.example.goran.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.textv)TextView txt;
    @BindView(R.id.spiner)Spinner spinner;
    Users user;
    User mainUser;
    ArrayList<Users> useri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);

        Intent intentprimi = getIntent();
        if (intentprimi.hasExtra("NovUser")){

           mainUser = (User) intentprimi.getSerializableExtra("NovUserMain");
           useri = new ArrayList<>();
           useri = mainUser.getUsers();
           user = (Users) intentprimi.getSerializableExtra("NovUser");
           txt.setText(user.getName() + " " + user.getLastname());
           useri.add(user);

        }


        ArrayAdapter<Users> adapter = new ArrayAdapter<Users>(this, android.R.layout.simple_list_item_1, useri);
        spinner.setAdapter(adapter);
    }
}
