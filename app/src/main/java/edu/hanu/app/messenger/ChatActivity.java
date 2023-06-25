package edu.hanu.app.messenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.app.R;
import edu.hanu.app.messenger.adpaters.ChatMessageAdapter;
import edu.hanu.app.messenger.models.BubbleChat;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager verticalLayout = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(verticalLayout);
        ChatMessageAdapter adapter = new ChatMessageAdapter(getListChat());
        recyclerView.setAdapter(adapter);
    }

    private List<BubbleChat> getListChat() {
        List<BubbleChat> list = new ArrayList<>();
        list.add(new BubbleChat(ChatMessageAdapter.SENDER, R.drawable.img2, "Hello!"));
        list.add(new BubbleChat(ChatMessageAdapter.RECEIVER, "Hi, Have a nice day!"));
        list.add(new BubbleChat(ChatMessageAdapter.SENDER, R.drawable.img2, "How are you today?"));
        list.add(new BubbleChat(ChatMessageAdapter.RECEIVER, "Great!!!"));
        list.add(new BubbleChat(ChatMessageAdapter.RECEIVER,"... :v"));

        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_messenger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.phone_call:
                Toast.makeText(this, "Phone call", Toast.LENGTH_SHORT).show();
                break;
            case R.id.video_call:
                Toast.makeText(this, "Video call", Toast.LENGTH_SHORT).show();
                break;
            case R.id.information:
                Toast.makeText(this, "Information detail", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
