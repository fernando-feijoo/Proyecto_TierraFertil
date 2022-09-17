package Controlador;

import Controlador.Grupo2.Controlador_Evaluacion;
import Controlador.Grupo2.Controlador_Menu;
import Controlador.Grupo3.Controlador_Datos_Llegada;
import Controlador.Grupo3.Controlador_Despacho;
import Controlador.Grupo3.Controlador_Higiene_Contenedor;
import Controlador.Grupo3.Controlador_Inspeccion_Contenedor;
import Controlador.Grupo3.Controlador_Menu_Acopio;
import Controlador.Grupo3.Controlador_Paletizado;
import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Datos_Llegada;
import Modelo.Grupo3.Modelo_Despacho;
import Modelo.Grupo3.Modelo_Higiene_Contenedor;
import Modelo.Grupo3.Modelo_Inspeccion_Contenedor;
import Modelo.Grupo3.Modelo_Paletizado;
import Modelo.Modelo_Login;
import Vista.Grupo1.Vista_Menu_Solucion_Campo;
import Vista.Grupo2.Vis_evaluacion;
import Vista.Grupo2.Vista_Menu_Calidad;
import Vista.Grupo3.Vista_Home;
import Vista.Grupo3.Vista_Llegada;
import Vista.Grupo3.Vista_Menu_Acopio;
import Vista.Vista_General;
import Vista.Vista_Login;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controlador_General implements MouseListener, ActionListener, MouseMotionListener, ComponentListener {

    Vista_General vistaGeneral;
    /*  
        Se instancia el login para poder volver al login cuando se inicia sesion
        ademas del controlador del login para poder "escuchar" sus acciones en la vista login.
    */
    Vista_Login vistaLogin = new Vista_Login();
    Controlador_Login controladorLogin = new Controlador_Login(vistaLogin);
    //  Aqui vamos a instanciar todas las vistas de cada grupo para trabajar los menus y sus escritorios.
    //  -> Importacion de Vistas Menus y sus controladores.
    //  GRUPO 1
    Vista_Menu_Solucion_Campo vistaMenuCampo = new Vista_Menu_Solucion_Campo();
    //  GRUPO 2
    Vista_Menu_Calidad vistaMenuCalidad = new Vista_Menu_Calidad();
    Controlador_Menu controladorMenuCalidad = new Controlador_Menu(vistaMenuCalidad);
    //  GRUPO 3
    Vista_Menu_Acopio vistaMenuAcopio = new Vista_Menu_Acopio();
    Controlador_Menu_Acopio controladorMenuAcopio = new Controlador_Menu_Acopio(vistaMenuAcopio);
    //  -> Importacion de Vistas Escritorios y sus controladores.
    //  GRUPO 1
    
    //  GRUPO 2
    Vis_evaluacion vistaEvaluacion = new Vis_evaluacion();
    Controlador_Evaluacion controlEvaluacion = new Controlador_Evaluacion(vistaEvaluacion);
    //  GRUPO 3
    Vista_Llegada vistaLlegada = new Vista_Llegada();
    Vista_Home vistaHome = new Vista_Home();
    Controlador_Datos_Llegada controlDatosLlegada = new Controlador_Datos_Llegada(vistaLlegada);
    Controlador_Despacho controlDespacho = new Controlador_Despacho(vistaLlegada);
    Controlador_Higiene_Contenedor controlHigiene = new Controlador_Higiene_Contenedor(vistaLlegada);
    Controlador_Inspeccion_Contenedor controlInspeccion = new Controlador_Inspeccion_Contenedor(vistaLlegada);
    Controlador_Paletizado controlPaletizado = new Controlador_Paletizado(vistaLlegada);
    Modelo_Contenedores modeloContenedor = new Modelo_Contenedores();
    Modelo_Datos_Llegada modeloDatosLlegada = new Modelo_Datos_Llegada();
    Modelo_Despacho modeloDespacho = new Modelo_Despacho();
    Modelo_Higiene_Contenedor modeloHigiCont = new Modelo_Higiene_Contenedor();
    Modelo_Inspeccion_Contenedor modeloInspCont = new Modelo_Inspeccion_Contenedor();
    Modelo_Paletizado modeloPaletizado = new Modelo_Paletizado();
    public static int temp = 1;
    //  Fin de instanciaciones Vistas y Controladores de MENUS y VISTAS INTERNAS.
    // -------------------------------------------------------------------------------------------------
    // Con esta parate validamos el rol y usuario, para posteriormente asignarlo segun su rol al menu principal.
    Modelo_Login modeloLogin = new Modelo_Login();
    //  Forma de colocar los colores de los botones generales.
    Color colorNormal = new Color(247, 246, 246);
    Color colorSeleccionMinimizar = new Color(133, 193, 233);
    Color colorSeleccionExit = new Color(231, 76, 60);
    Color colorUsuarioSeleccion = new Color(223,238,255);
    Color colorNormalOscuro = new Color(204,204,204);
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
        this.vistaGeneral.jp_opcionModoOscuro.addMouseListener(this);
        this.vistaGeneral.jp_opcionCerrarSesion.addMouseListener(this);
        // Grupo 1
        
        // Grupo 2
        this.vistaMenuCalidad.btn_acopio_control.addMouseListener(this);
        this.vistaEvaluacion.btn_siguiente.addMouseListener(this);
        // Grupo 3
        this.vistaMenuAcopio.btn_acopio_opcion_uno.addMouseListener(this);
        this.vistaMenuAcopio.btn_acopio_opcion_dos.addMouseListener(this);
        this.vistaMenuAcopio.btn_reportes_opcion_uno.addMouseListener(this);
        this.vistaMenuAcopio.btn_reportes_opcion_dos.addMouseListener(this);
        this.vistaLlegada.boton_home.addMouseListener(this);
        this.vistaLlegada.btn_guardar.addMouseListener(this);
        this.vistaLlegada.addComponentListener(this);
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
                this.vistaMenuAcopio.setVisible(false);
                this.vistaMenuCalidad.setVisible(false);
                this.vistaMenuCampo.setBorder(null);
                this.vistaMenuCampo.setVisible(true);
            }
            if (this.modeloLogin.rol.equals("Grupo 2")) {
                this.vistaGeneral.jp_menu_general.add(vistaMenuCalidad);
                this.vistaGeneral.lbl_nombre_usuario.setText(this.modeloLogin.user);
                this.vistaMenuAcopio.setVisible(false);
                this.vistaMenuCampo.setVisible(false);
                this.vistaMenuCalidad.setBorder(null);
                this.vistaMenuCalidad.setVisible(true);
            }
            if (this.modeloLogin.rol.equals("Grupo 3")) {
                
                this.vistaGeneral.jp_menu_general.add(vistaMenuAcopio);
                this.vistaGeneral.jp_escritorio_general.add(vistaHome);
                this.vistaGeneral.lbl_nombre_usuario.setText(this.modeloLogin.user);
                this.vistaHome.setVisible(true);
                this.vistaMenuCampo.setVisible(false);
                this.vistaMenuCalidad.setVisible(false);
                this.vistaHome.setBorder(null);
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
        //  GRUPO 1 OPCIONES DE BOTONES
        
        //  GRUPO 2 OPCIONES DE BOTONES
        if (me.getSource() == this.vistaMenuCalidad.btn_acopio_control) {
            this.vistaGeneral.jp_escritorio_general.add(vistaEvaluacion);
            this.vistaEvaluacion.setBorder(null);
            this.vistaEvaluacion.setVisible(true);
        }
        //  GRUPO 3 OPCIONES DE BOTONES
        if (me.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_uno) {
            this.vistaGeneral.jp_escritorio_general.add(vistaLlegada);
            this.vistaLlegada.setBorder(null);
            this.vistaHome.setVisible(false);
            this.vistaLlegada.setVisible(true);
            //  #########  Necesitamos validar cuando se haga guardar ejecuta consulta nuevo idContenedor y todo lo que sea fijo. #########
            if (temp != 0) {
                this.controlDatosLlegada.idEntidadContenedores();
                this.controlDatosLlegada.idEntidadDatosLlegada();
                
                System.out.println("General 1: " + this.controlDatosLlegada.idContenedor + " , " + this.controlDatosLlegada.idDatosLlegada);
                this.controlDatosLlegada.idContenedor++;
                this.controlDatosLlegada.idDatosLlegada++;
                
                this.controlDatosLlegada.autoIncrementarID_Entidades(this.controlDatosLlegada.idContenedor, this.controlDatosLlegada.idDatosLlegada);
                
                System.out.println("General 2+: " + this.controlDatosLlegada.idContenedor + " , " + this.controlDatosLlegada.idDatosLlegada);
                temp = 0;
            }   
            
            //  #########  Necesitamos validar cuando se haga guardar ejecuta consulta nuevo idContenedor y todo lo que sea fijo. #########
        }
        if (me.getSource() == this.vistaLlegada.btn_guardar) {
            temp = 1;
        }
            //  G3 Oculta el escritorio y muestra el principal, falta implementar la vista principal.
            //  Tambien restrablece el valor 0 al opcionClick para que valide los colores.
        if (me.getSource() == this.vistaLlegada.boton_home) {
            this.vistaLlegada.dispose();
            this.controladorMenuAcopio.opcionClick(0);
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(0);
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
        //  -> Es el boton usuario.
        if (me.getSource() == this.vistaGeneral.jp_opcionInicial) {
            this.vistaGeneral.jp_opcionInicial.setBackground(colorUsuarioSeleccion);
        }
        //  -> Es el boton modoSocuro.
        if (me.getSource() == this.vistaGeneral.jp_opcionModoOscuro) {
            this.vistaGeneral.jp_opcionModoOscuro.setBackground(colorUsuarioSeleccion);
        }
        //  -> Es el boton cerarSesion.
        if (me.getSource() == this.vistaGeneral.jp_opcionCerrarSesion) {
            this.vistaGeneral.jp_opcionCerrarSesion.setBackground(colorUsuarioSeleccion);
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
        //  -> Es el boton usuario.
        if (me.getSource() == this.vistaGeneral.jp_opcionInicial) {
            this.vistaGeneral.jp_opcionInicial.setBackground(colorNormal);
        }
        //  -> Es el boton modoSocuro.
        if (me.getSource() == this.vistaGeneral.jp_opcionModoOscuro) {
            this.vistaGeneral.jp_opcionModoOscuro.setBackground(colorNormalOscuro);
        }
        //  -> Es el boton cerarSesion.
        if (me.getSource() == this.vistaGeneral.jp_opcionCerrarSesion) {
            this.vistaGeneral.jp_opcionCerrarSesion.setBackground(colorNormalOscuro);
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

    @Override
    public void componentResized(ComponentEvent ce) {
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
    }

    @Override
    public void componentShown(ComponentEvent ce) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        //  Coloca el color base del boton del menu del se se sale "vista".
        //  GRUPO 3
        if (ce.getSource() == this.vistaLlegada)
        {
            this.vistaMenuAcopio.btn_acopio_opcion_uno.setBackground(colorNormalOscuro);
        }
        
    }
}