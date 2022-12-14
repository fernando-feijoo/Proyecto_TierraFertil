/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author chuchei
 */
public class Vista_Login extends javax.swing.JFrame {

    /**
     * Creates new form Vista_Login
     */
    public Vista_Login() {
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

        btn_minimizar = new Recursos_Codigo.Redondeado();
        icono_minimizar = new javax.swing.JLabel();
        btn_cerrar = new Recursos_Codigo.Redondeado();
        icono_cerrar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        redondeado1 = new Recursos_Codigo.Redondeado();
        redondeado2 = new Recursos_Codigo.Redondeado();
        jLabel3 = new javax.swing.JLabel();
        txt_contra = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        redondeado3 = new Recursos_Codigo.Redondeado();
        jLabel4 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_iniciar_sesion = new Recursos_Codigo.Redondeado();
        lbl_iniciar_sesion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_minimizar.setBackground(new java.awt.Color(255, 255, 255, 80));
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

        getContentPane().add(btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 2, -1, -1));

        btn_cerrar.setBackground(new java.awt.Color(255, 255, 255, 80));
        btn_cerrar.setMaximumSize(new java.awt.Dimension(36, 36));
        btn_cerrar.setMinimumSize(new java.awt.Dimension(36, 36));
        btn_cerrar.setRoundBottomLeft(25);
        btn_cerrar.setRoundBottomRight(25);
        btn_cerrar.setRoundTopLeft(25);
        btn_cerrar.setRoundTopRight(25);
        btn_cerrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icono_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/power_24px.png"))); // NOI18N
        btn_cerrar.add(icono_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 3, 30, 30));

        getContentPane().add(btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 2, -1, 36));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        redondeado1.setBackground(new java.awt.Color(255, 255, 255,80));
        redondeado1.setMaximumSize(new java.awt.Dimension(681, 646));
        redondeado1.setMinimumSize(new java.awt.Dimension(681, 646));
        redondeado1.setPreferredSize(new java.awt.Dimension(681, 646));
        redondeado1.setRoundBottomLeft(50);
        redondeado1.setRoundBottomRight(50);
        redondeado1.setRoundTopLeft(50);
        redondeado1.setRoundTopRight(50);
        redondeado1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        redondeado2.setBackground(new java.awt.Color(255, 255, 255));
        redondeado2.setPreferredSize(new java.awt.Dimension(490, 66));
        redondeado2.setRoundBottomLeft(50);
        redondeado2.setRoundBottomRight(50);
        redondeado2.setRoundTopLeft(50);
        redondeado2.setRoundTopRight(50);
        redondeado2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/eye.png"))); // NOI18N
        redondeado2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 20, -1, -1));

        txt_contra.setBackground(new java.awt.Color(255, 255, 255));
        txt_contra.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_contra.setForeground(new java.awt.Color(0, 0, 0));
        txt_contra.setBorder(null);
        redondeado2.add(txt_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 390, 30));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Contrase??a");
        redondeado2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 30));

        redondeado1.add(redondeado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        redondeado3.setBackground(new java.awt.Color(255, 255, 255));
        redondeado3.setPreferredSize(new java.awt.Dimension(490, 66));
        redondeado3.setRoundBottomLeft(50);
        redondeado3.setRoundBottomRight(50);
        redondeado3.setRoundTopLeft(50);
        redondeado3.setRoundTopRight(50);
        redondeado3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(204, 204, 204,80));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/user.png"))); // NOI18N
        redondeado3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        txt_usuario.setBackground(new java.awt.Color(255, 255, 255));
        txt_usuario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(0, 0, 0));
        txt_usuario.setBorder(null);
        redondeado3.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 13, 380, 40));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Usuario");
        redondeado3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 25, -1, -1));

        redondeado1.add(redondeado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        btn_iniciar_sesion.setBackground(new java.awt.Color(75, 174, 0, 140));
        btn_iniciar_sesion.setPreferredSize(new java.awt.Dimension(362, 60));
        btn_iniciar_sesion.setRoundBottomLeft(50);
        btn_iniciar_sesion.setRoundBottomRight(50);
        btn_iniciar_sesion.setRoundTopLeft(50);
        btn_iniciar_sesion.setRoundTopRight(50);
        btn_iniciar_sesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_iniciar_sesion.setBackground(new java.awt.Color(0, 0, 0));
        lbl_iniciar_sesion.setFont(new java.awt.Font("Roboto", 1, 30)); // NOI18N
        lbl_iniciar_sesion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_iniciar_sesion.setText("Iniciar Sesi??n");
        btn_iniciar_sesion.add(lbl_iniciar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        redondeado1.add(btn_iniciar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(112, 39, 1));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("BANANO ORG??NICO");
        redondeado1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Logo4kfullHd.png"))); // NOI18N
        redondeado1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 17)); // NOI18N
        jLabel9.setText("??Olvid?? su contrase??a?");
        redondeado1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, -1, -1));
        redondeado1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 190, 10));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/aso.png"))); // NOI18N
        redondeado1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        jPanel3.add(redondeado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/fondo.jpg"))); // NOI18N
        jPanel3.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

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
            java.util.logging.Logger.getLogger(Vista_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Fondo;
    public Recursos_Codigo.Redondeado btn_cerrar;
    public Recursos_Codigo.Redondeado btn_iniciar_sesion;
    public Recursos_Codigo.Redondeado btn_minimizar;
    public javax.swing.JLabel icono_cerrar;
    public javax.swing.JLabel icono_minimizar;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lbl_iniciar_sesion;
    public Recursos_Codigo.Redondeado redondeado1;
    public Recursos_Codigo.Redondeado redondeado2;
    public Recursos_Codigo.Redondeado redondeado3;
    public javax.swing.JPasswordField txt_contra;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
