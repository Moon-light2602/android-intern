package edu.hanu.app.instagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.instagram.model.ListPhotos;

public class ListPhotosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int INSTA_GRID = 1;
    public static final int INSTA_LARGE = 2;

    private List<ListPhotos> mListPhotos;

    public ListPhotosAdapter(List<ListPhotos> listPhotos) {
        this.mListPhotos = listPhotos;
    }

    @Override
    public int getItemViewType(int position) {
        ListPhotos listPhotos = mListPhotos.get(position);
        return listPhotos.getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(INSTA_GRID == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insta_grid_item, parent, false);
            return new GridHolder(view);
        } else if (INSTA_LARGE == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insta_large_item, parent, false);
            return new LargeHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListPhotos listPhotos = mListPhotos.get(position);
        if(INSTA_GRID == listPhotos.getType()) {
            GridHolder gridHolder = (GridHolder) holder;
            gridHolder.img1.setImageResource(listPhotos.getPhotos().get(0).getResourceId());
            gridHolder.img2.setImageResource(listPhotos.getPhotos().get(1).getResourceId());
            gridHolder.img3.setImageResource(listPhotos.getPhotos().get(2).getResourceId());
        } else if (INSTA_LARGE == listPhotos.getType()) {
            LargeHolder largeHolder = (LargeHolder) holder;
            largeHolder.img1.setImageResource(listPhotos.getPhotos().get(0).getResourceId());
            largeHolder.img2.setImageResource(listPhotos.getPhotos().get(1).getResourceId());
            largeHolder.img3.setImageResource(listPhotos.getPhotos().get(2).getResourceId());
            largeHolder.img4.setImageResource(listPhotos.getPhotos().get(3).getResourceId());
            largeHolder.img5.setImageResource(listPhotos.getPhotos().get(0).getResourceId());
        }
    }

    @Override
    public int getItemCount() {
        if(mListPhotos != null) {
            return mListPhotos.size();
        }
        return 0;
    }

    private class GridHolder extends RecyclerView.ViewHolder {
        private ImageView img1, img2, img3;
        public GridHolder(View view) {
            super(view);
            img1 = view.findViewById(R.id.image1);
            img2 = view.findViewById(R.id.image2);
            img3 = view.findViewById(R.id.image3);
        }
    }

    private class LargeHolder extends RecyclerView.ViewHolder {
        private ImageView img1, img2, img3, img4, img5;
        public LargeHolder(View view) {
            super(view);

            img1 = view.findViewById(R.id.image1);
            img2 = view.findViewById(R.id.image2);
            img3 = view.findViewById(R.id.image3);
            img4 = view.findViewById(R.id.image4);
            img5 = view.findViewById(R.id.image5);

        }
    }
}
