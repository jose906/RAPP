package com.fpp.rapp.fragmnets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fpp.rapp.PaginationScrollListener;
import com.fpp.rapp.R;
import com.fpp.rapp.adapters.noticias_adapter;
import com.fpp.rapp.conexionBD;
import com.fpp.rapp.model.Posts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FondoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FondoFragment extends Fragment {

    ArrayList<String> datos;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager linearLayoutManager;
    List<Posts> posts = new ArrayList<>();
    noticias_adapter adapter;
    int page = 1;
    public  boolean isLoading = false;
    boolean lastpage;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters


    public FondoFragment() {
        // Required empty public constructor
    }
    private void onscroll() {


        recyclerView.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {

                int currentPage = ++page;
                Log.e("num",String.valueOf(page));

                isLoading = true;
                fetchposts(currentPage);


            }

            @Override
            public int getTotalPageCount() {
                return 0;
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

    }
    private void fetchposts(int a) {
        progressBar.setVisibility(View.VISIBLE);
        conexionBD.getRetrofit().getcapacitacion(19,page).enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(response.isSuccessful() && response.body() != null){

                    posts.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    Log.e("code",String.valueOf(response.code()));
                    isLoading = false;


                }else {
                    progressBar.setVisibility(View.GONE);
                    Log.e("rsp","respuesta falla");
                    isLoading=true;
                }

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "fallo", Toast.LENGTH_SHORT).show();
                Log.e("servidor",t.getCause().getMessage());
                Log.e("servidor",t.toString());
                Log.e("servidor",t.getLocalizedMessage());

            }
        });


        Log.e("valor",String.valueOf(isLoading));

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     */
    // TODO: Rename and change types and number of parameters
    public static FondoFragment newInstance() {
        FondoFragment fragment = new FondoFragment();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.fondo_concursable);
        progressBar = (ProgressBar)view.findViewById(R.id.progress_bar_fondo);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new noticias_adapter(posts);
        recyclerView.setAdapter(adapter);
        fetchposts(page);
        onscroll();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fondo, container, false);
    }
}