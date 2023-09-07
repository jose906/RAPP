package com.fpp.rapp.connections;

import com.fpp.rapp.model.Forms;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface JsonDecoder2{


        @POST("enviarformulario.php")
        Call<List<Forms>> setForms(@Body Forms forms);

        @POST("enviarformulario.php")
        @FormUrlEncoded
        Call<List<Forms>> setForms2(@Field("apellidos") String apellidos,
                                    @Field("nombres") String nombres,
                                    @Field("ci") String ci,
                                    @Field("nacionalidad") String nacionalidad,
                                    @Field("fechan") String fecha,
                                    @Field("direccion") String direccion,
                                    @Field("correo") String correo,
                                    @Field("denuncia") String denuncia,
                                    @Field("libertad") String libertad,
                                    @Field("telefono") int telefono,
                                    @Field("ciudad") int ciudad,
                                    @Field("c1") String c1,
                                    @Field("c2") String c2,
                                    @Field("c3") String c3,
                                    @Field("c4") String c4,
                                    @Field("c5") String c5,
                                    @Field("c6") String c6,
                                    @Field("c7") String c7,
                                    @Field("c8") String c8,
                                    @Field("hechos") String hechos,
                                    @Field("detalle") String detalle,
                                    @Field("image") String image
                                    );

}
