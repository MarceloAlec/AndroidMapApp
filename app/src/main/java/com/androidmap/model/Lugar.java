package com.androidmap.model;

import com.google.android.gms.maps.model.LatLng;

public class Lugar {

    private int imagen;
    private String nombre;
    private LatLng coordenadas;

    public Lugar(int imagen, String nombre, LatLng coordenadas) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.coordenadas = coordenadas;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LatLng getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(LatLng coordenadas) {
        this.coordenadas = coordenadas;
    }
}
