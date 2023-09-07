package com.fpp.rapp.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fpp.rapp.PaginationScrollListener;
import com.fpp.rapp.R;
import com.fpp.rapp.adapters.list_adapter;
import com.fpp.rapp.adapters.noticias_adapter;
import com.fpp.rapp.conexionBD;
import com.fpp.rapp.model.YoutubeModel.Items;
import com.fpp.rapp.model.YoutubeModel.VideoList;
import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeIntents;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoPlayerActivity extends YouTubeBaseActivity implements list_adapter.MyCallBack  {

    YouTubePlayerView youTubePlayerView;
    String api_key = "AAIzaSyBWtMnAHLSK7fxWTgtUDU8f6m6rwCHVb_A";
    ListView listView;
    YouTubeThumbnailView youTubeThumbnailView;
    List<Items> posts = new ArrayList<>();
    list_adapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Boolean isLoading = false;
    String PageToken = "EAEaBlBUOkNBVQ";
    String videoid= "jY2viMLveQw";
    YouTubePlayer youTubePlayerGlobal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_youtube);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new list_adapter(this,posts,this);
        recyclerView.setAdapter(adapter);



        getvideolist("EAEaBlBUOkNBVQ");
        onscroll();

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube);
        playvideo(videoid);







    }




    public void playvideo(String VideoPlay){




        youTubePlayerView.initialize(api_key, new YouTubePlayer.OnInitializedListener() {
            // Implement two methods by clicking on red
            // error bulb inside onInitializationSuccess
            // method add the video link or the playlist
            // link that you want to play In here we
            // also handle the play and pause
            // functionality
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b)
            {

                Log.e("msn","hola mundo");
                youTubePlayerGlobal = youTubePlayer;
                youTubePlayerGlobal.loadVideo(VideoPlay);


                //youTubePlayer.loadPlaylist("PL5NtJkMKd9SEYLAF-pvJgzO9YCKvmQPQh");
                youTubePlayer.play();
            }


            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }

            // Inside onInitializationFailure
            // implement the failure functionality
            // Here we will show toast
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult)
            {
                Toast.makeText(getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();
                Log.e("msn",youTubeInitializationResult.toString());
            }
        });


    }
    private void onscroll() {


        recyclerView.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {


                //Log.e("num",String.valueOf(page));

                isLoading = true;
                getvideolist(PageToken);


            }

            @Override
            public int getTotalPageCount() {
                return 0;
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

    }


    public void getvideolist(String token){

        conexionBD.getVideos().getvideolist(token).enqueue(new Callback<VideoList>() {
            @Override
            public void onResponse(Call<VideoList> call, Response<VideoList> response) {
                if(response.isSuccessful() && response.body() != null){

                    Log.e("msn","hola");
                    Log.e("videoId",response.body().getItems().get(0).getSnippet().getResourceId().getVideoId());

                    if(response.body().getNextPageToken()!=null){

                        PageToken = response.body().getNextPageToken();
                        isLoading = false;
                    }else {

                        isLoading = true;
                    }


                    posts.addAll(response.body().getItems());
                    adapter.notifyDataSetChanged();




                }else {


                    Log.e("msn","fallo");
                    isLoading = true;
                }


            }

            @Override
            public void onFailure(Call<VideoList> call, Throwable t) {

                Log.e("msn","super fallo");
                isLoading = true;


            }
            
        });

    }



    @Override
    public void listenerMethod(String textViewvalue) {

        playvideo(textViewvalue);
        youTubePlayerGlobal.cueVideo(textViewvalue);
        //Toast.makeText(this, textViewvalue, Toast.LENGTH_SHORT).show();

    }
}