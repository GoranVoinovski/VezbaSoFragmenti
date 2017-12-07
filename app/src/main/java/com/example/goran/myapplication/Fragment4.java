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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by goran on 5.12.17.
 */

public class Fragment4 extends Fragment {

    @BindView(R.id.slika)ImageView img;
    @BindView(R.id.name)EditText ime;
    @BindView(R.id.lastname)EditText prezime;
    @BindView(R.id.username)EditText uname;
    @BindView(R.id.btn)Button kopce;
    @BindView(R.id.rbm)
    RadioButton male;
    @BindView(R.id.rbf)
    RadioButton female;
    Users userediting = new Users();
    int imeuser = 0;
    char pol;

    private Unbinder mUnbind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment4,null);
        mUnbind = ButterKnife.bind(this, view);

        Picasso.with(getActivity()).load(R.drawable.husky).fit().centerInside().into(img);

        Intent prevzemiedit = getActivity().getIntent();
        if (prevzemiedit.hasExtra("Edit")){

        userediting = (Users) prevzemiedit.getSerializableExtra("Edit");
        imeuser = userediting.getName().length();
        ime.setText(userediting.getName());
        prezime.setText(userediting.getLastname());
        uname.setText(userediting.getUsername());
        pol = userediting.getGender();
            if (pol == 'M') {
                male.setChecked(true);
            } else {
                female.setChecked(true);
            }


        }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }


    @OnClick (R.id.btn)
    public void EditBtn(){

        if (imeuser > 0){

       if (ime.length() < 1 || prezime.length() < 1 || uname.length() < 1){

           if (ime.length() < 1){ime.setError("Error in user editing");}
           else if (prezime.length() < 1){prezime.setError("Error in user editing");}
           else {uname.setError("Error in user editing");}



       }else {
           userediting.setName(ime.getText().toString());
           userediting.setLastname(prezime.getText().toString());
           userediting.setUsername(uname.getText().toString());
           if (male.isChecked()) {
               pol = 'M';
           } else {
               pol = 'F';
           }
           userediting.setGender(pol);
           Intent pratiedit = new Intent();
           pratiedit.putExtra("EditedUser",userediting);
           getActivity().setResult(Activity.RESULT_OK,pratiedit);
           getActivity().finish();
       }
        }else {

        kopce.setError("there is no such user to be edited");

        }




    }
}
