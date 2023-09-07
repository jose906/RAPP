package com.fpp.rapp.connections;

import com.fpp.rapp.model.Forms;
import com.fpp.rapp.model.Posts;
import com.fpp.rapp.model.infografias.Infografias;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonDecoder {

    //foro es categoria 20
    //taller es categoria 21
    //conversatorio es categoria 22
    // boletines es 18
    // fondo 19

    @GET("posts")
    Call<List<Posts>> getcontent();

    @GET("posts")
    Call<List<Posts>> setcontent(@Query("page") int page);

    @GET("posts")
    Call<List<Posts>> getcapacitacion(@Query("categories") int categoria,@Query("page") int page);

    @GET("media")
    Call<List<Infografias>> setinfografias(@Query("page") int page);



}
