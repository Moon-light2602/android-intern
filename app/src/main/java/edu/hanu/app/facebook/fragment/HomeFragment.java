package edu.hanu.app.facebook.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.facebook.adapters.FbPostAdapter;
import edu.hanu.app.facebook.adapters.FbStoryAdapter;
import edu.hanu.app.facebook.models.FbPost;
import edu.hanu.app.facebook.models.FbStory;
import edu.hanu.app.facebook.models.Images;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_fb, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView postList = view.findViewById(R.id.fb_post_list);
        FbPostAdapter postAdapter = new FbPostAdapter(getContext(), getPostList());

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        postList.setLayoutManager(manager);
        postList.setAdapter(postAdapter);

        RecyclerView storyList = view.findViewById(R.id.fb_story_list);
        FbStoryAdapter newsFeedAdapter = new FbStoryAdapter(getNewsFeedList());

        LinearLayoutManager manager1 = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        storyList.setLayoutManager(manager1);
        storyList.setAdapter(newsFeedAdapter);
    }

    private List<FbStory> getNewsFeedList() {
        List<FbStory> list = new ArrayList<>();
        list.add(new FbStory(R.drawable.user,0, "", true));
        list.add(new FbStory(R.drawable.img1, R.drawable.foryou1, "Thanh Trang", false));
        list.add(new FbStory(R.drawable.img2, R.drawable.img6, "Ngoc Lan", false));
        list.add(new FbStory(R.drawable.img3, R.drawable.img8, "Hoai Ngoc", false));
        list.add(new FbStory(R.drawable.img4, R.drawable.img2, "Quynh Trang", false));
        list.add(new FbStory(R.drawable.img5, R.drawable.img9, "Ngoc Mai", false));
        list.add(new FbStory(R.drawable.img6, R.drawable.img4, "Mai Phuong", false));
        list.add(new FbStory(R.drawable.img7, R.drawable.img10, "Nguyen Mai", false));
        list.add(new FbStory(R.drawable.img8, R.drawable.img1, "My Linh", false));
        list.add(new FbStory(R.drawable.img9, R.drawable.img5, "Minh Anh", false));
        list.add(new FbStory(R.drawable.img10, R.drawable.foryou3, "Dieu Thao", false));
        return list;
    }

    private List<FbPost> getPostList() {

        List<FbPost> list = new ArrayList<>();

        List<Images> images = new ArrayList<>();

        images.add(new Images(R.drawable.img3));
        images.add(new Images(R.drawable.img2));
        images.add(new Images(R.drawable.img1));
        images.add(new Images(R.drawable.img5));

        list.add(new FbPost(FbPostAdapter.IMAGE,"Mỹ Duyên", R.drawable.img4, R.drawable.img5, "Chuyện không muốn nhớ lại :(("));
        list.add(new FbPost(FbPostAdapter.MULTI_IMAGE,"Thanh Trang", R.drawable.img8, images, "Cháy như free fire \uD83D\uDD25"));
        list.add(new FbPost(FbPostAdapter.IMAGE,"Hoài Ngọc", R.drawable.img9, R.drawable.image, "Khi bạn làm sai công thức nhưng ra đúng kết quả"));
        list.add(new FbPost(FbPostAdapter.IMAGE,"Hà Nội", R.drawable.img3, R.drawable.malibu, "Malibu trong mắt tôi \uD83E\uDEE3"));
        list.add(new FbPost(FbPostAdapter.IMAGE,"Lang Thang Hà Nội", R.drawable.img2, R.drawable.image1, "Ngôn tình <3"));
        list.add(new FbPost(FbPostAdapter.IMAGE,"K Love", R.drawable.img1, R.drawable.image2, "Top 10 đứa bé hiểu chuyện nhất phim Hàn\n" +
                "Top 1:"));

        return list;
    }
}