package com.fpp.rapp.fragmnets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fpp.rapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NosotrosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NosotrosFragment extends Fragment {



    // TODO: Rename and change types of parameters


    public NosotrosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment NosotrosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NosotrosFragment newInstance() {
        NosotrosFragment fragment = new NosotrosFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nosotros, container, false);
    }
}