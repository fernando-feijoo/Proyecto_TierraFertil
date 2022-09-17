package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Despacho;
import Vista.Grupo3.Vista_Llegada;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Controlador_Despacho implements MouseListener, ComponentListener {

    Vista_Llegada vistaLlegada;
    Modelo_Despacho modeloDespacho = new Modelo_Despacho();
    Modelo_Contenedores modeloContenedor = new Modelo_Contenedores();

    ResultSet rs;
    public static int idContenedor;
    public static int idDespacho;

    public Controlador_Despacho(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;

        this.vistaLlegada.btn_siguiente_despacho.addMouseListener(this);
        this.vistaLlegada.jp_opcion_Despacho.addComponentListener(this);
    }

    public void idEntidadContenedores() {
        try {
            rs = modeloContenedor.consultaID_contenedor();
            while (rs.next()) {
                idContenedor = Integer.parseInt(rs.getString("id_contenedor"));
            }
            System.out.println("id Entidad Contenedor ControladorDespacho: " + idContenedor);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }
    }

    public void idEntidadDatosLlegada() {
        try {
            rs = modeloDespacho.consultaID_entidadDespacho();
            while (rs.next()) {
                idDespacho = Integer.parseInt(rs.getString("id_tablaDespacho"));
            }
            System.out.println("id Entidad Despacho ControladorDespacho: " + idDespacho);
        } catch (SQLException ex) {
            System.out.println("Error de consulta y almacenamiento: " + ex);
        }
    }
    //  Sirve para incrementar el valor idContenedor y de todos, se llama en el ControladorGeneral y aumenta ahi cuando se guarde.
    //  ESTO SE DEBERIA AUTO INCREMENTAR POR CONDICION SI ES PRIMER INGRESO SE SUMA, SI SE GUARDA SE SUMA.
    //  Mientras no se guarde no se suma.

    public void autoIncrementarID_Entidades(int herenciaUno, int herenciaDos) {
        this.idContenedor = herenciaUno;
        this.idDespacho = herenciaDos;
        System.out.println("ValorHerencia: " + idContenedor + " , " + idDespacho);

    }

    public String ObtenerFiltro() {

        if (vistaLlegada.despacho_check_filtro1.isSelected()) {
            return vistaLlegada.despacho_check_filtro1.getText();

        } else if (vistaLlegada.despacho_check_filtro2.isSelected()) {
            return vistaLlegada.despacho_check_filtro2.getText();
        } else {
            return vistaLlegada.despacho_chek_filtrono.getText();
        }

    }

    public String ObtenerTermografo() {

        if (vistaLlegada.despacho_check_termografo_18.isSelected()) {
            return vistaLlegada.despacho_check_termografo_18.getText();

        } else if (vistaLlegada.despacho_check_termografo_19.isSelected()) {
            return vistaLlegada.despacho_check_termografo_19.getText();
        } else {
            return vistaLlegada.despacho_check_termografo_no.getText();
        }

    }

    public void guardarDespacho() {
// SimpleDateFormat formatoP = new SimpleDateFormat("dd/MM/yyyy");
// this.vistaLlegada.datosLlegada_fechaInsp.setDate(formatoP.format(28/09/2022).toDate);
        SimpleDateFormat formatoD = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoH = new SimpleDateFormat("HH:mm:ss");
        String filtro, termografo_seleccion, termografo, selloAdhesivo, selloVerificador, selloCandado, fechaSalida, horaSalida, selloCable,
                compañiaTransportista, selloNaviero, vapor, destino, nombrePaletizadores, totalViajar, cajas, cantidadPallet;

        filtro = ObtenerFiltro();
        termografo_seleccion = ObtenerTermografo();
        termografo = this.vistaLlegada.despacho_termografo.getText();
        selloAdhesivo = this.vistaLlegada.despacho_sello_adhesivo.getText();
        selloVerificador = this.vistaLlegada.despacho_sello_verificador.getText();
        selloCandado = this.vistaLlegada.despacho_sello_exportador.getText();
        fechaSalida = (String) formatoD.format(this.vistaLlegada.despacho_fechaSalida.getDate());
        horaSalida = (String) formatoH.format(this.vistaLlegada.despacho_horaSalida);
        selloCable = this.vistaLlegada.despacho_sello_cable.getText();
        compañiaTransportista = this.vistaLlegada.despacho_compañia_tansportista.getText();
        selloNaviero = this.vistaLlegada.despacho_sello_naviero.getText();
        vapor = this.vistaLlegada.despacho_vapor.getText();
        destino = this.vistaLlegada.despacho_destino.getText();
        nombrePaletizadores = this.vistaLlegada.despacho_nombre_paletizadores.getText();
        totalViajar = this.vistaLlegada.despacho_total_viajar.getText();
        cajas = this.vistaLlegada.despacho_cajas_total.getText();
        cantidadPallet = this.vistaLlegada.despacho_cajas_total.getText();

        System.out.println(horaSalida);
        System.out.println(fechaSalida);
        System.out.println(ObtenerFiltro());
        System.out.println(ObtenerTermografo());

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.vistaLlegada.btn_siguiente_despacho) {
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(4);
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
    public void componentResized(ComponentEvent me) {
    }

    @Override
    public void componentMoved(ComponentEvent me) {
    }

    @Override
    public void componentShown(ComponentEvent me) {
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        if (ce.getSource() == this.vistaLlegada.jp_grupoOpciones_datosLlegada) {
            System.err.println("Ingreso Opcion. HIDE");
            this.guardarDespacho();
        }
    }

}
