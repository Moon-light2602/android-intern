package edu.hanu.app.instagram;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import edu.hanu.app.R;
import edu.hanu.app.instagram.adapter.AdapterViewPager;
import edu.hanu.app.instagram.fragment.HomeFragment;

public class InstagramActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);

        bottomNavigationView = findViewById(R.id.bottomNav);
        viewPager2 = findViewById(R.id.instagram_view_pager);

        setUpViewPagerWithBottomNav();

    }

    private void setUpViewPagerWithBottomNav() {
        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new SearchFragment());
        fragmentArrayList.add(new AddFragment());
        fragmentArrayList.add(new ChatFragment());
        fragmentArrayList.add(new AvatarFragment());

        AdapterViewPager instagramAdapterViewPager = new AdapterViewPager(this, fragmentArrayList);
        viewPager2.setAdapter(instagramAdapterViewPager);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.search);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.add);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.chat);
                        break;
                    case 4:
                        bottomNavigationView.setSelectedItemId(R.id.avatar);
                        break;
                }
                super.onPageSelected(position);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    viewPager2.setCurrentItem(0);
                    break;
                case R.id.search:
                    viewPager2.setCurrentItem(1);
                    break;
                case R.id.add:
                    viewPager2.setCurrentItem(2);
                    break;
                case R.id.chat:
                    viewPager2.setCurrentItem(3);
                    break;
                case R.id.avatar:
                    viewPager2.setCurrentItem(4);
                    break;

            }
            return true;
        });
    }
}