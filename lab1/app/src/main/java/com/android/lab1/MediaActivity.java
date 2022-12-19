package com.android.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class MediaActivity extends AppCompatActivity {

    private media_music music_fragment;
    private internal_videoFragment internal_video;
    private internet_videoFragment internet_video;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        tabLayout = findViewById(R.id.tablet_layout);
        viewPager = findViewById(R.id.view_pager);

        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new media_music(), "MUSIC");
        vpAdapter.addFragment(new internal_videoFragment(), "INTERNAL VIDEO");
        vpAdapter.addFragment(new external_videoFragment(), "EXTERNAL VIDEO");
        vpAdapter.addFragment(new internet_videoFragment(), "INTERNET VIDEO");
        viewPager.setAdapter(vpAdapter);
    }
}