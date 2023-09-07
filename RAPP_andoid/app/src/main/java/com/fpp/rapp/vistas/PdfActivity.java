package com.fpp.rapp.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fpp.rapp.R;
import com.fpp.rapp.modulos.UnsafeOkHttpClient;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class PdfActivity extends AppCompatActivity {

    PDFView pdfView;
    String pdfurl,previo;
    TextView textView;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);


        pdfurl = getIntent().getStringExtra("url");
        textView = (TextView)findViewById(R.id.texto_previo);
        int a = getIntent().getIntExtra("texto",0);
        if (a != 0) {
            previo = getResources().getString(a);
            textView.setText(previo);
        }

        progressBar=(ProgressBar)findViewById(R.id.progress_bar2);
        progressBar.setVisibility(View.VISIBLE);
        pdfView = findViewById(R.id.idPDFView);
        new RetrivePDFfromUrl().execute(pdfurl);

    }
    class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {

            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);

                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.setSSLSocketFactory(UnsafeOkHttpClient.getUnsafeOkHttpClient().sslSocketFactory());
                if (urlConnection.getResponseCode() == 200) {

                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            } catch (IOException e) {

                e.printStackTrace();
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            // after the execution of our async
            // task we are loading our pdf in our pdf view.
            pdfView.fromStream(inputStream).enableSwipe(false).enableDoubletap(true).load();

            pdfView.fitToWidth();
            pdfView.fitToWidth(1);

            pdfView.setSwipeVertical(true);

            progressBar.setVisibility(View.GONE);
        }
    }


}