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
import edu.hanu.app.messenger.ConversationListener;
import edu.hanu.app.messenger.models.ChatMessages;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<ChatMessages> list;
    ConversationListener listener;

    public Adapter(List<ChatMessages> list, ConversationListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_chat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatMessages item = list.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView userAvatar;
        TextView userName, content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userAvatar = itemView.findViewById(R.id.user_avatar);
            userName = itemView.findViewById(R.id.user_name);
            content = itemView.findViewById(R.id.content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) {
                        int pos = getAdapterPosition();
                        listener.onClickChatItem(pos);
                    }
                }
            });
        }

        private void setData(ChatMessages item) {
            userAvatar.setImageResource(item.getImageUrl());
            userName.setText(item.getUserName());
            content.setText(item.getContent());
        }
    }
}
