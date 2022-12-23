package com.android.lab4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

public class InternalVideoFragment extends Fragment {
    VideoView video_player;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_internal_video, container, false);

        video_player = v.findViewById(R.id.internalVideoView);
        String my_video_path = ("android.resource://"+getActivity().getPackageName()+"/"+R.raw.nuclear);
        video_player.setVideoPath(my_video_path);
        Button play_video = v.findViewById(R.id.internal_button_play);
        Button pause_video = v.findViewById(R.id.internal_button_pause);
        Button stop_video = v.findViewById(R.id.internal_button_stop);
        play_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video_player.start();
            }
        });
        pause_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video_player.pause();
            }
        });
        stop_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video_player.stopPlayback();
                video_player.resume();
            }
        });
        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        video_player.stopPlayback();
        video_player.resume();
    }
}