package com.fpp.rapp.fragmnets.subfragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fpp.rapp.R;
import com.fpp.rapp.vistas.PdfActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LegalNacionalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LegalNacionalFragment extends Fragment {

    CardView cpe,imprenta,penal,declaracion,nuevo_pro_penal,transparencia,infotmacion,provicions,constitucional;

    String url = "https://rapp.org.bo/";

    public LegalNacionalFragment() {

    }


    public static LegalNacionalFragment newInstance() {
        LegalNacionalFragment fragment = new LegalNacionalFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cpe = (CardView) view.findViewById(R.id.cpe);
        cpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url", url +"wp-content/uploads/2022/04/CPE-Bolivia.pdf");
                intent.putExtra("texto",R.string.cpe);
                startActivity(intent);
            }
        });
        imprenta = (CardView) view.findViewById(R.id.imprenta);
        imprenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url + "wp-content/uploads/2022/04/Ley-de-Imprenta-1925.pdf");
                intent.putExtra("texto",R.string.cpe);
                startActivity(intent);
            }
        });

        penal = (CardView) view.findViewById(R.id.penal);
        penal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url", url + "https://fundacionperiodismo.org/red-de-apoyo-para-periodistas/wp-content/uploads/2022/04/Codigo-Penal-Bolivia.pdf");
                intent.putExtra("texto",R.string.cpe);
                startActivity(intent);
            }
        });
        declaracion = (CardView) view.findViewById(R.id.declaracion);
        declaracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url","wp-content/uploads/2022/04/Ley-general-de-Telecomunicaciones.pdf");
                intent.putExtra("texto",R.string.cpe);
                startActivity(intent);
            }
        });
        nuevo_pro_penal = (CardView) view.findViewById(R.id.nuevo_pro_penal);
        nuevo_pro_penal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url", url +"wp-content/uploads/2022/04/la-Ley-1970.pdf");
                intent.putExtra("texto",R.string.cpe);
                startActivity(intent);
            }
        });
        transparencia = (CardView) view.findViewById(R.id.transparencia);
        transparencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url + "wp-content/uploads/2022/04/Ley-de-Unidades-de-transparencia-y-lucha-contra-la-corrupcion.pdf");
                intent.putExtra("texto",R.string.cpe);
                startActivity(intent);
            }
        });
        infotmacion = (CardView) view.findViewById(R.id.informacion);
        infotmacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url + "wp-content/uploads/2022/04/DS-28168-sobre-Acceso-a-la-Informacion-.pdf");
                intent.putExtra("texto",R.string.cpe);
                startActivity(intent);
            }
        });
        provicions = (CardView) view.findViewById(R.id.provicions);
        provicions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url", url +"wp-content/uploads/2022/04/DS-29174-denominado-_Reglamento-de-Provision-de-Servicios-de-Telecomunicaciones-en-Areas-Rurales-del-Territorio-Nacional_.pdf");
                intent.putExtra("texto",R.string.cpe);
                startActivity(intent);
            }
        });
        constitucional = (CardView) view.findViewById(R.id.constitucional);
        constitucional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url + "wp-content/uploads/2022/04/DS-29174-denominado-_Reglamento-de-Provision-de-Servicios-de-Telecomunicaciones-en-Areas-Rurales-del-Territorio-Nacional_.pdf");
                intent.putExtra("texto",R.string.cpe);
                startActivity(intent);
            }
        });






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_legal_nacional, container, false);
    }
}