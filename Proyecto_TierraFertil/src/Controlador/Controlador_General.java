package Controlador;

import Controlador.Grupo1.Ctrl_asepcias;
import Controlador.Grupo1.Ctrl_detalles_gen;
import Controlador.Grupo1.Ctrl_gc_ld;
import Controlador.Grupo1.Ctrl_largo_dedo;
import Controlador.Grupo1.Ctrl_listar_campo;
import Controlador.Grupo1.Ctrl_menu;
import Controlador.Grupo1.Ctrl_sel_emp;
import Controlador.Grupo2.Controlador_Evaluacion_Datos;
import static Controlador.Grupo2.Controlador_Evaluacion_Datos.mensaje;
import Controlador.Grupo2.Controlador_Listado_Menu;
import Controlador.Grupo2.Controlador_Evaluacion_Defectos;
import Controlador.Grupo2.Controlador_Evaluacion_Tabulacion;
import Controlador.Grupo2.Controlador_Listado_Menu;
import Controlador.Grupo2.Controlador_Menu_General;
import Controlador.Grupo2.Controlador_Evaluacion_Reportes;
import Controlador.Grupo3.Controlador_Datos_Llegada;
import Controlador.Grupo3.Controlador_Despacho;
import Controlador.Grupo3.Controlador_Higiene_Contenedor;
import Controlador.Grupo3.Controlador_Inspeccion_Contenedor;
import Controlador.Grupo3.Controlador_Listado_Contenedores;
import Controlador.Grupo3.Controlador_Menu_Acopio;
import Controlador.Grupo3.Controlador_Obtener_Reportes;
import Controlador.Grupo3.Controlador_Paletizado;
import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Modelo_Login;
import Vista.Grupo1.Listar_campo;
import Vista.Grupo1.Menu_Campo;
import Vista.Grupo1.Vista_campo_respaldo;
import Vista.Grupo2.Vista_Evaluacion_Total;
import Vista.Grupo2.Vista_Listado_Menu;
import Vista.Grupo2.Vista_Home_Calidad;
import Vista.Grupo2.Vista_Menu_Calidad;
import Vista.Grupo3.Vista_Home;
import Vista.Grupo3.Vista_Listado_Contenedores;
import Vista.Grupo3.Vista_Llegada;
import Vista.Grupo3.Vista_Menu_Acopio;
import Vista.Grupo3.Vista_Obtener_Reportes;
import Vista.Vista_General;
import Vista.Vista_Login;
import Modelo.Grupo2.Modelo_Evaluacion_Tabulacion;
import Vista.Grupo2.Vista_Reportes_Menu;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    Menu_Campo vistaMenuCampo = new Menu_Campo();
    Ctrl_menu ctrlMenu = new Ctrl_menu(vistaMenuCampo);
    //  GRUPO 2
    Vista_Menu_Calidad vistaMenuCalidad = new Vista_Menu_Calidad();
    Controlador_Menu_General controladorMenuCalidad = new Controlador_Menu_General(vistaMenuCalidad);
    //  GRUPO 3
    Vista_Menu_Acopio vistaMenuAcopio = new Vista_Menu_Acopio();
    Controlador_Menu_Acopio controladorMenuAcopio = new Controlador_Menu_Acopio(vistaMenuAcopio);
    //  -> Importacion de Vistas Escritorios y sus controladores.
    //  GRUPO 1
    Vista_campo_respaldo vistaCampo = new Vista_campo_respaldo();
    Listar_campo vistaListaCampo = new Listar_campo();
    Ctrl_detalles_gen ctrlDetGene = new Ctrl_detalles_gen(vistaCampo);
    Ctrl_asepcias ctrlAcepcias = new Ctrl_asepcias(vistaCampo);
    Ctrl_gc_ld ctrlGradoCalib = new Ctrl_gc_ld(vistaCampo);
    Ctrl_largo_dedo ctrlLargoDe = new Ctrl_largo_dedo(vistaCampo);
    Ctrl_sel_emp ctrlSeleEmp = new Ctrl_sel_emp(vistaCampo);
    Ctrl_listar_campo ctrlListarCamp = new Ctrl_listar_campo(vistaListaCampo);
    //  GRUPO 2
    Vista_Evaluacion_Total vistaEvaluacion = new Vista_Evaluacion_Total();
    Vista_Listado_Menu vistaEvaluacionListado = new Vista_Listado_Menu();
    Vista_Home_Calidad vistaHomeCalidad = new Vista_Home_Calidad();
    Vista_Reportes_Menu vistaEvaluacionReportes = new Vista_Reportes_Menu();
    Vista_Listado_Menu vistaListadoMenu = new Vista_Listado_Menu();

    Controlador_Listado_Menu controlaListado = new Controlador_Listado_Menu(vistaEvaluacionListado);
    Controlador_Evaluacion_Datos controlEvaluacion = new Controlador_Evaluacion_Datos(vistaEvaluacion);
    Controlador_Evaluacion_Tabulacion controlaEvaTabu = new Controlador_Evaluacion_Tabulacion(vistaEvaluacion);
    Controlador_Evaluacion_Defectos controlEvaDefec = new Controlador_Evaluacion_Defectos(vistaEvaluacion);
    Controlador_Evaluacion_Reportes controlEvaReportes = new Controlador_Evaluacion_Reportes(vistaEvaluacionReportes);
    Controlador_Listado_Menu controladorListado = new Controlador_Listado_Menu(vistaListadoMenu);
