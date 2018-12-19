/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.RepositoryController;

import com.reproductor.vistas.paneles.consultas.pnlArtistas;
import com.reproductor.modelo.Conexion;
import com.reproductor.vistas.Principal;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CancionArtistaController implements ActionListener, MouseListener {

    Conexion conexion = new Conexion();
    Principal interfaz = new Principal();
    pnlArtistas pnlGener = new pnlArtistas();
    int fila;
    String slc_artistas = "select id_artista,nm_artista,st_artista from tb_artista where st_artista='1'";
    int idArtista = 0;
    String artista_id = "";
    String valorSeleccionado;

    public CancionArtistaController(pnlArtistas gen) {
        this.pnlGener = gen;

        this.pnlGener.btnEliminar.addActionListener(this);
        this.pnlGener.btnModificar.addActionListener(this);
        this.pnlGener.btnCargar.addActionListener(this);
        this.pnlGener.btnAceptarModificar.addActionListener(this);
        this.pnlGener.tb_artista.addMouseListener(this);
        this.pnlGener.cmbArtista.addActionListener(this);
        this.pnlGener.btnEliminar.setEnabled(false);
        this.pnlGener.btnModificar.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.pnlGener.btnCargar) {
            cargarData(pnlGener.tb_artista);
            this.pnlGener.btnEliminar.setEnabled(true);
            this.pnlGener.btnModificar.setEnabled(true);
        } else if (ae.getSource() == this.pnlGener.btnEliminar) {
            if (fila >= 0) {
                eliminar();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
        } else if (ae.getSource() == this.pnlGener.btnModificar) {
            if (fila >= 0) {
                this.pnlGener.txtUsuario.setText(String.valueOf(this.pnlGener.tb_artista.getValueAt(fila, 1)));
                cargarDatos(slc_artistas, this.pnlGener.cmbArtista);
                valorSeleccionado = String.valueOf(this.pnlGener.tb_artista.getValueAt(fila, 2));
                this.pnlGener.cmbArtista.setSelectedItem(valorSeleccionado);
                this.pnlGener.jDialog1.setSize(300, 148);
                this.pnlGener.jDialog1.setResizable(false);
                this.pnlGener.jDialog1.setLocationRelativeTo(interfaz);
                this.pnlGener.jDialog1.setModal(true);
                this.pnlGener.jDialog1.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
        } else if (ae.getSource() == this.pnlGener.btnAceptarModificar) {
            modificar();
        } else if (ae.getSource() == this.pnlGener.cmbArtista) {
            this.selectArtista(this.pnlGener.cmbArtista);
        }

    }

    public void cargarData(JTable tblDatos) {
        conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.addColumn("CD");
        modelo.addColumn("Cancion");
        modelo.addColumn("Artista");
        String sentencia = "SELECT tb_cancion.id_cancion,tb_cancion.nm_cancion,tb_artista.nm_artista from tb_cancion\n"
                + "INNER JOIN tb_artista on tb_cancion.artista= tb_artista.id_artista\n"
                + "INNER JOIN tb_genero on tb_cancion.genero=tb_genero.id_genero";
        try {
            ResultSet rs = conexion.obtenerDatos(sentencia);
            while (rs.next()) {
                ArrayList datos = new ArrayList();
                datos.add(rs.getInt(1));
                datos.add(rs.getString(2).trim());
                datos.add(rs.getString(3).trim());
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.pnlGener.tb_artista) {
            if (e.getClickCount() == 1) {
                //JOptionPane.showMessageDialog(null, "1 Click");
                fila = this.pnlGener.tb_artista.getSelectedRow();
                this.pnlGener.btnEliminar.setEnabled(true);
                this.pnlGener.btnModificar.setEnabled(true);
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void eliminar() {
        PreparedStatement ps2;

        try {
            ps2 = conexion.getConnection().prepareStatement("delete from tb_cancion where tb_cancion.id_cancion= ?");
            ps2.setInt(1, Integer.parseInt(String.valueOf(this.pnlGener.tb_artista.getValueAt(fila, 0))));//CANCIONES
            ps2.execute();
            cargarData(this.pnlGener.tb_artista);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se la ha podido eliminar, probablemente el registro esta asociado a otras tablas.");
            Logger.getLogger(CancionArtistaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void modificar() {

        try {

            String Ssql = "UPDATE tb_cancion SET nm_cancion=?, artista=? WHERE id_cancion=?";

            PreparedStatement prest = conexion.getConnection().prepareStatement(Ssql);
            prest.setString(1, this.pnlGener.txtUsuario.getText());
            prest.setInt(2, this.idArtista);
            prest.setInt(3, Integer.parseInt(String.valueOf(this.pnlGener.tb_artista.getValueAt(fila, 0))));//CANCIONES

            if (prest.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                cargarData(this.pnlGener.tb_artista);
                this.pnlGener.jDialog1.dispose();

            } else {

                JOptionPane.showMessageDialog(null, "No se ha podido realizar la actualización de los datos\n"
                        + "Inténtelo nuevamente.", "Error en la operación",
                        JOptionPane.ERROR_MESSAGE);

            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void cargarDatos(String sql, JComboBox combo) {
        conexion = new Conexion();
        try {
            //RESULTADO(DATA) DE LA BASE DE DATOS
            ResultSet rs = conexion.obtenerDatos(sql);
            //RECORRE LOS DATOS QUE SE TRAEN DE LA BD
            while (rs.next()) {
                // SE AGREGA AL COMBO EL CAMPO NOMBRE QUE SE ENCUENTRA EN EL RESULTSET
                combo.addItem(rs.getString(2).trim());
                //DESCONECTA LA BASE DE DATOS
                conexion.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("ERROR:" + e.getMessage());
            //MUESTRA UN MENSAJE EMERGENTE
            JOptionPane.showMessageDialog(null, "Error al Cargar los datos Intente Otra Vez");
        }
    }

    public void selectArtista(JComboBox cmbempresa) {
        conexion = new Conexion();
        valorSeleccionado = (String) cmbempresa.getSelectedItem();
        //obtner el codigo de la empresa seleccionada
        artista_id = "select id_artista,nm_artista from tb_artista where nm_artista='" + valorSeleccionado + "'";
        try {
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(artista_id);
            if (rs.next()) {
            }
            idArtista = rs.getInt(1);
            System.out.println("se ha seleccionado :" + idArtista);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
