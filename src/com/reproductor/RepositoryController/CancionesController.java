package com.reproductor.RepositoryController;

import com.reproductor.modelo.Artistas;
import com.reproductor.modelo.Conexion;
import com.reproductor.modelo.MusicaSeleccionada;
import com.reproductor.modelo.Render;
import com.reproductor.modelo.Reproductor;
import com.reproductor.vistas.Principal;
import com.reproductor.vistas.paneles.pnlCanciones;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author HP
 */
public class CancionesController implements ActionListener, MouseListener {

    FileInputStream fis, fism;
    int logitudByte, longitudByteM;
    Artistas art = new Artistas();
    String slc_artistas = "select id_artista,nm_artista,st_artista from tb_artista where st_artista='1'";
    String slc_genero = "select id_genero,nm_genero,st_genero from tb_genero where st_genero='1'";
    String artista_id = "";
    String valorSeleccionado;
    int idArtista = 0;
    int idGenero = 0;
    int fila;
    Conexion conexion = new Conexion();
    Principal interfaz;
    pnlCanciones canciones = new pnlCanciones();
    JButton btnFav = new JButton("Favorito");
    MusicaSeleccionada musica = new MusicaSeleccionada();
    String url_musica = "";
    Reproductor mi_reproductor;
    String play = "pause";

