/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.RepositoryController;

import com.reproductor.modelo.Artistas;
import com.reproductor.modelo.Conexion;
import com.reproductor.vistas.Principal;
import com.reproductor.vistas.paneles.pnlListaReproduccion;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListRController implements ActionListener, MouseListener {

    FileInputStream fis, fism;
    int logitudByte, longitudByteM;
    Artistas art = new Artistas();
    String artista_id = "";
    String valorSeleccionado;
    int idArtista = 0;
    int idGenero = 0;
    int fila;
    Conexion conexion = new Conexion();
    Principal interfaz = new Principal();
    pnlListaReproduccion list = new pnlListaReproduccion();

    public ListRController(Principal interfaz, Artistas artistas, pnlListaReproduccion listP) {
        this.interfaz = interfaz;
        this.art = artistas;
        this.list = listP;
        
         this.list.BtnEnviar.addActionListener(this);
        this.list.BtnGuardar.addActionListener(this);
        this.list.BtnReset.addActionListener(this);
        this.list.tblCargarMusica.addMouseListener(this);
        cargarData(this.list.tblCargarMusica);
        /*DESACTIVAR LOS BOTONES*/
        this.list.BtnEnviar.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.list.BtnEnviar) {
            DefaultTableModel modelo = (DefaultTableModel) this.list.tblListaRepr.getModel();
            DefaultTableModel modelo2 = (DefaultTableModel) this.list.tblCargarMusica.getModel();
            ArrayList datos = new ArrayList();
            datos.add(String.valueOf(this.list.tblCargarMusica.getValueAt(fila, 0)));
            datos.add(String.valueOf(this.list.tblCargarMusica.getValueAt(fila, 1)));
            modelo.addRow(datos.toArray());
            this.list.tblListaRepr.setModel(modelo);
            this.list.tblListaRepr.getColumnModel().getColumn(0).setMinWidth(50);
            this.list.tblListaRepr.getColumnModel().getColumn(0).setMaxWidth(50);
            this.list.tblListaRepr.getColumnModel().getColumn(0).setMinWidth(150);
            this.list.tblListaRepr.getColumnModel().getColumn(0).setMaxWidth(200);
            /*eliminamos la fila seleccionada de la lista de canciones*/
            modelo2.removeRow(fila);
        } else if (ae.getSource() == this.list.BtnGuardar) {
            int idLista = 0;
            ResultSet rs2;
            PreparedStatement ps, ps2;
            conexion = new Conexion();
            //GUARDAMOS LOS DATOS EN LA  TABLA DE LA LISTA
            try {
                String sql = "INSERT INTO tb_listap ( nombre, status) "
                        + "VALUES ( ?, ?)";
                ps = conexion.getConnection().prepareStatement(sql);
                ps.setString(1, this.list.txtNombre.getText());//NOMBRE
                ps.setString(2, "1");//ARTISTA
                ps.execute();
                //OBTENGO EL ID DE LA LISTA CREADA
                try {
                    rs2 = conexion.obtenerDatos("SELECT* FROM tb_listap where nombre='" + this.list.txtNombre.getText() + "' ");
                    while (rs2.next()) {
                        idLista = rs2.getInt("id");
                    }
                    System.out.println("SEGUNDO SELECT:");
                    //GUARDO EL DETALLE DE LA LISTA DE REPRODUCCION
                    try {
                        String sql2 = "INSERT INTO tb_dLista (canciones,lista, status) "
                                + "VALUES ( ?, ?, ?)";
                        for (int i = 0; i < (this.list.tblListaRepr.getRowCount()); i++) {
                            ps2 = conexion.getConnection().prepareStatement(sql2);
                            ps2.setInt(1, Integer.parseInt(String.valueOf(this.list.tblListaRepr.getValueAt(i, 0))));//CANCIONES
                            ps2.setInt(2, Integer.parseInt(String.valueOf(idLista)));//LISTA
                            ps2.setString(3, "1");//LISTA
                            ps2.execute();

                        }
                        JOptionPane.showMessageDialog(null, "Lista de Reproduccion agregada correctamente.");
                        reset();

                    } catch (SQLException e) {
                        System.out.println("ERROR:" + e);
                    }
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                ps.close();

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } else {
             reset();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.list.tblCargarMusica) {
            fila = this.list.tblCargarMusica.getSelectedRow();
            if (fila >= 0) {
                this.list.BtnEnviar.setEnabled(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
    public void reset(){
        this.list.txtNombre.setText("");
        this.list.BtnEnviar.setEnabled(false);
        cargarData(this.list.tblCargarMusica);
        DefaultTableModel modelo2 = new DefaultTableModel();
        modelo2.addColumn("CD");
        modelo2.addColumn("Cancion Lista Reproducción");
        this.list.tblListaRepr.setModel(modelo2);
        this.list.tblListaRepr.getColumnModel().getColumn(0).setMinWidth(50);
        this.list.tblListaRepr.getColumnModel().getColumn(0).setMaxWidth(50);
    }
    public void cargarData(JTable tblDatos) {
        conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("CD");
        modelo.addColumn("Canción Grabadas");
        String sentencia = "select id_cancion,nm_cancion from tb_cancion";
        try {
            ResultSet rs = conexion.obtenerDatos(sentencia);
            while (rs.next()) {
                ArrayList datos = new ArrayList();
                datos.add(rs.getInt(1));
                datos.add(rs.getString(2).trim());
                modelo.addRow(datos.toArray());
            }
            tblDatos.setModel(modelo);

            tblDatos.getColumnModel().getColumn(0).setMinWidth(50);
            tblDatos.getColumnModel().getColumn(0).setMaxWidth(50);

            tblDatos.getColumnModel().getColumn(0).setMinWidth(150);
            tblDatos.getColumnModel().getColumn(0).setMaxWidth(200);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
