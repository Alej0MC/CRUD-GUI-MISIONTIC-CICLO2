/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.RankingDAO;
import controller.ContenidoDAO;
import model.Usuario;
import model.Contenido;
import model.Transmision;
import controller.TransmisionDAO;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class VideosPro extends javax.swing.JFrame {
    Usuario user = new Usuario();
    Contenido cont = new Contenido();
    Transmision tr = new Transmision();
    TransmisionDAO dao = new TransmisionDAO();
    ContenidoDAO Cdao = new ContenidoDAO();
    /**
     * Creates new form VideosPro
     */
    public VideosPro() throws Exception {
        initComponents();
        mostrarTabla();
        llenarCombo();
        selectValues();
        
    }
    
    public void mostrarTabla() throws Exception{
        RankingDAO dao = new RankingDAO();
        jTable1.setModel(new javax.swing.table.DefaultTableModel(dao.getAllRankings(),
            new String [] {
                "ID", "Nombre", "Vistas"
            }
        ));
        updateComboId();
    }
    public void llenarCombo(){
        jComboAlias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lucky", "malopez", "diva", "dreamer", "ninja", "neon", "rose", "green" }));
        jComboCont.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Los Vengadores", "Interestelar", "El viaje de Chihiro", "Parasitos", "Mas alla de los sueños", "The walking dead", "Viaje a las estrellas: la serie original", "Glow", "La casa de papel", "Friends", "Arrow", "The big bang theory", "Vikingos" }));
    }
    public void insertar() throws Exception{
       user.setAlias(this.jComboAlias.getSelectedItem().toString());
       cont.setNombreCont(this.jComboCont.getSelectedItem().toString());
       tr.setTransFecha(this.jTextFecha.getText());
       dao.insertTransmision(tr, user, cont);
    }
    public void updateComboId() throws  Exception{
        jComboID.setModel(new javax.swing.DefaultComboBoxModel<>(dao.getAllTransID()));
    }
    public void selectValues() throws  Exception{
        ArrayList<Transmision> Transmisiones = dao.getAllTransmisiones();
        ArrayList<Contenido> Contenidos = Cdao.getAllContenidos();
        jComboAlias.setSelectedItem(Transmisiones.get(Integer.parseInt(this.jComboID.getSelectedItem().toString())-1).getTransAlias());
        jComboCont.setSelectedItem(Contenidos.get(Integer.parseInt(this.jComboID.getSelectedItem().toString())-1).getNombreCont());
        jTextFecha.setText(Transmisiones.get(Integer.parseInt(this.jComboID.getSelectedItem().toString())-1).getTransFecha());
    }
    public void actualizar() throws Exception{
        ArrayList<Transmision> Transmisiones = dao.getAllTransmisiones();
        String nuevaFecha = this.jTextFecha.getText();
        user.setAlias(this.jComboAlias.getSelectedItem().toString());
        cont.setNombreCont(this.jComboCont.getSelectedItem().toString());
        tr.setTransId(Transmisiones.get(Integer.parseInt(this.jComboID.getSelectedItem().toString())-1).getTransId());
        dao.updateTransmision(nuevaFecha, tr, cont, user);
    }
    public void eliminar() throws  Exception{
        tr.setTransId(Integer.parseInt(this.jComboID.getSelectedItem().toString()));
        dao.deleteTransmision(tr);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonElim = new javax.swing.JButton();
        jButtonIngresar = new javax.swing.JButton();
        jButtonActu = new javax.swing.JButton();
        jComboAlias = new javax.swing.JComboBox<>();
        jComboCont = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFecha = new javax.swing.JTextField();
        jComboID = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setResizable(false);

        Background.setBackground(new java.awt.Color(29, 29, 29));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(97, 97, 97));

        jLabel1.setBackground(new java.awt.Color(254, 254, 254));
        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("VideosPro");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Imagenes/logoVideosPro.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 254, 254));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reto 5");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Mision Tic 2022");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 245, 245));
        jLabel5.setText("Alejandro Mendoza");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(52, 52, 52)
                .addComponent(jLabel5)
                .addGap(23, 23, 23))
        );

        Background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 470));

        jPanel2.setBackground(new java.awt.Color(46, 46, 46));

        jButtonElim.setBackground(new java.awt.Color(70, 70, 70));
        jButtonElim.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jButtonElim.setForeground(new java.awt.Color(254, 254, 254));
        jButtonElim.setText("ELIMINAR");
        jButtonElim.setToolTipText("");
        jButtonElim.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 254, 254), 1, true));
        jButtonElim.setBorderPainted(false);
        jButtonElim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonElim.setFocusable(false);
        jButtonElim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElimActionPerformed(evt);
            }
        });

        jButtonIngresar.setBackground(new java.awt.Color(70, 70, 70));
        jButtonIngresar.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jButtonIngresar.setForeground(new java.awt.Color(254, 254, 254));
        jButtonIngresar.setText("INGRESAR");
        jButtonIngresar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 254, 254), 1, true));
        jButtonIngresar.setBorderPainted(false);
        jButtonIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonIngresar.setFocusable(false);
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });

        jButtonActu.setBackground(new java.awt.Color(70, 70, 70));
        jButtonActu.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        jButtonActu.setForeground(new java.awt.Color(254, 254, 254));
        jButtonActu.setText("ACTUALIZAR");
        jButtonActu.setToolTipText("");
        jButtonActu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 254, 254), 1, true));
        jButtonActu.setBorderPainted(false);
        jButtonActu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonActu.setFocusable(false);
        jButtonActu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActuActionPerformed(evt);
            }
        });

        jComboAlias.setBackground(new java.awt.Color(254, 254, 254));
        jComboAlias.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        jComboAlias.setForeground(new java.awt.Color(1, 1, 1));
        jComboAlias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboAlias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboAlias.setFocusable(false);

        jComboCont.setBackground(new java.awt.Color(254, 254, 254));
        jComboCont.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        jComboCont.setForeground(new java.awt.Color(1, 1, 1));
        jComboCont.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboCont.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboCont.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Alias :");

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(254, 254, 254));
        jLabel7.setText("Contenido :");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(254, 254, 254));
        jLabel8.setText("Fecha :");

        jLabel9.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(254, 254, 254));
        jLabel9.setText("RANKING DE CONTENIDOS");

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(254, 254, 254));
        jLabel10.setText("Trans ID:");

        jTextFecha.setText("jTextField1");

        jComboID.setBackground(new java.awt.Color(254, 254, 254));
        jComboID.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        jComboID.setForeground(new java.awt.Color(1, 1, 1));
        jComboID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboID.setFocusable(false);
        jComboID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboIDItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButtonActu, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButtonElim, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboID, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFecha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboCont, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jComboID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonElim, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        Background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 590, 250));

        jScrollPane1.setForeground(new java.awt.Color(111, 111, 111));

        jTable1.setBorder(null);
        jTable1.setFont(new java.awt.Font("Roboto", 0, 15)); // NOI18N
        jTable1.setForeground(new java.awt.Color(158, 158, 158));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(187, 187, 187));
        jScrollPane1.setViewportView(jTable1);

        Background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 580, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElimActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == jButtonElim) {
            try {
                eliminar();
                mostrarTabla();
            } catch (Exception ex) {
                Logger.getLogger(VideosPro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonElimActionPerformed

    private void jButtonActuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActuActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == jButtonActu) {
            try {
                actualizar();
                mostrarTabla();
                
            } catch (Exception ex) {
                Logger.getLogger(VideosPro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButtonActuActionPerformed

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == jButtonIngresar) {
            try {
                insertar();
                mostrarTabla();
                
            } catch (Exception ex) {
                Logger.getLogger(VideosPro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonIngresarActionPerformed

    private void jComboIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboIDItemStateChanged
        try {
            // TODO add your handling code here:
            selectValues();
        } catch (Exception ex) {
            Logger.getLogger(VideosPro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboIDItemStateChanged
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VideosPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VideosPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VideosPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VideosPro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VideosPro().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(VideosPro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton jButtonActu;
    private javax.swing.JButton jButtonElim;
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JComboBox<String> jComboAlias;
    private javax.swing.JComboBox<String> jComboCont;
    private javax.swing.JComboBox<String> jComboID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFecha;
    // End of variables declaration//GEN-END:variables
}