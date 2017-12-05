package com.example.goran.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mypager)ViewPager pager;
    @BindView(R.id.mytabs)ViewPager tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setUpViewPager(pager);
    }

    private void setUpViewPager(ViewPager pager) {

        MyPagerAdapter adapter = new MyPagerAdapter(this.getSupportFragmentManager());
        adapter.addFragment(new Fragment1(), "Guest");
        adapter.addFragment(new Fragment1(), "Create User");

        pager.setAdapter(adapter);

    }


}
