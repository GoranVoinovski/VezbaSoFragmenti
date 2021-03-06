package com.example.goran.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by goran on 5.12.17.
 */

public class Fragment2 extends Fragment {


    @BindView(R.id.edtmail)EditText mail;
    @BindView(R.id.edtpass)EditText pass;
    private Unbinder mUnbind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2, null);
        mUnbind = ButterKnife.bind(this, view);




        return view;
    }

    @OnClick (R.id.btn)
    public void KlikNajava(){


        String posta = mail.getText().toString();
        String lozinka = pass.getText().toString();
        boolean validna =  isEmailValid(posta);
        if (posta.isEmpty() || lozinka.isEmpty() || !validna){

            if (posta.isEmpty() || !validna){
                mail.setError("Enter your email");
            }else{
                pass.setError("Enter your password");

            }


        }else {
            ArrayList<Users> user = new ArrayList<>();
            User usermain = new User(posta, lozinka, user);
            Intent novusermain = new Intent(getActivity(), Main2Activity.class);
            novusermain.putExtra("NovMainUser", usermain);
            startActivity(novusermain);
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }


    boolean isEmailValid(String email) {

        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();


    }



}
