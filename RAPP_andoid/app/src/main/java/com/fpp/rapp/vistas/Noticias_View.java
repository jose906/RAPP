package com.fpp.rapp.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fpp.rapp.R;

public class Noticias_View extends AppCompatActivity {
    String titulo, cont,img;
    ImageView imageView;
    TextView titu;
    WebView contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias_view);
        titulo = getIntent().getExtras().get("titulo").toString();
        cont = getIntent().getExtras().get("contenido").toString();
        img = getIntent().getExtras().get("imagen").toString();

        Log.e("titulo",img);
        cont =  cont.replace("<img","<img style=\"display:none;\"");


        imageView = (ImageView) findViewById(R.id.img_not);
        titu = (TextView) findViewById(R.id.titulo_not);
        contenido = (WebView) findViewById(R.id.contenido_not);
        Glide.with(getApplicationContext()).load(img).into(imageView);



        contenido.loadData(cont,"text/html; charset=utf-8", "UTF-8");
        contenido.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
                super.onReceivedSslError(view, handler, error);
            }
        });





        titu.setText(titulo);


    }




}