    public CancionesController(Principal interfaz, pnlCanciones listC) {
        this.canciones = listC;
        this.interfaz = interfaz;
        cargarDatos(slc_artistas, canciones.cmbArtista);
        cargarDatos(slc_genero, canciones.cmbGenero);
        mi_reproductor = new Reproductor();

        this.canciones.BtnCargarImagen.addActionListener(this);
        this.canciones.BtnCargarMusica.addActionListener(this);
        this.canciones.BtnGuardar.addActionListener(this);
        this.canciones.cmbArtista.addActionListener(this);
        this.canciones.cmbGenero.addActionListener(this);
        this.canciones.btnCargar.addActionListener(this);
        this.canciones.btnEliminar.addActionListener(this);

        this.canciones.tb_cancion.addMouseListener(this);
        this.canciones.btnPlay1.addActionListener(this);
        this.canciones.labelExit.addMouseListener(this);

        this.canciones.labelConsultarPI.addMouseListener(this);
        this.canciones.labelCrearPI.addMouseListener(this);
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

    public void selectActor(JComboBox cmbempresa) {
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

    public void selectGenero(JComboBox cmbempresa) {
        conexion = new Conexion();
        valorSeleccionado = (String) cmbempresa.getSelectedItem();
        //obtner el codigo de la empresa seleccionada
        artista_id = "select id_genero,nm_genero from tb_genero where nm_genero='" + valorSeleccionado + "'";
        try {
            Statement st = conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(artista_id);
            if (rs.next()) {
            }
            idGenero = rs.getInt(1);
            System.out.println("se ha seleccionado :" + idGenero);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.canciones.btnPlay1) {
            if (play.equals("pause")) {
                try {
                    mi_reproductor.Pausa();

                } catch (Exception ex) {
                    Logger.getLogger(CancionesController.class.getName()).log(Level.SEVERE, null, ex);
                }
                play = "play";
                this.canciones.btnPlay1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/reproductor/play.png")));
            } else {
                System.out.println("REPRODUCTOR ACTIVADO");
                try {
                    mi_reproductor.Continuar();

                } catch (Exception ex) {
                    Logger.getLogger(CancionesController.class.getName()).log(Level.SEVERE, null, ex);
                }
                play = "pause";
                this.canciones.btnPlay1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/reproductor/pausa.png")));
            }

        }

        if (ae.getSource() == this.canciones.btnCargar) {
            cargarData(canciones.tb_cancion);
            this.canciones.btnEliminar.setEnabled(true);

        }
        if (ae.getSource() == this.canciones.btnEliminar) {
            if (fila >= 0) {
                eliminar();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado una fila");
            }
        }
        if (ae.getSource() == this.canciones.cmbArtista) {
            this.selectActor(this.canciones.cmbArtista);
        }
        if (ae.getSource() == this.canciones.cmbGenero) {
            this.selectGenero(this.canciones.cmbGenero);
        }
        if (ae.getSource() == this.canciones.BtnCargarImagen) {
            this.canciones.lblFoto.setIcon(null);
            JFileChooser j = new JFileChooser();
            FileNameExtensionFilter filer = new FileNameExtensionFilter("Archivo de Imagenes", "png", "jpg");
            j.setFileFilter(filer);
            j.setDialogTitle("Cargar Imagen");
            j.setMultiSelectionEnabled(false);
            j.setAcceptAllFileFilterUsed(true);
            j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas

            int estado = j.showOpenDialog(null);
            if (estado == JFileChooser.APPROVE_OPTION) {
                try {
                    fis = new FileInputStream(j.getSelectedFile());
                    //necesitamos saber la cantidad de bytes
                    this.logitudByte = (int) j.getSelectedFile().length();
                    try {
                        Image icono = ImageIO.read(j.getSelectedFile()).getScaledInstance(this.canciones.lblFoto.getWidth(), this.canciones.lblFoto.getHeight(), Image.SCALE_DEFAULT);
                        this.canciones.lblFoto.setIcon(new ImageIcon(icono));
                        this.canciones.lblFoto.updateUI();

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this.interfaz, "imagen: " + ex);
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (ae.getSource() == this.canciones.BtnCargarMusica) {
            this.canciones.lblFoto.setIcon(null);
            JFileChooser j = new JFileChooser();
            FileNameExtensionFilter filer = new FileNameExtensionFilter("Archivo de Música", "mp3");
            j.setFileFilter(filer);
            j.setDialogTitle("Cargar Archivos de Musica");
            j.setMultiSelectionEnabled(false);
            j.setAcceptAllFileFilterUsed(true);
            j.setFileSelectionMode(JFileChooser.FILES_ONLY);//solo archivos y no carpetas

            int estado = j.showOpenDialog(null);
            if (estado == JFileChooser.APPROVE_OPTION) {
                try {
                    fism = new FileInputStream(j.getSelectedFile());
                    //necesitamos saber la cantidad de bytes
                    this.longitudByteM = (int) j.getSelectedFile().length();
                    JOptionPane.showMessageDialog(null, "Archivo MP3 Cargado correctamente...");
                    //OBTENEMOS LA RUTA
                    this.canciones.txtUrl.setText(j.getSelectedFile().toString());
//            File archivo = new File(this.Anverso);
//            archivo.getAbsolutePath();

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (ae.getSource() == this.canciones.BtnGuardar) {
            conexion = new Conexion();
            try {
                String sql = "INSERT INTO tb_cancion (nm_cancion, artista, genero, album, imagen, duracion, url) "
                        + "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
                ps.setString(1, this.canciones.txtNombre.getText());//NOMBRE
                ps.setInt(2, idArtista);//ARTISTA
                ps.setInt(3, idGenero);//GENERO
                ps.setString(4, this.canciones.txtAlbum.getText());//ALBUM
                ps.setBinaryStream(5, fis, logitudByte);//IMAGEN
                ps.setString(6, this.canciones.txtDuracion.getText());//DURACION
                ps.setString(7, this.canciones.txtUrl.getText());//URL
                ps.execute();
                ps.close();
                this.canciones.txtNombre.setText("");
                this.canciones.cmbArtista.setSelectedIndex(1);
                this.canciones.cmbArtista.setSelectedIndex(1);
                this.canciones.txtAlbum.setText("");
                this.canciones.txtDuracion.setText("##:##");
                JOptionPane.showMessageDialog(null, "Registro insertado Correctamente...");

            } catch (SQLException ex) {

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        if (me.getSource() == this.canciones.labelExit) {
            try {
                mi_reproductor.Stop();
            } catch (Exception ex) {
                Logger.getLogger(pnlCanciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (me.getSource() == this.canciones.tb_cancion) {
            switch (me.getClickCount()) {
                case 1:
                    fila = this.canciones.tb_cancion.getSelectedRow();
                    this.canciones.btnEliminar.setEnabled(true);
                    try {
                        int column = this.canciones.tb_cancion.getColumnModel().getColumnIndexAtX(me.getX());
                        int row = me.getY() / this.canciones.tb_cancion.getRowHeight();

                        if (row < this.canciones.tb_cancion.getRowCount() && row >= 0 && column < this.canciones.tb_cancion.getColumnCount() && column >= 0) {
                            JOptionPane.showMessageDialog(null, "FILA" + row + " Columna" + column);
                            if (column < 6) { // verificamos si se ha hecho clic en el boton

                                this.canciones.labelNMusica1.setText(String.valueOf(this.canciones.tb_cancion.getValueAt(fila, 1)));
                                this.canciones.labelArtista1.setText(String.valueOf(this.canciones.tb_cancion.getValueAt(fila, 2)));
                                this.canciones.btnPlay1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/reproductor/pausa.png"))); // NOI18N
                                
                                url_musica = String.valueOf(this.canciones.tb_cancion.getValueAt(fila, 5));

                                url_musica = url_musica.replace("\\", "\\\\");
                                JOptionPane.showMessageDialog(null, url_musica);
                                mi_reproductor.AbrirFichero(url_musica);
                                mi_reproductor.Play();
                            } else { // SE PRESIONO EL BOTON DE FAVORITO
                                mi_reproductor.Stop();
                                mi_reproductor = new Reproductor();
                                JOptionPane.showMessageDialog(null, "Agregado a Favorito");
                                agregarFavorito();

                            }

                        }

                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }

                    break;

                default:
                    break;
            }

        }
        if (me.getSource() == this.canciones.labelConsultarPI) {

            // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">                          
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.canciones.labelConsultarPI.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
            this.canciones.labelConsultarPI.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
            this.canciones.labelCrearPI.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.canciones.labelCrearPI.setForeground(new java.awt.Color(255, 255, 255));

            // </editor-fold>  
            this.canciones.tb_cancion.setVisible(true);
            this.canciones.pnlTabla.setVisible(true);
            this.canciones.btnEliminar.setVisible(true);
            this.canciones.btnCargar.setVisible(true);
            this.canciones.txtNombre.setEnabled(false);
            this.canciones.cmbArtista.setEnabled(false);
            this.canciones.cmbGenero.setEnabled(false);
            this.canciones.txtAlbum.setEnabled(false);
            this.canciones.txtDuracion.setEnabled(false);
            this.canciones.txtUrl.setEnabled(false);
            this.canciones.BtnCargarImagen.setVisible(false);
            this.canciones.BtnCargarMusica.setVisible(false);
            this.canciones.BtnGuardar.setVisible(false);

        }
        if (me.getSource() == this.canciones.labelCrearPI) {

            // <editor-fold defaultstate="collapsed" desc="Metodos Hover en Botones">                          
            /*CAMBIAMOS LOS COLORES Y LETRAS PARA SABER QUE ESTA ES LA OPCION SELECCIONADA*/
            this.canciones.labelCrearPI.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
            this.canciones.labelCrearPI.setForeground(new java.awt.Color(29, 185, 84));
            /*REGRESAMOS LOS OTRAS OPCIONES A SU ESTADO ORIGINAL.*/
            this.canciones.labelConsultarPI.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
            this.canciones.labelConsultarPI.setForeground(new java.awt.Color(255, 255, 255));

            // </editor-fold>  
            this.canciones.tb_cancion.setVisible(false);
            this.canciones.pnlTabla.setVisible(false);
            this.canciones.btnEliminar.setVisible(false);
            this.canciones.btnCargar.setVisible(false);
            this.canciones.txtNombre.setEnabled(true);
            this.canciones.cmbArtista.setEnabled(true);
            this.canciones.cmbGenero.setEnabled(true);
            this.canciones.txtAlbum.setEnabled(true);
            this.canciones.txtDuracion.setEnabled(true);
            this.canciones.txtUrl.setEnabled(true);
            this.canciones.BtnCargarImagen.setVisible(true);
            this.canciones.BtnCargarMusica.setVisible(true);
            this.canciones.BtnGuardar.setVisible(true);
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

    /*METODOS   */
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
        modelo.addColumn("FAVORITO");
        String sentencia = "SELECT id_cancion, nm_cancion, tb_artista.nm_artista, tb_genero.nm_genero, album, url\n"
                + "	FROM public.tb_cancion\n"
                + "	INNER JOIN tb_artista on tb_cancion.artista=tb_artista.id_artista\n"
                + "	INNER JOIN tb_genero on tb_cancion.genero=tb_genero.id_genero";
        try {
            ResultSet rs = conexion.obtenerDatos(sentencia);

            btnFav.setName("m");
            while (rs.next()) {
                Object fila[] = new Object[7];
                fila[0] = rs.getInt(1);
                fila[1] = rs.getString(2).trim();
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = btnFav;
                modelo.addRow(fila);

            }
            tblDatos.setModel(modelo);
            tblDatos.setRowHeight(35);

            tblDatos.getColumnModel().getColumn(0).setMinWidth(50);
            tblDatos.getColumnModel().getColumn(0).setMaxWidth(50);

            tblDatos.getColumnModel().getColumn(1).setMinWidth(320);

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

    private void eliminar() {
        PreparedStatement ps2;

        try {
            ps2 = conexion.getConnection().prepareStatement("delete from tb_cancion where tb_cancion.id_cancion= ?");
            ps2.setInt(1, Integer.parseInt(String.valueOf(this.canciones.tb_cancion.getValueAt(fila, 0))));//CANCIONES
            ps2.execute();
            cargarData(this.canciones.tb_cancion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se la ha podido eliminar, probablemente el registro esta asociado a otras tablas.");
            Logger.getLogger(DataCancionesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void agregarFavorito() {
        conexion = new Conexion();
        try {
            String sql = "INSERT INTO public.tb_favorito(cancion, st_fav) VALUES (?, ?)";
            PreparedStatement ps = conexion.getConnection().prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(String.valueOf(this.canciones.tb_cancion.getValueAt(fila, 0))));
            ps.setInt(2, 1);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Agregado Correctamente");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo Agregar, intentar nuevamente");
        }

    }
}
