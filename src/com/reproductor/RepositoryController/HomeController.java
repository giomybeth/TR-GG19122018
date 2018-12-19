package com.reproductor.RepositoryController;

import com.reproductor.modelo.Conexion;
import com.reproductor.modelo.Favoritos;
import com.reproductor.modelo.ListaReproduccion;
import com.reproductor.modelo.Reproductor;
import com.reproductor.vistas.Principal;
import com.reproductor.vistas.paneles.pnlCanciones;
import com.reproductor.vistas.paneles.pnlFavorito;
import com.reproductor.vistas.paneles.pnlHome;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
//import com.reproductor.vistas.paneles.pnlHome;

/**
 *
 * @author HP
 */
public class HomeController implements ActionListener {

    Conexion conexion = new Conexion();
    Principal interfaz;
    pnlHome home = new pnlHome();
    //pnlHome canciones = new pnlHome();
    String sql_fav = "select id_fav,id_cancion,nm_cancion,tb_artista.nm_artista,album,imagen,url FROM tb_favorito\n"
            + "INNER JOIN tb_cancion ON tb_favorito.cancion=tb_cancion.id_cancion "
            + "INNER JOIN tb_artista ON tb_cancion.artista=tb_artista.id_artista";
    String sql_listas="SELECT id,nombre,status FROM tb_listap";

    private List<JPanel> panelesFav;
    private List<JPanel> panelesRec;
    private List<JPanel> panelesLre;
    private ArrayList<Favoritos> favoritos;
    private ArrayList<ListaReproduccion> lrepr;
    ImageIcon foto;
    Reproductor mi_reproductor;
    String url = "";
    String play = "pause";

    public HomeController(Principal interfaz, pnlHome home) {
        this.home = home;
        this.interfaz = interfaz;
        mi_reproductor = new Reproductor();
        home.setSize(1320, 828);
        panelesFav = new ArrayList<>();
        panelesLre = new ArrayList<>();
        
        cargar_favoritos();
        cargarpnlFav();
        cargar_lrepr();
        cargarpnlLrp();

        this.home.btnPlay.addActionListener(this);
    }

    /*CARGA LA LISTA DE ESCUCHADAS RECIENTEMENTE*/
 /*CARGA LA LISTA DE REPRODUCCION*/
 /*TRAE LAS CANCIONES ASOCIADAS A UNA LISTA DE REPRODUCCION*/
 /*CARGA LA CANCIONES FAVORITAS*/
    public ArrayList<Favoritos> cargar_favoritos() {
        conexion = new Conexion();
        InputStream is;
        try {
            ResultSet rs = conexion.obtenerDatos(sql_fav);
            favoritos = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                Integer idCancion = rs.getInt(2);
                String nmCancion = rs.getString(3);
                String artista = rs.getString(4);
                String album = rs.getString(5);
                is = rs.getBinaryStream(6);
                String url = rs.getString(7);

                System.out.println("DATO 1" + rs.getInt(1));
                System.out.println("DATO 2" + rs.getInt(2));
                System.out.println("DATO 3" + rs.getString(3));
                System.out.println("DATO 4" + rs.getString(4));
                System.out.println("DATO 5" + rs.getString(5));
                System.out.println("DATO 6" + rs.getBinaryStream(6));
                System.out.println("DATO 7" + rs.getString(7));
                favoritos.add(new Favoritos(id, idCancion, nmCancion, artista, album, is, url));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(home, "ERROR AL CARGAR LOS FAVORITOS", "Reproductor", JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR FAVORITOS:" + e);
        }
        return favoritos;
    }

    public void cargarpnlFav() {

        for (int i = 0; i < favoritos.size(); i++) {
            //cargamos las acciones de los accesos directos al Panel
            JPanel panel = new JPanel();
            JPanel contenedor = new JPanel();
            JLabel NMusica = new JLabel();
            JLabel Caratula = new JLabel();
            JLabel Artista = new JLabel();
            JLabel Album = new JLabel();
            NMusica.setText(favoritos.get(i).getNmCancion());
            Artista.setText(favoritos.get(i).getArtista());
            Album.setText(favoritos.get(i).getAlbum());
            url = String.valueOf(favoritos.get(i).getUrl());
            url = url.replace("\\", "\\\\");
            NMusica.setForeground(new java.awt.Color(255, 255, 255));
            Artista.setForeground(new java.awt.Color(255, 255, 255));
            Album.setForeground(new java.awt.Color(255, 255, 255));

            try {
                BufferedImage bi = ImageIO.read(favoritos.get(i).getImagen());
                cargarImagen(Caratula, bi);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            ;
            /*try {
                bi = ImageIO.read(favoritos.get(i).getImagen());
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newicon = new ImageIcon(newimg);
                Caratula.setIcon(newicon);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }*/

            Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
            UIManager.put("ToolTip.border", border);//coloca el tipo de borde
            UIManager.put("ToolTip.foreground", new ColorUIResource(Color.white));// color de las letras
            UIManager.put("ToolTip.font", new FontUIResource("Century Gothic", Font.BOLD, 10));//fuente
            UIManager.put("ToolTip.background", new ColorUIResource(Color.black));//coloca color de fondo
            NMusica.setFont(new java.awt.Font("Century Gothic", 2, 14));
            panel.setBackground(new java.awt.Color(18, 18, 18));

            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            /*File archivo = new File(directorio + separador + "src\\com\\mancompsolutions\\imgs\\" + sub_menu.get(i).getId_msc() + ".png");
            if (archivo.exists()) {
                ic_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mancompsolutions/imgs/" + sub_menu.get(i).getId_msc() + ".png"))); // NOI18N
                panel.add(ic_icon);
            }*/
            panel.add(Caratula);
            panel.add(NMusica);
            panel.add(Artista);
            panel.add(Album);
            panel.setToolTipText("Favoritos");

            panel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(null, NMusica.getText());
                    reproducir(NMusica.getText(), Artista.getText(), Caratula);
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

            });
            contenedor.add(panel);
            contenedor.setBackground(new java.awt.Color(18, 18, 18));
            //contenedor.setBackground(new java.awt.Color(240, 240, 240));
            //contenedor.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(240, 240, 240)));
            this.home.pnlInternoFav.add(contenedor);
            panelesFav.add(panel);
            this.home.pnlInternoFav.updateUI();

        }
    }
    
