package Controlador;

import Controlador.Grupo3.Controlador_Menu_Acopio;
import Vista.Grupo3.Vista_Menu_Acopio;
import Vista.Vista_General;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controlador_General implements MouseListener, ActionListener, MouseMotionListener {
    
    Vista_General vistaGeneral;
    // Aqui vamos a instanciar todas las vistas de cada grupo para trabajar los menus y sus escritorios.
    Vista_Menu_Acopio vistaMenuAcopio = new Vista_Menu_Acopio();
    Controlador_Menu_Acopio controladorMenuAcopio = new Controlador_Menu_Acopio(vistaMenuAcopio);
    // Fin de instanciaciones Vistas.
        //Aqui va el codigo instanciacion Menus.
    // Fin de instanciaciones Menus.
    // -------------------------------------------------------------------------------------------------
    //Forma de colocar los colores de los botones generales.
    Color colorNormal = new Color(247,246,246);
    Color colorSeleccionMinimizar = new Color(133, 193, 233 );
    Color colorSeleccionExit = new Color(231, 76, 60 );
    // Variables locales para usar en vista general de la clase.
    int xMouse, yMouse, contTemp = 0;
    // Fin de variables locales de case.
    public Controlador_General(Vista_General vistaGeneral) {
        this.vistaGeneral = vistaGeneral;
        // MouseListeners de los dintintos elementos.
        this.vistaGeneral.btn_minimizar.addMouseListener(this);
        this.vistaGeneral.btn_cerrar.addMouseListener(this);
        this.vistaGeneral.icono_minimizar.addMouseListener(this);
        this.vistaGeneral.icono_cerrar.addMouseListener(this);
        this.vistaGeneral.jp_banner.addMouseListener(this);
        this.vistaGeneral.btn_minimizar.addMouseListener(this);
        this.vistaGeneral.jp_opcionInicial.addMouseListener(this);
        //ActionListesner de los distintos elementos.
        
        //Area de pruebas para los metodos a ejecutar en el constructor.
        this.menuRoles();
        //MouseMotionListener de los distintos elementos.
        this.vistaGeneral.jp_banner.addMouseMotionListener(this);
        
        //Ocultar, es temporal debe ir en un metodo.
        this.vistaGeneral.jp_opcionModoOscuro.setVisible(false);
        this.vistaGeneral.jp_opcionCerrarSesion.setVisible(false);
    }
    /**
     * Instanciacion de los menus segun su rol.
     */
    public void menuRoles(){
        this.vistaGeneral.jp_menu_general.add(vistaMenuAcopio);
        this.vistaMenuAcopio.setBorder(null);
        this.vistaMenuAcopio.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        // Hacemos la interaccion de los botones minimizar y cerrar.
        // Este es el boton minimizar.
        if (me.getSource() == this.vistaGeneral.btn_minimizar || me.getSource() == this.vistaGeneral.icono_minimizar) {
            this.vistaGeneral.setExtendedState(ICONIFIED);
        }
        // Este es el boton cerrar.
        if (me.getSource() == this.vistaGeneral.btn_cerrar || me.getSource() == this.vistaGeneral.icono_cerrar) {
            System.exit(0);
        }
        // Realiza la interaccion de menu desplegable en el area de usuario, donde muestra modo oscuro y cerrar sesion.
        if (me.getSource() == this.vistaGeneral.jp_opcionInicial || me.getSource() == this.vistaGeneral.lbl_nombre_usuario) {
            if (contTemp == 0) {
                this.vistaGeneral.jp_opcionModoOscuro.setVisible(true);
                this.vistaGeneral.jp_opcionCerrarSesion.setVisible(true);
            }
            contTemp++;    
        }
        
        if (me.getSource() == this.vistaGeneral.jp_opcionInicial && contTemp == 2) {
            this.vistaGeneral.jp_opcionModoOscuro.setVisible(false);
            this.vistaGeneral.jp_opcionCerrarSesion.setVisible(false);
            this.vistaGeneral.jp_lienzo_principal.setVisible(false);
            this.vistaGeneral.jp_lienzo_principal.setVisible(true);
            contTemp = 0;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == this.vistaGeneral.jp_banner) {
            xMouse = me.getX();
            yMouse = me.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == this.vistaGeneral.btn_minimizar || me.getSource() == this.vistaGeneral.icono_minimizar) {
            this.vistaGeneral.btn_minimizar.setBackground(colorSeleccionMinimizar);
        }
        if (me.getSource() == this.vistaGeneral.btn_cerrar || me.getSource() == this.vistaGeneral.icono_cerrar) {
            this.vistaGeneral.btn_cerrar.setBackground(colorSeleccionExit);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == this.vistaGeneral.btn_minimizar || me.getSource() == this.vistaGeneral.icono_minimizar) {
            this.vistaGeneral.btn_minimizar.setBackground(colorNormal);
        }
        if (me.getSource() == this.vistaGeneral.btn_cerrar || me.getSource() == this.vistaGeneral.icono_cerrar) {
            this.vistaGeneral.btn_cerrar.setBackground(colorNormal);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        int x = me.getXOnScreen();
        int y = me.getYOnScreen();
        this.vistaGeneral.setLocation(x - xMouse, y - yMouse);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
}