package edu.hanu.app.messenger;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import edu.hanu.app.R;
import edu.hanu.app.messenger.adpaters.ViewPagerAdapter;

public class MessengerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final int FRAGMENT_CHATS = 0;
    private static final int FRAGMENT_CALLS = 1;
    private static final int FRAGMENT_PEOPLE = 2;
    private static final int FRAGMENT_STORIES = 3;

    private DrawerLayout drawerLayout;
    private int currentFragment = FRAGMENT_CHATS;
    private TabLayout tabLayout;
    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager2;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager2 = findViewById(R.id.view_pager_2);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);

        bottomNavigationView = findViewById(R.id.bottom_messenger);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().findItem(R.id.bottom_chats).setChecked(true);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case FRAGMENT_CHATS:
                        currentFragment = FRAGMENT_CHATS;
                        navigationView.getMenu().findItem(R.id.bottom_chats).setChecked(true);
                        bottomNavigationView.getMenu().findItem(R.id.bottom_chats).setChecked(true);
                        break;
                    case FRAGMENT_CALLS:
                        currentFragment = FRAGMENT_CALLS;
                        bottomNavigationView.getMenu().findItem(R.id.bottom_calls).setChecked(true);
                        break;
                    case FRAGMENT_PEOPLE:
                        currentFragment = FRAGMENT_PEOPLE;
                        bottomNavigationView.getMenu().findItem(R.id.bottom_people).setChecked(true);
                        break;
                    case FRAGMENT_STORIES:
                        currentFragment = FRAGMENT_STORIES;
                        bottomNavigationView.getMenu().findItem(R.id.bottom_stories).setChecked(true);
                        break;
                }
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.bottom_chats:
                        viewPager2.setCurrentItem(FRAGMENT_CHATS);
                        break;
                    case R.id.bottom_calls:
                        viewPager2.setCurrentItem(FRAGMENT_CALLS);
                        break;
                    case R.id.bottom_people:
                        viewPager2.setCurrentItem(FRAGMENT_PEOPLE);
                        break;
                    case R.id.bottom_stories:
                        viewPager2.setCurrentItem(FRAGMENT_STORIES);
                        break;
                }
                setTitleToolBar();
                return true;
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.bottom_chats:
                viewPager2.setCurrentItem(FRAGMENT_CHATS);
                break;
            case R.id.bottom_calls:
                viewPager2.setCurrentItem(FRAGMENT_CALLS);
                break;
            case R.id.bottom_people:
                viewPager2.setCurrentItem(FRAGMENT_PEOPLE);
                break;
            case R.id.bottom_stories:
                viewPager2.setCurrentItem(FRAGMENT_STORIES);
                break;

        }
        setTitleToolBar();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
}

    private void setTitleToolBar() {
        String title = "";
        switch (currentFragment) {
            case 0:
                title = getString(R.string.bottom_chats);
                break;
            case 1:
                title = getString(R.string.bottom_calls);
                break;
            case 2:
                title = getString(R.string.bottom_people);
                break;
            case 3:
                title = getString(R.string.bottom_stories);
                break;
        }

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}