    public ArrayList<ListaReproduccion> cargar_lrepr() {
        conexion = new Conexion();
        try {
            ResultSet rs = conexion.obtenerDatos(sql_listas);
            lrepr = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String nmLista = rs.getString(2);
                String status = rs.getString(3);
               
                System.out.println("LISTA 1: " + rs.getInt(1));
                System.out.println("LISTA 2: " + rs.getString(2));
                System.out.println("LISTA 3: " + rs.getString(3));
                lrepr.add(new ListaReproduccion(id, nmLista, status));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(home, "ERROR AL CARGAR LAS LIST. REP", "Reproductor", JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR FAVORITOS:" + e);
        }
        return lrepr;
    }
    
     public void cargarpnlLrp() {

        for (int i = 0; i < lrepr.size(); i++) {
            //cargamos las acciones de los accesos directos al Panel
            JPanel panel = new JPanel();
            JPanel contenedor = new JPanel();
            JLabel NLista = new JLabel();
            JLabel Caratula = new JLabel();
            
            NLista.setText(lrepr.get(i).getNombre());
            url = String.valueOf(favoritos.get(i).getUrl());
            url = url.replace("\\", "\\\\");
            NLista.setForeground(new java.awt.Color(255, 255, 255));
            
            /*try {
                BufferedImage bi = ImageIO.read(favoritos.get(i).getImagen());
                cargarImagen(Caratula, bi);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }*/


            Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
            UIManager.put("ToolTip.border", border);//coloca el tipo de borde
            UIManager.put("ToolTip.foreground", new ColorUIResource(Color.white));// color de las letras
            UIManager.put("ToolTip.font", new FontUIResource("Century Gothic", Font.BOLD, 10));//fuente
            UIManager.put("ToolTip.background", new ColorUIResource(Color.black));//coloca color de fondo
            NLista.setFont(new java.awt.Font("Century Gothic", 2, 14));
            panel.setBackground(new java.awt.Color(18, 18, 18));

            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            /*File archivo = new File(directorio + separador + "src\\com\\mancompsolutions\\imgs\\" + sub_menu.get(i).getId_msc() + ".png");
            if (archivo.exists()) {
                ic_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mancompsolutions/imgs/" + sub_menu.get(i).getId_msc() + ".png"))); // NOI18N
                panel.add(ic_icon);
            }*/
            panel.add(Caratula);
            panel.add(NLista);
            panel.setToolTipText("Favoritos");

            panel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(null, NLista.getText());
                    //reproducir(NMusica.getText(), Artista.getText(), Caratula);
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

            });
            contenedor.add(panel);
            contenedor.setBackground(new java.awt.Color(18, 18, 18));
            //contenedor.setBackground(new java.awt.Color(240, 240, 240));
            //contenedor.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(240, 240, 240)));
            this.home.pnlInternoRep.add(contenedor);
            panelesLre.add(panel);
            this.home.pnlInternoRep.updateUI();

        }
    }
    

    private void reproducir(String nombre, String artista, JLabel caratula) {
        conexion = new Conexion();
        String select = "select url from tb_cancion where nm_cancion='" + nombre + "'";
        try {
            ResultSet rs = conexion.obtenerDatos(select);
            while (rs.next()) {
                this.home.btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/reproductor/pausa.png"))); // NOI18N
                // mandamos los datos a las cajas de texto del reproductor
                this.home.labelNMusica.setText(nombre);
                this.home.labelArtista.setText(artista);
                this.home.labelImagen.setIcon(caratula.getIcon());

                System.out.println("DATO 1" + rs.getString(1));
                mi_reproductor.AbrirFichero(rs.getString(1));
                mi_reproductor.Play();
            }

        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.home.btnPlay) {
            if (play.equals("pause")) {
                try {
                    mi_reproductor.Pausa();
                } catch (Exception ex) {
                    Logger.getLogger(CancionesController.class.getName()).log(Level.SEVERE, null, ex);
                }
                play = "play";
                this.home.btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/reproductor/play.png")));
            } else {
                System.out.println("REPRODUCTOR ACTIVADO");
                try {
                    mi_reproductor.Continuar();

                } catch (Exception ex) {
                    Logger.getLogger(CancionesController.class.getName()).log(Level.SEVERE, null, ex);
                }
                play = "pause";
                this.home.btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/reproductor/pausa.png")));
            }

        }
    }

    private void cargarImagen(JLabel Caratula, BufferedImage bi) {
        foto = new ImageIcon(bi);
        Image img = foto.getImage();
        Image newimg = img.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newicon = new ImageIcon(newimg);
        Caratula.setIcon(newicon);
    }
}