package com.example.usuario.recyclerview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.session.MediaController;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;


public class VideoFragment extends Fragment  {
    private MediaController mediaController;
    private Uri uri;
    private YouTubePlayer YPlayer;
    private static final int RECOVERY_DIALOG_REQUEST = 1;


    public VideoFragment() {

    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video, container, false);
/*
        VideoView view = (VideoView)v.findViewById(R.id.videoView);
        view.setVideoURI(Uri.parse("http://techslides.com/demos/sample-videos/small.mp4"));
        view.setMediaController(new android.widget.MediaController(getActivity()));
        view.requestFocus();
        view.start();
*/

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_fragment, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize("xxxxxxxxxxx", new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider arg0, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    Bundle bundle = getArguments();
                    if (bundle != null) {



                    YPlayer = youTubePlayer;
                    YPlayer.setFullscreen(false);
                    YPlayer.loadVideo(bundle.getString("video"));
                 //  YPlayer.play();

                }
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {


            }
        });



        return v;
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }

    // TODO: Rename method, update argument and hook method into UI event
}