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
import edu.hanu.app.pinterest.adapters.ForUAdapter;
import edu.hanu.app.pinterest.models.ForU;

public class ForYouFragment extends Fragment {

    private RecyclerView rcvForU;
    private View view;

    public ForYouFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_for_you, container, false);
        rcvForU = view.findViewById(R.id.rcv_foryou);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rcvForU.setLayoutManager(staggeredGridLayoutManager);

        ForUAdapter forUAdapter = new ForUAdapter();
        forUAdapter.setData(getListForU());
        rcvForU.setAdapter(forUAdapter);

        return view;
    }

    private List<ForU> getListForU() {
        List<ForU> list = new ArrayList<>();
        list.add(new ForU(R.drawable.foryou1));
        list.add(new ForU(R.drawable.foryou2));
        list.add(new ForU(R.drawable.foryou3));
        list.add(new ForU(R.drawable.foryou4));
        list.add(new ForU(R.drawable.foryou5));
        list.add(new ForU(R.drawable.foryou6));
        list.add(new ForU(R.drawable.foryou7));
        list.add(new ForU(R.drawable.foryou8));

        return list;
    }
}