package com.fpp.rapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.LibraryGlideModule;
import com.fpp.rapp.R;
import com.fpp.rapp.conexionBD;
import com.fpp.rapp.model.Posts;
import com.fpp.rapp.vistas.Noticias_View;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

public class noticias_adapter extends RecyclerView.Adapter<noticias_adapter.ViewHolderDatos>{

    List<Posts> datos;


    public noticias_adapter(List<Posts> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_inicio,parent,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        holder.txt.setText(datos.get(position).getTitle().getrendered());
        Glide.with(holder.img.getContext()).load(datos.get(position).getJetpack_featured_media_url()).into(holder.img);
        String time =  datos.get(position).getDate().toString();
        time = time.replace("T", " ");
        holder.scntxt.setText(time);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(), Noticias_View.class);
                intent.putExtra("titulo",datos.get(holder.getAdapterPosition()).getTitle().getrendered().toString());
                intent.putExtra("contenido",datos.get(holder.getAdapterPosition()).getContent().getRendered().toString());
                intent.putExtra("imagen",datos.get(holder.getAdapterPosition()).getJetpack_featured_media_url().toString());
                view.getContext().startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {

        return datos.size();

    }



    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView txt,scntxt;
        ImageView img;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            txt = (TextView)itemView.findViewById(R.id.article_title);
            //scntxt = (TextView) itemView.findViewById(R.id.article_description);
            img = (ImageView)itemView.findViewById(R.id.featured_image);
            scntxt = (TextView) itemView.findViewById(R.id.id_subtitulo);

        }


    }

}
