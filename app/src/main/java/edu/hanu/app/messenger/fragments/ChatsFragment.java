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
        RecyclerView rcvHorizontal = view.findViewById(R.id.rcvHorizontal);
        LinearLayoutManager horizontalLayout = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        rcvHorizontal.setLayoutManager(horizontalLayout);
        HomeChatListAdapter adapter = new HomeChatListAdapter(getListChatHorizontal(), this);
        rcvHorizontal.setAdapter(adapter);

        RecyclerView rvVertical = view.findViewById(R.id.rcvVertical);
        LinearLayoutManager manager1 = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rvVertical.setLayoutManager(manager1);
        Adapter adapter2 = new Adapter(getListChatVertical());
        rvVertical.setAdapter(adapter2);
    }

    private List<ChatMessages> getListChatVertical() {
        List<ChatMessages> list = new ArrayList<>();
        list.add(new ChatMessages(R.drawable.img6, "User name 1", "Content"));
        list.add(new ChatMessages(R.drawable.img4, "User name 1", "Content"));
        list.add(new ChatMessages(R.drawable.img8, "User name 1", "Content"));
        list.add(new ChatMessages(R.drawable.img10, "User name 1", "Content"));
        list.add(new ChatMessages(R.drawable.img9, "User name 1", "Content"));
        list.add(new ChatMessages(R.drawable.img3, "User name 1", "Content"));
        list.add(new ChatMessages(R.drawable.img1, "User name 1", "Content"));
        list.add(new ChatMessages(R.drawable.img2, "User name 1", "Content"));
        list.add(new ChatMessages(R.drawable.img7, "User name 1", "Content"));
        list.add(new ChatMessages(R.drawable.img3, "User name 1", "Content"));

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
