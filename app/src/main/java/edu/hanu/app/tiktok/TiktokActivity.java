package edu.hanu.app.tiktok;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.tiktok.adapter.VideosAdapter;
import edu.hanu.app.tiktok.model.VideoItem;

public class TiktokActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiktok);

        final ViewPager2 videosViewpager = findViewById(R.id.viewPagerVideo);

        List<VideoItem> videoItems = new ArrayList<>();

        videoItems.add(new VideoItem("https://www.tiktok.com/@datdo0803/video/7240694337191857414?is_from_webapp=1&sender_device=pc", "datdo0803", "Cách gọi dậy mùa hè đúng cách", "datdo0803"));
        videoItems.add(new VideoItem("https://www.tiktok.com/@sanbarentertainment/video/7229855779329789189?is_from_webapp=1&sender_device=pc", "sanbarentertainment", "Đang Học Cấp 2 Mẹ lại bắt Đi Làm Dj", "sanbarentertainment"));
        videoItems.add(new VideoItem("https://www.tiktok.com/@hoaa.hanassii/video/7237830718854909189?is_from_webapp=1&sender_device=pc","hoaa.hanassii", "Xem nhảy thôi đừng để ý mặt :)) bài này thích nhảy kiểu sung vậy mới đã nè", "hoaa.hanassii"));
        videoItems.add(new VideoItem("https://www.tiktok.com/@datdo0803/video/7236610831914372357?is_from_webapp=1&sender_device=pc", "Đỗ Đạt", "Câu chuyện cảm động mẹ chợt nhận ra", "Đỗ Đạt"));


        videosViewpager.setAdapter(new VideosAdapter(videoItems, this));
    }
}
