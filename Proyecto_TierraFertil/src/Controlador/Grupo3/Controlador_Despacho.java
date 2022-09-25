package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Despacho;
import Vista.Grupo3.Vista_Llegada;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;

public class Controlador_Despacho implements MouseListener, KeyListener {

    Vista_Llegada vistaLlegada;
    Modelo_Despacho modeloDespacho = Modelo_Despacho.getInstancia();
    Modelo_Contenedores modeloContenedor = Modelo_Contenedores.getInstancia();
    SimpleDateFormat formatoD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatoH = new SimpleDateFormat("HH:mm:ss");

    ResultSet rs, rsC;
    public static int idContenedor;
    public static int idDespacho;
    public int tempClickG3;
    String filtro, termografo_seleccion, termografo, selloAdhesivo, selloVerificador, selloCandado, fechaSalida, horaSalida, selloCable,
            compañiaTransportista, selloNaviero, vapor, destino, nombrePaletizadores, totalViajar, cajas, cantidadPallet, observacion;

    public Controlador_Despacho(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.vistaLlegada.btn_siguiente_despacho.addMouseListener(this);

        this.vistaLlegada.despacho_termografo.addKeyListener(this);
        this.vistaLlegada.despacho_sello_adhesivo.addKeyListener(this);
        this.vistaLlegada.despacho_sello_verificador.addKeyListener(this);
        this.vistaLlegada.despacho_sello_exportador.addKeyListener(this);
        this.vistaLlegada.despacho_sello_cable.addKeyListener(this);
        this.vistaLlegada.despacho_compañia_tansportista.addKeyListener(this);
        this.vistaLlegada.despacho_sello_naviero.addKeyListener(this);
        this.vistaLlegada.despacho_vapor.addKeyListener(this);
        this.vistaLlegada.despacho_destino.addKeyListener(this);
        this.vistaLlegada.despacho_nombre_paletizadores.addKeyListener(this);
        this.vistaLlegada.despacho_total_viajar.addKeyListener(this);
        this.vistaLlegada.despacho_cajas_total.addKeyListener(this);
        this.vistaLlegada.despacho_cantidad_pallets.addKeyListener(this);
        this.vistaLlegada.boton_home.addMouseListener(this);
        
        this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(4, false);
        
    }
    public void cargaDatosInicial(){
        this.cargaDefault();
    }

    // #SE NECESITA PROBAR BIEN ESTO AUN.
    public void idBusqueda(int idBusquedaUno) {
        this.idContenedor = idBusquedaUno;
        this.idDespacho = idBusquedaUno;
        this.modeloDespacho.id_contenedor = this.idContenedor;
    }

