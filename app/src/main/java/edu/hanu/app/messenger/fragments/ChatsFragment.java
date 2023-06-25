package edu.hanu.app.messenger.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.messenger.ChatActivity;
import edu.hanu.app.messenger.ConversationListener;
import edu.hanu.app.messenger.adpaters.Adapter;
import edu.hanu.app.messenger.adpaters.HomeChatListAdapter;
import edu.hanu.app.messenger.models.ChatMessages;
import edu.hanu.app.messenger.models.HomeChat;

public class ChatsFragment extends Fragment implements ConversationListener {

    List<HomeChat> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chats_messenger, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView story = view.findViewById(R.id.story);
        LinearLayoutManager horizontalLayout = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        story.setLayoutManager(horizontalLayout);
        HomeChatListAdapter homeChatListAdapter = new HomeChatListAdapter(getListChatHorizontal(), this);
        story.setAdapter(homeChatListAdapter);

        RecyclerView listChat = view.findViewById(R.id.list_chat);
        LinearLayoutManager manager1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        listChat.setLayoutManager(manager1);
        Adapter adapter = new Adapter(getListChatVertical(), this);
        listChat.setAdapter(adapter);
    }

    private List<ChatMessages> getListChatVertical() {
        List<ChatMessages> list = new ArrayList<>();
        list.add(new ChatMessages(R.drawable.img6, "User name 1", "Hi!!!"));
        list.add(new ChatMessages(R.drawable.img4, "User name 2", "Hello"));
        list.add(new ChatMessages(R.drawable.img8, "User name 3", "How old are you?"));
        list.add(new ChatMessages(R.drawable.img10, "User name 4", "Great!!"));
        list.add(new ChatMessages(R.drawable.img9, "User name 5", "Thank you very much!!"));
        list.add(new ChatMessages(R.drawable.img3, "User name 6", "Sorry =(("));
        list.add(new ChatMessages(R.drawable.img1, "User name 7", "Oh yeah!!!"));
        list.add(new ChatMessages(R.drawable.img2, "User name 8", "Are you there??"));
        list.add(new ChatMessages(R.drawable.img7, "User name 9", "Come here"));
        list.add(new ChatMessages(R.drawable.img3, "User name 10", "Don't talk to me!!"));

        return list;
    }

    private List<HomeChat> getListChatHorizontal() {
        list = new ArrayList<>();
        list.add(new HomeChat(R.drawable.img1, "User name 1"));
        list.add(new HomeChat(R.drawable.img2, "User name 2"));
        list.add(new HomeChat(R.drawable.img6, "User name 3"));
        list.add(new HomeChat(R.drawable.img3, "User name 4"));
        list.add(new HomeChat(R.drawable.img7, "User name 5"));
        list.add(new HomeChat(R.drawable.img4, "User name 16"));
        list.add(new HomeChat(R.drawable.img8, "User name 7"));
        list.add(new HomeChat(R.drawable.img10, "User name 69"));
        list.add(new HomeChat(R.drawable.img9, "User name 18"));
        list.add(new HomeChat(R.drawable.img3, "User name 13"));

        return list;
    }

    @Override
    public void onClickChatItem(int position) {
        Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ChatActivity.class);
        intent.putExtra("name", list.get(position).getUserName());
        startActivity(intent);
    }
}
