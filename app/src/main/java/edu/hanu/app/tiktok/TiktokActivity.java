package edu.hanu.app.tiktok;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.hanu.app.R;
import edu.hanu.app.tiktok.adapter.AdapterViewPager;

public class TiktokActivity extends AppCompatActivity {

    ViewPager tikTokViewPager;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiktok);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        tikTokViewPager = findViewById(R.id.viewPagerVideo);

        setViewPagerBottomNav();
    }

    private void setViewPagerBottomNav() {

        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tikTokViewPager.setAdapter(adapterViewPager);

        tikTokViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.homeTiktok).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.shopTiktok).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.addTiktok).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.messageTiktok).setChecked(true);
                        break;
                    case 4:
                        bottomNavigationView.getMenu().findItem(R.id.userTikTok).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.homeTiktok:
                        tikTokViewPager.setCurrentItem(0);
                        break;
                    case R.id.shopTiktok:
                        tikTokViewPager.setCurrentItem(1);
                        break;
                    case R.id.addTiktok:
                        tikTokViewPager.setCurrentItem(2);
                        break;
                    case R.id.messageTiktok:
                        tikTokViewPager.setCurrentItem(3);
                        break;
                    case R.id.userTikTok:
                        tikTokViewPager.setCurrentItem(4);
                        break;
                }
                return false;
            }
        });
    }
}
