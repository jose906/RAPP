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
import android.widget.Button;

import com.fpp.rapp.R;
import com.fpp.rapp.vistas.PdfActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LegalInternacional#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LegalInternacional extends Fragment {
    String url = "https://rapp.org.bo/";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters
    CardView humanos, civiles,nnuu,declaracion,convencion,carta,libertad,antecedentes,cidh;



    public LegalInternacional() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment LegalInternacional.
     */
    // TODO: Rename and change types and number of parameters
    public static LegalInternacional newInstance() {
        LegalInternacional fragment = new LegalInternacional();
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
        humanos=(CardView)view.findViewById(R.id.derechos_humanos);
        humanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url+"wp-content/uploads/2022/04/Declaracion-Universal-de-Derechos-Humanos.pdf");
                intent.putExtra("texto",R.string.articulo19);
                startActivity(intent);
            }
        });
        civiles=(CardView) view.findViewById(R.id.civiles);
        civiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url +"wp-content/uploads/2022/04/Pacto-Internacional-de-Derechos-Civiles-y-Politicos.pdf");
                intent.putExtra("texto",R.string.articulo192);
                startActivity(intent);

            }
        });
        nnuu=(CardView) view.findViewById(R.id.nnuu);
        nnuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url","wp-content/uploads/2022/04/Pacto-Internacional-de-Derechos-Civiles-y-Politicos.pdf");
                intent.putExtra("texto",R.string.nnuu);
                startActivity(intent);

            }
        });
        declaracion = (CardView)view.findViewById(R.id.declaracion);
        declaracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url + "wp-content/uploads/2022/04/DECLARACION-AMERICANA-DE-LOS-DERECHOS-Y-DEBERES-DEL-HOMBRE.pdf");
                intent.putExtra("texto",R.string.articulo4);
                startActivity(intent);
            }
        });
        convencion = (CardView) view.findViewById(R.id.convencion);
        convencion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url +"wp-content/uploads/2022/04/CONVENCION-AMERICANA-SOBRE-DERECHOS-HUMANOS.pdf");
                intent.putExtra("texto",R.string.articulo13);
                startActivity(intent);

            }
        });
        carta=(CardView)view.findViewById(R.id.carta);
        carta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url +"wp-content/uploads/2022/04/Carta-Democratica-Interamericana-.pdf");
                intent.putExtra("texto",R.string.articulo42);
                startActivity(intent);
            }
        });
        libertad=(CardView) view.findViewById(R.id.libertad);
        libertad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url + "wp-content/uploads/2022/04/DECLARACION-DE-PRINCIPIOS-SOBRE-LIBERTAD-DE-EXPRESION-.pdf");
                intent.putExtra("texto",R.string.principios);
                startActivity(intent);
            }
        });
        antecedentes=(CardView)view.findViewById(R.id.antecedentes);
        antecedentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PdfActivity.class);
                intent.putExtra("url",url + "wp-content/uploads/2022/04/Antecedentes-e-interpretacion-de-la-declaracion-de-principios.pdf");
                intent.putExtra("texto",R.string.principio1);
                startActivity(intent);
            }
        });
        cidh=(CardView) view.findViewById(R.id.cidh);
        cidh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Intent intent = new Intent(getContext(), PdfActivity.class);
                //intent.putExtra("url","");
               // startActivity(intent);

            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_legal_internacional, container, false);
    }
}