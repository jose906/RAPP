package com.fpp.rapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fpp.rapp.R;
import com.fpp.rapp.interfaces.onItemClick;
import com.fpp.rapp.model.Posts;
import com.fpp.rapp.model.YoutubeModel.Items;
import com.fpp.rapp.vistas.VideoPlayerActivity;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

public class list_adapter extends RecyclerView.Adapter<list_adapter.ViewHolderDatos> {


    List<Items> items;
    public String videoId;
    private onItemClick listener  = null;


    MyCallBack myCallback;

    public interface MyCallBack{
        void listenerMethod(String textViewvalue);
    }

    public list_adapter(Context context, List<Items> items,MyCallBack myCallback){

        this.myCallback = myCallback;
        this.items= items;


    }



    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list,parent,false);


        return  new ViewHolderDatos(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        holder.titulo.setText(items.get(position).getSnippet().getTitle());
        holder.descripcion.setText(items.get(position).getSnippet().getDescription());
        holder.fecha.setText(items.get(position).getSnippet().getPublishedAt());
        Glide.with(holder.img.getContext()).load(items.get(position).getSnippet().getThumbnails().getHigh().getUrl()).into(holder.img);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                videoId = items.get(holder.getAdapterPosition()).getSnippet().getResourceId().getVideoId();
                myCallback.listenerMethod(videoId);
                notifyDataSetChanged();
                Log.e("vidoe",videoId);




            }
        });


    }



    @Override
    public int getItemCount() {
        return items.size();
    }





    public static class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView titulo,descripcion,fecha;
        ImageView img;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            titulo = (TextView)itemView.findViewById(R.id.text_list_1);
            //scntxt = (TextView) itemView.findViewById(R.id.article_description);
            img = (ImageView)itemView.findViewById(R.id.img_list);
            descripcion = (TextView) itemView.findViewById(R.id.text_list_2);
            fecha = (TextView) itemView.findViewById(R.id.text_list_3);

        }



    }




}
