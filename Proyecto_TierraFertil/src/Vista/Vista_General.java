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
        this.setLocationRelativeTo(null);
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
        lbl_icono_logo = new javax.swing.JLabel();
        jp_icono_minimizar = new javax.swing.JPanel();
        lbl_icono_minimizar = new javax.swing.JLabel();
        jp_icono_cerrar = new javax.swing.JPanel();
        lbl_icono_cerrar = new javax.swing.JLabel();
        jp_campo_usuario = new javax.swing.JPanel();
        lbl_nombre_usuario = new javax.swing.JLabel();
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

        jp_banner.setBackground(new java.awt.Color(204, 255, 204));
        jp_banner.setMaximumSize(new java.awt.Dimension(1280, 80));
        jp_banner.setMinimumSize(new java.awt.Dimension(1280, 80));
        jp_banner.setPreferredSize(new java.awt.Dimension(1280, 80));
        jp_banner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_icono_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/LogoTierraFertil_250px_68px.png"))); // NOI18N
        jp_banner.add(lbl_icono_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 6, -1, -1));

        jp_icono_minimizar.setMaximumSize(new java.awt.Dimension(36, 36));
        jp_icono_minimizar.setMinimumSize(new java.awt.Dimension(36, 36));
        jp_icono_minimizar.setPreferredSize(new java.awt.Dimension(36, 36));
        jp_icono_minimizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_icono_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/minimizeSign_24px.png"))); // NOI18N
        jp_icono_minimizar.add(lbl_icono_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 15, -1, 15));

        jp_banner.add(jp_icono_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 0, -1, -1));

        jp_icono_cerrar.setMaximumSize(new java.awt.Dimension(36, 36));
        jp_icono_cerrar.setMinimumSize(new java.awt.Dimension(36, 36));
        jp_icono_cerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_icono_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/power_24px.png"))); // NOI18N
        jp_icono_cerrar.add(lbl_icono_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jp_banner.add(jp_icono_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, -1, -1));

        lbl_nombre_usuario.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_nombre_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ProfileUser_32px.png"))); // NOI18N
        lbl_nombre_usuario.setText("Nombre Usuario");
        lbl_nombre_usuario.setAlignmentX(0.5F);

        javax.swing.GroupLayout jp_campo_usuarioLayout = new javax.swing.GroupLayout(jp_campo_usuario);
        jp_campo_usuario.setLayout(jp_campo_usuarioLayout);
        jp_campo_usuarioLayout.setHorizontalGroup(
            jp_campo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_nombre_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        jp_campo_usuarioLayout.setVerticalGroup(
            jp_campo_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_nombre_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jp_banner.add(jp_campo_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 250, 40));

        jp_lienzo_principal.add(jp_banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        jp_contenedor_menu.setBackground(new java.awt.Color(204, 204, 255));
        jp_contenedor_menu.setMaximumSize(new java.awt.Dimension(310, 640));
        jp_contenedor_menu.setMinimumSize(new java.awt.Dimension(310, 640));
        jp_contenedor_menu.setPreferredSize(new java.awt.Dimension(310, 640));
        jp_contenedor_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_menu_general.setBackground(new java.awt.Color(51, 102, 255));
        jp_menu_general.setMaximumSize(new java.awt.Dimension(310, 540));
        jp_menu_general.setMinimumSize(new java.awt.Dimension(310, 540));
        jp_menu_general.setPreferredSize(new java.awt.Dimension(310, 540));

        javax.swing.GroupLayout jp_menu_generalLayout = new javax.swing.GroupLayout(jp_menu_general);
        jp_menu_general.setLayout(jp_menu_generalLayout);
        jp_menu_generalLayout.setHorizontalGroup(
            jp_menu_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jp_menu_generalLayout.setVerticalGroup(
            jp_menu_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jp_contenedor_menu.add(jp_menu_general, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 310, 540));

        jp_hora_fecha.setBackground(new java.awt.Color(204, 255, 255));
        jp_hora_fecha.setMaximumSize(new java.awt.Dimension(310, 100));
        jp_hora_fecha.setMinimumSize(new java.awt.Dimension(310, 100));
        jp_hora_fecha.setPreferredSize(new java.awt.Dimension(310, 100));

        javax.swing.GroupLayout jp_hora_fechaLayout = new javax.swing.GroupLayout(jp_hora_fecha);
        jp_hora_fecha.setLayout(jp_hora_fechaLayout);
        jp_hora_fechaLayout.setHorizontalGroup(
            jp_hora_fechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jp_hora_fechaLayout.setVerticalGroup(
            jp_hora_fechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jp_contenedor_menu.add(jp_hora_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 100));

        jp_lienzo_principal.add(jp_contenedor_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 310, 640));

        jp_escritorio_general.setBackground(new java.awt.Color(204, 204, 204));
        jp_escritorio_general.setMaximumSize(new java.awt.Dimension(970, 640));
        jp_escritorio_general.setMinimumSize(new java.awt.Dimension(970, 640));

        javax.swing.GroupLayout jp_escritorio_generalLayout = new javax.swing.GroupLayout(jp_escritorio_general);
        jp_escritorio_general.setLayout(jp_escritorio_generalLayout);
        jp_escritorio_generalLayout.setHorizontalGroup(
            jp_escritorio_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jp_escritorio_generalLayout.setVerticalGroup(
            jp_escritorio_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        jp_lienzo_principal.add(jp_escritorio_general, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, 640));

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
    public javax.swing.JPanel jp_campo_usuario;
    public javax.swing.JPanel jp_contenedor_menu;
    public javax.swing.JPanel jp_escritorio_general;
    public javax.swing.JPanel jp_hora_fecha;
    public javax.swing.JPanel jp_icono_cerrar;
    public javax.swing.JPanel jp_icono_minimizar;
    public javax.swing.JPanel jp_lienzo_principal;
    public javax.swing.JPanel jp_menu_general;
    public javax.swing.JLabel lbl_icono_cerrar;
    public javax.swing.JLabel lbl_icono_logo;
    public javax.swing.JLabel lbl_icono_minimizar;
    public javax.swing.JLabel lbl_nombre_usuario;
    // End of variables declaration//GEN-END:variables
}
