/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.RepositoryController;

import com.reproductor.vistas.paneles.consultas.pnlUsers;
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

public class UsersController implements ActionListener, MouseListener {

    Conexion conexion = new Conexion();
    Principal interfaz = new Principal();
    pnlUsers pnlUsers = new pnlUsers();
    int fila;

    public UsersController(pnlUsers usuario) {
        this.pnlUsers = usuario;

        this.pnlUsers.btnCargar.addActionListener(this);
        this.pnlUsers.btnEliminar.addActionListener(this);
        this.pnlUsers.btnModificar.addActionListener(this);
        this.pnlUsers.btnAceptarModificar.addActionListener(this);
        this.pnlUsers.tbusers.addMouseListener(this);
        this.pnlUsers.btnEliminar.setEnabled(false);
        this.pnlUsers.btnModificar.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.pnlUsers.btnCargar) {
            cargarData(pnlUsers.tbusers);
            this.pnlUsers.btnEliminar.setEnabled(true);
            this.pnlUsers.btnModificar.setEnabled(true);
        } else if (ae.getSource() == this.pnlUsers.btnEliminar) {
            if (fila >= 0) {
                eliminar();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
        } else if (ae.getSource() == this.pnlUsers.btnModificar) {
            if (fila >= 0) {
                this.pnlUsers.txtUsuario.setText(String.valueOf(this.pnlUsers.tbusers.getValueAt(fila, 1)));
                this.pnlUsers.txtCoontraseña.setText(String.valueOf(this.pnlUsers.tbusers.getValueAt(fila, 2)));

                this.pnlUsers.jDialog1.setSize(300, 148);
                this.pnlUsers.jDialog1.setResizable(false);
                this.pnlUsers.jDialog1.setLocationRelativeTo(interfaz);
                this.pnlUsers.jDialog1.setModal(true);
                this.pnlUsers.jDialog1.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
        } else if (ae.getSource() == this.pnlUsers.btnAceptarModificar) {
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
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        String sentencia = "select id,nombre, clave from tb_user";
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
            tblDatos.setRowHeight(35);

            tblDatos.getColumnModel().getColumn(0).setMinWidth(50);
            tblDatos.getColumnModel().getColumn(0).setMaxWidth(50);

            tblDatos.getColumnModel().getColumn(1).setMinWidth(400);
            tblDatos.getColumnModel().getColumn(1).setMaxWidth(400);
            
            tblDatos.getColumnModel().getColumn(2).setMinWidth(400);
            tblDatos.getColumnModel().getColumn(2).setMaxWidth(400);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.pnlUsers.tbusers) {
            fila = this.pnlUsers.tbusers.getSelectedRow();
            this.pnlUsers.btnEliminar.setEnabled(true);
            this.pnlUsers.btnModificar.setEnabled(true);
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
            ps2 = conexion.getConnection().prepareStatement("delete from tb_user where tb_user.id = ?");
            ps2.setInt(1, Integer.parseInt(String.valueOf(this.pnlUsers.tbusers.getValueAt(fila, 0))));//CANCIONES
            ps2.execute();
            cargarData(this.pnlUsers.tbusers);
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void modificar() {

        try {

            String Ssql = "UPDATE tb_user SET nombre=?, clave=? WHERE id=?";

            PreparedStatement prest = conexion.getConnection().prepareStatement(Ssql);
            prest.setString(1, this.pnlUsers.txtUsuario.getText());
            prest.setString(2, this.pnlUsers.txtCoontraseña.getText());
            prest.setInt(3, Integer.parseInt(String.valueOf(this.pnlUsers.tbusers.getValueAt(fila, 0))));

            if (prest.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                cargarData(this.pnlUsers.tbusers);
                this.pnlUsers.jDialog1.dispose();

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
