package edu.hanu.app.facebook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.FaceDetector;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.palette.graphics.Palette;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import edu.hanu.app.R;

public class FacebookActivity extends AppCompatActivity {

    RelativeLayout topBar;
    TabLayout homeTabLayout;
    ViewPager contentView;
    TabItem tabHome, tabWatch, tabMarketPlace, tabGaming, tabNotification, tabMenu;
    PagerController pagerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        topBar = findViewById(R.id.topBar);
        homeTabLayout = findViewById(R.id.homeTabLayout);
        contentView = findViewById(R.id.contentView);

        tabGaming = findViewById(R.id.tabGaming);
        tabHome = findViewById(R.id.tabHome);
        tabMarketPlace = findViewById(R.id.tabMarketPlace);
        tabWatch = findViewById(R.id.tabWatch);
        tabNotification = findViewById(R.id.tabNotification);
        tabMenu = findViewById(R.id.tabMenu);

//        reaction_iv = findViewById(R.id.reaction_iv);
//        reaction_btn =(Button) findViewById(R.id.reaction_btn);

        pagerController = new PagerController(getSupportFragmentManager(), homeTabLayout.getTabCount());
        contentView.setAdapter(pagerController);

        homeTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                contentView.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    pagerController.notifyDataSetChanged();
                    topBar.setVisibility(View.VISIBLE);
                }
                if (tab.getPosition() == 1) {
                    pagerController.notifyDataSetChanged();
                    topBar.setVisibility(View.GONE);
                }
                if (tab.getPosition() == 2) {
                    pagerController.notifyDataSetChanged();
                    topBar.setVisibility(View.GONE);
                }
                if (tab.getPosition() == 3) {
                    pagerController.notifyDataSetChanged();
                    topBar.setVisibility(View.GONE);
                }
                if (tab.getPosition() == 4) {
                    pagerController.notifyDataSetChanged();
                    topBar.setVisibility(View.GONE);
                }
                if (tab.getPosition() == 5) {
                    pagerController.notifyDataSetChanged();
                    topBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        contentView.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(homeTabLayout));

//        reaction_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FacebookActivity.this, FBReactionDialog.class);
//                startActivity(intent);
//            }
//        });

//    private DialogFragment getReactionDialog() {
//        FBReactionDialog fbReactionDialog = new FBReactionDialog();
//        fbReactionDialog.show(getSupportFragmentManager(), fbReactionDialog.getClass().getSimpleName());
//        return fbReactionDialog;
//    }
//    public void onReactionSelected(int reactionType) {
//        switch (reactionType){
//            case 0:
//                reaction_btn.setText("Like");
//                reaction_iv.setImageResource(R.drawable.ic_like);
//                break;
//            case 1:
//                reaction_btn.setText("Love");
//                reaction_iv.setImageResource(R.drawable.ic_love);
//                break;
//            case 2:
//                reaction_btn.setText("Haha");
//                reaction_iv.setImageResource(R.drawable.ic_haha);
//                break;
//            case 3:
//                reaction_btn.setText("Wow");
//                reaction_iv.setImageResource(R.drawable.ic_wow);
//                break;
//            case 4:
//                reaction_btn.setText("Sad");
//                reaction_iv.setImageResource(R.drawable.ic_sad);
//                break;
//            case 5:
//                reaction_btn.setText("Angry");
//                reaction_iv.setImageResource(R.drawable.ic_angry);
//                break;
//
//        }
//    }
    }

}