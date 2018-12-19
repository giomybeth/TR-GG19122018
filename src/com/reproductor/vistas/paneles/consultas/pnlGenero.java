/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reproductor.vistas.paneles.consultas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RoggerAlexis
 */
public class pnlGenero extends javax.swing.JPanel {

    /**
     * Creates new form pnlUsers
     */
    public pnlGenero() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptarModificar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_genero = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        btnEliminar = new com.reproductor.modelo.MaterialButtomRectangle();
        btnModificar = new com.reproductor.modelo.MaterialButtomRectangle();
        btnCargar = new com.reproductor.modelo.MaterialButtomRectangle();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nombre");

        btnAceptarModificar.setText("Aceptar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAceptarModificar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnAceptarModificar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBackground(new java.awt.Color(18, 18, 18));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb_genero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_genero);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 44, 604, 140));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Genero");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 120, 41));

        btnEliminar.setBackground(new java.awt.Color(29, 185, 84));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setMaximumSize(new java.awt.Dimension(65, 22));
        btnEliminar.setMinimumSize(new java.awt.Dimension(65, 22));
        btnEliminar.setPreferredSize(new java.awt.Dimension(65, 22));
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 90, 40));

        btnModificar.setBackground(new java.awt.Color(29, 185, 84));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setMaximumSize(new java.awt.Dimension(65, 22));
        btnModificar.setMinimumSize(new java.awt.Dimension(65, 22));
        btnModificar.setPreferredSize(new java.awt.Dimension(65, 22));
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 90, 40));

        btnCargar.setBackground(new java.awt.Color(29, 185, 84));
        btnCargar.setForeground(new java.awt.Color(255, 255, 255));
        btnCargar.setText("Cargar");
        add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 90, 40));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptarModificar;
    public com.reproductor.modelo.MaterialButtomRectangle btnCargar;
    public com.reproductor.modelo.MaterialButtomRectangle btnEliminar;
    public com.reproductor.modelo.MaterialButtomRectangle btnModificar;
    public javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tb_genero;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
