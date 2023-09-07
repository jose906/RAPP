package com.fpp.rapp.fragmnets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.fpp.rapp.R;
import com.fpp.rapp.conexionBD;
import com.fpp.rapp.model.Posts;
import com.fpp.rapp.model.infografias.Infografias;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link infografiassFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class infografiassFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    String[] links;
    Boolean estado = true;
    List<String> links2 = new ArrayList<>();
    ImageView info1,info2,info3,info4;



    public infografiassFragment() {







        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment infografiassFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static infografiassFragment newInstance() {
        infografiassFragment fragment = new infografiassFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
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

        info1 = (ImageView) view.findViewById(R.id.info1);
        info2 = (ImageView) view.findViewById(R.id.info2);
        info3 = (ImageView) view.findViewById(R.id.info3);
        info4 = (ImageView) view.findViewById(R.id.info4);

        setImages();
    }

    private void setImages() {

        Glide.with(info1.getContext()).load("https://fundacionperiodismo.org/red-de-apoyo-para-periodistas/wp-content/uploads/2022/03/4.png").into(info1);
        Glide.with(info2.getContext()).load("https://fundacionperiodismo.org/red-de-apoyo-para-periodistas/wp-content/uploads/2022/03/6.png").into(info2);
        Glide.with(info3.getContext()).load("https://fundacionperiodismo.org/red-de-apoyo-para-periodistas/wp-content/uploads/2022/03/5.png").into(info3);
        Glide.with(info4.getContext()).load("https://fundacionperiodismo.org/red-de-apoyo-para-periodistas/wp-content/uploads/2022/03/3.png").into(info4);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_infografiass, container, false);
    }

    private void getimages(int b){
        conexionBD.getRetrofit().setinfografias(b).enqueue(new Callback<List<Infografias>>() {
            @Override
            public void onResponse(Call<List<Infografias>> call, Response<List<Infografias>> response) {
                if(response.isSuccessful() && response.body() != null){
                    for (int a=0;a < response.body().size();a++ ){
                        if(response.body().get(a).getGuid().getRendered().contains("arte")){
                            Log.e("hola",response.body().get(a).getGuid().getRendered().toString());
                            links2.add(response.body().get(a).getGuid().getRendered().toString());

                        }
                        else{

                            Log.e("else",response.body().get(a).getGuid().getRendered());

                        }
                    }
                }else {

                    Log.e("rsp","repueta falla");
                }
            }

            @Override
            public void onFailure(Call<List<Infografias>> call, Throwable t) {

            }
        });


    }
}