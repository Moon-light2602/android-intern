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
import edu.hanu.app.facebook.models.FbStory;

public class FbStoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_ADD = 1;
    private static int TYPE_DEFAULT = 2;
    private List<FbStory> list;


    public FbStoryAdapter(List<FbStory> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        FbStory fbStory = list.get(position);
        if(fbStory.isUser()) {
            return TYPE_ADD;
        } else {
            return TYPE_DEFAULT;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(TYPE_ADD == viewType) {
            View view = inflater.inflate(R.layout.fb_add_story_item, parent, false);
            return new AddUserStoryHolder(view);
        } else if (TYPE_DEFAULT== viewType) {
            View view = inflater.inflate(R.layout.fb_story_item, parent, false);
            return new DefaultStoryHolder(view);
        }
        return new DefaultStoryHolder(inflater.inflate(R.layout.fb_story_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FbStory fbStory = list.get(position);
        if(TYPE_ADD == holder.getItemViewType()) {
            AddUserStoryHolder addUserStoryHolder = (AddUserStoryHolder) holder;
            addUserStoryHolder.user_avatar.setImageResource(fbStory.getUserAvatar());
        } else if(TYPE_DEFAULT == holder.getItemViewType()) {
            DefaultStoryHolder defaultStoryHolder = (DefaultStoryHolder) holder;
            defaultStoryHolder.userName.setText(fbStory.getUserName());
            defaultStoryHolder.userStory.setImageResource(fbStory.getUserStoryImg());
            defaultStoryHolder.userAvatar.setImageResource(fbStory.getUserAvatar());
        }
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    private class AddUserStoryHolder extends RecyclerView.ViewHolder {
        private ImageView user_avatar;

        public AddUserStoryHolder(@NonNull View itemView) {
            super(itemView);

            user_avatar = itemView.findViewById(R.id.user_avatar);
        }
    }

    private class DefaultStoryHolder extends RecyclerView.ViewHolder {
        private ImageView userStory;
        private CircleImageView userAvatar;
        private TextView userName;

        public DefaultStoryHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.default_user_name);
            userStory = itemView.findViewById(R.id.default_user_story);
            userAvatar = itemView.findViewById(R.id.default_user_avatar);
        }
    }
}
