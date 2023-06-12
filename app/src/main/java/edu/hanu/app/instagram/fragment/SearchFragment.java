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
import edu.hanu.app.instagram.adapter.ListPhotosAdapter;
import edu.hanu.app.instagram.model.ListPhotos;
import edu.hanu.app.instagram.model.Photos;

public class SearchFragment extends Fragment {
    RecyclerView rcvPhotos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_instagram, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcvPhotos = view.findViewById(R.id.rcvPhoto);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rcvPhotos.setLayoutManager(manager);

        ListPhotosAdapter adapter = new ListPhotosAdapter(getListPhotos());
        rcvPhotos.setAdapter(adapter);
    }

    private List<ListPhotos> getListPhotos() {
        List<ListPhotos> listPhotos = new ArrayList<>();

        List<Photos> list = new ArrayList<>();
            list.add(new Photos(R.drawable.img6));
            list.add(new Photos(R.drawable.img7));
            list.add(new Photos(R.drawable.img8));


        List<Photos> list1 = new ArrayList<>();
        list1.add(new Photos(R.drawable.img1));
        list1.add(new Photos(R.drawable.img2));
        list1.add(new Photos(R.drawable.img3));
        list1.add(new Photos(R.drawable.img4));
        list1.add(new Photos(R.drawable.img7));

        List<Photos> list2 = new ArrayList<>();
        list2.add(new Photos(R.drawable.img9));
        list2.add(new Photos(R.drawable.img10));
        list2.add(new Photos(R.drawable.img6));

        listPhotos.add(new ListPhotos(ListPhotosAdapter.INSTA_LARGE, list1));
        listPhotos.add(new ListPhotos(ListPhotosAdapter.INSTA_GRID, list));

        listPhotos.add(new ListPhotos(ListPhotosAdapter.INSTA_GRID, list2));
        listPhotos.add(new ListPhotos(ListPhotosAdapter.INSTA_LARGE, list1));

        listPhotos.add(new ListPhotos(ListPhotosAdapter.INSTA_LARGE, list1));
        listPhotos.add(new ListPhotos(ListPhotosAdapter.INSTA_GRID, list));
        return listPhotos;
    }
}

