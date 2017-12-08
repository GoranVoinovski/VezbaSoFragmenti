package com.example.goran.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    @BindView(R.id.account)TextView glavenuser;
    @BindView(R.id.textv)RecyclerView myView;
    char pol;
    Users user;
    User mainUser;
    ArrayList<Users> useri;

    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ButterKnife.bind(this);
        useri = new ArrayList<>();

        adapter = new MyAdapter(this);
        adapter.setItems(useri);
        myView.setHasFixedSize(true);
        myView.setLayoutManager(new LinearLayoutManager(this));


        Intent intentprimi = getIntent();
        if (intentprimi.hasExtra("NovUser")) {

            mainUser = (User) intentprimi.getSerializableExtra("NovUserMain");
            glavenuser.setText("Users for the account: " + mainUser.getMail());
            user = (Users) intentprimi.getSerializableExtra("NovUser");
            useri.add(user);


        } else if (intentprimi.hasExtra("Novo")) {
            user = new Users();
            useri.add(user);

        }

        myView.setAdapter(adapter);

    }

    @OnClick (R.id.add)
    public void AddUser(){

        Intent adduser = new Intent(Main3Activity.this, Main2Activity.class);
        adduser.putExtra("Adding", "Addwrap_contenting");
        startActivityForResult(adduser,1000);



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1000){
            if (data.hasExtra("AddedUser")){
                user = new Users();
                user = (Users) data.getSerializableExtra("AddedUser");
                useri.add(user);
                adapter.notifyDataSetChanged();

            }else if (data.hasExtra("EditedUser")){
                Users edited;
                edited = (Users) data.getSerializableExtra("EditedUser");
               int userpoz = data.getIntExtra("Pozicija",0);
                user = useri.get(userpoz);
                useri.remove(user);
                useri.add(userpoz, edited);
                adapter.notifyDataSetChanged();



            }



        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);
    }

         ArrayList<Users> generateList() {


            return useri;
    }


}
