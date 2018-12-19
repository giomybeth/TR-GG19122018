/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author operador
 */
public class UsuarioDaoImpl {

    Conexion conexion;
    PreparedStatement pst, pst1;
    ResultSet rs;
    ResultSet rs1;

    public Usuario iniciarSesion(String user, String pass) {
        Usuario usuario = null;
        conexion = new Conexion();
        String s_usuario = "select nombre,clave from tb_user where nombre = ? and clave = ?";
        
        try {
            pst = conexion.getConnection().prepareStatement(s_usuario);
            pst.setString(1, user);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setUsuario(rs.getString(1).trim());
                usuario.setClaver(rs.getString(2).trim());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);//usuario = null;
        }
        return usuario;

    }
    
    public int registrar(String user, String pass) {
       int result= 0;
        conexion = new Conexion();
       String insertTableSQL = "INSERT INTO tb_user (nombre, clave) VALUES (?,?)";
         
        try {
            pst = conexion.getConnection().prepareStatement(insertTableSQL);
            pst.setString(1, user);
            pst.setString(2, pass);
            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                result=1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);//usuario = null;
            result = 0;
        }
        return result;

    }

}
