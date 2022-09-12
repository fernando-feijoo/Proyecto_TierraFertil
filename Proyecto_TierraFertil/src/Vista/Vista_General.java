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
        jp_contenedor_opciones = new javax.swing.JPanel();
        jp_opcionModoOscuro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jp_opcionInicial = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_nombre_usuario = new javax.swing.JLabel();
        jp_opcionCerrarSesion = new Recursos_Codigo.Redondeado();
        jLabel3 = new javax.swing.JLabel();
        jp_banner = new javax.swing.JPanel();
        lbl_icono_logo = new javax.swing.JLabel();
        btn_cerrar = new Recursos_Codigo.Redondeado();
        icono_cerrar = new javax.swing.JLabel();
        btn_minimizar = new Recursos_Codigo.Redondeado();
        icono_minimizar = new javax.swing.JLabel();
        jp_contenedor_menu = new javax.swing.JPanel();
        jp_hora_fecha = new Recursos_Codigo.Redondeado();
        lbl_icono_reloj = new javax.swing.JLabel();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        lbl_icono_calendario = new javax.swing.JLabel();
        rSLabelFecha1 = new rojeru_san.RSLabelFecha();
        jp_menu_general = new Recursos_Codigo.Redondeado();
        jp_redondeado_escritorio = new Recursos_Codigo.Redondeado();
        jp_escritorio_general = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        setResizable(false);

        jp_lienzo_principal.setBackground(new java.awt.Color(247, 246, 246));
        jp_lienzo_principal.setMaximumSize(new java.awt.Dimension(1280, 720));
        jp_lienzo_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_contenedor_opciones.setBackground(new java.awt.Color(255, 255, 255, 1));
        jp_contenedor_opciones.setMaximumSize(new java.awt.Dimension(250, 120));
        jp_contenedor_opciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_opcionModoOscuro.setBackground(new java.awt.Color(204, 204, 204));
        jp_opcionModoOscuro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jp_opcionModoOscuro.setMaximumSize(new java.awt.Dimension(220, 40));
        jp_opcionModoOscuro.setMinimumSize(new java.awt.Dimension(220, 40));
        jp_opcionModoOscuro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Modo Oscuro");
        jp_opcionModoOscuro.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, -1, -1));

        jp_contenedor_opciones.add(jp_opcionModoOscuro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 220, 40));

        jp_opcionInicial.setBackground(new java.awt.Color(247, 246, 246));
        jp_opcionInicial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jp_opcionInicial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/flechaMenu_24px.png"))); // NOI18N
        jp_opcionInicial.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        lbl_nombre_usuario.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbl_nombre_usuario.setForeground(new java.awt.Color(0, 0, 0));
        lbl_nombre_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ProfileUser_32px.png"))); // NOI18N
        lbl_nombre_usuario.setText("Nombre Usuario");
        lbl_nombre_usuario.setAlignmentX(0.5F);
        jp_opcionInicial.add(lbl_nombre_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 40));

        jp_contenedor_opciones.add(jp_opcionInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 40));

        jp_opcionCerrarSesion.setBackground(new java.awt.Color(153, 153, 153));
        jp_opcionCerrarSesion.setMaximumSize(new java.awt.Dimension(220, 40));
        jp_opcionCerrarSesion.setMinimumSize(new java.awt.Dimension(220, 40));
        jp_opcionCerrarSesion.setPreferredSize(new java.awt.Dimension(220, 40));
        jp_opcionCerrarSesion.setRoundBottomLeft(35);
        jp_opcionCerrarSesion.setRoundBottomRight(35);
        jp_opcionCerrarSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cerrar Sesion");
        jp_opcionCerrarSesion.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 10, -1, -1));

        jp_contenedor_opciones.add(jp_opcionCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 220, 40));

        jp_lienzo_principal.add(jp_contenedor_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 37, 250, 120));

        jp_banner.setBackground(new java.awt.Color(247, 246, 246));
        jp_banner.setMaximumSize(new java.awt.Dimension(1280, 80));
        jp_banner.setMinimumSize(new java.awt.Dimension(1280, 80));
        jp_banner.setPreferredSize(new java.awt.Dimension(1280, 80));
        jp_banner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_icono_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/LogoTierraFertil_250px_68px.png"))); // NOI18N
        jp_banner.add(lbl_icono_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 6, -1, -1));

        btn_cerrar.setBackground(new java.awt.Color(247, 246, 246));
        btn_cerrar.setMaximumSize(new java.awt.Dimension(36, 36));
        btn_cerrar.setMinimumSize(new java.awt.Dimension(36, 36));
        btn_cerrar.setRoundBottomLeft(25);
        btn_cerrar.setRoundBottomRight(25);
        btn_cerrar.setRoundTopLeft(25);
        btn_cerrar.setRoundTopRight(25);
        btn_cerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icono_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/power_24px.png"))); // NOI18N
        btn_cerrar.add(icono_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 3, 30, 30));

        jp_banner.add(btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 2, -1, 36));

        btn_minimizar.setBackground(new java.awt.Color(247, 246, 246));
        btn_minimizar.setMaximumSize(new java.awt.Dimension(36, 36));
        btn_minimizar.setMinimumSize(new java.awt.Dimension(36, 36));
        btn_minimizar.setPreferredSize(new java.awt.Dimension(36, 36));
        btn_minimizar.setRoundBottomLeft(25);
        btn_minimizar.setRoundBottomRight(25);
        btn_minimizar.setRoundTopLeft(25);
        btn_minimizar.setRoundTopRight(25);
        btn_minimizar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icono_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/minimizeSign_24px.png"))); // NOI18N
        btn_minimizar.add(icono_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 13, 30, -1));

        jp_banner.add(btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 2, -1, -1));

        jp_lienzo_principal.add(jp_banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 80));

        jp_contenedor_menu.setBackground(new java.awt.Color(247, 246, 246));
        jp_contenedor_menu.setMaximumSize(new java.awt.Dimension(310, 640));
        jp_contenedor_menu.setMinimumSize(new java.awt.Dimension(310, 640));
        jp_contenedor_menu.setPreferredSize(new java.awt.Dimension(310, 640));
        jp_contenedor_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_hora_fecha.setBackground(new java.awt.Color(204, 204, 204));
        jp_hora_fecha.setMaximumSize(new java.awt.Dimension(310, 100));
        jp_hora_fecha.setMinimumSize(new java.awt.Dimension(310, 100));
        jp_hora_fecha.setPreferredSize(new java.awt.Dimension(310, 100));
        jp_hora_fecha.setRoundTopLeft(45);
        jp_hora_fecha.setRoundTopRight(45);
        jp_hora_fecha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_icono_reloj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/clock_32px.png"))); // NOI18N
        jp_hora_fecha.add(lbl_icono_reloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        rSLabelHora1.setForeground(new java.awt.Color(0, 0, 0));
        rSLabelHora1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        jp_hora_fecha.add(rSLabelHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 140, 30));

        lbl_icono_calendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/calendar_32px.png"))); // NOI18N
        jp_hora_fecha.add(lbl_icono_calendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        rSLabelFecha1.setForeground(new java.awt.Color(0, 0, 0));
        rSLabelFecha1.setFont(new java.awt.Font("Roboto Bold", 1, 18)); // NOI18N
        jp_hora_fecha.add(rSLabelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 140, 30));

        jp_contenedor_menu.add(jp_hora_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 300, 95));

        jp_menu_general.setBackground(new java.awt.Color(204, 204, 204));
        jp_menu_general.setMaximumSize(new java.awt.Dimension(310, 540));
        jp_menu_general.setMinimumSize(new java.awt.Dimension(310, 540));
        jp_menu_general.setPreferredSize(new java.awt.Dimension(310, 540));
        jp_menu_general.setRoundBottomLeft(45);
        jp_menu_general.setRoundBottomRight(45);

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

        jp_contenedor_menu.add(jp_menu_general, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 100, 300, 535));

        jp_lienzo_principal.add(jp_contenedor_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 310, 640));

        jp_redondeado_escritorio.setBackground(new java.awt.Color(204, 204, 204));
        jp_redondeado_escritorio.setMaximumSize(new java.awt.Dimension(970, 640));
        jp_redondeado_escritorio.setMinimumSize(new java.awt.Dimension(970, 640));
        jp_redondeado_escritorio.setRoundBottomLeft(45);
        jp_redondeado_escritorio.setRoundBottomRight(30);
        jp_redondeado_escritorio.setRoundTopLeft(45);
        jp_redondeado_escritorio.setRoundTopRight(30);
        jp_redondeado_escritorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jp_escritorio_general.setBackground(new java.awt.Color(255, 204, 102));
        jp_escritorio_general.setMaximumSize(new java.awt.Dimension(965, 605));
        jp_escritorio_general.setMinimumSize(new java.awt.Dimension(970, 605));
        jp_escritorio_general.setPreferredSize(new java.awt.Dimension(965, 605));

        javax.swing.GroupLayout jp_escritorio_generalLayout = new javax.swing.GroupLayout(jp_escritorio_general);
        jp_escritorio_general.setLayout(jp_escritorio_generalLayout);
        jp_escritorio_generalLayout.setHorizontalGroup(
            jp_escritorio_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jp_escritorio_generalLayout.setVerticalGroup(
            jp_escritorio_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        jp_redondeado_escritorio.add(jp_escritorio_general, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 13, 965, 605));

        jp_lienzo_principal.add(jp_redondeado_escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 85, 970, 630));

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
    public Recursos_Codigo.Redondeado btn_cerrar;
    public Recursos_Codigo.Redondeado btn_minimizar;
    public javax.swing.JLabel icono_cerrar;
    public javax.swing.JLabel icono_minimizar;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jp_banner;
    public javax.swing.JPanel jp_contenedor_menu;
    public javax.swing.JPanel jp_contenedor_opciones;
    public javax.swing.JPanel jp_escritorio_general;
    public Recursos_Codigo.Redondeado jp_hora_fecha;
    public javax.swing.JPanel jp_lienzo_principal;
    public Recursos_Codigo.Redondeado jp_menu_general;
    public Recursos_Codigo.Redondeado jp_opcionCerrarSesion;
    public javax.swing.JPanel jp_opcionInicial;
    public javax.swing.JPanel jp_opcionModoOscuro;
    public Recursos_Codigo.Redondeado jp_redondeado_escritorio;
    public javax.swing.JLabel lbl_icono_calendario;
    public javax.swing.JLabel lbl_icono_logo;
    public javax.swing.JLabel lbl_icono_reloj;
    public javax.swing.JLabel lbl_nombre_usuario;
    public rojeru_san.RSLabelFecha rSLabelFecha1;
    public rojeru_san.RSLabelHora rSLabelHora1;
    // End of variables declaration//GEN-END:variables
}
