/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista.Grupo1;

import Vista.Grupo3.*;

/**
 *
 * @author Fabricio F. Feijoo
 */
public class Menu_Campo extends javax.swing.JInternalFrame {

    /**
     * Creates new form Prueba_InstanciarMenu
     */
    public Menu_Campo() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_contenedor_menu_acopio = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        redondeado1 = new Recursos_Codigo.Redondeado();
        jLabel2 = new javax.swing.JLabel();
        redondeado2 = new Recursos_Codigo.Redondeado();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        redondeado3 = new Recursos_Codigo.Redondeado();
        jLabel7 = new javax.swing.JLabel();
        redondeado4 = new Recursos_Codigo.Redondeado();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(300, 516));
        setMinimumSize(new java.awt.Dimension(300, 516));
        setPreferredSize(new java.awt.Dimension(300, 516));

        jp_contenedor_menu_acopio.setMaximumSize(new java.awt.Dimension(290, 480));
        jp_contenedor_menu_acopio.setMinimumSize(new java.awt.Dimension(290, 480));
        jp_contenedor_menu_acopio.setName(""); // NOI18N
        jp_contenedor_menu_acopio.setPreferredSize(new java.awt.Dimension(290, 480));
        jp_contenedor_menu_acopio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(270, 48));
        jPanel1.setMinimumSize(new java.awt.Dimension(270, 48));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ico_acopio_32px.png"))); // NOI18N
        jLabel1.setText("Acopio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jp_contenedor_menu_acopio.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 270, -1));

        jPanel2.setBackground(new java.awt.Color(112, 39, 1));
        jPanel2.setMaximumSize(new java.awt.Dimension(267, 3));
        jPanel2.setMinimumSize(new java.awt.Dimension(267, 3));
        jPanel2.setPreferredSize(new java.awt.Dimension(267, 3));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jp_contenedor_menu_acopio.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, -1, -1));

        redondeado1.setBackground(new java.awt.Color(204, 204, 204));
        redondeado1.setMaximumSize(new java.awt.Dimension(218, 38));
        redondeado1.setMinimumSize(new java.awt.Dimension(218, 38));
        redondeado1.setPreferredSize(new java.awt.Dimension(218, 38));
        redondeado1.setRoundBottomLeft(30);
        redondeado1.setRoundBottomRight(30);
        redondeado1.setRoundTopLeft(30);
        redondeado1.setRoundTopRight(30);
        redondeado1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Registro contenedores");
        redondeado1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, -1, -1));

        jp_contenedor_menu_acopio.add(redondeado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        redondeado2.setBackground(new java.awt.Color(204, 204, 204));
        redondeado2.setMaximumSize(new java.awt.Dimension(218, 38));
        redondeado2.setMinimumSize(new java.awt.Dimension(218, 38));
        redondeado2.setPreferredSize(new java.awt.Dimension(218, 38));
        redondeado2.setRoundBottomLeft(30);
        redondeado2.setRoundBottomRight(30);
        redondeado2.setRoundTopLeft(30);
        redondeado2.setRoundTopRight(30);
        redondeado2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Listado contenedores");
        redondeado2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, -1, -1));

        jp_contenedor_menu_acopio.add(redondeado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jPanel3.setMaximumSize(new java.awt.Dimension(270, 48));
        jPanel3.setMinimumSize(new java.awt.Dimension(270, 48));
        jPanel3.setPreferredSize(new java.awt.Dimension(270, 48));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/playlist_32px.png"))); // NOI18N
        jLabel4.setText("Reportes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp_contenedor_menu_acopio.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 198, -1, 40));

        redondeado3.setBackground(new java.awt.Color(204, 204, 204));
        redondeado3.setMaximumSize(new java.awt.Dimension(218, 38));
        redondeado3.setMinimumSize(new java.awt.Dimension(218, 38));
        redondeado3.setPreferredSize(new java.awt.Dimension(218, 38));
        redondeado3.setRoundBottomLeft(30);
        redondeado3.setRoundBottomRight(30);
        redondeado3.setRoundTopLeft(30);
        redondeado3.setRoundTopRight(30);
        redondeado3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nuevo reporte");
        redondeado3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, -1, -1));

        jp_contenedor_menu_acopio.add(redondeado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        redondeado4.setBackground(new java.awt.Color(204, 204, 204));
        redondeado4.setMaximumSize(new java.awt.Dimension(218, 38));
        redondeado4.setMinimumSize(new java.awt.Dimension(218, 38));
        redondeado4.setPreferredSize(new java.awt.Dimension(218, 38));
        redondeado4.setRoundBottomLeft(30);
        redondeado4.setRoundBottomRight(30);
        redondeado4.setRoundTopLeft(30);
        redondeado4.setRoundTopRight(30);
        redondeado4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Reportes generados");
        redondeado4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, -1, -1));

        jp_contenedor_menu_acopio.add(redondeado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nuevo reporte");
        jp_contenedor_menu_acopio.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_contenedor_menu_acopio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_contenedor_menu_acopio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jp_contenedor_menu_acopio;
    private Recursos_Codigo.Redondeado redondeado1;
    private Recursos_Codigo.Redondeado redondeado2;
    private Recursos_Codigo.Redondeado redondeado3;
    private Recursos_Codigo.Redondeado redondeado4;
    // End of variables declaration//GEN-END:variables
}
