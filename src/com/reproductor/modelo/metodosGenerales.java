/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.modelo;

import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author user1
 */
public class metodosGenerales {
    
    public void form_mensaje(JDialog conf_acc, int ancho, int alto, JFrame form, JLabel JDLabelTitulo, String nom_sof, JLabel icon_mensaje,
            String ruta_icon, JLabel JDLabelMensaje, String tipoMensaje, Color color, JLabel JDLabelMensaje2, String Mensaje, JLabel JDLabelMensaje1, String Mensaje2) {
        conf_acc.setSize(ancho, alto);//[513, 461][491, 190]
        conf_acc.setResizable(false);
        conf_acc.setLocationRelativeTo(form);//posicion
        conf_acc.setModal(true);//que se ubique al centro
        JDLabelTitulo.setText(nom_sof);
        icon_mensaje.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta_icon)));
        JDLabelMensaje.setText(tipoMensaje);
        JDLabelMensaje.setForeground(color);
        JDLabelMensaje2.setText(Mensaje);
        JDLabelMensaje1.setText(Mensaje2);
        conf_acc.setVisible(true);
    }
    

    
}
