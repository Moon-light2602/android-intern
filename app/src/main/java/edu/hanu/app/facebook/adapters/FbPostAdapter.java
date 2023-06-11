package edu.hanu.app.facebook.adapters;

import android.content.Context;
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

public class FbPostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int IMAGE = 1;
    public static final int MULTI_IMAGE = 2;
    List<FbPost> list;
    private Context context;

    public FbPostAdapter(Context context, List<FbPost> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        FbPost fbPost = list.get(position);
        return fbPost.getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(IMAGE == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fb_one_image_item, parent, false);
            return new PostHolder(view);
        } else if (MULTI_IMAGE == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fb_post_multiple_image_item, parent, false);
            return new MultiplePostHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FbPost itemPost = list.get(position);
        if (IMAGE == itemPost.getType()) {
            PostHolder postHolder = (PostHolder) holder;
            postHolder.userNameOfPost.setText(itemPost.getUserNameOfPost());
            postHolder.userAvatar.setImageResource(itemPost.getUserAvatar());
            postHolder.userImage.setImageResource(itemPost.getUserImage());
            postHolder.postContent.setText(itemPost.getPostContent());
        } else if (MULTI_IMAGE == itemPost.getType()) {
            MultiplePostHolder multiplePostHolder = (MultiplePostHolder) holder;
            multiplePostHolder.userAvatar.setImageResource(itemPost.getUserAvatar());
            multiplePostHolder.userNameOfPost.setText(itemPost.getUserNameOfPost());
            multiplePostHolder.postContent.setText(itemPost.getPostContent());
            multiplePostHolder.image_1.setImageResource(itemPost.getImages().get(0).getResourceId());
            multiplePostHolder.image_2.setImageResource(itemPost.getImages().get(1).getResourceId());
            multiplePostHolder.image_3.setImageResource(itemPost.getImages().get(2).getResourceId());
            multiplePostHolder.image_4.setImageResource(itemPost.getImages().get(3).getResourceId());
        }
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

    private class MultiplePostHolder extends PostHolder {
        private CircleImageView userAvatar;
        private TextView userNameOfPost, postContent;
        private ImageView image_1, image_2, image_3, image_4;
        public MultiplePostHolder(View itemView) {
            super(itemView);

            userNameOfPost = itemView.findViewById(R.id.user_name_of_post);
            userAvatar = itemView.findViewById(R.id.user_avatar_of_post);
            postContent = itemView.findViewById(R.id.post_content);
            image_1 = itemView.findViewById(R.id.image_1);
            image_2 = itemView.findViewById(R.id.image_2);
            image_3 = itemView.findViewById(R.id.image_3);
            image_4 = itemView.findViewById(R.id.image_4);
        }
    }
}
