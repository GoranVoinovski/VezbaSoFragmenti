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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by goran on 5.12.17.
 */

public class Fragment4 extends Fragment {

    @BindView(R.id.name)EditText ime;
    @BindView(R.id.lastname)EditText prezime;
    @BindView(R.id.username)EditText uname;
    @BindView(R.id.btn)Button kopce;
    Users userediting = new Users();

    private Unbinder mUnbind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment4,null);

        mUnbind = ButterKnife.bind(this, view);

        Intent prevzemiedit = getActivity().getIntent();
        if (prevzemiedit.hasExtra("Edit")){

        userediting = (Users) prevzemiedit.getSerializableExtra("Edit");
        ime.setText(userediting.getName());
        prezime.setText(userediting.getLastname());
        uname.setText(userediting.getUsername());


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
       userediting.setName(ime.getText().toString());
       userediting.setLastname(prezime.getText().toString());
       userediting.setUsername(uname.getText().toString());
       Intent pratiedit = new Intent();
       pratiedit.putExtra("EditedUser",userediting);
       getActivity().setResult(Activity.RESULT_OK,pratiedit);
       getActivity().finish();




    }
}
