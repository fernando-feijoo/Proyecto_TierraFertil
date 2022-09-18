package Controlador;

import Modelo.Modelo_Login;
import Vista.Vista_General;
import Vista.Vista_Login;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Controlador_Login implements MouseListener, KeyListener {

    Vista_Login vistaLogin;

    Modelo_Login modeloLogin = new Modelo_Login();

    Color colorNormal = new Color(255, 255, 255, 80);
    Color colorSeleccionMinimizar = new Color(133, 193, 233);
    Color colorSeleccionExit = new Color(231, 76, 60);
    Color colorNormalInicioSesion = new Color(75, 174, 0);
    Color colorSeleccionInicioSesion = new Color(75, 174, 0, 140);
    /*  
        Variables locales para hacer inicio de sesion y compartir valores dentro del scope "alcance"
        general de la clase, contTemp valida que solo se haga click 1 vez en el boton para que salga 1 sola
        ventana. temp es el validado de que si coincide usuario y contraseña. rol es el valor que se comparte 
        con el modelo para asiganar los roles en la vista general.
        ResulSet es donde se almacenan los valores del SELECT del metodo consulta.
     */
    int contTemp = 0, temp = 0;
    String rol = "";
    ResultSet rs;

    public Controlador_Login(Vista_Login vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.vistaLogin.btn_minimizar.addMouseListener(this);
        this.vistaLogin.btn_cerrar.addMouseListener(this);
        this.vistaLogin.icono_minimizar.addMouseListener(this);
        this.vistaLogin.icono_cerrar.addMouseListener(this);
        this.vistaLogin.btn_iniciar_sesion.addMouseListener(this);
        this.vistaLogin.lbl_iniciar_sesion.addMouseListener(this);
        this.vistaLogin.txt_usuario.addKeyListener(this);
        this.vistaLogin.txt_contra.addKeyListener(this);

    }

    public void inicioSesion(int temp) {
        modeloLogin.user = this.vistaLogin.txt_usuario.getText();
        modeloLogin.pass = this.vistaLogin.txt_contra.getText();
        rs = modeloLogin.consultarUsuario();
        try {
            while (rs.next()) {
                rol = rs.getString("rol");
                temp = 1;
            }
            /*  
                    Aqui validamos el valor de 1 solo click, si hace 1 click suma +1 entonces 
                    solo ingresa 1 vez si esta bien el usuario.
             */
            if (contTemp == 0) {
                if (temp == 1) {
                    System.out.println("Ingreso Login");
                    this.modeloLogin.rol = rol;
                    Vista_General vistaGeneral = new Vista_General();
                    Controlador_General controladorGeneral = new Controlador_General(vistaGeneral);
                    vistaGeneral.show();
                    this.vistaLogin.setVisible(false);
                    contTemp++;
                } else {
                    JOptionPane.showMessageDialog(vistaLogin, "Contraseña o usuario incorrecto.", "Error de Login", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception ex) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        /*  
            Hacemos la interaccion de los botones minimizar y cerrar.
            este es el boton minimizar.
         */
        if (me.getSource() == this.vistaLogin.btn_minimizar || me.getSource() == this.vistaLogin.icono_minimizar) {
            this.vistaLogin.setExtendedState(ICONIFIED);
        }
        //  Este es el boton cerrar.
        if (me.getSource() == this.vistaLogin.btn_cerrar || me.getSource() == this.vistaLogin.icono_cerrar) {
            System.exit(0);
        }
        //  Este es el boton iniciar sesion.
        if (me.getSource() == this.vistaLogin.btn_iniciar_sesion || me.getSource() == this.vistaLogin.lbl_iniciar_sesion) {
        /*  
            Ejecutamos o llamamos al metodo iniciar sesion, enviamos el valor almacenado en temp si ingresa de forma correcta
            se validara el usuario y contraseña por lo que ingresara al menu del rol asignado a ese usuario.
        */
            inicioSesion(temp);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //  Esta es la accion que se realiza de cambio de colores, en la parte de los botones minimizar y cerrar.
        //  ->Este es el del boton minimizar.
        if (me.getSource() == this.vistaLogin.btn_minimizar || me.getSource() == this.vistaLogin.icono_minimizar) {
            this.vistaLogin.btn_minimizar.setBackground(colorSeleccionMinimizar);
        }
        //  ->Este es del boton cerrar.
        if (me.getSource() == this.vistaLogin.btn_cerrar || me.getSource() == this.vistaLogin.icono_cerrar) {
            this.vistaLogin.btn_cerrar.setBackground(colorSeleccionExit);
        }
        //  ->Este es del iniciar sesion.
        if (me.getSource() == this.vistaLogin.btn_iniciar_sesion || me.getSource() == this.vistaLogin.lbl_iniciar_sesion) {
            this.vistaLogin.btn_iniciar_sesion.setBackground(colorNormalInicioSesion);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        /*  
            Aqui es donde realizamos la interactividad ya que en "mouseEntered" realiza el cambio de color cuando ingresa
            entonces en esta parte lo que hacemos es cambiarlo a su color base, ya que sale el mouse del boton. 
         */
        //  -> Este es el boton minimizar.
        if (me.getSource() == this.vistaLogin.btn_minimizar || me.getSource() == this.vistaLogin.icono_minimizar) {
            this.vistaLogin.btn_minimizar.setBackground(colorNormal);
        }
        //  -> Este es el boton cerrar.
        if (me.getSource() == this.vistaLogin.btn_cerrar || me.getSource() == this.vistaLogin.icono_cerrar) {
            this.vistaLogin.btn_cerrar.setBackground(colorNormal);
        }
        //  ->Este es del iniciar sesion.
        if (me.getSource() == this.vistaLogin.btn_iniciar_sesion || me.getSource() == this.vistaLogin.lbl_iniciar_sesion) {
            this.vistaLogin.btn_iniciar_sesion.setBackground(colorSeleccionInicioSesion);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //  Hace la escucha de la tecla enter, si hace enter ingresa al metodo iniciar sesion.
        char teclas = e.getKeyChar();
        if (teclas == KeyEvent.VK_ENTER) {
            inicioSesion(temp);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
