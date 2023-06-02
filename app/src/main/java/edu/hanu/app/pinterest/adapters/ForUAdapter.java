package edu.hanu.app.pinterest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.pinterest.models.ForU;

public class ForUAdapter extends RecyclerView.Adapter<ForUAdapter.ForUViewHolder> {

    private List<ForU> listImg;
    public void setData(List<ForU> list){
        this.listImg = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ForUViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.for_you_item, parent, false);
        return new ForUViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForUViewHolder holder, int position) {
        ForU forU = listImg.get(position);
        if (forU == null) {
            return;
        }
        holder.imgView.setImageResource(forU.getImg());
    }

    @Override
    public int getItemCount() {
        if(listImg != null) {
            return listImg.size();
        }
        return 0;
    }

    public class ForUViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgView;

        public ForUViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgView);
        }
    }
}
