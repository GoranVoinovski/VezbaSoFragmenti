package com.example.goran.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by goran on 5.12.17.
 */

public class Fragment3 extends Fragment {

    @BindView(R.id.slika)ImageView img;
    @BindView(R.id.name)EditText ime;
    @BindView(R.id.lastname)EditText prezime;
    @BindView(R.id.username)EditText uname;
    @BindView(R.id.btn)Button kopce;
    @BindView(R.id.rbm)
    RadioButton male;
    @BindView(R.id.rbf)
    RadioButton female;
    char pol = 'M';
    User usermain;
    ArrayList<Users> useri;
    String kopceopcija = "";
    private Unbinder mUnbind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment3,null);
        mUnbind = ButterKnife.bind(this, view);

        Picasso.with(getActivity()).load(R.drawable.husky).fit().centerInside().into(img);

        Intent primi = getActivity().getIntent();
        if (primi.hasExtra("NovMainUser")){

            usermain = (User) primi.getSerializableExtra("NovMainUser");
            useri = new ArrayList<>();
            useri = usermain.getUsers();


        }else if (primi.hasExtra("Adding")){

            kopceopcija = "Adding";
        }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }



    @OnClick (R.id.btn)
    public void KlikKreiraj(){
        String myusername = ime.getText().toString();
        String myuserlastname = prezime.getText().toString();
        String myuseruname = uname.getText().toString();
        if (male.isChecked()) {
            pol = 'M';
            male.setChecked(true);
        } else {
            pol = 'F';
            female.setChecked(true);
        }

        Users user = new Users(myusername, myuserlastname, myuseruname, pol);

        if (myusername.isEmpty() || myuserlastname.isEmpty() || myuseruname.isEmpty()){

            if (myusername.isEmpty()){ime.setError("Enter your name");}
            else if (myuserlastname.isEmpty()){prezime.setError("Enter your lastname");}
            else {uname.setError("Enter your username");}

        }else {

            if (kopceopcija.equals("Adding")){
                Intent intent = new Intent();
                intent.putExtra("AddedUser", user);
                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();




            }else {
                Intent pratinovuser = new Intent(getActivity(), Main3Activity.class);
                pratinovuser.putExtra("NovUser", user);
                pratinovuser.putExtra("NovUserMain", usermain);
                startActivity(pratinovuser);

            }

        }



    }
}
