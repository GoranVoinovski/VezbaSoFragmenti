package com.example.goran.myapplication;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {


    @BindView(R.id.mypager)ViewPager pager;
    @BindView(R.id.mytabs)TabLayout tabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);
        setUpViewPager2(pager);

        Intent proverka = getIntent();
        if (proverka.hasExtra("NovMainUser")){

            pager.setCurrentItem(0);



        }else if (proverka.hasExtra("Edituser")){

            pager.setCurrentItem(1);
        }


    }

    private void setUpViewPager2(ViewPager pager) {

        MyPagerAdapter2 adapter2 = new MyPagerAdapter2(this.getSupportFragmentManager());
        adapter2.addFragment(new Fragment3(),"Add Users");
        adapter2.addFragment(new Fragment4(),"Edit Users");

        pager.setAdapter(adapter2);
    }
}
