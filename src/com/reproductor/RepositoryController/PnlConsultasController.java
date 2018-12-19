/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.RepositoryController;

import com.mancompsolutions.modelo.Dimensiones;
import com.reproductor.vistas.paneles.consultas.pnlArtistas;
import com.reproductor.vistas.paneles.consultas.pnlCancion;
import com.reproductor.vistas.paneles.consultas.pnlConsultas;
import com.reproductor.vistas.paneles.consultas.pnlGenero;
import com.reproductor.vistas.paneles.consultas.pnlUsers;
import com.reproductor.vistas.Principal;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author operador
 */
public class PnlConsultasController implements ActionListener {

    pnlConsultas panel = new pnlConsultas();
    Principal interfaz;
    Dimensiones dimensiones = new Dimensiones();
    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

    public PnlConsultasController(pnlConsultas interfaz, Principal princ) {
        this.panel = interfaz;
        this.interfaz = princ;

        this.panel.btnusers.addActionListener(this);
        this.panel.btnCanciones.addActionListener(this);
        this.panel.btnartistas.addActionListener(this);
        this.panel.btngeneros.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panel.btnusers) {

            

        }
        if (e.getSource() == this.panel.btnCanciones) {
            pnlCancion pc = new pnlCancion();
            DataCancionesController p = new DataCancionesController(pc);
            pc.setSize(interfaz.pnlPrincipal.getWidth(), interfaz.pnlPrincipal.getHeight());
            this.panel.panelPrincipal.removeAll();
            this.panel.panelPrincipal.add(pc, BorderLayout.CENTER);
            this.panel.panelPrincipal.revalidate();
            this.panel.panelPrincipal.repaint();
            
        }
        if (e.getSource() == this.panel.btnartistas) {

           
        }
        if (e.getSource() == this.panel.btngeneros) {

            
        }
    }
}
