/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.RepositoryController;

import com.reproductor.modelo.Usuario;
import com.reproductor.modelo.UsuarioDaoImpl;
import com.reproductor.modelo.metodosGenerales;
import com.reproductor.vistas.JDMensajes;
import com.reproductor.vistas.Login;
import com.reproductor.vistas.Principal;
import com.reproductor.vistas.paneles.pnlHome;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class LoginController implements FocusListener, ActionListener, MouseListener {

    private final UsuarioDaoImpl modeloUsuario = new UsuarioDaoImpl();
    private final metodosGenerales met_gm = new metodosGenerales();
    Usuario user;
    
    Login login = new Login();

    public LoginController( Login login) {

        
        this.login = login;
        user = new Usuario();
        this.login.btnCancelar.setVisible(false);
        this.login.btnRegistrar.setVisible(false);
        this.login.BtnLogin.setVisible(true);

        /*EVENTOS FOCUS*/
        this.login.txtUsuario.addFocusListener(this);
        this.login.txtpass.addFocusListener(this);
        /*EVENTOS ACTIONLISTEHER*/
        this.login.btnCancelar.addActionListener(this);
        this.login.BtnLogin.addActionListener(this);
        this.login.btnRegistrar.addActionListener(this);
        /*EVENTOS MOUSECLIC*/
        this.login.labelExit.addMouseListener(this);
        this.login.labelRegistrar.addMouseListener(this);
    }

    @Override
    public void focusGained(FocusEvent fe) {
        if (fe.getSource() == this.login.txtUsuario) {
            this.login.txtUsuario.selectAll();
        }
        if (fe.getSource() == this.login.txtpass) {
            this.login.txtpass.selectAll();
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.login.btnCancelar) {
            this.login.btnCancelar.setVisible(false);
            this.login.btnRegistrar.setVisible(false);
            this.login.BtnLogin.setVisible(true);
        }
        if (ae.getSource() == this.login.BtnLogin) {
            String usuario = this.login.txtUsuario.getText();
            String pass = String.valueOf(this.login.txtpass.getPassword());
            user = modeloUsuario.iniciarSesion(usuario, pass);
            if (user != null) {
                JDMensajes conf_acc = new JDMensajes(this.login, true);
                Color blue = new java.awt.Color(0, 74, 140);
                met_gm.form_mensaje(conf_acc, 430, 185, this.login, conf_acc.JDLabelTitulo, "Reproductor GG", conf_acc.icon_mensaje, "",
                        conf_acc.JDLabelMensaje, "Información:", blue, conf_acc.JDLabelMensaje2, "Bienvenido " + " - " + user.getUsuario(), conf_acc.JDLabelMensaje1, "");
                this.login.dispose();

                // CARGAMOS EL FORMULARIO PRINCIPAL
                Principal interfaz = new Principal();

                interfaz.setExtendedState(JFrame.MAXIMIZED_BOTH);
                interfaz.setVisible(true);
                PrincipalController controler= new PrincipalController(interfaz);
                interfaz.labelNombreUsuario.setText(usuario);
                
            } else {
                JDMensajes conf_acc = new JDMensajes(this.login, true);
                met_gm.form_mensaje(conf_acc, 430, 185, this.login, conf_acc.JDLabelTitulo, "Reproductor GG", conf_acc.icon_mensaje, "/com/reproductor/img/ic_error.png",
                        conf_acc.JDLabelMensaje, "Error: ", Color.RED, conf_acc.JDLabelMensaje2, "Credenciales Incorrectas", conf_acc.JDLabelMensaje1, "");
                this.login.txtUsuario.selectAll();

            }
        }
        if (ae.getSource() == this.login.btnRegistrar) {
            String usuario = this.login.txtUsuario.getText();
            String pass = String.valueOf(this.login.txtpass.getPassword());
            int registro = modeloUsuario.registrar(usuario, pass);
            if (registro > 0) {
                JDMensajes conf_acc = new JDMensajes(this.login, true);
                Color blue = new java.awt.Color(0, 74, 140);
                met_gm.form_mensaje(conf_acc, 430, 185, this.login, conf_acc.JDLabelTitulo, "Reproductor GG", conf_acc.icon_mensaje, "/com/reproductor/img/ic_information.png",
                        conf_acc.JDLabelMensaje, "Información:", blue, conf_acc.JDLabelMensaje2, "Registro Correcto... Bienvenido " + " - " + usuario, conf_acc.JDLabelMensaje1, "");
                this.login.dispose();

                // CARGAMOS EL FORMULARIO PRINCIPAL
                Principal interfaz = new Principal();
                //interfaz.setIconImage(new ImageIcon(getClass().getResource("/com/mancompsolutions/imgs/Ico.png")).getImage());
                interfaz.setExtendedState(JFrame.MAXIMIZED_BOTH);
                interfaz.setVisible(true);

                //ControllerPrincipal p = new ControllerPrincipal(interfaz, user, opciones);
            } else {
                JDMensajes conf_acc = new JDMensajes(this.login, true);
                met_gm.form_mensaje(conf_acc, 430, 185, this.login, conf_acc.JDLabelTitulo, "Reproductor GG", conf_acc.icon_mensaje, "/com/reproductor/img/ic_error.png",
                        conf_acc.JDLabelMensaje, "Error: ", Color.RED, conf_acc.JDLabelMensaje2, "No se ha podido registrar los credenciales", conf_acc.JDLabelMensaje1, "");
                this.login.txtUsuario.selectAll();

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.login.labelRegistrar) {
            this.login.btnCancelar.setVisible(true);
            this.login.BtnLogin.setVisible(false);
            this.login.btnRegistrar.setVisible(true);
        }
        if (me.getSource() == this.login.labelExit) {
            System.exit(0);
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

}
