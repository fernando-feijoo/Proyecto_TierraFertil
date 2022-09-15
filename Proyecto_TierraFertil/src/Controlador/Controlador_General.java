package Controlador;

import Controlador.Grupo3.Controlador_Menu_Acopio;
import Modelo.Modelo_Login;
import Vista.Grupo1.Vista_Menu_Solucion_Campo;
import Vista.Grupo2.Vista_Menu_DanielModifica;
import Vista.Grupo3.Vista_Menu_Acopio;
import Vista.Vista_General;
import Vista.Vista_Login;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controlador_General implements MouseListener, ActionListener, MouseMotionListener {

    Vista_General vistaGeneral;
    /*  
        Se instancia el login para poder volver al login cuando se inicia sesion
        ademas del controlador del login para poder "escuchar" sus acciones en la vista login.
    */
    Vista_Login vistaLogin = new Vista_Login();
    Controlador_Login controladorLogin = new Controlador_Login(vistaLogin);
    //  Aqui vamos a instanciar todas las vistas de cada grupo para trabajar los menus y sus escritorios.
    Vista_Menu_Acopio vistaMenuAcopio = new Vista_Menu_Acopio();
    Controlador_Menu_Acopio controladorMenuAcopio = new Controlador_Menu_Acopio(vistaMenuAcopio);
    Vista_Menu_Solucion_Campo vistaMenuCampo = new Vista_Menu_Solucion_Campo();
    
    Vista_Menu_DanielModifica vistaMenuDaniel = new Vista_Menu_DanielModifica();
    // Prueba de dataLogin
    Modelo_Login modeloLogin = new Modelo_Login();

    //  Fin de instanciaciones Vistas.
    //  Aqui vamos a instanciar las vitas de todos los grupos.
    //  ->Aqui va el codigo instanciacion Menus.
    //  Fin de instanciaciones Menus.
    // -------------------------------------------------------------------------------------------------
    //  Forma de colocar los colores de los botones generales.
    Color colorNormal = new Color(247, 246, 246);
    Color colorSeleccionMinimizar = new Color(133, 193, 233);
    Color colorSeleccionExit = new Color(231, 76, 60);
    //  Variables locales para usar en vista general de la clase.
    int xMouse, yMouse, contTemp = 0;

    //  Fin de variables locales de case.
    public Controlador_General(Vista_General vistaGeneral) {
        this.vistaGeneral = vistaGeneral;
        //  MouseListeners de los dintintos elementos.
        this.vistaGeneral.btn_minimizar.addMouseListener(this);
        this.vistaGeneral.btn_cerrar.addMouseListener(this);
        this.vistaGeneral.icono_minimizar.addMouseListener(this);
        this.vistaGeneral.icono_cerrar.addMouseListener(this);
        this.vistaGeneral.jp_banner.addMouseListener(this);
        this.vistaGeneral.jp_opcionInicial.addMouseListener(this);
        this.vistaGeneral.jp_opcionCerrarSesion.addMouseListener(this);
        this.vistaGeneral.lbl_cerrarSesion.addMouseListener(this);
        //  ActionListesner de los distintos elementos.

        //  Area de pruebas para los metodos a ejecutar en el constructor.
        this.menuRoles();
        //  MouseMotionListener de los distintos elementos.
        this.vistaGeneral.jp_banner.addMouseMotionListener(this);

        //  Ocultar, es temporal debe ir en un metodo.
        this.vistaGeneral.jp_opcionModoOscuro.setVisible(false);
        this.vistaGeneral.jp_opcionCerrarSesion.setVisible(false);
    }

    /**
     * Instanciacion de los menus segun su rol.
     */
    public void menuRoles() {
        try {
            if (this.modeloLogin.rol.equals("Grupo 1")) {
                this.vistaGeneral.jp_menu_general.add(vistaMenuCampo);
                this.vistaGeneral.lbl_nombre_usuario.setText(this.modeloLogin.user);
                this.vistaMenuCampo.setBorder(null);
                this.vistaMenuCampo.setVisible(true);
            }
            if (this.modeloLogin.rol.equals("Grupo 2")) {
                this.vistaGeneral.jp_menu_general.add(vistaMenuDaniel);
                this.vistaGeneral.lbl_nombre_usuario.setText(this.modeloLogin.user);
                this.vistaMenuDaniel.setBorder(null);
                this.vistaMenuDaniel.setVisible(true);
            }
            if (this.modeloLogin.rol.equals("Grupo 3")) {
                this.vistaGeneral.jp_menu_general.add(vistaMenuAcopio);
                this.vistaGeneral.lbl_nombre_usuario.setText(this.modeloLogin.user);
                this.vistaMenuAcopio.setBorder(null);
                this.vistaMenuAcopio.setVisible(true);
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
        if (me.getSource() == this.vistaGeneral.btn_minimizar || me.getSource() == this.vistaGeneral.icono_minimizar) {
            this.vistaGeneral.setExtendedState(ICONIFIED);
        }
        //  Este es el boton cerrar.
        if (me.getSource() == this.vistaGeneral.btn_cerrar || me.getSource() == this.vistaGeneral.icono_cerrar) {
            System.exit(0);
        }
        //  Realiza la interaccion de menu desplegable en el area de usuario, donde muestra modo oscuro y cerrar sesion.
        if (me.getSource() == this.vistaGeneral.jp_opcionInicial || me.getSource() == this.vistaGeneral.lbl_nombre_usuario) {
            if (contTemp == 0) {
                this.vistaGeneral.jp_opcionModoOscuro.setVisible(true);
                this.vistaGeneral.jp_opcionCerrarSesion.setVisible(true);
            }
            contTemp++;
        }
        //  Esta parte hay que trabajr bien aun, porque veo un error aun. Es cuando se oculta las opciones en el boton usuario.
        if (me.getSource() == this.vistaGeneral.jp_opcionInicial && contTemp == 2) {
            this.vistaGeneral.jp_opcionModoOscuro.setVisible(false);
            this.vistaGeneral.jp_opcionCerrarSesion.setVisible(false);
            this.vistaGeneral.jp_lienzo_principal.setVisible(false);
            this.vistaGeneral.jp_lienzo_principal.setVisible(true);
            contTemp = 0;
        }
        //  Aqui hacemos el cerrar sesion en la vista general.
        if (me.getSource() == this.vistaGeneral.jp_opcionCerrarSesion || me.getSource() == this.vistaGeneral.lbl_cerrarSesion) {
            this.vistaGeneral.setVisible(false);
            this.vistaLogin.setVisible(true);
        }
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        /*  
            Esto es para obtener la ruta del mouse en pantalla para luego enviarlas a la parte donde se hace el "mouseDragged"
            eso es basicamente que se mueve el cursor presionado, asi se identifica esa accion y como se presiona se envia la ruta 
            desde cualqueir parte de la pantalla. Osea la ruta se envia de los datos X y Y, para ejecutarse en la parte del "mouseDragged".
         */
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
        //  Esta es la accion que se realiza de cambio de colores, en la parte de los botones minimizar y cerrar.
        //  ->Este es el del boton minimizar.
        if (me.getSource() == this.vistaGeneral.btn_minimizar || me.getSource() == this.vistaGeneral.icono_minimizar) {
            this.vistaGeneral.btn_minimizar.setBackground(colorSeleccionMinimizar);
        }
        //  ->Este es del boton cerrar.
        if (me.getSource() == this.vistaGeneral.btn_cerrar || me.getSource() == this.vistaGeneral.icono_cerrar) {
            this.vistaGeneral.btn_cerrar.setBackground(colorSeleccionExit);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        /*  
            Aqui es donde realizamos la interactividad ya que en "mouseEntered" realiza el cambio de color cuando ingresa
            entonces en esta parte lo que hacemos es cambiarlo a su color base, ya que sale el mouse del boton. 
         */
        //  -> Este es el boton minimizar.
        if (me.getSource() == this.vistaGeneral.btn_minimizar || me.getSource() == this.vistaGeneral.icono_minimizar) {
            this.vistaGeneral.btn_minimizar.setBackground(colorNormal);
        }
        //  -> Este es el boton cerrar.
        if (me.getSource() == this.vistaGeneral.btn_cerrar || me.getSource() == this.vistaGeneral.icono_cerrar) {
            this.vistaGeneral.btn_cerrar.setBackground(colorNormal);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        /*  
            Hacemos la parte de obtener los datos de X y Y cuando se hace click y se procede a usar en este lugar
            para poder hacer el movimiento de la ventana, solo en la parte del baner funciona ya que ahi esta implementado
            el mouseListener.
         */
        int x = me.getXOnScreen();
        int y = me.getYOnScreen();
        this.vistaGeneral.setLocation(x - xMouse, y - yMouse);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
}