/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.RepositoryController;

import com.reproductor.vistas.paneles.consultas.pnlGenero;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GeneController implements ActionListener, MouseListener {

    Conexion conexion = new Conexion();
    Principal interfaz = new Principal();
    pnlGenero pnlGener = new pnlGenero();
    int fila;

    public GeneController(pnlGenero gen) {
        this.pnlGener = gen;

        this.pnlGener.btnEliminar.addActionListener(this);
        this.pnlGener.btnModificar.addActionListener(this);
        this.pnlGener.btnCargar.addActionListener(this);
        this.pnlGener.btnAceptarModificar.addActionListener(this);
        this.pnlGener.tb_genero.addMouseListener(this);

        this.pnlGener.btnEliminar.setEnabled(false);
        this.pnlGener.btnModificar.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.pnlGener.btnCargar) {
            cargarData(pnlGener.tb_genero);
        } else if (ae.getSource() == this.pnlGener.btnEliminar) {
            if (fila >= 0) {
                eliminar();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
        } else if (ae.getSource() == this.pnlGener.btnModificar) {
            if (fila >= 0) {
                this.pnlGener.txtUsuario.setText(String.valueOf(this.pnlGener.tb_genero.getValueAt(fila, 1)));

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
        modelo.addColumn("Nombre");
        String sentencia = "SELECT id_genero, nm_genero FROM public.tb_genero;";
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.pnlGener.tb_genero) {
            if (e.getClickCount() == 1) {
                //JOptionPane.showMessageDialog(null, "1 Click");
                fila = this.pnlGener.tb_genero.getSelectedRow();
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
            ps2 = conexion.getConnection().prepareStatement("delete from tb_genero where tb_genero.id_genero= ?");
            ps2.setInt(1, Integer.parseInt(String.valueOf(this.pnlGener.tb_genero.getValueAt(fila, 0))));//CANCIONES
            ps2.execute();
            cargarData(this.pnlGener.tb_genero);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se la ha podido eliminar, probalmente el registro esta asociado a otras tablas.");
            Logger.getLogger(GeneController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void modificar() {

        try {

            String Ssql = "UPDATE tb_genero SET nm_genero=? WHERE id_genero=?";

            PreparedStatement prest = conexion.getConnection().prepareStatement(Ssql);
            prest.setString(1, this.pnlGener.txtUsuario.getText());
            prest.setInt(2, Integer.parseInt(String.valueOf(this.pnlGener.tb_genero.getValueAt(fila, 0))));

            if (prest.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                cargarData(this.pnlGener.tb_genero);
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

}