    public void idEntidadDatosDespacho() {
        try {
            rs = modeloDespacho.consultaID_entidadDespacho();
            while (rs.next()) {
                idDespacho = Integer.parseInt(rs.getString("id_tablaDatosDespacho"));
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
        System.out.println("ValorHerencia Despacho contDespacho: " + idContenedor + " , " + idDespacho);

    }

    public String ObtenerFiltro() {

        if (vistaLlegada.despacho_check_filtro1.isSelected()) {
            return vistaLlegada.despacho_check_filtro1.getText();

        } else if (vistaLlegada.despacho_check_filtro2.isSelected()) {
            return vistaLlegada.despacho_check_filtro2.getText();
        } else {
            return vistaLlegada.despacho_check_filtrono.getText();
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

    public void almacenarDatosDespacho() {

        try {

            filtro = ObtenerFiltro();
            termografo_seleccion = ObtenerTermografo();
            termografo = this.vistaLlegada.despacho_termografo.getText();
            selloAdhesivo = this.vistaLlegada.despacho_sello_adhesivo.getText();
            selloVerificador = this.vistaLlegada.despacho_sello_verificador.getText();
            selloCandado = this.vistaLlegada.despacho_sello_exportador.getText();
            fechaSalida = (String) formatoD.format(this.vistaLlegada.despacho_fechaSalida.getDate());
            horaSalida = (String) formatoH.format(this.vistaLlegada.despacho_horaSalida.getValue());
            selloCable = this.vistaLlegada.despacho_sello_cable.getText();
            compañiaTransportista = this.vistaLlegada.despacho_compañia_tansportista.getText();
            selloNaviero = this.vistaLlegada.despacho_sello_naviero.getText();
            vapor = this.vistaLlegada.despacho_vapor.getText();
            destino = this.vistaLlegada.despacho_destino.getText();
            nombrePaletizadores = this.vistaLlegada.despacho_nombre_paletizadores.getText();
            totalViajar = this.vistaLlegada.despacho_total_viajar.getText();
            cajas = this.vistaLlegada.despacho_cajas_total.getText();
            cantidadPallet = this.vistaLlegada.despacho_cajas_total.getText();
            observacion = this.vistaLlegada.despacho_observaciones.getText();
        } catch (Exception e) {
            System.out.println("Error faltan campos fecha u hora: " + e);

        }

    }

    public void enviarDatosDespacho() {
        this.modeloDespacho.id = idDespacho;
        this.modeloDespacho.id_contenedor = idContenedor;

        this.modeloDespacho.filtro = filtro;
        this.modeloDespacho.termografo = termografo_seleccion;
        this.modeloDespacho.termografo_numero = termografo;
        this.modeloDespacho.sello_adhesivo = selloAdhesivo;
        this.modeloDespacho.sello_verificador = selloVerificador;
        this.modeloDespacho.sello_candado = selloCandado;
        this.modeloDespacho.fecha_salidad = fechaSalida;
        this.modeloDespacho.hora_salida = horaSalida;
        this.modeloDespacho.sello_cable = selloCable;
        this.modeloDespacho.compañia_transportista = compañiaTransportista;
        this.modeloDespacho.sello_naviero = selloNaviero;
        this.modeloDespacho.vapor = vapor;
        this.modeloDespacho.destino = destino;
        this.modeloDespacho.nombre_paletizadores = nombrePaletizadores;
        this.modeloDespacho.total_viajar = totalViajar;
        this.modeloDespacho.cajas = cajas;
        this.modeloDespacho.cantidad_pallets = cantidadPallet;
        this.modeloDespacho.observacion = observacion;
    }

    public void cargarDatosDespacho() {
        //  ## Esta mal no carga la informacion. ##
        rsC = modeloDespacho.consultaDatos_entidadDatosDespacho();
        try {
            while (rsC.next()) {

                if (rsC.getString("termografo").equalsIgnoreCase("P:19")) {
                    this.vistaLlegada.despacho_check_termografo_19.setSelected(true);
                } else if (rsC.getString("termografo").equalsIgnoreCase("P:18")) {
                    this.vistaLlegada.despacho_check_termografo_18.setSelected(true);
                } else {
                    this.vistaLlegada.despacho_check_termografo_no.setSelected(true);
                }

                if (rsC.getString("filtro").equalsIgnoreCase("1")) {
                    this.vistaLlegada.despacho_check_filtro1.setSelected(true);
                } else if (rsC.getString("filtro").equalsIgnoreCase("2")) {
                    this.vistaLlegada.despacho_check_filtro2.setSelected(true);
                } else {
                    this.vistaLlegada.despacho_check_filtrono.setSelected(true);
                }

                this.vistaLlegada.despacho_termografo.setText(rsC.getString("termografo_numero"));
                this.vistaLlegada.despacho_sello_adhesivo.setText(rsC.getString("sello_adhesivo"));
                this.vistaLlegada.despacho_sello_verificador.setText(rsC.getString("sello_verificador"));
                this.vistaLlegada.despacho_sello_exportador.setText(rsC.getString("sello_exp_candado"));
                this.vistaLlegada.despacho_fechaSalida.setDate(funcionFecha_Formato(rsC.getString("fecha_hora_salida").substring(0, 10)));
                this.vistaLlegada.despacho_horaSalida.setValue(funcionHora_Formato(rsC.getString("fecha_hora_salida").substring(11, 19)));
                this.vistaLlegada.despacho_sello_cable.setText(rsC.getString("sello_exp_cable"));
                this.vistaLlegada.despacho_compañia_tansportista.setText(rsC.getString("compania_transportista"));
                this.vistaLlegada.despacho_sello_naviero.setText(rsC.getString("sello_naviero"));
                this.vistaLlegada.despacho_vapor.setText(rsC.getString("vapor"));
                this.vistaLlegada.despacho_destino.setText(rsC.getString("destino"));
                this.vistaLlegada.despacho_nombre_paletizadores.setText(rsC.getString("nombre_paletizadores"));
                this.vistaLlegada.despacho_total_viajar.setText(rsC.getString("total_viajar"));
                this.vistaLlegada.despacho_cajas_total.setText(rsC.getString("cajas"));
                this.vistaLlegada.despacho_cantidad_pallets.setText(rsC.getString("cant_palet"));
                this.vistaLlegada.despacho_observaciones.setText(rsC.getString("observacion"));

            }
        } catch (Exception e) {
            System.out.println("Error al cargar componentes Modelo_Datos_Despacho: " + e);
        }
    }

    public void borrarCamposDatosDespacho() {
        try {
            this.vistaLlegada.despacho_termografo.setText(null);
            this.vistaLlegada.despacho_sello_adhesivo.setText(null);
            this.vistaLlegada.despacho_sello_verificador.setText(null);
            this.vistaLlegada.despacho_sello_exportador.setText(null);
            this.vistaLlegada.despacho_fechaSalida.setDate(null);
            this.vistaLlegada.despacho_horaSalida.setValue(funcionHora_Formato("00:00:00"));
            this.vistaLlegada.despacho_sello_cable.setText(null);
            this.vistaLlegada.despacho_compañia_tansportista.setText(null);
            this.vistaLlegada.despacho_sello_naviero.setText(null);
            this.vistaLlegada.despacho_vapor.setText(null);
            this.vistaLlegada.despacho_destino.setText(null);
            this.vistaLlegada.despacho_nombre_paletizadores.setText(null);
            this.vistaLlegada.despacho_total_viajar.setText(null);
            this.vistaLlegada.despacho_cajas_total.setText(null);
            this.vistaLlegada.despacho_cantidad_pallets.setText(null);
            this.vistaLlegada.despacho_observaciones.setText(null);

        } catch (Exception e) {
            System.out.println("Error de borrado: " + e);
        }
    }

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

    public void guardadoFinal() {
        this.almacenarDatosDespacho();
        this.enviarDatosDespacho();
        this.modeloDespacho.guardar_Despacho();
        this.modeloDespacho.pruebaGuardado();

    }

    public void cargaDefault() {
        LocalDate actualDate = LocalDate.now();
        this.vistaLlegada.despacho_fechaSalida.setDate(funcionFecha_Formato(actualDate.toString()));
    }

    public void completo() {
        if (vistaLlegada.despacho_termografo.getText().isEmpty() || vistaLlegada.despacho_sello_adhesivo.getText().isEmpty() || vistaLlegada.despacho_sello_verificador.getText().isEmpty()
                || vistaLlegada.despacho_sello_exportador.getText().isEmpty() || vistaLlegada.despacho_sello_cable.getText().isEmpty() || vistaLlegada.despacho_compañia_tansportista.getText().isEmpty()
                || vistaLlegada.despacho_sello_naviero.getText().isEmpty() || vistaLlegada.despacho_vapor.getText().isEmpty() || vistaLlegada.despacho_destino.getText().isEmpty()
                || vistaLlegada.despacho_nombre_paletizadores.getText().isEmpty() || vistaLlegada.despacho_total_viajar.getText().isEmpty() || vistaLlegada.despacho_cajas_total.getText().isEmpty()
                || vistaLlegada.despacho_cantidad_pallets.getText().isEmpty() || vistaLlegada.despacho_observaciones.getText().isEmpty()) {

            JOptionPane.showMessageDialog(vistaLlegada, "Porfavor no dejar campos vacios ");
        } else {
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(4);
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(4, true);
        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        // usamos para hacer el cambio de formulario en boton siguiente
        if (me.getSource() == this.vistaLlegada.btn_siguiente_despacho) {
            this.completo();

        }
        if (me.getSource() == this.vistaLlegada.boton_home) {
            this.borrarCamposDatosDespacho();
            this.cargaDefault();
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
    public void keyTyped(KeyEvent e) {

        if (e.getSource() == this.vistaLlegada.despacho_termografo) {
            if (this.vistaLlegada.despacho_termografo.getText().length() >= 25) {
                e.consume();
            }

        }

        if (e.getSource() == this.vistaLlegada.despacho_sello_adhesivo) {
            if (this.vistaLlegada.despacho_sello_adhesivo.getText().length() >= 250) {
                e.consume();
            }
        }
        if (e.getSource() == this.vistaLlegada.despacho_sello_verificador) {
            if (this.vistaLlegada.despacho_sello_verificador.getText().length() >= 250) {
                e.consume();
            }
        }

        if (e.getSource() == this.vistaLlegada.despacho_sello_exportador) {
            if (this.vistaLlegada.despacho_sello_exportador.getText().length() >= 250) {
                e.consume();
            }
        }

        if (e.getSource() == this.vistaLlegada.despacho_sello_cable) {
            if (this.vistaLlegada.despacho_sello_cable.getText().length() >= 250) {
                e.consume();
            }
        }
        if (e.getSource() == this.vistaLlegada.despacho_compañia_tansportista) {
            if (this.vistaLlegada.despacho_compañia_tansportista.getText().length() >= 100) {
                e.consume();
            }
        }
        if (e.getSource() == this.vistaLlegada.despacho_sello_naviero) {
            if (this.vistaLlegada.despacho_sello_naviero.getText().length() >= 250) {
                e.consume();
            }
        }
        if (e.getSource() == this.vistaLlegada.despacho_vapor) {
            if (this.vistaLlegada.despacho_vapor.getText().length() >= 50) {
                e.consume();
            }
        }
        if (e.getSource() == this.vistaLlegada.despacho_destino) {
            if (this.vistaLlegada.despacho_destino.getText().length() >= 50) {
                e.consume();
            }
        }
        if (e.getSource() == this.vistaLlegada.despacho_nombre_paletizadores) {
            if (this.vistaLlegada.despacho_nombre_paletizadores.getText().length() >= 50) {
                e.consume();
            }
        }
        if (e.getSource() == this.vistaLlegada.despacho_total_viajar) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();}
                if (this.vistaLlegada.despacho_total_viajar.getText().length() >= 5) {
                    e.consume();
                }
            }
        

        if (e.getSource() == this.vistaLlegada.despacho_cajas_total) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();
            }
                if (this.vistaLlegada.despacho_cajas_total.getText().length() >= 5) {
                    e.consume();
                }
            }
        
        if (e.getSource() == this.vistaLlegada.despacho_cantidad_pallets) {
            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();
            }
                if (this.vistaLlegada.despacho_cantidad_pallets.getText().length() >= 5) {
                    e.consume();
                }
            }
        
        if (e.getSource() == this.vistaLlegada.despacho_observaciones) {
            if (this.vistaLlegada.despacho_observaciones.getText().length() >= 250) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
