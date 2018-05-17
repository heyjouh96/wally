package com.example.jonathan.wally;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Jonathan on 17/05/2018.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter {

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    public String horarios(int position){
        switch (position){
            case 1: return "19:00";
            case 2: return "19:50";
            case 3: return "20:40";
            case 4: return "21:30";
            default: return "erro";
        }
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new HorariosFragment();
        Bundle bundle = new Bundle();
        bundle.putString("horario", horarios(position+1));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
