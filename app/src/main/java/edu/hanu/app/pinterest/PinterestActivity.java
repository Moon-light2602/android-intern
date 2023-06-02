package edu.hanu.app.pinterest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import edu.hanu.app.R;
import edu.hanu.app.pinterest.adapters.MainAdapter;
import edu.hanu.app.pinterest.fragments.CraftFragment;
import edu.hanu.app.pinterest.fragments.FlowersFragment;
import edu.hanu.app.pinterest.fragments.ForYouFragment;
import edu.hanu.app.pinterest.fragments.GirlFragment;
import edu.hanu.app.pinterest.fragments.LapTrinhFragment;
import edu.hanu.app.pinterest.fragments.NgamFragment;
import edu.hanu.app.pinterest.fragments.XinhFragment;;

public class PinterestActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinterest);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        adapter = new MainAdapter(getSupportFragmentManager());

        adapter.AddFragment(new ForYouFragment(), "For You");
        adapter.AddFragment(new NgamFragment(), "Ngẫm");
        adapter.AddFragment(new XinhFragment(), "Xinh");
        adapter.AddFragment(new CraftFragment(), "Craft");
        adapter.AddFragment(new LapTrinhFragment(), "Lập Trình");
        adapter.AddFragment(new GirlFragment(), "Girl");
        adapter.AddFragment(new FlowersFragment(), "Flowers");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}

