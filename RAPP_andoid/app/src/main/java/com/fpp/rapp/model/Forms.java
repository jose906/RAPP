package com.fpp.rapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forms {


    String apellidos;
    String nombres;
    String ci;
    String nacionalidad;
    String fechan;
    int telefono;
    String direccion;
    int ciudad;
    String correo;
    String denuncia;
    String libertad;
    String c1;
    String c2;
    String c3;
    String c4;
    String c5;
    String c6;
    String c7;
    String c8;
    String hechos;
    String detalle;
    String response;

    public Forms(String apellidos, String nombres, String ci, String nacionalidad, String fechan, int telefono, String direccion, int ciudad, String correo, String denuncia, String libertad, String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String hechos, String detalle) {
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.ci = ci;
        this.nacionalidad = nacionalidad;
        this.fechan = fechan;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.correo = correo;
        this.denuncia = denuncia;
        this.libertad = libertad;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
        this.c5 = c5;
        this.c6 = c6;
        this.c7 = c7;
        this.c8 = c8;
        this.hechos = hechos;
        this.detalle = detalle;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setFechan(String fechan) {
        this.fechan = fechan;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDenuncia(String denuncia) {
        this.denuncia = denuncia;
    }

    public void setLibertad(String libertad) {
        this.libertad = libertad;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public void setC5(String c5) {
        this.c5 = c5;
    }

    public void setC6(String c6) {
        this.c6 = c6;
    }

    public void setC7(String c7) {
        this.c7 = c7;
    }

    public void setC8(String c8) {
        this.c8 = c8;
    }

    public void setHechos(String hechos) {
        this.hechos = hechos;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public String getCi() {
        return ci;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getFechan() {
        return fechan;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCiudad() {
        return ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDenuncia() {
        return denuncia;
    }

    public String getLibertad() {
        return libertad;
    }

    public String getC1() {
        return c1;
    }

    public String getC2() {
        return c2;
    }

    public String getC3() {
        return c3;
    }

    public String getC4() {
        return c4;
    }

    public String getC5() {
        return c5;
    }

    public String getC6() {
        return c6;
    }

    public String getC7() {
        return c7;
    }

    public String getC8() {
        return c8;
    }

    public String getHechos() {
        return hechos;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getResponse() {
        return response;
    }


}

