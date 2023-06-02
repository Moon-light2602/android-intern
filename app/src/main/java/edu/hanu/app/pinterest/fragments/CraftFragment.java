package edu.hanu.app.pinterest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.pinterest.adapters.ImageAdapter;
import edu.hanu.app.pinterest.models.Image;


public class CraftFragment extends Fragment {

    private RecyclerView rcvImg;
    private View view;

    public CraftFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_craft, container, false);

        rcvImg = view.findViewById(R.id.rcv_img);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rcvImg.setLayoutManager(staggeredGridLayoutManager);

        ImageAdapter imageAdapter = new ImageAdapter();
        imageAdapter.setData(getListImage());
        rcvImg.setAdapter(imageAdapter);

        return view;
    }

    private List<Image> getListImage() {
        List<Image> list = new ArrayList<>();
        list.add(new Image(R.drawable.img1));
        list.add(new Image(R.drawable.img2));
        list.add(new Image(R.drawable.img3));
        list.add(new Image(R.drawable.img4));
        list.add(new Image(R.drawable.img5));
        list.add(new Image(R.drawable.img6));
        list.add(new Image(R.drawable.img7));
        list.add(new Image(R.drawable.img8));
        list.add(new Image(R.drawable.img9));
        list.add(new Image(R.drawable.img10));

        return list;
    }
}