package com.fpp.rapp.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fpp.rapp.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class RegistroActivity extends AppCompatActivity {

    String api_key = "AIzaSyCNweNUINBFPx2MtgkPAWInVM3bq-OypTA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        YouTubePlayerView ytPlayer = (YouTubePlayerView)findViewById(R.id.ytPlayer2);

        ytPlayer.initialize(api_key, new YouTubePlayer.OnInitializedListener() {
            // Implement two methods by clicking on red
            // error bulb inside onInitializationSuccess
            // method add the video link or the playlist
            // link that you want to play In here we
            // also handle the play and pause
            // functionality
            @Override
            public void onInitializationSuccess(
                    YouTubePlayer.Provider provider,
                    YouTubePlayer youTubePlayer, boolean b)
            {
                youTubePlayer.loadVideo("NUl8yiVZnjo");
                youTubePlayer.play();
            }

            // Inside onInitializationFailure
            // implement the failure functionality
            // Here we will show toast
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult)
            {
                Toast.makeText(getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();
                Log.e("msn","fallo");
            }
        });
    }
}