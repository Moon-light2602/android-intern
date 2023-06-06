package edu.hanu.app.facebook.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.R;
import edu.hanu.app.facebook.models.FbPost;

public class FbPostAdapter extends RecyclerView.Adapter<FbPostAdapter.PostHolder> {
    List<FbPost> list;

    public FbPostAdapter(List<FbPost> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fb_one_image_item, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        FbPost itemPost = list.get(position);
        holder.userNameOfPost.setText(itemPost.getUserNameOfPost());
        holder.userAvatar.setImageResource(itemPost.getUserAvatar());
        holder.userImage.setImageResource(itemPost.getUserImage());
        holder.postContent.setText(itemPost.getPostContent());
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        private CircleImageView userAvatar;
        private TextView userNameOfPost, postContent;
        private ImageView userImage;

        public PostHolder(@NonNull View itemView) {
            super(itemView);

            userNameOfPost = itemView.findViewById(R.id.user_name_of_post);
            userAvatar = itemView.findViewById(R.id.user_avatar_of_post);
            userImage = itemView.findViewById(R.id.user_image_of_post);
            postContent = itemView.findViewById(R.id.post_content);
        }
    }
}
