package edu.hanu.app.instagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.R;
import edu.hanu.app.instagram.model.Story;

public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int ADD_STORY = 1;
    private static int DEFAULT_STORY = 2;
    private List<Story> list;

    public StoryAdapter(List<Story> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        Story insStory = list.get(position);
        if(insStory.isUser()) {
            return ADD_STORY;
        } else {
            return DEFAULT_STORY;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(ADD_STORY == viewType) {
            View view = inflater.inflate(R.layout.insta_add_story_item, parent, false);
            return new AddUserStoryHolder(view);
        } else if (DEFAULT_STORY == viewType) {
            View view = inflater.inflate(R.layout.story_item_insta, parent, false);
            return new DefaultStoryHolder(view);
        }
        return new DefaultStoryHolder(inflater.inflate(R.layout.story_item_insta, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Story insStory = list.get(position);
        if(ADD_STORY == holder.getItemViewType()) {
            AddUserStoryHolder addUserStoryHolder = (AddUserStoryHolder) holder;
            addUserStoryHolder.avatar.setImageResource(insStory.getInstaAvatar());
        } else if(DEFAULT_STORY == holder.getItemViewType()) {
            DefaultStoryHolder defaultStoryHolder = (DefaultStoryHolder) holder;
            defaultStoryHolder.default_avatar.setImageResource(insStory.getInstaAvatar());
            defaultStoryHolder.userName.setText(insStory.getInstaUserName());
        }
    }

    @Override
    public int getItemCount() {
        if(list != null) return list.size();
        return 0;
    }

    public class AddUserStoryHolder extends RecyclerView.ViewHolder {
        private CircleImageView avatar;

        public AddUserStoryHolder(@NonNull View itemView) {
            super(itemView);

            avatar = itemView.findViewById(R.id.ins_avatar);
        }
    }

    public class DefaultStoryHolder extends RecyclerView.ViewHolder {
        private CircleImageView default_avatar;
        private TextView userName;

        public DefaultStoryHolder(@NonNull View itemView) {
            super(itemView);

           default_avatar = itemView.findViewById(R.id.ins_default_avatar);
           userName = itemView.findViewById(R.id.ins_user_name);
        }
    }
}
