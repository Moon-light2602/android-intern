package edu.hanu.app.tiktok.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.R;
import edu.hanu.app.tiktok.model.VideoItem;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.viewHolder> {

    private List<VideoItem> mVideosList;
    Context context;

    public VideosAdapter(List<VideoItem> videoItems, Context ctx) {
        mVideosList = videoItems;
        context = ctx;
    }
    @NonNull
    @Override
    public VideosAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_back, parent, false));
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.setData(position);

        holder.userTikTok.setTextAlignment(mVideosList.get(position).getUserTikTok());
        holder.textDesc.setText(mVideosList.get(position).getVideoDescription());
        Glide.with(context).load(mVideosList.get(position).getVideoUrl()).into(holder.userTikTok);
        holder.textDesc.setSelected(true);
    }

    @Override
    public int getItemCount() {
        return mVideosList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        public VideoView mVideoView;
        TextView userId, textDesc;
        ProgressBar progressBar;
        CircleImageView userTikTok;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            mVideoView = itemView.findViewById(R.id.videoView);
            textDesc = itemView.findViewById(R.id.textDesc);
            userId = itemView.findViewById(R.id.user_id);
            progressBar = itemView.findViewById(R.id.progressBar);
            userTikTok = itemView.findViewById(R.id.userTikTok);

        }
        void setData(int position){
            if(mVideosList.get(position).getVideoUrl() != null) {
                mVideoView.setVideoURI(Uri.parse(mVideosList.get(position).getVideoUrl()));
            }

            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progressBar.setVisibility(View.GONE);
                    mediaPlayer.start();
                }
            });

            mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
    }

    }
}
