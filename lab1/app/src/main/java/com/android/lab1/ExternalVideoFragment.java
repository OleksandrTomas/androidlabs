package com.android.lab1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;


public class ExternalVideoFragment extends Fragment {
    VideoView video_player;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_external_video, container, false);
        video_player = v.findViewById(R.id.externalVideoView);

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            Toast.makeText(getContext(), "Перезапустіть застосунок", Toast.LENGTH_LONG).show();
        }
        String video_path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        video_player.setVideoPath(video_path + "/test.mp4");

        Button play_video = v.findViewById(R.id.external_button_play);
        Button pause_video = v.findViewById(R.id.external_button_pause);
        Button stop_video = v.findViewById(R.id.external_button_stop);
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