package com.reproductor.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public final class Conexion {

    // VARIABLE DE USUARIO DE CONEXION A LA BASE DE DATOS, POR DEFECTO ES postgres
    static String user = "postgres";
    // CONTRASEÑA DEL USUARIO DE LA BASE DE DATOS(ESTO SE CONFIGURA CUANDO SE instala el gestor de base de datos)
    static String clave ="123";
    //CADENA DE CONEXION, GENERALMENTE ESTA ES POR DEFAULT SOLO SE CAMBIA EL PUERTO(SIEMPRE Y CUANDO SE CAMBIA CUANDO SE INSTALA EL GESTOR),
    //AL ULTIMO SE PONE EL NOMBRE DE LA BASE DE DATOS "bd_uicombobox"
    //EL LOCALHOST ES EL NOMBRE DE LA MAQUINA; COMO EL GESTOR DE LA BASE DE DATOS ESTA EN LA MISMA MAQUINA SE PUEDE PONER LOCALHOST O LA IP, LA
    //IP DEBE DE ESTAR CONFIGURADA ESTATICAMENTE
    static String url = "jdbc:postgresql://localhost:5432/bd_reproductor";
    
    //VARIABLE CONNECTION; POR DEFAULT SE INICIALIZA EN NULL
    Connection conn = null;

    //METODO DE CONEXION
    public Conexion() {
        //TRY CATCH CAPTURA POSIBLES ERRORES CUANDO SE EJECUTA LA SENTENCIA.
        try {
            /*inicializamos nuestra clase conexion*/
            Class.forName("org.postgresql.Driver").newInstance();
            /*REALIZAMOS LA CONEXION  a la bd*/
            conn = DriverManager.getConnection(url, user, clave);
            if (conn != null) {
                //System.out.println("Conexión a la base de Datos" + url + "...OK");
            }
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
           // MUESTRA UN MENSAJE CON EL ERROR QUE SE PRESENTE
            JOptionPane.showMessageDialog(null, ex);
            //CIERRA EL MENSAJE
            System.exit(0);
        }
    }
    /*DEVUELVE LA CONEXION PARA SABER SI SE A REALIZADO CORRECTAMENTE*/
    public Connection getConnection() {
        return conn;
    }

    /*CERRAR LA CONEXION*/
    public void desconectar() {
        conn = null;
        if (conn != null) {
            JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexion a la BD");
        }
    }
    //obtener los datos a traves de un resulset
    public ResultSet obtenerDatos(String sql) {
       ResultSet rs = null;
        try {
            // SE ESTABLECE LA CONEXION A LA BASE DE DATOS
            Connection accesoDB = this.getConnection();
            // Statement nos suministra tres métodos diferentes para ejecutar sentencias SQL
            Statement st = accesoDB.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("ERROR OBTENER DATOS:"+e.getMessage());
        }

        return rs;
    }

}
