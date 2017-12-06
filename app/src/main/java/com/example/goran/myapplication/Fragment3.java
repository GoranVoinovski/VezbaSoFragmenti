package com.example.goran.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by goran on 5.12.17.
 */

public class Fragment3 extends Fragment {

    @BindView(R.id.name)EditText ime;
    @BindView(R.id.lastname)EditText prezime;
    @BindView(R.id.username)EditText uname;
    @BindView(R.id.btn)Button kopce;
    ArrayList<Users> useri;
    private Unbinder mUnbind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment3,null);

        mUnbind = ButterKnife.bind(this, view);
        Intent primi = getActivity().getIntent();
        if (primi.hasExtra("NovMainUser")){

            User usermain = (User) primi.getSerializableExtra("NovMainUser");
            useri = new ArrayList<>();
            useri = usermain.getUsers();


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
        Users user = new Users(myusername, myuserlastname, myuseruname);
        Intent pratinovuser = new Intent(getActivity(), Main3Activity.class);
        pratinovuser.putExtra("NovUser", user);
        startActivity(pratinovuser);



    }
}
