package com.fpp.rapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.fpp.rapp.connections.JsonDecoder;
import com.fpp.rapp.fragmnets.BoletinesFragment;
import com.fpp.rapp.fragmnets.CapacitacionFragment;
import com.fpp.rapp.fragmnets.Formulario;
import com.fpp.rapp.fragmnets.GraficasFragment;
import com.fpp.rapp.fragmnets.LoginFragment;
import com.fpp.rapp.fragmnets.MainFragment;
import com.fpp.rapp.fragmnets.NosotrosFragment;
import com.fpp.rapp.fragmnets.YoutubeFragment;
import com.fpp.rapp.fragmnets.infografiassFragment;
import com.fpp.rapp.fragmnets.inicio;
import com.fpp.rapp.fragmnets.legal;
import com.fpp.rapp.model.Posts;

import com.fpp.rapp.model.infografias.Infografias;
import com.fpp.rapp.vistas.VideoPlayerActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    FrameLayout containerView;
    FragmentManager fragManager;
    List<Posts> lista;
    Boolean estado;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        navigationView = findViewById(R.id.nav_bar);
        fragManager = getSupportFragmentManager();
        containerView = (FrameLayout) findViewById(R.id.containerView);
        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        openFragment(MainFragment.newInstance());
        estado =true;
        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Log.e("msn",String.valueOf(item.getItemId()));
                 switch (item.getItemId()){

                    case R.id.nav_account:
                        estado=true;
                        openFragment(MainFragment.newInstance());
                        break;

                    case R.id.legal:
                        estado=false;
                        openFragment(legal.newInstance());
                        break;
                     case R.id.notas:
                         estado=false;
                         openFragment(inicio.newInstance());
                         break;
                    case R.id.boletines:
                        estado=false;
                         openFragment(BoletinesFragment.newInstance());
                         break;

                    case R.id.nav_forms:
                        estado=false;
                         openFragment(GraficasFragment.newInstance());
                         break;
                    case R.id.nosotros:
                        estado=false;
                         openFragment(NosotrosFragment.newInstance());
                         break;

                    case R.id.youtube:
                        estado=false;
                         //openFragment(YoutubeFragment.newInstance());
                         Intent intent = new Intent(getApplicationContext(), VideoPlayerActivity.class);
                         startActivity(intent);
                         break;
                    case R.id.capacitaciones:
                        estado=false;
                         openFragment(CapacitacionFragment.newInstance());
                         break;



                }

                return false;
            }
        });






    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerView, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}