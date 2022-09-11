/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Brayan Carmona
 */
public class Vista_General extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Vista_General() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_lienzo_principal = new javax.swing.JPanel();
        jp_banner = new javax.swing.JPanel();
        jp_contenedor_menu = new javax.swing.JPanel();
        jp_menu_general = new javax.swing.JPanel();
        jp_hora_fecha = new javax.swing.JPanel();
        jp_escritorio_general = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jp_lienzo_principal.setBackground(new java.awt.Color(153, 153, 153));
        jp_lienzo_principal.setMaximumSize(new java.awt.Dimension(1280, 720));
        jp_lienzo_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_banner.setMaximumSize(new java.awt.Dimension(1280, 105));
        jp_banner.setMinimumSize(new java.awt.Dimension(1280, 105));

        javax.swing.GroupLayout jp_bannerLayout = new javax.swing.GroupLayout(jp_banner);
        jp_banner.setLayout(jp_bannerLayout);
        jp_bannerLayout.setHorizontalGroup(
            jp_bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        jp_bannerLayout.setVerticalGroup(
            jp_bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 105, Short.MAX_VALUE)
        );

        jp_lienzo_principal.add(jp_banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jp_contenedor_menu.setBackground(new java.awt.Color(204, 204, 255));
        jp_contenedor_menu.setMaximumSize(new java.awt.Dimension(310, 620));
        jp_contenedor_menu.setMinimumSize(new java.awt.Dimension(310, 620));
        jp_contenedor_menu.setPreferredSize(new java.awt.Dimension(305, 620));

        jp_menu_general.setMaximumSize(new java.awt.Dimension(300, 515));
        jp_menu_general.setMinimumSize(new java.awt.Dimension(300, 515));
        jp_menu_general.setPreferredSize(new java.awt.Dimension(300, 515));

        javax.swing.GroupLayout jp_menu_generalLayout = new javax.swing.GroupLayout(jp_menu_general);
        jp_menu_general.setLayout(jp_menu_generalLayout);
        jp_menu_generalLayout.setHorizontalGroup(
            jp_menu_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jp_menu_generalLayout.setVerticalGroup(
            jp_menu_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jp_hora_fecha.setMaximumSize(new java.awt.Dimension(300, 90));
        jp_hora_fecha.setMinimumSize(new java.awt.Dimension(300, 90));
        jp_hora_fecha.setPreferredSize(new java.awt.Dimension(300, 90));

        javax.swing.GroupLayout jp_hora_fechaLayout = new javax.swing.GroupLayout(jp_hora_fecha);
        jp_hora_fecha.setLayout(jp_hora_fechaLayout);
        jp_hora_fechaLayout.setHorizontalGroup(
            jp_hora_fechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jp_hora_fechaLayout.setVerticalGroup(
            jp_hora_fechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_contenedor_menuLayout = new javax.swing.GroupLayout(jp_contenedor_menu);
        jp_contenedor_menu.setLayout(jp_contenedor_menuLayout);
        jp_contenedor_menuLayout.setHorizontalGroup(
            jp_contenedor_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_contenedor_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_menu_general, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_contenedor_menuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp_hora_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jp_contenedor_menuLayout.setVerticalGroup(
            jp_contenedor_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_contenedor_menuLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jp_hora_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_menu_general, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jp_lienzo_principal.add(jp_contenedor_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 310, 620));

        jp_escritorio_general.setMaximumSize(new java.awt.Dimension(970, 610));
        jp_escritorio_general.setMinimumSize(new java.awt.Dimension(970, 610));

        javax.swing.GroupLayout jp_escritorio_generalLayout = new javax.swing.GroupLayout(jp_escritorio_general);
        jp_escritorio_general.setLayout(jp_escritorio_generalLayout);
        jp_escritorio_generalLayout.setHorizontalGroup(
            jp_escritorio_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jp_escritorio_generalLayout.setVerticalGroup(
            jp_escritorio_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jp_lienzo_principal.add(jp_escritorio_general, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_lienzo_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp_lienzo_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Vista_General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_General.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_General().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel jp_banner;
    public javax.swing.JPanel jp_contenedor_menu;
    public javax.swing.JPanel jp_escritorio_general;
    public javax.swing.JPanel jp_hora_fecha;
    public javax.swing.JPanel jp_lienzo_principal;
    public javax.swing.JPanel jp_menu_general;
    // End of variables declaration//GEN-END:variables
}
