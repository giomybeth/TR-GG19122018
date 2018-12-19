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
public class Favoritos {
    private int id;
    private int idCancion;
    private String nmCancion;
    private String Artista;
    private String album;
    private InputStream imagen;
    private String Url;

    public Favoritos(int id, int idCancion, String nmCancion, String Artista, String album, InputStream imagen, String Url) {
        this.id = id;
        this.idCancion = idCancion;
        this.nmCancion = nmCancion;
        this.Artista = Artista;
        this.album = album;
        this.imagen = imagen;
        this.Url = Url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNmCancion() {
        return nmCancion;
    }

    public void setNmCancion(String nmCancion) {
        this.nmCancion = nmCancion;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getArtista() {
        return Artista;
    }

    public void setArtista(String Artista) {
        this.Artista = Artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }
    
    
    
}
