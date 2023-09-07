package com.fpp.rapp.fragmnets;

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
import com.fpp.rapp.vistas.FrameActivity;
import com.fpp.rapp.vistas.PdfActivity;


public class ObservatorioFragment extends Fragment {



    CardView reformas,ataques,intimidacion,aparato,procesospenales,condicionamientos,faltasyrestricciones,conflictossosciales;


    public ObservatorioFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ObservatorioFragment newInstance(String param1, String param2) {
        ObservatorioFragment fragment = new ObservatorioFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        reformas = (CardView) view.findViewById(R.id.reformas);
        reformas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url","https://fundacionperiodismo.org/red-de-apoyo-para-periodistas/wp-content/uploads/2022/05/INFORME-REGIONAL-ANDINO-5.pdf");
                startActivity(intent);


            }
        });
        ataques = (CardView) view.findViewById(R.id.ataques);
        ataques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FrameActivity.class);
                intent.putExtra("frame","https://www.noticiasfides.com/nacional/politica/evo-morales-unitel-red-uno-el-deber-y-pagina-siete-son-peor-que-la-bomba-atomica-414046");
                startActivity(intent);


            }
        });
        intimidacion = (CardView) view.findViewById(R.id.intimidacion);
        intimidacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FrameActivity.class);
                intent.putExtra("frame","https://www.paginasiete.bo/nacional/2022/4/24/el-procurador-amenaza-con-dar-su-dosis-pagina-siete-329390.html");
                startActivity(intent);


            }
        });
        aparato = (CardView) view.findViewById(R.id.aparato);
        aparato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FrameActivity.class);
                intent.putExtra("frame","https://eldeber.com.bo/santa-cruz/caso-londras-periodistas-piden-rearticular-la-comision-de-fiscales-y-restituir-a-los-investigadores_267220");
                startActivity(intent);


            }
        });
        procesospenales = (CardView) view.findViewById(R.id.procesospenales);
        procesospenales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FrameActivity.class);
                intent.putExtra("frame","https://www.paginasiete.bo/nacional/2022/4/20/ministerio-de-obras-publicas-anuncia-acciones-legales-contra-pagina-siete-329041.html");
                startActivity(intent);


            }
        });
        condicionamientos = (CardView) view.findViewById(R.id.condicimientos);
        condicionamientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url","https://fundacionperiodismo.org/red-de-apoyo-para-periodistas/wp-content/uploads/2022/05/censura-indirecta.pdf");
                startActivity(intent);


            }
        });
        faltasyrestricciones = (CardView) view.findViewById(R.id.faltasyrestricciones);
        faltasyrestricciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                startActivity(intent);


            }
        });
        conflictossosciales = (CardView) view.findViewById(R.id.conflictossociales);
        conflictossosciales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url","https://fundacionperiodismo.org/red-de-apoyo-para-periodistas/wp-content/uploads/2022/05/PeriodistasConflictosSocialesYReconciliacion-5242721.pdf");
                startActivity(intent);


            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_observatorio, container, false);
    }
}