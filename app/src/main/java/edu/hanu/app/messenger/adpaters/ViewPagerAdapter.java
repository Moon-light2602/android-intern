package edu.hanu.app.messenger.adpaters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

import java.util.List;

import edu.hanu.app.messenger.fragments.CallsFragment;
import edu.hanu.app.messenger.fragments.ChatsFragment;
import edu.hanu.app.messenger.fragments.PeopleFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new ChatsFragment();
            case 1: return new CallsFragment();
            case 2: return new PeopleFragment();
            case 3: return new StoriesFragment();
            default: return new ChatsFragment();
        }
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
