/*
 * TABLA USUARIO
 */
package com.reproductor.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author MancompSolutions
 */
// TABLA DE USUARIOS
public class Usuario {
    private String usuario;
    private String claver;
    Conexion conexion;
    PreparedStatement pst, pst1;
    ResultSet rs;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClaver() {
        return claver;
    }

    public void setClaver(String claver) {
        this.claver = claver;
    }
    
    }
