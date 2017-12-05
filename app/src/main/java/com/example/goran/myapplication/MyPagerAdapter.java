package com.example.goran.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by goran on 5.12.17.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {


    ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    ArrayList<String> titles = new ArrayList<String>();

   public void addFragment (Fragment fragment, String title){
       fragments.add(fragment);
       titles.add(title);

   }

    public MyPagerAdapter(FragmentManager fm) {super(fm);}

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {return titles.get(position);}
}
