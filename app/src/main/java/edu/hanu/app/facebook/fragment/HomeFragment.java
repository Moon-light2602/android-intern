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

        String videoUrl = "https://firebasestorage.googleapis.com/v0/b/design-ui-bd258.appspot.com/o/TRAILER%20%233%20-%20VI%20C%C3%81%20TI%E1%BB%80N%20TRUY%E1%BB%86N%20-%20C%C3%81%20CON%20V%C6%AF%E1%BB%A2T%20BI%E1%BB%82N%20L%E1%BB%9AN%20-%20Qu%C3%A1ch%20Ng%E1%BB%8Dc%20Tuy%C3%AAn%2C%20H%E1%BB%A9a%20Minh%20%C4%90%E1%BA%A1t%2C%20Will%2C%20DJ%20Mie.mp4?alt=media&token=1a9ed919-b8e8-41bf-ae09-264717879047&_gl=1*1ccsrq2*_ga*NTYzOTM3OTM5LjE2ODY1ODcwNjE.*_ga_CW55HF8NVT*MTY4NjU5OTc3NC4yLjEuMTY4NjYwMDkwOC4wLjAuMA..";

        list.add(new FbPost(FbPostAdapter.IMAGE,"Mỹ Duyên", R.drawable.img4, R.drawable.img5, "Chuyện không muốn nhớ lại :(("));
        list.add(new FbPost(FbPostAdapter.MULTI_IMAGE,"Thanh Trang", R.drawable.img8, images, "Cháy như free fire \uD83D\uDD25"));
        list.add(new FbPost(FbPostAdapter.IMAGE,"Hoài Ngọc", R.drawable.img9, R.drawable.image, "Khi bạn làm sai công thức nhưng ra đúng kết quả"));
        list.add(new FbPost(FbPostAdapter.IMAGE,"Hà Nội", R.drawable.img3, R.drawable.malibu, "Malibu trong mắt tôi \uD83E\uDEE3"));
        list.add(new FbPost(FbPostAdapter.IMAGE,"Lang Thang Hà Nội", R.drawable.img2, R.drawable.image1, "Ngôn tình <3"));
        list.add(new FbPost(FbPostAdapter.VIDEO,"K Love", R.drawable.img1, videoUrl, "TRAILER # Vi Cá tiền truyện" +
                "Top 1:"));

        return list;
    }
}