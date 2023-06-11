package edu.hanu.app.facebook;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import edu.hanu.app.R;
import edu.hanu.app.facebook.adapters.FbAdapterViewPager;
import edu.hanu.app.facebook.fragment.GamingFragment;
import edu.hanu.app.facebook.fragment.HomeFragment;
import edu.hanu.app.facebook.fragment.MarketPlaceFragment;
import edu.hanu.app.facebook.fragment.MenuFragment;
import edu.hanu.app.facebook.fragment.NotificationFragment;
import edu.hanu.app.facebook.fragment.WatchFragment;

public class FacebookActivity extends AppCompatActivity {

    int[] images = {R.drawable.img4, R.drawable.img5, R.drawable.img1, R.drawable.img7};
    FbAdapterViewPager fbAdapterViewPager;
    ViewPager postList;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);


        postList = findViewById(R.id.post_list);
        tabLayout = findViewById(R.id.tabLayoutFb);

        setUpPagerAdapter();

        setUpTabLayout();

    }

    private void setUpPagerAdapter() {
        fbAdapterViewPager = new FbAdapterViewPager(getSupportFragmentManager());
        fbAdapterViewPager.addFragment(new HomeFragment(), "");
        fbAdapterViewPager.addFragment(new WatchFragment(), "");
        fbAdapterViewPager.addFragment(new MarketPlaceFragment(), "");
        fbAdapterViewPager.addFragment(new GamingFragment(), "");
        fbAdapterViewPager.addFragment(new NotificationFragment(), "");
        fbAdapterViewPager.addFragment(new MenuFragment(), "");

        postList.setAdapter(fbAdapterViewPager);
    }
    private void setUpTabLayout() {
        tabLayout.setupWithViewPager(postList);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_watch);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_marketplace);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_gaming);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_notification);
        tabLayout.getTabAt(5).setIcon(R.drawable.ic_baseline_menu_24);

        tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.blue_500), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(4).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(5).getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.blue_500), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}