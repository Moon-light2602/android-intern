package edu.hanu.app.instagram.fragment;

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
import edu.hanu.app.instagram.adapter.PostAdapter;
import edu.hanu.app.instagram.adapter.StoryAdapter;
import edu.hanu.app.instagram.model.Post;
import edu.hanu.app.instagram.model.Story;

public class HomeFragment extends Fragment {

    RecyclerView rvStoryList, rvPostList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_instagram, container, false);
   }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvStoryList = view.findViewById(R.id.rv_ins_story_list);
        rvPostList = view.findViewById(R.id.rv_ins_post_list);

        setUpStoryAdapter();
        setUpPostAdapter();

    }

    private void setUpStoryAdapter() {
        StoryAdapter storyAdapter = new StoryAdapter(getStoryList());
        LinearLayoutManager verticalLayout = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rvStoryList.setLayoutManager(verticalLayout);
        rvStoryList.setAdapter(storyAdapter);
    }

    private void setUpPostAdapter() {
        PostAdapter postAdapter = new PostAdapter(getPostList());
        LinearLayoutManager horizontalLayout = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rvPostList.setLayoutManager(horizontalLayout);
        rvPostList.setAdapter(postAdapter);
    }

    private List<Post> getPostList() {
        List<Post> list = new ArrayList<>();
        list.add(new Post(R.drawable.img5, "Tuan Anh", "22/02/2023", R.drawable.img6));
        list.add(new Post(R.drawable.img1, "Hoang Anh", "26/04/2023", R.drawable.img2));
        list.add(new Post(R.drawable.img3, "Ngoc Lan", "29/05/2023", R.drawable.img4));
        list.add(new Post(R.drawable.img7, "Thanh Trang", "30/05/2023", R.drawable.img8));
        list.add(new Post(R.drawable.image2, "My Duyen", "31/05/2023", R.drawable.img9));
        list.add(new Post(R.drawable.img10, "Dieu Thao", "02/06/2023", R.drawable.img8));

        return list;
    }

    private List<Story> getStoryList() {
        List<Story> list = new ArrayList<>();
        list.add(new Story(R.drawable.user, "Tin của bạn", true));
        list.add(new Story(R.drawable.img6, "myduyen_2602", false));
        list.add(new Story(R.drawable.img7, "vietnameG", false));
        list.add(new Story(R.drawable.img3, "_mikezxc_", false));
        list.add(new Story(R.drawable.img9, "mikurasa", false));
        list.add(new Story(R.drawable.img1, "dyndyn17", false));

        return list;
    }
}
