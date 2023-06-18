package edu.hanu.app.messenger.adpaters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import edu.hanu.app.R;
import edu.hanu.app.messenger.models.ChatMessages;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<ChatMessages> list;

    public Adapter (List<ChatMessages> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_vertical, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatMessages item = list.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        if(list != null) {
            list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView userAvatar;
        TextView userName, content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userAvatar = itemView.findViewById(R.id.user_avatar);
            userName = itemView.findViewById(R.id.user_name);
            content = itemView.findViewById(R.id.content);
        }

        private void setData(ChatMessages item) {
            userAvatar.setImageResource(item.getImageUrl());
            userName.setText(item.getUserName());
            content.setText(item.getContent());
        }
    }
}
