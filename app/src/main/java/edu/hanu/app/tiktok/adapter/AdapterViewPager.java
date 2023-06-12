package edu.hanu.app.tiktok.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import edu.hanu.app.tiktok.fragments.CommentFragment;
import edu.hanu.app.tiktok.fragments.CreateFragment;
import edu.hanu.app.tiktok.fragments.HomeFragment;
import edu.hanu.app.tiktok.fragments.InformationFragment;
import edu.hanu.app.tiktok.fragments.ShopFragment;

public class AdapterViewPager extends FragmentStatePagerAdapter {
    ArrayList<Fragment> arrayList;

    public AdapterViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new HomeFragment();
            case 1: return new ShopFragment();
            case 2: return new CreateFragment();
            case 3: return new CommentFragment();
            case 4: return new InformationFragment();
            default: return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
