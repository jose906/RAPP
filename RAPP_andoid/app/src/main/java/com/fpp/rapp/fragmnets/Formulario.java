package com.fpp.rapp.fragmnets;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.fpp.rapp.MainActivity;
import com.fpp.rapp.R;
import com.fpp.rapp.conexionBD;
import com.fpp.rapp.connections.JsonDecoder2;
import com.fpp.rapp.model.Forms;
import com.fpp.rapp.model.Posts;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Formulario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Formulario extends Fragment {
    String apellidos,nombres,nacionalidad="",fechan="",ci,direccion="",correo="",denuncia="",libertad="";
    String c1="",c2="",c3="",c4="",c5="",c6="",c7="",c8="",hechos="",detalle="";
    int telefono,ciudad;
    Spinner spinner;
    ArrayAdapter<CharSequence> CiudadSpinner;
    EditText ETapellido,ETnombre,ETnacionalidad,ETfecha,ETci,ETdireccion,ETcorreo,ETtelefono,bigtext,bigtext2;
    RadioButton rb1,rb2,rb3,rb4;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;
    Button enviar,btnselect;
    Bitmap bitmap;
    String path1 = "";




    public Formulario() {
        // Required empty public constructor




    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Formulario newInstance() {
        Formulario fragment = new Formulario();
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

        spinner = (Spinner) view.findViewById(R.id.spinner);
        CiudadSpinner = ArrayAdapter.createFromResource(getContext(),R.array.ciudades,R.layout.new_spinner);
        spinner.setAdapter(CiudadSpinner);
        ETapellido =(EditText) view.findViewById(R.id.apellido);
        ETnombre =(EditText) view.findViewById(R.id.nombre);
        ETnacionalidad=(EditText)view.findViewById(R.id.nacionalidad);
        ETfecha = (EditText) view.findViewById(R.id.fecha_lugar);
        ETci = (EditText) view.findViewById(R.id.num_ci);
        ETdireccion=(EditText)view.findViewById(R.id.domicilio);
        ETcorreo=(EditText) view.findViewById(R.id.correo);
        ETtelefono = (EditText)view.findViewById(R.id.telefono);
        rb1=(RadioButton) view.findViewById(R.id.rb1);
        rb2=(RadioButton) view.findViewById(R.id.rb2);
        rb3=(RadioButton) view.findViewById(R.id.rb3);
        rb4=(RadioButton) view.findViewById(R.id.rb4);
        cb1=(CheckBox) view.findViewById(R.id.check1);
        cb2=(CheckBox) view.findViewById(R.id.check2);
        cb3=(CheckBox)view.findViewById(R.id.check3);
        cb4 = (CheckBox) view.findViewById(R.id.check4);
        cb5 = (CheckBox) view.findViewById(R.id.check5);
        cb6=(CheckBox) view.findViewById(R.id.check6);
        cb7=(CheckBox) view.findViewById(R.id.check7);
        cb8=(CheckBox) view.findViewById(R.id.check8);
        bigtext=(EditText)view.findViewById(R.id.textoGrande);
        bigtext2=(EditText)view.findViewById(R.id.textoGrande2);
        enviar=(Button) view.findViewById(R.id.enviar);
        btnselect = (Button)view.findViewById(R.id.select_file);

        getinfotxt();

        selectfile();



    }

    private void selectfile() {

        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(galleryIntent, 1);

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {

                    bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), contentURI);



                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        }
    }

    private void getinfotxt() {

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ETnombre.getText().toString().equals("")&&ETapellido.getText().toString().equals("")&&ETci.getText().toString().equals("")) {

                    Log.e("mundo","hola");


                }else{

                    apellidos = ETapellido.getText().toString();
                    nombres = ETnombre.getText().toString();
                    nacionalidad = ETnacionalidad.getText().toString();
                    fechan = ETfecha.getText().toString();
                    ci = ETci.getText().toString();
                    direccion = ETdireccion.getText().toString();
                    correo = ETcorreo.getText().toString();
                    ciudad = spinner.getSelectedItemPosition();
                    if(ETtelefono.getText().toString().equals("")){

                        telefono=1;

                    }else{
                    telefono = Integer.parseInt(ETtelefono.getText().toString());
                    }
                    if (rb1.isChecked()) {
                        denuncia = "Esta denuncia la presento en nombre propio";
                    }
                    if (rb2.isChecked()) {

                        denuncia = "Nombre de otra persona";
                    }
                    if (rb3.isChecked()) {

                        libertad = "La presunta victima se encuentra en libertad";
                    }
                    if (rb4.isChecked()) {

                        libertad = "o privada de libertad";

                    }
                    if (cb1.isChecked()) {

                        c1 = cb1.getText().toString();

                    }
                    if (cb2.isChecked()) {

                        c2 = cb2.getText().toString();

                    }
                    if (cb3.isChecked()) {


                        c3 = cb3.getText().toString();

                    }
                    if (cb4.isChecked()) {

                        c4 = cb4.getText().toString();
                    }
                    if (cb5.isChecked()) {

                        c5 = cb5.getText().toString();


                    }
                    if (cb6.isChecked()) {

                        c6 = cb6.getText().toString();


                    }
                    if (cb7.isChecked()) {

                        c7 = cb7.getText().toString();
                    }
                    if (cb8.isChecked()) {

                        c8 = cb8.getText().toString();

                    }

                    hechos = bigtext.getText().toString();
                    detalle = bigtext2.getText().toString();

                    savedata();
                }


            }
        });
    }


    public  void savedata(){

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);



        conexionBD.getRetrofit2().setForms2(apellidos,nombres,ci,nacionalidad,fechan,direccion,correo,denuncia,libertad,telefono,ciudad,c1,c2,c3,c4,c5,c6,c7,c8,hechos,detalle,encodedImage).enqueue(new Callback<List<Forms>>() {
            @Override
            public void onResponse(Call<List<Forms>> call, Response<List<Forms>> response) {

                if(response.isSuccessful() && response.body() != null){

                    Log.e("rsp",String.valueOf(response.code()));
                    Log.e("servidor",response.body().get(0).getResponse().toString());
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Datos enviados correctamente");
                    builder.setMessage("Todos los datos fueron enviados correctamente");
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent intent = new Intent(getContext(), MainActivity.class);
                            startActivity(intent);

                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();




                }else {

                    Log.e("rsp","incorrecto");
                    Log.e("codigo",String.valueOf(response.code()));
                    Log.e("msn",response.message());

                }

            }

            @Override
            public void onFailure(Call<List<Forms>> call, Throwable t) {

            }
        });



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_formulario, container, false);
    }
}