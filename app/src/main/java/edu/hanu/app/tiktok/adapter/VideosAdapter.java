package edu.hanu.app.tiktok.adapter;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.tiktok.model.VideoItem;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.viewHolder> {

    private List<VideoItem> mVideosList;

    public VideosAdapter(List<VideoItem> videoItems) {
        mVideosList = videoItems;
    }
    @NonNull
    @Override
    public VideosAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_tiktok, parent, false);
    return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.setVideoItem(mVideosList.get(position));
    }

    @Override
    public int getItemCount() {
        if(mVideosList != null) {
            return mVideosList.size();
        }
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

       VideoView videoView;
       TextView userName, videoDesc, videoHastag, musicName;
       ProgressBar progressBar;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

           videoView = itemView.findViewById(R.id.videoView);
           userName = itemView.findViewById(R.id.user_name);
           videoDesc = itemView.findViewById(R.id.video_desc);
           videoHastag = itemView.findViewById(R.id.video_hastag);
           musicName = itemView.findViewById(R.id.music_name);
           progressBar = itemView.findViewById(R.id.videoProgressBar);

        }
        public void setVideoItem(VideoItem videoItem) {
            userName.setText(videoItem.getUserName());
            videoDesc.setText(videoItem.getVideoDesc());
            videoHastag.setText(videoItem.getVideoHastag());
            musicName.setText(videoItem.getMusicName());
            videoView.setVideoPath(videoItem.getVideoUrl());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    progressBar.setVisibility(View.GONE);
                    mediaPlayer.start();
                }
            });

            videoView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if(videoView.isPlaying()) {
                        videoView.pause();
                        return false;
                    } else {
                        videoView.start();
                        return false;
                    }
                }
            });
        }
    }
}
