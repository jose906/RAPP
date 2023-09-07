package com.fpp.rapp.fragmnets;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.fpp.rapp.R;
import com.fpp.rapp.fragmnets.subfragments.LegalInternacional;
import com.fpp.rapp.fragmnets.subfragments.LegalNacionalFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link legal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class legal extends Fragment {

    FrameLayout containerView;
    FragmentManager fragManager;
    Context myContext;
    Button btnnacional,btninternacional;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters

    public legal() {




        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     */
    // TODO: Rename and change types and number of parameters
    public static legal newInstance() {
        legal fragment = new legal();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myContext = getContext();
        fragManager = ((FragmentActivity) myContext).getSupportFragmentManager();
        containerView = (FrameLayout) view.findViewById(R.id.container_2);
        btnnacional = (Button) view.findViewById(R.id.btn_nacional);
        btnnacional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               openFragment(LegalNacionalFragment.newInstance());


            }
        });
        btninternacional=(Button)view.findViewById(R.id.btn_internacional);
        btninternacional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment(LegalInternacional.newInstance());
            }
        });
        openFragment(LegalInternacional.newInstance());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_legal, container, false);
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = ((FragmentActivity) myContext).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_2, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}