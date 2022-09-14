package Controlador;

import Vista.Vista_General;
import Vista.Vista_Login;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controlador_Login implements MouseListener {
    Vista_Login vistaLogin;
    
    Vista_General vistaGeneral = new Vista_General();
    Controlador_General controladorGeneral = new Controlador_General(vistaGeneral);
    
    Color colorNormal = new Color(255, 255, 255,80);
    Color colorSeleccionMinimizar = new Color(133, 193, 233);
    Color colorSeleccionExit = new Color(231, 76, 60);
    Color colorNormalInicioSesion = new Color(75,174,0);
    Color colorSeleccionInicioSesion = new Color(75, 174, 0, 140);
    
    public Controlador_Login(Vista_Login vistaLogin) {
        this.vistaLogin = vistaLogin;
        this.vistaLogin.btn_minimizar.addMouseListener(this);
        this.vistaLogin.btn_cerrar.addMouseListener(this);
        this.vistaLogin.icono_minimizar.addMouseListener(this);
        this.vistaLogin.icono_cerrar.addMouseListener(this);
        this.vistaLogin.btn_iniciar_sesion.addMouseListener(this);
        this.vistaLogin.lbl_iniciar_sesion.addMouseListener(this);
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
            
            //Colocar codigo de inicio de sesion con validor de rol, para las vistas de cada grupo.
            
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
}