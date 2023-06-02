package edu.hanu.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import edu.hanu.app.facebook.FacebookActivity;
import edu.hanu.app.instagram.InstagramActivity;
import edu.hanu.app.pinterest.PinterestActivity;

public class MainActivity extends AppCompatActivity {
    ImageView pinterest, facebook, instagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pinterest = findViewById(R.id.imgPinterest);
        facebook = findViewById(R.id.imgFacebook);
        instagram = findViewById(R.id.imgInstagram);

        pinterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PinterestActivity.class);
                startActivity(intent);
            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FacebookActivity.class);
                startActivity(intent);
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InstagramActivity.class);
                startActivity(intent);
            }
        });
    }
}