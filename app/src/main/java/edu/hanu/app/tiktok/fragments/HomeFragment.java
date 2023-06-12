package edu.hanu.app.tiktok.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.tiktok.adapter.VideosAdapter;
import edu.hanu.app.tiktok.model.VideoItem;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_tiktok, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager2);

        List<VideoItem> list = new ArrayList<>();

        VideoItem video1 = new VideoItem("https://firebasestorage.googleapis.com/v0/b/design-ui-bd258.appspot.com/o/Amazing%20Magic%20Acts%20and%20Illusions%20%F0%9F%98%B2%20America's%20Got%20Talent%20%23shorts.mp4?alt=media&token=20f455d9-b3c3-4dd9-90e5-8df7d2a40918&_gl=1*pbt367*_ga*NTYzOTM3OTM5LjE2ODY1ODcwNjE.*_ga_CW55HF8NVT*MTY4NjYwNDI4MC4zLjEuMTY4NjYwNDI4NC4wLjAuMA..", "Din Din", "Amazing Magic Acts and Illusions", "#America's God Talent", "BABY");
        list.add(video1);

        VideoItem video2 = new VideoItem("https://firebasestorage.googleapis.com/v0/b/design-ui-bd258.appspot.com/o/Watermelon%20popsicle.mp4?alt=media&token=edb8d3b7-46d0-460e-9e03-297c27cf3dd1&_gl=1*s4wgj4*_ga*NTYzOTM3OTM5LjE2ODY1ODcwNjE.*_ga_CW55HF8NVT*MTY4NjYwNDI4MC4zLjEuMTY4NjYwNjU3Ny4wLjAuMA..", "My Duyen", "Watermelon popsicle", "#watermelon", "What do you mean?");
        list.add(video2);

        VideoItem video3 = new VideoItem("https://firebasestorage.googleapis.com/v0/b/design-ui-bd258.appspot.com/o/X%C3%93M%20R%C3%81CH%20VI%E1%BB%86C-%20N%C3%93NG%20CH%E1%BA%A2Y%20M%E1%BB%A0%20%23shorts%20%23Cozy%20%23NgonRoVi.mp4?alt=media&token=25c28cc1-5a0c-4135-8177-a6ff510490fe&_gl=1*tyrs78*_ga*NTYzOTM3OTM5LjE2ODY1ODcwNjE.*_ga_CW55HF8NVT*MTY4NjYwNDI4MC4zLjEuMTY4NjYwNjc0MC4wLjAuMA..", "Datoifd", "Xóm rách việc - nóng chảy mỡ", "#shorts #Cozy #NgonRoVi", "Ngtanoise");
        list.add(video3);

        VideoItem video4 = new VideoItem("https://firebasestorage.googleapis.com/v0/b/design-ui-bd258.appspot.com/o/%5BASMR%5D%20Drawing%20KAKASHI%20On%20WOOD%20%F0%9F%98%AE%E2%9C%8D%EF%B8%8F%20%23satisfying%20%23shorts%20%23asmr.mp4?alt=media&token=3a255dd6-ca1b-4504-9edd-0bd83d890b4d&_gl=1*k07vtg*_ga*NTYzOTM3OTM5LjE2ODY1ODcwNjE.*_ga_CW55HF8NVT*MTY4NjYwNDI4MC4zLjEuMTY4NjYwNjg1Mi4wLjAuMA..", "ThanhTrang", "Drawing KAKASHI On WOOD", "#satisfying", "nothing");
        list.add(video4);

        VideoItem video5 = new VideoItem("https://firebasestorage.googleapis.com/v0/b/design-ui-bd258.appspot.com/o/%C4%90ang%20u%20s%E1%BA%A7u%20v%E1%BA%BFt%20b%E1%BA%A9n-%20B%E1%BB%99t%20t%E1%BA%A9y%20oxi%20clen%20ximo%20si%C3%AAu%20s%E1%BA%A1ch%20an%20to%C3%A0n%20-%20-%20%C4%90%C3%A0m%20%C4%90%E1%BB%A9c%20Review%20%23shorts.mp4?alt=media&token=48c48b33-56b3-4e54-b7c7-be912efa9e3f&_gl=1*fppcvs*_ga*NTYzOTM3OTM5LjE2ODY1ODcwNjE.*_ga_CW55HF8NVT*MTY4NjYwNDI4MC4zLjEuMTY4NjYwNjkzMC4wLjAuMA..", "Kaka", "Đang u sầu vết bẩn - Bột tẩy oxiclen ximo siêu sạch an toàn", "#DamducReview", "Say So");
        list.add(video5);

        VideoItem video6 = new VideoItem("https://firebasestorage.googleapis.com/v0/b/design-ui-bd258.appspot.com/o/%C4%90%E1%BA%BFn%20Th%C4%83m%20Nh%C3%A0%20R%C3%B9a%20--%20Ryan%20Kalimba%20Cover.mp4?alt=media&token=703f2bc6-7584-4c21-aa17-104df09326cc&_gl=1*13w43fx*_ga*NTYzOTM3OTM5LjE2ODY1ODcwNjE.*_ga_CW55HF8NVT*MTY4NjYwNDI4MC4zLjEuMTY4NjYwNzA4Ni4wLjAuMA..", "Ryan Kali", "Đến thăm nhà rùa", "#Cover", "Music");
        list.add(video6);

        viewPager2.setAdapter(new VideosAdapter(list));
    }
}
