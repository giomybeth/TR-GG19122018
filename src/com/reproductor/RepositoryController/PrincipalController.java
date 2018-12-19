/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.RepositoryController;

import com.mancompsolutions.modelo.Dimensiones;
import com.reproductor.modelo.Artistas;
import com.reproductor.modelo.MusicaSeleccionada;
import com.reproductor.modelo.metodosGenerales;
import com.reproductor.vistas.Principal;
import com.reproductor.vistas.paneles.consultas.pnlArtistas;
import com.reproductor.vistas.paneles.consultas.pnlCancion;
import com.reproductor.vistas.paneles.consultas.pnlConsultas;
import com.reproductor.vistas.paneles.consultas.pnlGenero;
import com.reproductor.vistas.paneles.consultas.pnlUsers;
import com.reproductor.vistas.paneles.pnlCanciones;
import com.reproductor.vistas.paneles.pnlHome;
import com.reproductor.vistas.paneles.pnlListaReproduccion;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class PrincipalController implements MouseListener {

    //variables para capturar la posicion del cursor
    int x, y;
    public metodosGenerales metodos = new metodosGenerales();
    Dimensiones dimensiones = new Dimensiones();

    int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    Principal interfaz = new Principal();

    MusicaSeleccionada musica = new MusicaSeleccionada();

    public PrincipalController(Principal interfaz) {
        this.interfaz = interfaz;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) (dimension.getHeight() - 40.0);
        this.interfaz.setBounds(0, 0, width, height);

        pnlHome pc = new pnlHome();
        pc.setSize(1320, 828);
        HomeController inicio = new HomeController(interfaz, pc);
        
        this.interfaz.pnlPrincipal.removeAll();
        this.interfaz.pnlPrincipal.add(pc, BorderLayout.CENTER);
        this.interfaz.pnlPrincipal.revalidate();
        this.interfaz.pnlPrincipal.repaint();

        this.interfaz.labelHome.addMouseListener(this);
        this.interfaz.labelUsers.addMouseListener(this);
        this.interfaz.labelCanciones.addMouseListener(this);
        this.interfaz.labelCFavoritas.addMouseListener(this);
        this.interfaz.labelArtistas.addMouseListener(this);
        this.interfaz.labelGenero.addMouseListener(this);
        this.interfaz.labelAlbunes.addMouseListener(this);
        this.interfaz.labelEReciente.addMouseListener(this);
        this.interfaz.labelListaReproduciones.addMouseListener(this);

    }

    // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">  }
    // </editor-fold>
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.interfaz.labelHome) {
            // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">                          
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.interfaz.labelHome.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
            this.interfaz.labelHome.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
            this.interfaz.labelUsers.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelUsers.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelReproductor.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelReproductor.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelEReciente.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelEReciente.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelCFavoritas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCFavoritas.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelListaReproduciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelListaReproduciones.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelCanciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCanciones.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelArtistas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelArtistas.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelGenero.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelGenero.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));
            // </editor-fold>
            
            pnlHome pc = new pnlHome();
            System.out.println("WIDTH :"+this.interfaz.pnlPrincipal.getWidth());
            System.out.println("HEIGH :"+this.interfaz.pnlPrincipal.getHeight());
            pc.setSize(this.interfaz.pnlPrincipal.getWidth(), this.interfaz.pnlPrincipal.getHeight());
            pc.pnlFavoritos.setSize(this.interfaz.pnlPrincipal.getWidth(),210);
            pc.pnlListas.setSize(this.interfaz.pnlPrincipal.getWidth(),210);
            pc.pnlRecientes.setSize(this.interfaz.pnlPrincipal.getWidth(),210);
            HomeController inicio = new HomeController(interfaz, pc);

            this.interfaz.pnlPrincipal.removeAll();
            this.interfaz.pnlPrincipal.add(pc, BorderLayout.CENTER);
            this.interfaz.pnlPrincipal.revalidate();
            this.interfaz.pnlPrincipal.repaint();
        }
        if (me.getSource() == this.interfaz.labelUsers) {
            // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">                          
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.interfaz.labelUsers.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
            this.interfaz.labelUsers.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
            this.interfaz.labelHome.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelHome.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelReproductor.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelReproductor.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelEReciente.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelEReciente.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelCFavoritas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCFavoritas.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelListaReproduciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelListaReproduciones.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelCanciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCanciones.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelArtistas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelArtistas.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelGenero.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelGenero.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));
            // </editor-fold>    
            pnlUsers pc = new pnlUsers();
            UsersController cp = new UsersController(pc);
            pc.setSize(this.interfaz.pnlPrincipal.getWidth(), this.interfaz.pnlPrincipal.getHeight());
            this.interfaz.pnlPrincipal.removeAll();
            this.interfaz.pnlPrincipal.add(pc, BorderLayout.CENTER);
            this.interfaz.pnlPrincipal.revalidate();
            this.interfaz.pnlPrincipal.repaint();

        } else if (me.getSource() == this.interfaz.labelCanciones) {
            // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">                          
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.interfaz.labelCanciones.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
            this.interfaz.labelCanciones.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
           this.interfaz.labelHome.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelHome.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelReproductor.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelReproductor.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelEReciente.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelEReciente.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelCFavoritas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCFavoritas.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelListaReproduciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelListaReproduciones.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelUsers.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelUsers.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelArtistas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelArtistas.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelGenero.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelGenero.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));
            // </editor-fold>  
            pnlCanciones pr = new pnlCanciones();
            pr.pnlTabla.setVisible(false);
            pr.pnlIngreso.setVisible(true);
            pr.tb_cancion.setVisible(false);
            pr.btnEliminar.setVisible(false);
            pr.btnCargar.setVisible(false);
            pr.setSize(this.interfaz.pnlPrincipal.getWidth(), this.interfaz.pnlPrincipal.getHeight());
            CancionesController controlleter = new CancionesController(interfaz, pr);
            this.interfaz.pnlPrincipal.removeAll();
            this.interfaz.pnlPrincipal.add(pr);
            this.interfaz.pnlPrincipal.revalidate();
            this.interfaz.pnlPrincipal.repaint();

        } else if (me.getSource() == this.interfaz.labelCFavoritas) {

            // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">                          
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.interfaz.labelCFavoritas.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
            this.interfaz.labelCFavoritas.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
            
            this.interfaz.labelHome.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelHome.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelReproductor.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelReproductor.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelEReciente.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelEReciente.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelCanciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCanciones.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelListaReproduciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelListaReproduciones.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelUsers.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelUsers.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelArtistas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelArtistas.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelGenero.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelGenero.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));
            // </editor-fold>  

        } else if (me.getSource() == this.interfaz.labelArtistas) {

            // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">                          
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.interfaz.labelArtistas.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
            this.interfaz.labelArtistas.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
            this.interfaz.labelHome.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelHome.setForeground(new java.awt.Color(255, 255, 255));
            
            this.interfaz.labelEReciente.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelEReciente.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelCFavoritas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCFavoritas.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelUsers.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelUsers.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelCanciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCanciones.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelGenero.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelGenero.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelReproductor.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelReproductor.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelListaReproduciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelListaReproduciones.setForeground(new java.awt.Color(255, 255, 255));

            // </editor-fold>  
            pnlArtistas pc = new pnlArtistas();
            CancionArtistaController c = new CancionArtistaController(pc);
            pc.setSize(this.interfaz.pnlPrincipal.getWidth(), this.interfaz.pnlPrincipal.getHeight());

            this.interfaz.pnlPrincipal.removeAll();
            this.interfaz.pnlPrincipal.add(pc, BorderLayout.CENTER);
            this.interfaz.pnlPrincipal.revalidate();
            this.interfaz.pnlPrincipal.repaint();

        } else if (me.getSource() == this.interfaz.labelGenero) {

            // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">                          
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.interfaz.labelGenero.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
            this.interfaz.labelGenero.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
            this.interfaz.labelHome.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelHome.setForeground(new java.awt.Color(255, 255, 255));
            
            this.interfaz.labelEReciente.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelEReciente.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelCFavoritas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCFavoritas.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelUsers.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelUsers.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelCanciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCanciones.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelArtistas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelArtistas.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelReproductor.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelReproductor.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelListaReproduciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelListaReproduciones.setForeground(new java.awt.Color(255, 255, 255));

            // </editor-fold>  
            pnlGenero pc = new pnlGenero();
            GeneController c = new GeneController(pc);
            pc.setSize(this.interfaz.pnlPrincipal.getWidth(), this.interfaz.pnlPrincipal.getHeight());

            this.interfaz.pnlPrincipal.removeAll();
            this.interfaz.pnlPrincipal.add(pc, BorderLayout.CENTER);
            this.interfaz.pnlPrincipal.revalidate();
            this.interfaz.pnlPrincipal.repaint();

        } else if (me.getSource() == this.interfaz.labelAlbunes) {

            // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">                          
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
            this.interfaz.labelHome.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelHome.setForeground(new java.awt.Color(255, 255, 255));
                        
            this.interfaz.labelEReciente.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelEReciente.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelCFavoritas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCFavoritas.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelUsers.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelUsers.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelCanciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCanciones.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelArtistas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelArtistas.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelGenero.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelGenero.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelReproductor.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelReproductor.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelListaReproduciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelListaReproduciones.setForeground(new java.awt.Color(255, 255, 255));

            // </editor-fold>
        } else if (me.getSource() == this.interfaz.labelEReciente) {

            // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">                          
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.interfaz.labelEReciente.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
            this.interfaz.labelEReciente.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelCFavoritas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCFavoritas.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelUsers.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelUsers.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelCanciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCanciones.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelArtistas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelArtistas.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelGenero.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelGenero.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelReproductor.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelReproductor.setForeground(new java.awt.Color(255, 255, 255));

            this.interfaz.labelListaReproduciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelListaReproduciones.setForeground(new java.awt.Color(255, 255, 255));

            // </editor-fold>
        }
        if (me.getSource() == this.interfaz.labelListaReproduciones) {
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.interfaz.labelListaReproduciones.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
            this.interfaz.labelListaReproduciones.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
            this.interfaz.labelHome.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelHome.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelReproductor.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelReproductor.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelAlbunes.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelAlbunes.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelEReciente.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelEReciente.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelCFavoritas.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCFavoritas.setForeground(new java.awt.Color(255, 255, 255));
            this.interfaz.labelCanciones.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.interfaz.labelCanciones.setForeground(new java.awt.Color(255, 255, 255));

            pnlListaReproduccion pr = new pnlListaReproduccion();
            pr.setSize(this.interfaz.pnlPrincipal.getWidth(), this.interfaz.pnlPrincipal.getHeight());
            Artistas art = new Artistas();
            ListRController controlleter = new ListRController(this.interfaz, art, pr);
            this.interfaz.pnlPrincipal.removeAll();
            this.interfaz.pnlPrincipal.add(pr);
            this.interfaz.pnlPrincipal.revalidate();
            this.interfaz.pnlPrincipal.repaint();
        } else if (me.getSource() == this.interfaz.lblConsulta) {
            pnlConsultas pc = new pnlConsultas();
            PnlConsultasController ps = new PnlConsultasController(pc, this.interfaz);
            pc.setSize(this.interfaz.pnlPrincipal.getWidth(), this.interfaz.pnlPrincipal.getHeight());
            this.interfaz.pnlPrincipal.removeAll();
            this.interfaz.pnlPrincipal.add(pc, BorderLayout.CENTER);
            this.interfaz.pnlPrincipal.revalidate();
            this.interfaz.pnlPrincipal.repaint();
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
