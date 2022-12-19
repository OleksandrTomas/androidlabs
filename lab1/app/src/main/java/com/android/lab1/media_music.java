package com.android.lab1;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class media_music extends Fragment {
    MediaPlayer music_player;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_media_music, container, false);

        Button play = v.findViewById(R.id.music_button_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_music(v);
            }
        });

        Button pause = v.findViewById(R.id.music_button_pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause_music(v);
            }
        });
        Button stop = v.findViewById(R.id.music_button_stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop_music(v);
            }
        });
        return v;
    }

    @Override
    public void onPause(){
        super.onPause();
        releasePlayer();
    }
    public void play_music(View v) {
        if (music_player == null){
            music_player = MediaPlayer.create(getActivity(), R.raw.pentagramma);
        }
        music_player.start();
    }

    public void pause_music(View v) {
        if (music_player != null){
            music_player.pause();
        }
    }

    public void stop_music(View view) {
        releasePlayer();
    }
    private void releasePlayer(){
        if (music_player != null){
            music_player.release();
            music_player=null;
        }
    }

}