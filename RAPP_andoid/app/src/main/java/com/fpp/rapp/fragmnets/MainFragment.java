package com.fpp.rapp.fragmnets;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.fpp.rapp.R;
import com.fpp.rapp.vistas.VideoPlayerActivity;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    ImageView info1, info2,info3,info4,coperantes,aliados;
    YouTubePlayerView youTubePlayerView;
    String api_key = "AAIzaSyBWtMnAHLSK7fxWTgtUDU8f6m6rwCHVb_A";
    String url = "https://rapp.org.bo/";
    ImagePopup imagePopup;
    CardView consultorio, denuncias, capacitacion,observatorio;
    ImageButton button, btnfondo;
   // ImagePopup imagePopup;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters

    public MainFragment() {
        //imagePopup = new ImagePopup(getContext());

        // Required empty public constructor
    }

    private void popup() {


        imagePopup = new ImagePopup(getContext());
        imagePopup.setWindowHeight(600); // Optional
        imagePopup.setWindowWidth(600); // Optional
        imagePopup.setBackgroundColor(Color.argb(150,0,0,0));  // Optional
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setHideCloseIcon(true);  // Optional
        imagePopup.setImageOnClickClose(true);  // Optional



        // Load Image from Drawable


        info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Initiate Popup view **/
                getpopup(url + "wp-content/uploads/2022/03/4.png");

            }
        });
        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Initiate Popup view **/
                getpopup(url+"wp-content/uploads/2022/03/6.png");

            }
        });
        info3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Initiate Popup view **/
                getpopup(url+"wp-content/uploads/2022/03/5.png");

            }
        });
        info4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Initiate Popup view **/
                getpopup(url+"wp-content/uploads/2022/03/3.png");

            }
        });

    }

    public void getpopup(String url){

        Glide.with(info1.getContext()).load(url).into(new CustomTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {

                imagePopup.initiatePopup(resource);
                imagePopup.viewPopup();
            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }
        });

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        info1 = (ImageView)view.findViewById(R.id.info5);
        info2 = (ImageView)view.findViewById(R.id.info6);
        info3 = (ImageView)view.findViewById(R.id.info7);
        info4 = (ImageView)view.findViewById(R.id.info8);
        coperantes = (ImageView)view.findViewById(R.id.coperantes);
        button = (ImageButton)view.findViewById(R.id.youtubes);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), VideoPlayerActivity.class);
                startActivity(intent);
            }
        });
        aliados = (ImageView)view.findViewById(R.id.aliados);
        Glide.with(info1.getContext()).load(url +"wp-content/uploads/2022/03/4.png").into(info1);
        Glide.with(info2.getContext()).load(url+"wp-content/uploads/2022/03/6.png").into(info2);
        Glide.with(info3.getContext()).load(url+"wp-content/uploads/2022/03/5.png").into(info3);
        Glide.with(info4.getContext()).load(url+"wp-content/uploads/2022/03/3.png").into(info4);
        Glide.with(coperantes.getContext()).load(url+"wp-content/uploads/2022/03/images.png").into(coperantes);
        Glide.with(aliados.getContext()).load(url+"wp-content/uploads/2022/03/logo-web-1.png").into(aliados);
        popup();
        openwindows(view);


    }

    private void openwindows(View view) {

        observatorio = (CardView)view.findViewById(R.id.observatorio);
        observatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObservatorioFragment observatorioFragment = new ObservatorioFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerView, observatorioFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });
        consultorio = (CardView) view.findViewById(R.id.consultorio);
        consultorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                legal legal = new legal();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerView, legal, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });
        denuncias = (CardView)view.findViewById(R.id.denuncias);
        denuncias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Formulario formulario =  new Formulario();
                GraficasFragment graficasFragment = new GraficasFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerView, graficasFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        capacitacion = (CardView) view.findViewById(R.id.capacitacion);
        capacitacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CapacitacionFragment capacitacionFragment = new CapacitacionFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerView, capacitacionFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });

        btnfondo=(ImageButton) view.findViewById(R.id.fondo_btn);
        btnfondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FondoFragment fondoFragment = new FondoFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerView, fondoFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });
        if(getinternet()){


        }else {

            nointernet();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    public void nointernet(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("No hay ninguna conexion a internet");
        builder.setMessage("Revise su conexion!");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {




            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }
    public Boolean getinternet(){
        ConnectivityManager cm = (ConnectivityManager)getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();


        return isConnected;

    }


}