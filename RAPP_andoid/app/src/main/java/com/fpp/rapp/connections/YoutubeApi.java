package com.fpp.rapp.connections;

import com.fpp.rapp.model.Posts;
import com.fpp.rapp.model.YoutubeModel.VideoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeApi {

    @GET("playlistItems?part=snippet&playlistId=PL5NtJkMKd9SEYLAF-pvJgzO9YCKvmQPQh&key=AIzaSyBWtMnAHLSK7fxWTgtUDU8f6m6rwCHVb_A")
    Call<VideoList> getvideolist(@Query("pageToken") String token);

}
