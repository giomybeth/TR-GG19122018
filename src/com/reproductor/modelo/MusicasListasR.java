/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.modelo;

import java.io.InputStream;

/**
 *
 * @author operador
 */
public class MusicasListasR {
    private int id;
    private String nmCancion;
    private String nmArtista;
    private String url;
    private InputStream imagen;
    private String nmLista;

    public MusicasListasR(int id, String nmCancion, String nmArtista, String url, InputStream imagen, String nmLista) {
        this.id = id;
        this.nmCancion = nmCancion;
        this.nmArtista = nmArtista;
        this.url = url;
        this.imagen = imagen;
        this.nmLista = nmLista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNmCancion() {
        return nmCancion;
    }

    public void setNmCancion(String nmCancion) {
        this.nmCancion = nmCancion;
    }

    public String getNmArtista() {
        return nmArtista;
    }

    public void setNmArtista(String nmArtista) {
        this.nmArtista = nmArtista;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public String getNmLista() {
        return nmLista;
    }

    public void setNmLista(String nmLista) {
        this.nmLista = nmLista;
    }
    
    
    
}
