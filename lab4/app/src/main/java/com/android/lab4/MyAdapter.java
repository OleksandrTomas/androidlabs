package com.android.lab4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {

    public MyAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case  0:
                return new InternalMusicFragment();
            case 1:
                return new InternalVideoFragment();
            case 2:
                return new ExternalVideoFragment();
            case 3:
                return new InternetVideoFragment();
            default:
                return new InternalMusicFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
