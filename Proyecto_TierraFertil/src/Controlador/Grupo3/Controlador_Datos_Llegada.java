package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Datos_Llegada;
import Vista.Grupo3.Vista_Llegada;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador_Datos_Llegada implements MouseListener, ComponentListener {

    Vista_Llegada vistaLlegada;
    Modelo_Datos_Llegada modeloDatosLlegada = new Modelo_Datos_Llegada();
    Modelo_Contenedores modeloContenedor = new Modelo_Contenedores();

    SimpleDateFormat formatoD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatoH = new SimpleDateFormat("HH:mm:ss");

    ResultSet rs, rsC;
    public static int idContenedor;
    public static int idDatosLlegada;
    String fechaInsp, fechaSalida, horaSalida, horaLlegada, tipoCaja, cupo, contenedor, placa,
            chasis, choferContenedor, ci, nombreFinca, candadosLlegada, sellosInternos, sellosExternos;
    int semana;

    public Controlador_Datos_Llegada(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.vistaLlegada.btn_siguiente_llegada.addMouseListener(this);
        //  Con este podemos hacer el guardado cuando se oculta esta ventana.
        this.vistaLlegada.jp_opcion_DatosLlegada.addComponentListener(this);

    }

    public void idEntidadContenedores() {
        try {
            rs = modeloContenedor.consultaID_contenedor();
            while (rs.next()) {
                idContenedor = Integer.parseInt(rs.getString("id_contenedor"));
            }
            System.out.println("id Entidad Contenedor ControladorDatosLLegada: " + idContenedor);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }
    }

    public void idEntidadDatosLlegada() {
        try {
            rs = modeloDatosLlegada.consultaID_entidadDatosLlegada();
            while (rs.next()) {
                idDatosLlegada = Integer.parseInt(rs.getString("id_tablaDatosLlegada"));
            }
            System.out.println("id Entidad Llegada ControladorDatosLLegada: " + idDatosLlegada);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }
    }

    //  Sirve para incrementar el valor idContenedor y de todos, se llama en el ControladorGeneral y aumenta ahi cuando se guarde.
    //  ESTO SE DEBERIA AUTO INCREMENTAR POR CONDICION SI ES PRIMER INGRESO SE SUMA, SI SE GUARDA SE SUMA.
    //  Mientras no se guarde no se suma.
    public void autoIncrementarID_Entidades(int herenciaUno, int herenciaDos) {
        this.idContenedor = herenciaUno;
        this.idDatosLlegada = herenciaDos;
        System.out.println("ValorHerencia: " + idContenedor + " , " + idDatosLlegada);
    }

    public void almacenarDatosLlegada() {
        //  Hacemos este tryCatch por si no colocan fecha en algun campo, eso genera exepciones.
        try {
            fechaInsp = (String) formatoD.format(this.vistaLlegada.datosLlegada_fechaInsp.getDate());
            semana = this.vistaLlegada.datosLlegada_semana.getValue();
            fechaSalida = (String) formatoD.format(this.vistaLlegada.datosLlegada_fechaSalida.getDate());
            horaSalida = (String) formatoH.format(this.vistaLlegada.datosLlegada_horaSalida.getValue());
            horaLlegada = (String) formatoH.format(this.vistaLlegada.datosLlegada_horaLlegada.getValue());
            tipoCaja = this.vistaLlegada.datosLlegada_tipocaja.getText();
            cupo = this.vistaLlegada.datosLlegada_cupo.getText();
            contenedor = this.vistaLlegada.datosLlegada_contenedor.getText();
            placa = this.vistaLlegada.datosLlegada_placa.getText();
            chasis = this.vistaLlegada.datosLlegada_chasis.getText();
            choferContenedor = this.vistaLlegada.datosLlegada_chofer.getText();
            ci = this.vistaLlegada.datosLlegada_ci.getText();
            nombreFinca = this.vistaLlegada.datosLlegada_nombrefinca.getText();
            candadosLlegada = this.vistaLlegada.datosLlegada_candadosllegada.getText();

            sellosInternos = (this.vistaLlegada.datosLlegada_sellosInternos_1.getText() + ";"
                    + this.vistaLlegada.datosLlegada_sellosInternos_2.getText() + ";"
                    + this.vistaLlegada.datosLlegada_sellosInternos_3.getText());

            sellosExternos = (this.vistaLlegada.datosLlegada_sellosExtrenos_1.getText() + ";"
                    + this.vistaLlegada.datosLlegada_sellosExtrenos_2.getText() + ";"
                    + this.vistaLlegada.datosLlegada_sellosExtrenos_3.getText() + ";"
                    + this.vistaLlegada.datosLlegada_sellosExtrenos_4.getText() + ";"
                    + this.vistaLlegada.datosLlegada_sellosExtrenos_5.getText() + ";"
                    + this.vistaLlegada.datosLlegada_sellosExtrenos_6.getText() + ";"
                    + this.vistaLlegada.datosLlegada_sellosExtrenos_7.getText() + ";"
                    + this.vistaLlegada.datosLlegada_sellosExtrenos_8.getText() + ";"
                    + this.vistaLlegada.datosLlegada_sellosExtrenos_9.getText());

        } catch (Exception e) {
            System.out.println("Error faltan campos fecha u hora: " + e);
        }
    }

    public void enviarDatosLLegada() {
        this.modeloDatosLlegada.id = idDatosLlegada;
        this.modeloDatosLlegada.id_contenedor = idContenedor;

        this.modeloDatosLlegada.fecha_insp = fechaInsp;
        this.modeloDatosLlegada.semana = semana;
        this.modeloDatosLlegada.fecha_salida = fechaSalida;
        this.modeloDatosLlegada.hora_salida = horaSalida;
        this.modeloDatosLlegada.hora_llegada = horaLlegada;
        this.modeloDatosLlegada.tipo_caja = tipoCaja;
        this.modeloDatosLlegada.cupo = cupo;
        this.modeloDatosLlegada.contenedor = contenedor;
        this.modeloDatosLlegada.placa = placa;
        this.modeloDatosLlegada.chasis = chasis;
        this.modeloDatosLlegada.chofer = choferContenedor;
        this.modeloDatosLlegada.ci = ci;
        this.modeloDatosLlegada.nombre_finca = nombreFinca;
        this.modeloDatosLlegada.candados = candadosLlegada;
        this.modeloDatosLlegada.sellos_internos = sellosInternos;
        this.modeloDatosLlegada.sellos_externos = sellosExternos;

    }

    public void guardarContenedor() {
        this.modeloContenedor.id = idContenedor;
        this.modeloContenedor.codigo_Contenedor = contenedor;
    }

    public void cargarDatosLlegada() {
        String sellosInternos, sellosExternos;
        rsC = modeloDatosLlegada.consultaDatos_entidadDatosLlegada();
        try {
            while (rsC.next()) {
            this.vistaLlegada.datosLlegada_fechaInsp.setDate(funcionFecha_Formato(rsC.getString("fecha_insp")));
            this.vistaLlegada.datosLlegada_semana.setValue(Integer.parseInt(rsC.getString("semana")));
            this.vistaLlegada.datosLlegada_fechaSalida.setDate(funcionFecha_Formato(rsC.getString("fecha_hora_salida").substring(0 , 10)));
            this.vistaLlegada.datosLlegada_horaSalida.setValue(funcionHora_Formato(rsC.getString("fecha_hora_salida").substring(11 , 19)));
            this.vistaLlegada.datosLlegada_horaLlegada.setValue(funcionHora_Formato(rsC.getString("hora_llegada")));
            this.vistaLlegada.datosLlegada_tipocaja.setText(rsC.getString("tipo_caja"));
            this.vistaLlegada.datosLlegada_cupo.setText(rsC.getString("cupo"));
//            this.vistaLlegada.datosLlegada_contenedor.setText(rsC.getString("CORERGIR SELECT JOIN"));
            this.vistaLlegada.datosLlegada_placa.setText(rsC.getString("placa"));
            this.vistaLlegada.datosLlegada_chasis.setText(rsC.getString("chasis"));
            this.vistaLlegada.datosLlegada_chofer.setText(rsC.getString("chofer_contenedor"));
            this.vistaLlegada.datosLlegada_ci.setText(rsC.getString("cedula_chofer"));
            this.vistaLlegada.datosLlegada_nombrefinca.setText(rsC.getString("nombre_finca"));
            this.vistaLlegada.datosLlegada_candadosllegada.setText(rsC.getString("candados"));
            sellosInternos = rsC.getString("sellos_internos");
            sellosExternos = rsC.getString("sellos_externos");
            }
            
        } catch (Exception e) {
            System.out.println("Error al cargar componentes Modelo_Datos_LLegada: " + e);
        }
    }

    /**
     * Funcion que retorna la fecha formato yyyy-MM-dd esta la usariamos para
     * obtener la conversion a formato DATE se ingresa un dato String. Para asi
     * poder cargar al componente de la libreria jcalendar.
     *
     * @param @String para el ingreso de valor a convertir.
     * @return Date or null.
     */
    public Date funcionFecha_Formato(String x) {
        Date datoSQLFecha;
        try {
            datoSQLFecha = formatoD.parse(x);
            return datoSQLFecha;
        } catch (ParseException ex) {
            System.out.println("Error al convertir fecha: " + ex);
        }
        return null;
    }

    /**
     * Funcion que retorna la hora HH:mm:ss en formato 24H esta la usariamos
     * para obtener la conversion a formato DATE se ingresa un dato String. Para
     * asi poder cargar al componente de la libreria jcalendar.
     *
     * @param @String para el ingreso de valor a convertir.
     * @return Date or null.
     */
    public Date funcionHora_Formato(String y) {
        Date datosHora;
        try {
            datosHora = formatoH.parse(y);
            return datosHora;
        } catch (ParseException ex) {
            System.out.println("Error al convertir hora: " + ex);
        }
        return null;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        // usamos para hacer el cambio de formulario en boton siguiente
        if (me.getSource() == this.vistaLlegada.btn_siguiente_llegada) {
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(1);
            this.almacenarDatosLlegada();
            this.enviarDatosLLegada();
            this.guardarContenedor();
            this.modeloContenedor.guardarContenedorDatos();
            this.modeloDatosLlegada.guardarActualizar_DatosLlegada();

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
    }

    @Override
    public void mouseExited(MouseEvent me) {
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
        if (ce.getSource() == this.vistaLlegada.jp_opcion_DatosLlegada) {
            //  Para ejecutar guardar al cambiar de pestaña por click en siguiente o pestaña.
            System.out.println("Ingreso Opcion. HIDE");
            this.almacenarDatosLlegada();
            this.enviarDatosLLegada();
            this.guardarContenedor();
            this.modeloDatosLlegada.pruebaGuardado();
            this.modeloContenedor.pruebaGuardado();
            this.cargarDatosLlegada();
            System.out.println("ValorSiguiente: " + idContenedor + " , " + idDatosLlegada);
        }

    }
}
