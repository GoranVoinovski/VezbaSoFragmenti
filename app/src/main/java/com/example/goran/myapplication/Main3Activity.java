package com.example.goran.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.textv)TextView txt;
    @BindView(R.id.account)TextView glavenuser;
    @BindView(R.id.spiner)Spinner spinner;
    Users user;
    Users usernow;
    User mainUser;
    ArrayList<Users> useri;
    ArrayAdapter<Users> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);
        useri = new ArrayList<>();

        Intent intentprimi = getIntent();
        if (intentprimi.hasExtra("NovUser")){

           mainUser = (User) intentprimi.getSerializableExtra("NovUserMain");
           useri = mainUser.getUsers();
           glavenuser.setText("Users for the account: " + mainUser.getMail());
           user = (Users) intentprimi.getSerializableExtra("NovUser");
           txt.setText(user.getName() + " " + user.getLastname());
           useri.add(user);

        }else if (intentprimi.hasExtra("Novo")){
            user = new Users();
            useri.add(user);

        }


        adapter = new ArrayAdapter<Users>(this, android.R.layout.simple_list_item_1, useri);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                usernow = adapter.getItem(position);
                txt.setText("Name: " + usernow.getName() + "\nLastname: " + usernow.getLastname());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }

    @OnClick (R.id.add)
    public void AddUser(){

        Intent adduser = new Intent(Main3Activity.this, Main2Activity.class);
        adduser.putExtra("Adding", "Adding");
        startActivityForResult(adduser,1000);



    }

    @OnClick (R.id.edit)
    public void EditUser(){

        Intent edituser = new Intent(Main3Activity.this, Main2Activity.class);
        edituser.putExtra("Edituser", "Edituser");
        edituser.putExtra("Adding", "Adding");
        edituser.putExtra("Edit", usernow);
        startActivityForResult(edituser, 1000);



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1000){
            if (data.hasExtra("AddedUser")){
                Users useradd;
                useradd = (Users) data.getSerializableExtra("AddedUser");
                useri.add(useradd);
                txt.setText(useradd.getName() + " " + useradd.getLastname());
                adapter.notifyDataSetChanged();
            }else if (data.hasExtra("EditedUser")){
                Users edited;
                edited = (Users) data.getSerializableExtra("EditedUser");
                usernow.setName(edited.getName());
                usernow.setLastname(edited.getLastname());
                usernow.setUsername(edited.getUsername());
                adapter.notifyDataSetChanged();



            }




        }
    }
}
