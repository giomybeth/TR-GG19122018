/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.RepositoryController;

import com.reproductor.vistas.paneles.consultas.pnlCancion;
import com.reproductor.vistas.paneles.consultas.pnlConsultas;
import com.reproductor.modelo.Conexion;
import com.reproductor.modelo.MusicaSeleccionada;
import com.reproductor.modelo.Render;
import com.reproductor.modelo.Reproductor;
import com.reproductor.vistas.Principal;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class DataCancionesController implements ActionListener, MouseListener {

    Conexion conexion = new Conexion();

    pnlCancion pnlGener = new pnlCancion();
    pnlConsultas panel = new pnlConsultas();
    Reproductor mi_reproductor;
    JButton btn_reproducir = new JButton("Reproducir");

    int fila;
    String slc_artistas = "select id_artista,nm_artista,st_artista from tb_artista where st_artista='1'";
    String slc_genero = "select id_genero,nm_genero,st_genero from tb_genero where st_genero='1'";
    int idArtista = 0;
    String artista_id = "";
    String valorSeleccionado, valorSeleccionado2;
    InputStream is;
    ImageIcon foto;
    String NMusica = "";
    Principal interfaz;
    MusicaSeleccionada musica = new MusicaSeleccionada();

    public DataCancionesController(pnlCancion gen) {
        this.pnlGener = gen;
        this.pnlGener.btnEliminar.addActionListener(this);
        this.pnlGener.btnCargar.addActionListener(this);
        this.pnlGener.btnAceptarModificar.addActionListener(this);
        this.pnlGener.tb_cancion.addMouseListener(this);
        this.pnlGener.cmbArtista.addActionListener(this);
        this.pnlGener.btnPausa.addActionListener(this);
        this.pnlGener.btnDetener.addActionListener(this);
        mi_reproductor = new Reproductor();
        this.pnlGener.btnEliminar.setEnabled(false);
        this.btn_reproducir.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.pnlGener.btnCargar) {
            cargarData(pnlGener.tb_cancion);
            this.pnlGener.btnEliminar.setEnabled(true);
        } else if (ae.getSource() == this.pnlGener.btnEliminar) {
            if (fila >= 0) {
                eliminar();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
        } else if (ae.getSource() == this.pnlGener.btnDetener) {
            try {
                mi_reproductor.Stop();
                this.pnlGener.pnlReproductor.dispose();
            } catch (Exception ex) {
                //Logger.getLogger(this.pnlGener.pnlReproductor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ae.getSource() == this.pnlGener.btnPausa) {

            switch (this.pnlGener.btnPausa.getText()) {
                case "Play":
                    try {
                        mi_reproductor.Continuar();
                        this.pnlGener.btnPausa.setText("Pausa");

                    } catch (BasicPlayerException ex) {
                        Logger.getLogger(DataCancionesController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(DataCancionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case "Pausa":
                    try {
                        mi_reproductor.Pausa();
                    } catch (BasicPlayerException ex) {
                        Logger.getLogger(DataCancionesController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(DataCancionesController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.pnlGener.btnPausa.setText("Play");
                    break;

            }

        } else if (ae.getSource() == this.btn_reproducir) {
            musica.setMusica(String.valueOf(pnlGener.tb_cancion.getValueAt(fila, 1)));
            musica.setId(String.valueOf(pnlGener.tb_cancion.getValueAt(fila, 0)));
            musica.setArtista(String.valueOf(pnlGener.tb_cancion.getValueAt(fila, 2)));
            musica.setGenero(String.valueOf(pnlGener.tb_cancion.getValueAt(fila, 3)));
            musica.setAlbum(String.valueOf(pnlGener.tb_cancion.getValueAt(fila, 4)));
            musica.setUrl(String.valueOf(pnlGener.tb_cancion.getValueAt(fila, 5)));
            

            //JOptionPane.showMessageDialog(null, princ.labelNMusica);
        }

    }

    public void cargarData(JTable tblDatos) {
        conexion = new Conexion();
        tblDatos.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE_C");
        modelo.addColumn("ARTISTA");
        modelo.addColumn("GENERO");
        modelo.addColumn("ALBUM");
        modelo.addColumn("URL");
        modelo.addColumn("ACCION");
        String sentencia = "SELECT id_cancion, nm_cancion, tb_artista.nm_artista, tb_genero.nm_genero, album, url\n"
                + "	FROM public.tb_cancion\n"
                + "	INNER JOIN tb_artista on tb_cancion.artista=tb_artista.id_artista\n"
                + "	INNER JOIN tb_genero on tb_cancion.genero=tb_genero.id_genero";
        try {
            ResultSet rs = conexion.obtenerDatos(sentencia);

            btn_reproducir.setName("m");
            while (rs.next()) {
                Object fila[] = new Object[7];
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2).trim();
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = btn_reproducir;
                modelo.addRow(fila);

            }
            tblDatos.setModel(modelo);
            tblDatos.setRowHeight(35);

            tblDatos.getColumnModel().getColumn(0).setMinWidth(50);
            tblDatos.getColumnModel().getColumn(0).setMaxWidth(50);

            tblDatos.getColumnModel().getColumn(1).setMinWidth(250);
            tblDatos.getColumnModel().getColumn(1).setMaxWidth(300);

            tblDatos.getColumnModel().getColumn(2).setMinWidth(100);//artista
            tblDatos.getColumnModel().getColumn(2).setMaxWidth(100);

            tblDatos.getColumnModel().getColumn(3).setMinWidth(100);
            tblDatos.getColumnModel().getColumn(3).setMaxWidth(100);

            tblDatos.getColumnModel().getColumn(4).setMinWidth(100);
            tblDatos.getColumnModel().getColumn(4).setMaxWidth(100);

            tblDatos.getColumnModel().getColumn(5).setMinWidth(500);
            tblDatos.getColumnModel().getColumn(5).setMaxWidth(500);

            tblDatos.getColumnModel().getColumn(6).setMinWidth(100);
            tblDatos.getColumnModel().getColumn(6).setMaxWidth(100);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.pnlGener.tb_cancion) {
            switch (e.getClickCount()) {
                case 1:
                    //JOptionPane.showMessageDialog(null, "1 Click");
                    fila = this.pnlGener.tb_cancion.getSelectedRow();
                    this.pnlGener.btnEliminar.setEnabled(true);
                    break;
                case 4:
                    // <editor-fold defaultstate="collapsed" desc="Metodo sin botones de reproduccion">
                    /*try {
                        FileInputStream fis;
                        Player player;
                        String musica = String.valueOf(this.pnlGener.tb_cancion.getValueAt(fila, 5));
                        musica = musica.replace("\\", "\\\\");
                        //JOptionPane.showMessageDialog(null, musica);
                        fis = new FileInputStream(musica);
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        player = new Player(bis); // Llamada a constructor de la clase Player
                        player.play();          // Llamada al método play

                    } catch (JavaLayerException ex) {
                        JOptionPane.showMessageDialog(null, "No se ha encontrado Periferico de Sonido...");
                        ex.printStackTrace();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }*/
                    break;
                // </editor-fold> 
                case 2:

                    try {

                        int column = this.pnlGener.tb_cancion.getColumnModel().getColumnIndexAtX(e.getX());
                        int row = e.getY() / this.pnlGener.tb_cancion.getRowHeight();

                        if (row < this.pnlGener.tb_cancion.getRowCount() && row >= 0 && column < this.pnlGener.tb_cancion.getColumnCount() && column >= 0) {
                            Object value = this.pnlGener.tb_cancion.getValueAt(row, column);
                            JOptionPane.showMessageDialog(null, "FILA" + row + " Columna" + column);

                            if (value instanceof JButton) {
                                ((JButton) value).doClick();
                                JButton boton = (JButton) value;
                                if (boton.getName().equals("m")) {

                                }

                            }
                        }

                        //this.pnlGener.labelMusica.setText(String.valueOf(this.pnlGener.tb_cancion.getValueAt(fila, 1)));
                        String musica = String.valueOf(this.pnlGener.tb_cancion.getValueAt(fila, 5));
//                        musica = musica.replace("\\", "\\\\");
//                        mi_reproductor.AbrirFichero(musica);
//                        mi_reproductor.Play();

                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }

                    break;

                default:
                    break;
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {

    }

    @Override
    public void mouseExited(MouseEvent e
    ) {

    }

    private void eliminar() {
        PreparedStatement ps2;

        try {
            ps2 = conexion.getConnection().prepareStatement("delete from tb_cancion where tb_cancion.id_cancion= ?");
            ps2.setInt(1, Integer.parseInt(String.valueOf(this.pnlGener.tb_cancion.getValueAt(fila, 0))));//CANCIONES
            ps2.execute();
            cargarData(this.pnlGener.tb_cancion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se la ha podido eliminar, probablemente el registro esta asociado a otras tablas.");
            Logger.getLogger(DataCancionesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void modificar() {

        try {

            String Ssql = "UPDATE tb_cancion SET nm_cancion=?, artista=? WHERE id_cancion=?";

            PreparedStatement prest = conexion.getConnection().prepareStatement(Ssql);
            prest.setString(1, this.pnlGener.txtAlbum.getText());
            prest.setInt(2, this.idArtista);
            prest.setInt(3, Integer.parseInt(String.valueOf(this.pnlGener.tb_cancion.getValueAt(fila, 0))));//CANCIONES

            if (prest.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(null, "Los datos han sido modificados con éxito", "Operación Exitosa",
                        JOptionPane.INFORMATION_MESSAGE);
                cargarData(this.pnlGener.tb_cancion);
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
