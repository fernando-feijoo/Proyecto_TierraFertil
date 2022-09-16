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
import java.text.SimpleDateFormat;

public class Controlador_Datos_Llegada implements MouseListener, ComponentListener{
    Vista_Llegada vistaLlegada;
    Modelo_Datos_Llegada modeloDatosLlegada = new Modelo_Datos_Llegada();
    Modelo_Contenedores modeloContenedor = new Modelo_Contenedores();
    
    
    ResultSet rs;
    public static int idContenedor;
    public static int idDatosLlegada;
    
    public Controlador_Datos_Llegada(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.vistaLlegada.btn_siguiente_llegada.addMouseListener(this);
        //  Con este podemos hacer el guardado cuando se oculta esta ventana.
        this.vistaLlegada.jp_opcion_DatosLlegada.addComponentListener(this);
        this.idEntidadContenedores();
        this.idEntidadDatosLlegada();
        System.out.println("Activado Controlador Llegada");
    }
    
    public void idEntidadContenedores (){
        try {
            rs = modeloContenedor.consultaID_contenedor();
            while (rs.next()) {
                idContenedor = Integer.parseInt(rs.getString("id_contenedor"));
            }
            System.out.println("Dato Contenedor Controlador: " + idContenedor);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }
    }
    
    public void idEntidadDatosLlegada (){
        try {
            rs = modeloContenedor.consultaID_contenedor();
            while (rs.next()) {
                idDatosLlegada = Integer.parseInt(rs.getString("id_contenedor"));
            }
            System.out.println("DatosLlegada Controlador: " + idDatosLlegada);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }
    }
    //  Sirve para incrementar el valor idContenedor y de todos, se llama en el ControladorGeneral y aumenta ahi cuando se guarde.
    //  ESTO SE DEBERIA AUTO INCREMENTAR POR CONDICION SI ES PRIMER INGRESO SE SUMA, SI SE GUARDA SE SUMA.
    //  Mientras no se guarde no se suma.
    public void autoIncrementarID_Entidades(int herenciaUno, int herenciaDos){
        this.idContenedor = herenciaUno;
        this.idDatosLlegada = herenciaDos;
        System.out.println("ValorTemp: " + idContenedor);
    }
    
    public void guardarDatosLlegada(){
        SimpleDateFormat formatoD = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoH = new SimpleDateFormat("HH:mm:ss");
        String fechaInsp, fechaSalida, horaSalida, horaLlegada, tipoCaja, cupo, contenedor, placa, chasis, choferContenedor,
                ci, nombreFinca, candadosLlegada, sellosInternos, sellosExternos; 
        int semana;
        
        fechaInsp = (String)formatoD.format(this.vistaLlegada.datosLlegada_fechaInsp.getDate());
        semana = this.vistaLlegada.datosLlegada_semana.getValue();
        fechaSalida = (String)formatoD.format(this.vistaLlegada.datosLlegada_fechaSalida.getDate());
        horaSalida =  (String)formatoH.format(this.vistaLlegada.datosLlegada_horaSalida.getValue());
        horaLlegada = (String)formatoH.format(this.vistaLlegada.datosLlegada_horaLlegada.getValue());
        tipoCaja = this.vistaLlegada.datosLlegada_tipocaja.getText();
        cupo = this.vistaLlegada.datosLlegada_cupo.getText();
        contenedor = this.vistaLlegada.datosLlegada_contenedor.getText();
        placa = this.vistaLlegada.datosLlegada_placa.getText();
        chasis = this.vistaLlegada.datosLlegada_chasis.getText();
        choferContenedor = this.vistaLlegada.datosLlegada_chofer.getText();
        nombreFinca = this.vistaLlegada.datosLlegada_nombrefinca.getText();
        candadosLlegada = this.vistaLlegada.datosLlegada_candadosllegada.getText();

        ci = this.vistaLlegada.datosLlegada_ci.getText();
        System.out.println(fechaInsp);
        System.out.println(semana);
        System.out.println(fechaSalida);
        System.out.println(horaSalida);
        System.out.println(horaLlegada);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.vistaLlegada.btn_siguiente_llegada) {
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(1);
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
            this.guardarDatosLlegada();
        }
    }
}