package com.example.goran.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by goran on 5.12.17.
 */

public class Fragment1 extends Fragment {

@BindView(R.id.slika)ImageView img;
    private Unbinder mUnbind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1,null);

        mUnbind = ButterKnife.bind(this, view);

        Picasso.with(getActivity()).load(R.drawable.husky).fit().centerInside().into(img);

        return view;
    }

    @OnClick (R.id.btn)
    public void KlikGuest(){
        Intent intent = new Intent(getActivity(), Main3Activity.class);
        intent.putExtra("Novo","Novo");
        startActivity(intent);



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
    }
}