//    Controlador_Listado_Menu controladorLisMenu = new Controlador_Listado_Menu(vistaEvaluacion);
    //  GRUPO 3
    Vista_Home vistaHome = new Vista_Home();
    Vista_Llegada vistaLlegada = new Vista_Llegada();
    Vista_Listado_Contenedores vistaListado = new Vista_Listado_Contenedores();
    Vista_Obtener_Reportes vistaObteReport = new Vista_Obtener_Reportes();
    Controlador_Datos_Llegada controlDatosLlegada = new Controlador_Datos_Llegada(vistaLlegada);
    Controlador_Despacho controlDespacho = new Controlador_Despacho(vistaLlegada);
    Controlador_Higiene_Contenedor controlHigiene = new Controlador_Higiene_Contenedor(vistaLlegada);
    Controlador_Inspeccion_Contenedor controlInspeccion = new Controlador_Inspeccion_Contenedor(vistaLlegada);
    Controlador_Paletizado controlPaletizado = new Controlador_Paletizado(vistaLlegada);
    Controlador_Listado_Contenedores controlListadoCont = new Controlador_Listado_Contenedores(vistaListado);
    Controlador_Obtener_Reportes controlObtReport = new Controlador_Obtener_Reportes(vistaObteReport);
    Modelo_Contenedores modeloContenedor = new Modelo_Contenedores();
    public static int tempClickG3 = 1;
    //  Fin de instanciaciones Vistas y Controladores de MENUS y VISTAS INTERNAS.
    // -------------------------------------------------------------------------------------------------
    // Con esta parate validamos el rol y usuario, para posteriormente asignarlo segun su rol al menu principal.
    Modelo_Login modeloLogin = new Modelo_Login();
    //  Forma de colocar los colores de los botones generales.
    Color colorNormal = new Color(247, 246, 246);
    Color colorSeleccionMinimizar = new Color(133, 193, 233);
    Color colorSeleccionExit = new Color(231, 76, 60);
    Color colorUsuarioSeleccion = new Color(223, 238, 255);
    Color colorNormalOscuro = new Color(204, 204, 204);
    //  Variables locales para usar en vista general de la clase.
    int xMouse, yMouse, contTemp = 0;

    public static String id_evaluacion;

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
        this.vistaMenuCampo.boton_campo_uno.addMouseListener(this);
        this.vistaMenuCampo.boton_campo_dos.addMouseListener(this);
        this.vistaMenuCampo.boton_listar_uno.addMouseListener(this);
        this.vistaCampo.btn_guardar_total.addActionListener(this);
        this.vistaListaCampo.btn_actualizar.addActionListener(this);
        // Grupo 2
        this.vistaMenuCalidad.btn_acopio_control.addMouseListener(this);
        this.vistaEvaluacion.btn_siguiente.addMouseListener(this);
        this.vistaMenuCalidad.btn_acopio_listado.addMouseListener(this);
        this.vistaMenuCalidad.btn_reportes.addMouseListener(this);

        this.vistaEvaluacionListado.rdn_actualizar.addMouseListener(this);
        this.vistaEvaluacionReportes.rdn_imprimir.addMouseListener(this);

        // Grupo 3
        this.vistaMenuAcopio.btn_acopio_opcion_uno.addMouseListener(this);
        this.vistaMenuAcopio.btn_acopio_opcion_dos.addMouseListener(this);
        this.vistaMenuAcopio.btn_reportes_opcion_uno.addMouseListener(this);
        this.vistaLlegada.boton_home.addMouseListener(this);
        this.vistaListado.boton_home.addMouseListener(this);
        this.vistaObteReport.boton_home.addMouseListener(this);
        this.vistaListado.tabla_listado_contenedores.addMouseListener(this); ////////////#############
        this.vistaLlegada.btn_guardar.addMouseListener(this);
