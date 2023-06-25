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
import edu.hanu.app.messenger.models.BubbleChat;

public class ChatMessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int SENDER = 0;
    public static final int RECEIVER = 1;

    List<BubbleChat> list;

    public ChatMessageAdapter(List<BubbleChat> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == SENDER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_send, parent, false);
            return new SenderHolder(view);
        } else if (viewType == RECEIVER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receive, parent, false);
            return new ReceiverHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BubbleChat item = list.get(position);
        if(item.getType() == SENDER) {
            SenderHolder senderHolder = (SenderHolder) holder;
            senderHolder.setData(item);
        } else if (item.getType() == RECEIVER) {
            ReceiverHolder receiverHolder = (ReceiverHolder) holder;
            receiverHolder.setData(item);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class SenderHolder extends RecyclerView.ViewHolder {
        CircleImageView senderOfAvatar;
        TextView senderOfContent;

        public SenderHolder(@NonNull View itemView) {
            super(itemView);

            senderOfAvatar = itemView.findViewById(R.id.sender_avatar);
            senderOfContent = itemView.findViewById(R.id.sender_content);
        }

        private void setData(BubbleChat item) {
            senderOfAvatar.setImageResource(item.getAvatarSender());
            senderOfContent.setText(item.getContentOfSender());
        }
    }

    private class ReceiverHolder extends RecyclerView.ViewHolder {
        TextView receiverOfContent;

        public ReceiverHolder(@NonNull View itemView) {
            super(itemView);

            receiverOfContent = itemView.findViewById(R.id.receiver_content);
        }

        private void setData(BubbleChat item) {
            receiverOfContent.setText(item.getContentOfReceiver());

        }
    }
}

