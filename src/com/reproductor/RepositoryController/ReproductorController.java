///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.reproductor.RepositoryController;
//
//import com.reproductor.modelo.Conexion;
//import com.reproductor.modelo.Reproductor;
//
//import java.awt.HeadlessException;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.io.InputStream;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import javax.swing.ImageIcon;
//import javax.swing.JOptionPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//public class ReproductorController implements ActionListener, MouseListener {
//
//    Conexion conexion = new Conexion();
//
//    //pnlReproductor pnlGener = new pnlReproductor();
//    //pnlConsultas panel = new pnlConsultas();
//    Reproductor mi_reproductor;
//
//    String slc_artistas = "select id_artista,nm_artista,st_artista from tb_artista where st_artista='1'";
//    String slc_genero = "select id_genero,nm_genero,st_genero from tb_genero where st_genero='1'";
//    String valorSeleccionado;
//    int fila = -1; //FILA DE LA TABLA SELECCIONADA.
//    int idListaR; //ID LISTA DE REPRODUCCION
//    String cargarCanciones; //CARGA LAS MUSICAS DE LAS LISTAS DE REPRODUCCION.
//
//    public ReproductorController(pnlReproductor pnlReproductor) {
//        this.pnlGener = pnlReproductor;
//        /*EVENTOS DE LOS CONTROLES DEL REPRODUCTOR*/
//        this.pnlGener.btnPlay.addActionListener(this);
//        this.pnlGener.btnPause.addActionListener(this);
//        this.pnlGener.btnAtras.addActionListener(this);
//        this.pnlGener.btnSiguiente.addActionListener(this);
//        this.pnlGener.btnStop.addActionListener(this);
//        /*EVENTOS DE LA LISTA DE REPRODUCCION*/
//        this.pnlGener.cmbListaR.addActionListener(this);
//        this.pnlGener.btnAgregarCanciones.addActionListener(this);
//
//        this.pnlGener.labelListasR.addMouseListener(this);
//        this.pnlGener.labelAMusica.addMouseListener(this);
//        mi_reproductor = new Reproductor();
//        CargarListaR();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == this.pnlGener.btnPlay) {
//            if (this.pnlGener.tblCancionesReproductor.getRowCount() == 0) {
//                JOptionPane.showMessageDialog(null, "No se ha agregado las musicas para reproducirlas");
//            } else {
//                //RECORREMOS LAS FILAS PARA REPRODUCIR
//                for (int i = 0; i < pnlGener.tblCancionesReproductor.getRowCount(); i++) {
//                    fila = i;
//                    System.out.println("FILA:" + fila);
//                }
//            }
//        } else if (ae.getSource() == this.pnlGener.cmbListaR) {
//            SeleccionarListaR();
//        } else if (ae.getSource() == this.pnlGener.btnAgregarCanciones) {
//            enviarData();
//        }
//        /* if (ae.getSource() == this.pnlGener.btnCargar) {
//            cargarData(pnlGener.tb_cancion);
//        } else if (ae.getSource() == this.pnlGener.btnEliminar) {
//            if (fila >= 0) {
//                eliminar();
//            } else {
//                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
//            }
//        } else if (ae.getSource() == this.pnlGener.btnDetener) {
//            try {
//                mi_reproductor.Stop();
//                this.pnlGener.pnlReproductor.dispose();
//            } catch (Exception ex) {
//                //Logger.getLogger(this.pnlGener.pnlReproductor.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if (ae.getSource() == this.pnlGener.btnPausa) {
//
//            switch (this.pnlGener.btnPausa.getText()) {
//                case "Play":
//                    try {
//                        mi_reproductor.Continuar();
//                        this.pnlGener.btnPausa.setText("Pausa");
//
//                    } catch (BasicPlayerException ex) {
//                        Logger.getLogger(ReproductorController.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (Exception ex) {
//                        Logger.getLogger(ReproductorController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    break;
//                case "Pausa":
//                    try {
//                        mi_reproductor.Pausa();
//                    } catch (BasicPlayerException ex) {
//                        Logger.getLogger(ReproductorController.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (Exception ex) {
//                Logger.getLogger(ReproductorController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                    this.pnlGener.btnPausa.setText("Play");
//                    break;
//
//            }
//
//        }*/
//
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        if (e.getSource() == this.pnlGener.labelListasR) {
//            //CARGAMOS EL FORMULARIO DE LAS LISTAS REPRODUCCION.
//            this.pnlGener.pnListaR.setSize(315, 305);
//            this.pnlGener.pnListaR.setResizable(false);
//            this.pnlGener.pnListaR.setLocationRelativeTo(pnlGener);
//            this.pnlGener.pnListaR.setModal(true);
//            this.pnlGener.pnListaR.setVisible(true);
//
//        }
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//
//    /*--------------- Metodos ------------------------*/
//    public void CargarListaR() {
//        conexion = new Conexion();
//        String sql = "SELECT id, nombre FROM public.tb_listap";
//        try {
//            //RESULTADO(DATA) DE LA BASE DE DATOS
//            ResultSet rs = conexion.obtenerDatos(sql);
//            //RECORRE LOS DATOS QUE SE TRAEN DE LA BD
//            while (rs.next()) {
//                // SE AGREGA AL COMBO EL CAMPO NOMBRE QUE SE ENCUENTRA EN EL RESULTSET
//                this.pnlGener.cmbListaR.addItem(rs.getString(2).trim());
//                //DESCONECTA LA BASE DE DATOS
//                conexion.desconectar();
//            }
//        } catch (SQLException e) {
//            System.out.println("ERROR:" + e.getMessage());
//            //MUESTRA UN MENSAJE EMERGENTE
//            JOptionPane.showMessageDialog(null, "Error al Cargar los datos Intente Otra Vez");
//        }
//    }
//
//    public void SeleccionarListaR() {
//        conexion = new Conexion();
//
//        valorSeleccionado = (String) this.pnlGener.cmbListaR.getSelectedItem();
//        //obtner el codigo de la empresa seleccionada
//        String sql = "SELECT id FROM public.tb_listap WHERE nombre='" + valorSeleccionado + "'";
//        try {
//            Statement st = conexion.getConnection().createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            if (rs.next()) {
//                // CARGAMOS LAS MUSICAS QUE PERTENECEN A ESA LISTA DE REPRODUCCION:
//                cargarCanciones = "SELECT tb_cancion.id_cancion AS \"Id Canción\",tb_cancion.nm_cancion AS \"Nombre Cancion\",tb_cancion.url AS \"URL\"\n"
//                        + "	FROM tb_dlista\n"
//                        + "	INNER JOIN tb_cancion on tb_dlista.canciones=tb_cancion.id_cancion\n"
//                        + "	INNER JOIN tb_listap ON tb_dlista.lista=tb_listap.id\n"
//                        + "	WHERE tb_dlista.lista ='" + rs.getInt(1) + "'";
//            }
//            cargarData();
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//
//    public void cargarData() {
//        conexion = new Conexion();
//        DefaultTableModel modelo = new DefaultTableModel() {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//
//        modelo.addColumn("ID");
//        modelo.addColumn("NOMBRE");
//        modelo.addColumn("URL");
//
//        try {
//            ResultSet rs = conexion.obtenerDatos(cargarCanciones);
//            while (rs.next()) {
//                ArrayList datos = new ArrayList();
//                datos.add(rs.getInt(1));
//                datos.add(rs.getString(2).trim());
//                datos.add(rs.getString(3).trim());
//                System.out.println("DATO1:" + rs.getString(1));
//                System.out.println("DATO2:" + rs.getString(2));
//                System.out.println("DATO3:" + rs.getString(3));
//                modelo.addRow(datos.toArray());
//
//            }
//            this.pnlGener.tblLstRepro.setModel(modelo);
//
//            this.pnlGener.tblLstRepro.getColumnModel().getColumn(0).setMinWidth(70);
//            this.pnlGener.tblLstRepro.getColumnModel().getColumn(0).setMaxWidth(70);
//            this.pnlGener.tblLstRepro.getColumnModel().getColumn(2).setMinWidth(250);
//            this.pnlGener.tblLstRepro.getColumnModel().getColumn(2).setMaxWidth(250);
//
//        } catch (SQLException | HeadlessException e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//
//    public void enviarData() {
//        DefaultTableModel modelo = new DefaultTableModel() {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//        modelo.addColumn("ID");
//        modelo.addColumn("URL");
//        for (int i = 0; i < pnlGener.tblLstRepro.getRowCount(); i++) {
//            ArrayList datos = new ArrayList();
//            datos.add(this.pnlGener.tblLstRepro.getValueAt(i, 0));
//            datos.add(this.pnlGener.tblLstRepro.getValueAt(i, 2));
//            modelo.addRow(datos.toArray());
//            System.out.println("DATO1" + this.pnlGener.tblLstRepro.getValueAt(i, 0));
//            System.out.println("DATO2" + this.pnlGener.tblLstRepro.getValueAt(i, 2));
//        }
//        this.pnlGener.tblCancionesReproductor.setModel(modelo);
//        this.pnlGener.tblCancionesReproductor.getColumnModel().getColumn(0).setMinWidth(40);
//        this.pnlGener.tblCancionesReproductor.getColumnModel().getColumn(0).setMaxWidth(40);
//        this.pnlGener.tblCancionesReproductor.getColumnModel().getColumn(1).setMinWidth(250);
//        this.pnlGener.tblCancionesReproductor.getColumnModel().getColumn(1).setMaxWidth(250);
//        this.pnlGener.labelNListaR.setText("LISTA REPRODUCCION: "+String.valueOf(this.pnlGener.cmbListaR.getSelectedItem()));
//        this.pnlGener.pnListaR.dispose();
//
//    }
//}