//        this.vistaHome.boton_buscar.addMouseListener(this); // <-- Aqui se tiene que activar el actualizar #
        this.vistaLlegada.addComponentListener(this);
        this.vistaListado.addComponentListener(this);
        this.vistaObteReport.addComponentListener(this);
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
                this.vistaGeneral.jp_escritorio_general.add(vistaCampo);
                this.vistaGeneral.jp_escritorio_general.add(vistaHome);
                this.vistaGeneral.jp_escritorio_general.add(vistaListaCampo);
                this.vistaGeneral.lbl_nombre_usuario.setText(this.modeloLogin.user);
                this.vistaHome.setVisible(true);
                this.vistaHome.setBorder(null);
                this.vistaMenuAcopio.setVisible(false);
                this.vistaMenuCalidad.setVisible(false);
                this.vistaMenuCampo.setBorder(null);
                this.vistaMenuCampo.setVisible(true);
            }
            if (this.modeloLogin.rol.equals("Grupo 2")) {
                this.vistaGeneral.jp_menu_general.add(vistaMenuCalidad);
                this.vistaGeneral.lbl_nombre_usuario.setText(this.modeloLogin.user);
                this.vistaGeneral.jp_escritorio_general.add(vistaHomeCalidad);
                this.vistaHomeCalidad.setVisible(true);
                this.vistaHomeCalidad.setBorder(null);

                this.vistaMenuAcopio.setVisible(false);
                this.vistaMenuCampo.setVisible(false);
                this.vistaMenuCalidad.setBorder(null);
                this.vistaMenuCalidad.setVisible(true);
            }
            if (this.modeloLogin.rol.equals("Grupo 3")) {
                this.vistaGeneral.jp_escritorio_general.add(vistaLlegada);
                this.vistaGeneral.jp_escritorio_general.add(vistaListado);
                this.vistaGeneral.jp_escritorio_general.add(vistaObteReport);
                this.vistaGeneral.jp_menu_general.add(vistaMenuAcopio);
                this.vistaGeneral.jp_escritorio_general.add(vistaHome);
                this.vistaGeneral.lbl_nombre_usuario.setText(this.modeloLogin.user);
                this.vistaHome.setVisible(true);
                this.vistaHome.setBorder(null);
                this.vistaMenuCampo.setVisible(false);
                this.vistaMenuCalidad.setVisible(false);
                this.vistaMenuAcopio.setBorder(null);
                this.vistaMenuAcopio.setVisible(true);
            }
        } catch (Exception ex) {

        }
    }

    public void menuUsuarioSwitchOnOFF() {
        this.vistaGeneral.jp_opcionModoOscuro.setVisible(false);
        this.vistaGeneral.jp_opcionCerrarSesion.setVisible(false);
        this.vistaGeneral.jp_lienzo_principal.setVisible(false);
        this.vistaGeneral.jp_lienzo_principal.setVisible(true);
        System.out.println("OFF - ON");
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
            this.menuUsuarioSwitchOnOFF();
            contTemp = 0;
        }
        //  Aqui hacemos el cerrar sesion en la vista general.
        if (me.getSource() == this.vistaGeneral.jp_opcionCerrarSesion || me.getSource() == this.vistaGeneral.lbl_cerrarSesion) {
            this.vistaGeneral.dispose();
            this.vistaLogin.setVisible(true);
        }
        //  GRUPO 1 OPCIONES DE BOTONES
        if (me.getSource() == this.vistaMenuCampo.boton_campo_uno) {
            this.menuUsuarioSwitchOnOFF();
            this.vistaCampo.setBorder(null);
            this.vistaHome.dispose();
            this.vistaListaCampo.dispose();
            this.vistaCampo.setVisible(true);
        }
        if (me.getSource() == this.vistaMenuCampo.boton_campo_dos) {
            this.menuUsuarioSwitchOnOFF();
            this.vistaListaCampo.setBorder(null);
            this.vistaHome.dispose();
            this.vistaCampo.dispose();
            this.vistaListaCampo.setVisible(true);
        }

        //  GRUPO 2 OPCIONES DE BOTONES
        if (me.getSource() == this.vistaMenuCalidad.btn_acopio_control) {
            this.vistaEvaluacion.setBorder(null);

            this.vistaHomeCalidad.dispose();
            this.vistaEvaluacionListado.dispose();
            this.vistaEvaluacionReportes.dispose();

            this.vistaGeneral.jp_escritorio_general.add(vistaEvaluacion);
            this.vistaEvaluacion.setVisible(true);

        }
        if (me.getSource() == this.vistaMenuCalidad.btn_reportes) {
            this.vistaEvaluacionReportes.setBorder(null);

            this.vistaHomeCalidad.dispose();
            this.vistaEvaluacion.dispose();
            this.vistaEvaluacionListado.dispose();

            this.vistaGeneral.jp_escritorio_general.add(vistaEvaluacionReportes);
            this.vistaEvaluacionReportes.setVisible(true);

        }
        if (me.getSource() == this.vistaMenuCalidad.btn_acopio_listado) {
            this.vistaEvaluacionListado.setBorder(null);

            this.vistaEvaluacion.dispose();
            this.vistaHomeCalidad.dispose();
            this.vistaEvaluacionReportes.dispose();
            this.controlaListado.mostrarDatos();
            this.vistaGeneral.jp_escritorio_general.add(vistaEvaluacionListado);

            this.vistaEvaluacionListado.setVisible(true);

        }
        //Boton de listado para actualizar datos GRUPO2
        if (me.getSource() == this.vistaEvaluacionListado.rdn_actualizar) {
            //Carga todos los datos en los campos para la actualizacion
            this.controlEvaluacion.cargarDatos();
            
            //Actualiza la tabla
            this.controladorListado.mostrarDatos();
           // this.controlEvaDefec.cargarDefectos(this.controlEvaluacion.mensaje);
            //this.controlaEvaTabu.cargarTabulacion(this.controlEvaluacion.mensaje);
            this.controlaEvaTabu.mostrarTabulacion();
            
            
            this.vistaEvaluacion.setBorder(null);
            this.vistaEvaluacionListado.dispose();
            this.vistaEvaluacion.pesta??a_tabulacion.setEnabledAt(1, true);
            
            
            this.vistaGeneral.jp_escritorio_general.add(vistaEvaluacion);
            this.vistaEvaluacion.setVisible(true);
            JOptionPane.showMessageDialog(vistaListado, "No cambie el campo CODIGO", "ATENCION", JOptionPane.ERROR_MESSAGE);

        }

        //  GRUPO 3 OPCIONES DE BOTONES
        if (me.getSource() == this.vistaLlegada.btn_guardar) {
            tempClickG3 = 1;

            this.controlDatosLlegada.guardadoFinal();
            this.controlInspeccion.guardadoFinal();
            this.controlHigiene.guardadoFinal();
            this.controlDespacho.guardadoFinal();
            this.controlPaletizado.guardadoFinal();
        }

        if (me.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_uno || me.getSource() == this.vistaLlegada.btn_guardar) {
//            this.vistaGeneral.jp_escritorio_general.add(vistaLlegada); // #Toca eliminar esta linea quizas.
            this.vistaLlegada.setBorder(null);
            this.vistaHome.dispose();
            this.vistaListado.dispose();
            this.vistaObteReport.dispose();
            // Un solo validador de menu desplegable.
            this.menuUsuarioSwitchOnOFF();
            contTemp = 0;
            // Necesita la asignacion para leer evento a la primera.
            this.vistaLlegada.setVisible(true);
            //  #########  SOLUCIONADO LO DE ID FIJO DE CONTENDOR Y DEMAS TABLAS, FALTA DE ROJAS #########
            if (tempClickG3 != 0) {
                //  Consultas de id de Entidades.
                this.controlDatosLlegada.idEntidadContenedores();
                this.controlDatosLlegada.idEntidadDatosLlegada();
                this.controlDespacho.idEntidadDatosDespacho();

                // --> Retorna 11 que es su maximo.
                this.controlInspeccion.idEntidadInspCont();
                //  Esta entidad ya retorna el max id como 8 si es null al inicio de la BD.
                this.controlHigiene.idEntidadHigCont();
                //  --> Retornara 20 que es su maximo.
                this.controlPaletizado.idEntidadPalet();

                //  #Para ver datos de entrada.
                System.out.println("General 1 Entrada: idCon>" + this.controlDatosLlegada.idContenedor + " , idDaLle>"
                        + this.controlDatosLlegada.idDatosLlegada + " , idInsCont>" + this.controlInspeccion.idInspCont + " , idHigCont>" + this.controlHigiene.idHigCont
                        + "  idDes> " + this.controlDespacho.idDespacho + " idPal> " + this.controlPaletizado.idPalet);
                tempClickG3 = 0;
                //  Validacion en caso de datos erroneos en la BD. BORRADO DE EMERGENCIA.
                if ((this.controlInspeccion.idInspCont % 11 != 0) || (this.controlHigiene.idHigCont % 8 != 0) || (this.controlPaletizado.idPalet % 20 != 0)) {
                    this.modeloContenedor.id = this.controlDatosLlegada.idContenedor;
                    this.modeloContenedor.eliminadoEmergencia_Contenedor();
                    this.controlDatosLlegada.idEntidadContenedores();
                    this.controlDatosLlegada.idEntidadDatosLlegada();
                    this.controlInspeccion.idEntidadInspCont();
                    this.controlHigiene.idEntidadHigCont();
                    this.controlDespacho.idEntidadDatosDespacho();
                    this.controlPaletizado.idEntidadPalet();
                    tempClickG3 = 1;
                }

                //  Autoincremento de las entidades fijas que comparten id entre entidades. ej. 1, 1, 1...
                this.controlDatosLlegada.idContenedor++;
                this.controlDatosLlegada.idDatosLlegada++;
                this.controlDespacho.idDespacho++;

                this.controlDatosLlegada.autoIncrementarID_Entidades(this.controlDatosLlegada.idContenedor, this.controlDatosLlegada.idDatosLlegada);
                this.controlInspeccion.autoIncrementarID_Entidades(this.controlDatosLlegada.idContenedor, this.controlInspeccion.idInspCont);
                this.controlHigiene.autoIncrementarID_Entidades(this.controlDatosLlegada.idContenedor, this.controlHigiene.idHigCont);
                this.controlDespacho.autoIncrementarID_Entidades(this.controlDatosLlegada.idContenedor, this.controlDespacho.idDespacho);
                this.controlPaletizado.autoIncrementarID_Entidades(this.controlDatosLlegada.idContenedor, this.controlPaletizado.idPalet);

                //  #para ver datos de salida.
                System.out.println("General 2 Salida: idCon>" + this.controlDatosLlegada.idContenedor + " , idDaLle>"
                        + this.controlDatosLlegada.idDatosLlegada + " , idInsCont>" + this.controlInspeccion.idInspCont + " , idHigCont>" + this.controlHigiene.idHigCont
                        + "  idDes> " + this.controlDespacho.idDespacho + " idPal> " + this.controlPaletizado.idPalet);

                //  Con ese valor evitamos guardar varias veces y seria un nuevo registro.
            }

        }
        if (me.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_dos) {
            this.vistaListado.setBorder(null);
            this.vistaHome.dispose();
            this.vistaLlegada.dispose();
            this.vistaObteReport.dispose();
            this.menuUsuarioSwitchOnOFF();
            contTemp = 0;
            this.vistaListado.setVisible(true);
        }
        if (me.getSource() == this.vistaMenuAcopio.btn_reportes_opcion_uno) {
            this.vistaObteReport.setBorder(null);
            this.vistaHome.dispose();
            this.vistaLlegada.dispose();
            this.vistaListado.dispose();
            this.menuUsuarioSwitchOnOFF();
            contTemp = 0;
            this.vistaObteReport.setVisible(true);
        }
        //  Aqui es cuando volvemos al home, se oculta ele scritorio anterior y se muestra el home.
        if (me.getSource() == this.vistaLlegada.boton_home) {
            this.vistaLlegada.dispose();
            this.menuUsuarioSwitchOnOFF();
            contTemp = 0;
            this.vistaHome.setVisible(true);
            this.controladorMenuAcopio.opcionClick(0);
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(0);
        }
        if (me.getSource() == this.vistaListado.boton_home) {
            this.vistaListado.dispose();
            this.vistaHome.setVisible(true);
            this.menuUsuarioSwitchOnOFF();
            contTemp = 0;
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(0);
        }
        if (me.getSource() == this.vistaObteReport.boton_home) {
            this.vistaObteReport.dispose();
            this.vistaHome.setVisible(true);
            this.menuUsuarioSwitchOnOFF();
            contTemp = 0;
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(0);
        }
        //  Boton actualizar, lo que hace es buscar la informacion en la BD y mostrar en el formulario principal.
        if (me.getSource() == this.vistaListado.tabla_listado_contenedores && this.vistaListado.tabla_listado_contenedores.getSelectedColumn() == 9) {
            this.vistaListado.dispose();
            this.vistaLlegada.setBorder(null);
            this.vistaLlegada.setVisible(true);

            int busqueda = this.controlListadoCont.idContenedor;

            this.controlDatosLlegada.idBusqueda(busqueda);
            this.controlInspeccion.idBusqueda(busqueda);
            this.controlHigiene.idBusqueda(busqueda);
            this.controlDespacho.idBusqueda(busqueda);
            this.controlPaletizado.idBusqueda(busqueda);

            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(0);

            this.controlDatosLlegada.cargarDatosLlegada();
            this.controlInspeccion.cargarDatosInspCont();
            this.controlHigiene.cargarDatosHigCont();
            this.controlDespacho.cargarDatosDespacho();
            this.controlPaletizado.cargarDatosPalet();
            System.out.println("General Busqueda: idCon>" + this.controlDatosLlegada.idContenedor + " , idDaLle> " + this.controlDatosLlegada.idDatosLlegada
                    + " , idInsCo> " + this.controlInspeccion.idInspCont + " , idHigCont>" + this.controlHigiene.idHigCont
                    + " , idDes> " + this.controlDespacho.idDespacho + " idPal> " + this.controlPaletizado.idPalet);

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
        if (ae.getSource() == this.vistaCampo.btn_guardar_total) {
            this.ctrlDetGene.guradar_datos_evaluacion();
            this.ctrlGradoCalib.guardar_cantidad_gc();
            this.ctrlLargoDe.guardar_datos();
            this.ctrlAcepcias.guardar_asepcias();
            this.ctrlSeleEmp.guardar_datos();
        }
        if (ae.getSource() == this.vistaListaCampo.btn_actualizar) {
            int fila = this.vistaListaCampo.tabla_campo.getSelectedRow();
            this.id_evaluacion = (String) this.vistaListaCampo.tabla_campo.getValueAt(fila, 0);

            JOptionPane.showMessageDialog(this.vistaListaCampo, "El id de eva a actualizar es: " + this.id_evaluacion);

            int respuesta = JOptionPane.showConfirmDialog(this.vistaListaCampo, "??Desea Actualizar el registro?", "ATENCION", JOptionPane.YES_OPTION);
            if (respuesta == 0) {
                this.vistaListaCampo.dispose();
                this.vistaCampo.setBorder(null);
                this.vistaCampo.setVisible(true);

                this.ctrlSeleEmp.CargarDatosSE(id_evaluacion);
                this.ctrlLargoDe.CargarDatosGradoCalibre(id_evaluacion);
                this.ctrlGradoCalib.CargarDatosGradoCalibre(id_evaluacion);
                this.ctrlDetGene.CargarDatosDetallesGenerales(id_evaluacion);

                this.ctrlListarCamp.tabla_listado_campo();
            }
            DefaultTableModel tabla = (DefaultTableModel) this.vistaListaCampo.tabla_campo.getModel();
        }
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
        if (ce.getSource() == this.vistaLlegada) {
            this.vistaMenuAcopio.btn_acopio_opcion_uno.setBackground(colorNormalOscuro);
        }
        if (ce.getSource() == this.vistaListado) {
            this.vistaMenuAcopio.btn_acopio_opcion_dos.setBackground(colorNormalOscuro);
        }
        if (ce.getSource() == this.vistaObteReport) {
            this.vistaMenuAcopio.btn_reportes_opcion_uno.setBackground(colorNormalOscuro);
        }
    }
}
