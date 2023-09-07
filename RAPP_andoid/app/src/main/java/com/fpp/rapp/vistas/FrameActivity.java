package com.fpp.rapp.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fpp.rapp.R;

public class FrameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        WebView webView = (WebView) findViewById(R.id.iframes);
        String url = getIntent().getExtras().get("frame").toString();
        String frame = "<iframe src='"+url+"' width='100%' height='850px' frameborder='0' scrolling='auto' style='display: inline-block; width: 1032px; height: 850px;'></iframe>";

        webView.loadData(frame,"text/html","UTF-8");


        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
                super.onReceivedSslError(view, handler, error);
            }
        });





    }
}