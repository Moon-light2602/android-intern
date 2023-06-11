package edu.hanu.app.instagram.adapter;

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
import edu.hanu.app.instagram.model.Post;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private List<Post> list;

    public PostAdapter (List<Post> list) {
        this.list = list;
    }
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.insta_post_item, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        Post post = list.get(position);
        holder.userAvatarPost.setImageResource(post.getAvatar());
        holder.userNamePost.setText(post.getUserName());
        holder.postDesc.setText(post.getUserDesc());
        holder.postImage.setImageResource(post.getInstaImage());
        holder.contentPost.setText(post.getContentPost());
        holder.commentOfUser.setText(post.getCommentOfUser());
        holder.comment.setText(post.getComment());
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class PostHolder extends RecyclerView.ViewHolder {

        private TextView userNamePost, postDesc, contentPost, commentOfUser, comment, likeNumber;
        private ImageView postImage;
        private CircleImageView userAvatarPost;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            userAvatarPost = itemView.findViewById(R.id.ins_user_avatar_post);
            userNamePost = itemView.findViewById(R.id.ins_user_name_post);
            postImage = itemView.findViewById(R.id.ins_post_image);
            postDesc = itemView.findViewById(R.id.ins_post_desc);
            contentPost = itemView.findViewById(R.id.content_post);
            commentOfUser = itemView.findViewById(R.id.commenter_name);
            comment = itemView.findViewById(R.id.comment);
        }
    }
}

