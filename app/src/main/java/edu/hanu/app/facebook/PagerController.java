package edu.hanu.app.facebook;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import edu.hanu.app.facebook.fragment.GamingFragment;
import edu.hanu.app.facebook.fragment.HomeFragment;
import edu.hanu.app.facebook.fragment.MarketPlaceFragment;
import edu.hanu.app.facebook.fragment.MenuFragment;
import edu.hanu.app.facebook.fragment.NotificationFragment;
import edu.hanu.app.facebook.fragment.WatchFragment;

public class PagerController extends FragmentPagerAdapter {

    int numTabs;

    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new WatchFragment();
            case 2:
                return new MarketPlaceFragment();
            case 3:
                return new GamingFragment();
            case 4:
                return  new NotificationFragment();
            case 5:
                return new MenuFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
