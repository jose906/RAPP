package com.fpp.rapp;

import android.os.Handler;
import android.util.Log;

import com.fpp.rapp.connections.JsonDecoder;
import com.fpp.rapp.connections.JsonDecoder2;
import com.fpp.rapp.connections.YoutubeApi;
import com.fpp.rapp.model.Posts;
import com.fpp.rapp.modulos.UnsafeOkHttpClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.cert.CertificateException;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class conexionBD {

    private static final String baseURl = "https://rapp.org.bo/wp-json/wp/v2/";
    private static final String baseURl2 = "https://reserhost.com/fpp/controladores/cursos327/mensajes239/";
    private static final String youtubeurl = "https://youtube.googleapis.com/youtube/v3/";
    private static Retrofit retrofit = null;
    private static Retrofit retrofit2 = null;
    private static Retrofit youtubeapi = null;

    List<Posts> lista;
    public conexionBD() {



    }
    public static JsonDecoder getRetrofit(){
        if(retrofit == null ){
            retrofit =new Retrofit.Builder().baseUrl(baseURl).client(UnsafeOkHttpClient.getUnsafeOkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(JsonDecoder.class);

    }
    public static JsonDecoder2 getRetrofit2(){
        Gson gson = new GsonBuilder().setLenient().create();
        if(retrofit2 == null ){

            retrofit2 =new Retrofit.Builder().baseUrl(baseURl2).client(UnsafeOkHttpClient.getUnsafeOkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit2.create(JsonDecoder2.class);

    }
    public static YoutubeApi getVideos(){
        Gson gson = new GsonBuilder().setLenient().create();
        if(youtubeapi == null ){

            youtubeapi =new Retrofit.Builder().baseUrl(youtubeurl).client(UnsafeOkHttpClient.getUnsafeOkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return youtubeapi.create(YoutubeApi.class);

    }

    public List<Posts> getposts(){

        JsonDecoder jsonDecoder = retrofit.create(JsonDecoder.class);
        //Posts posts = new Posts();

        Call<List<Posts>> call = jsonDecoder.getcontent();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
            List<Posts> posts1 = response.body();
            Log.e("Lista", String.valueOf(posts1));
            lista = posts1;
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

                Log.e("error",t.getMessage().toString());

            }
        });

        return lista;
    }

}
