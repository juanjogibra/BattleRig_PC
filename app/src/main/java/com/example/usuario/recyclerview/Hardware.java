package com.example.usuario.recyclerview;

import java.io.Serializable;

public class Hardware implements Serializable {

    private String nombre;
    private String info;
    private String infolarga;
    private boolean favorito;
    private int fotoid;
    private String URL;
    private String videoid;


    public Hardware()  {

    }

    public Hardware(String nombre, String info, String infolarga, int fotoid, boolean favorito, String URL, String videoid) {
        this.nombre = nombre;
        this.info = info;
        this.infolarga = infolarga;
        this.fotoid = fotoid;
        this.favorito = favorito;
        this.URL = URL;
        this.videoid = videoid;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFotoid() {
        return fotoid;
    }

    public void setFotoid(int fotoid) {
        this.fotoid = fotoid;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getURL() {
        return URL;
    }

    public String getInfolarga() {
        return infolarga;
    }

    public void setInfolarga(String infolarga) {
        this.infolarga = infolarga;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }
}
