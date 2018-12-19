/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.reproductorgg;

import com.reproductor.RepositoryController.LoginController;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import com.reproductor.vistas.Login;
import javax.swing.JDialog;
import javax.swing.UIManager;

/**
 *
 * @author user1
 */
public class ReproductorGG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            
            Login login = new Login();
            LoginController log= new LoginController(login);
            login.setVisible(true);
            login.setLocationRelativeTo(null);

            
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // login.setIconImage(new ImageIcon(getClass().getResource("/com/reproductor/imgs/Ico.png")).getImage());
    }

}
