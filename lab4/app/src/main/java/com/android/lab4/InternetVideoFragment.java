package com.android.lab4;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.VideoView;

public class InternetVideoFragment extends Fragment {
    VideoView video_internet_player;
    EditText link_text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_internet_video, container, false);

        video_internet_player = v.findViewById(R.id.internetVideoView);
        link_text = v.findViewById(R.id.link_internet);
        MediaController mediaController = new MediaController(getContext());
        Button play_video = v.findViewById(R.id.internet_button_play);
        play_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video_internet_player.setVideoURI(Uri.parse(link_text.getText().toString()));
                play_video(v, mediaController);
            }
        });
        return v;
    }
    public void play_video(View v, MediaController mediaController){
        video_internet_player.setMediaController(mediaController);
        video_internet_player.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        video_internet_player.stopPlayback();
    }
}