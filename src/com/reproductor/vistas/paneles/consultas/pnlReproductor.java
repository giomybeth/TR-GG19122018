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
public class pnlReproductor extends javax.swing.JPanel {

    /**
     * Creates new form pnlUsers
     */
    public pnlReproductor() {
        initComponents();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnListaR = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        CerrarVentanaCI = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarCanciones = new com.reproductor.modelo.MaterialButton();
        cmbListaR = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLstRepro = new javax.swing.JTable();
        pnlNorteR = new javax.swing.JPanel();
        labelExit = new javax.swing.JLabel();
        pnlSurR = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelNMusica = new javax.swing.JLabel();
        labelNMusica1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlCentralR = new javax.swing.JPanel();
        pnlListaR = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCancionesReproductor = new javax.swing.JTable();
        pnlEcualizador = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        pnListaR.setBackground(new java.awt.Color(9, 64, 99));
        pnListaR.setUndecorated(true);
        pnListaR.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                pnListaRWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                pnListaRWindowLostFocus(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(9, 64, 99));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel7MouseDragged(evt);
            }
        });
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel7MousePressed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Sitka Text", 0, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Listas de Reproducción");

        CerrarVentanaCI.setFont(new java.awt.Font("Aharoni", 0, 18)); // NOI18N
        CerrarVentanaCI.setForeground(new java.awt.Color(255, 255, 255));
        CerrarVentanaCI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CerrarVentanaCI.setText("X");
        CerrarVentanaCI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CerrarVentanaCIMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CerrarVentanaCI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(titulo)
                .addGap(0, 3, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(CerrarVentanaCI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Listas Reproducción");

        btnAgregarCanciones.setBackground(new java.awt.Color(0, 74, 140));
        btnAgregarCanciones.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCanciones.setText("ok");
        btnAgregarCanciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCancionesActionPerformed(evt);
            }
        });

        tblLstRepro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblLstRepro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblLstRepro.setEnabled(false);
        jScrollPane1.setViewportView(tblLstRepro);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbListaR, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbListaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarCanciones, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout pnListaRLayout = new javax.swing.GroupLayout(pnListaR.getContentPane());
        pnListaR.getContentPane().setLayout(pnListaRLayout);
        pnListaRLayout.setHorizontalGroup(
            pnListaRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnListaRLayout.setVerticalGroup(
            pnListaRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 153, 255));
        setLayout(new java.awt.BorderLayout());

        pnlNorteR.setBackground(new java.awt.Color(18, 18, 18));
        pnlNorteR.setPreferredSize(new java.awt.Dimension(663, 32));

        labelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/ic_exi.png"))); // NOI18N
        labelExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelExitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlNorteRLayout = new javax.swing.GroupLayout(pnlNorteR);
        pnlNorteR.setLayout(pnlNorteRLayout);
        pnlNorteRLayout.setHorizontalGroup(
            pnlNorteRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNorteRLayout.createSequentialGroup()
                .addGap(0, 681, Short.MAX_VALUE)
                .addComponent(labelExit))
        );
        pnlNorteRLayout.setVerticalGroup(
            pnlNorteRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorteRLayout.createSequentialGroup()
                .addComponent(labelExit)
                .addGap(0, 0, 0))
        );

        add(pnlNorteR, java.awt.BorderLayout.PAGE_START);

        pnlSurR.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setBackground(new java.awt.Color(40, 40, 40));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Imagen");

        labelNMusica.setForeground(new java.awt.Color(255, 255, 255));
        labelNMusica.setText("NOMBRE DE LA MUSICA");

        labelNMusica1.setForeground(new java.awt.Color(255, 255, 255));
        labelNMusica1.setText("ARTISTA");

        btnAtras.setBackground(new java.awt.Color(0, 74, 140));
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/reproductor/atras.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAtras.setRequestFocusEnabled(false);

        btnPause.setBackground(new java.awt.Color(0, 74, 140));
        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/reproductor/pause.png"))); // NOI18N
        btnPause.setBorder(null);
        btnPause.setBorderPainted(false);
        btnPause.setContentAreaFilled(false);
        btnPause.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPause.setRequestFocusEnabled(false);

        btnSiguiente.setBackground(new java.awt.Color(0, 74, 140));
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/reproductor/siguiente.png"))); // NOI18N
        btnSiguiente.setBorder(null);
        btnSiguiente.setBorderPainted(false);
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSiguiente.setRequestFocusEnabled(false);

        jProgressBar1.setBackground(new java.awt.Color(0, 74, 140));
        jProgressBar1.setMaximumSize(new java.awt.Dimension(32767, 5));
        jProgressBar1.setMinimumSize(new java.awt.Dimension(10, 5));
        jProgressBar1.setPreferredSize(new java.awt.Dimension(146, 5));
        jProgressBar1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jProgressBar1StateChanged(evt);
            }
        });
        jProgressBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgressBar1MouseClicked(evt);
            }
        });

        jLabel3.setText("Lista de Reproduccion");

        jLabel5.setText("Cargar Musica");

        javax.swing.GroupLayout pnlSurRLayout = new javax.swing.GroupLayout(pnlSurR);
        pnlSurR.setLayout(pnlSurRLayout);
        pnlSurRLayout.setHorizontalGroup(
            pnlSurRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSurRLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSurRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNMusica1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSurRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSurRLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btnAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSiguiente)
                        .addGap(50, 50, 50)
                        .addGroup(pnlSurRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        pnlSurRLayout.setVerticalGroup(
            pnlSurRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSurRLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlSurRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSurRLayout.createSequentialGroup()
                        .addGroup(pnlSurRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPause)
                            .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSurRLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addGap(12, 12, 12)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSurRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlSurRLayout.createSequentialGroup()
                            .addComponent(labelNMusica)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelNMusica1)
                            .addGap(12, 12, 12))))
                .addContainerGap())
        );

        add(pnlSurR, java.awt.BorderLayout.PAGE_END);

        pnlCentralR.setBackground(new java.awt.Color(0, 204, 255));
        pnlCentralR.setMinimumSize(new java.awt.Dimension(200, 250));
        pnlCentralR.setPreferredSize(new java.awt.Dimension(663, 230));
        pnlCentralR.setLayout(new java.awt.BorderLayout());

        pnlListaR.setBackground(new java.awt.Color(102, 0, 204));
        pnlListaR.setMinimumSize(new java.awt.Dimension(100, 50));
        pnlListaR.setPreferredSize(new java.awt.Dimension(180, 170));

        tblCancionesReproductor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblCancionesReproductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Cancion", "Ruta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCancionesReproductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCancionesReproductorMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCancionesReproductorMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblCancionesReproductor);
        if (tblCancionesReproductor.getColumnModel().getColumnCount() > 0) {
            tblCancionesReproductor.getColumnModel().getColumn(0).setMinWidth(50);
            tblCancionesReproductor.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblCancionesReproductor.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout pnlListaRLayout = new javax.swing.GroupLayout(pnlListaR);
        pnlListaR.setLayout(pnlListaRLayout);
        pnlListaRLayout.setHorizontalGroup(
            pnlListaRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
            .addGroup(pnlListaRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlListaRLayout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlListaRLayout.setVerticalGroup(
            pnlListaRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
            .addGroup(pnlListaRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlListaRLayout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );

        pnlCentralR.add(pnlListaR, java.awt.BorderLayout.LINE_START);

        pnlEcualizador.setBackground(new java.awt.Color(255, 51, 255));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/radio.gif"))); // NOI18N

        javax.swing.GroupLayout pnlEcualizadorLayout = new javax.swing.GroupLayout(pnlEcualizador);
        pnlEcualizador.setLayout(pnlEcualizadorLayout);
        pnlEcualizadorLayout.setHorizontalGroup(
            pnlEcualizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEcualizadorLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 546, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnlEcualizadorLayout.setVerticalGroup(
            pnlEcualizadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEcualizadorLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, 0))
        );

        pnlCentralR.add(pnlEcualizador, java.awt.BorderLayout.CENTER);

        add(pnlCentralR, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jProgressBar1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jProgressBar1StateChanged

    }//GEN-LAST:event_jProgressBar1StateChanged

    private void jProgressBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar1MouseClicked

    }//GEN-LAST:event_jProgressBar1MouseClicked

    private void CerrarVentanaCIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CerrarVentanaCIMouseClicked
        this.pnListaR.dispose();
    }//GEN-LAST:event_CerrarVentanaCIMouseClicked

    private void jPanel7MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseDragged
        
    }//GEN-LAST:event_jPanel7MouseDragged

    private void jPanel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MousePressed
       
    }//GEN-LAST:event_jPanel7MousePressed

    private void btnAgregarCancionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCancionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarCancionesActionPerformed

    private void pnListaRWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_pnListaRWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_pnListaRWindowGainedFocus

    private void pnListaRWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_pnListaRWindowLostFocus

    }//GEN-LAST:event_pnListaRWindowLostFocus

    private void labelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_labelExitMouseClicked

    private void labelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExitMouseEntered
        labelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/ic_exih.png"))); // NOI18N
    }//GEN-LAST:event_labelExitMouseEntered

    private void labelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelExitMouseExited
        labelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/reproductor/img/ic_exi.png"))); // NOI18N
    }//GEN-LAST:event_labelExitMouseExited

    private void tblCancionesReproductorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCancionesReproductorMouseClicked

    }//GEN-LAST:event_tblCancionesReproductorMouseClicked

    private void tblCancionesReproductorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCancionesReproductorMouseReleased

    }//GEN-LAST:event_tblCancionesReproductorMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel CerrarVentanaCI;
    public com.reproductor.modelo.MaterialButton btnAgregarCanciones;
    public javax.swing.JButton btnAtras;
    public javax.swing.JButton btnPause;
    public javax.swing.JButton btnSiguiente;
    public javax.swing.JComboBox<String> cmbListaR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel labelExit;
    public javax.swing.JLabel labelNMusica;
    public javax.swing.JLabel labelNMusica1;
    public javax.swing.JDialog pnListaR;
    private javax.swing.JPanel pnlCentralR;
    private javax.swing.JPanel pnlEcualizador;
    private javax.swing.JPanel pnlListaR;
    private javax.swing.JPanel pnlNorteR;
    private javax.swing.JPanel pnlSurR;
    public javax.swing.JTable tblCancionesReproductor;
    public javax.swing.JTable tblLstRepro;
    public javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
