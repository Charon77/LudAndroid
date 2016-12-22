package com.ludandroid.lud;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by richi on 9/18/2016.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter{

    int mNumOfTabs;

    public HomePagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.mNumOfTabs = numOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                TimelineFragment tab1 = new TimelineFragment();
                return tab1;
            case 1:
                TimelineFragment tab2 = new TimelineFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
