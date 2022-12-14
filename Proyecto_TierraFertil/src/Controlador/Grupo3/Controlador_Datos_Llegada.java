package Controlador.Grupo3;

import Modelo.Grupo3.Modelo_Contenedores;
import Modelo.Grupo3.Modelo_Datos_Llegada;
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

public class Controlador_Datos_Llegada implements MouseListener, KeyListener {

    Vista_Llegada vistaLlegada;
    Modelo_Datos_Llegada modeloDatosLlegada = new Modelo_Datos_Llegada();
    Modelo_Contenedores modeloDaLleContenedor = new Modelo_Contenedores();

    SimpleDateFormat formatoD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatoH = new SimpleDateFormat("HH:mm:ss");

    ResultSet rs, rsC;
    public static int idContenedor;
    public static int idDatosLlegada;
    public int tempClickG3;
    String fechaInsp, fechaSalida, horaSalida, horaLlegada, tipoCaja, cupo, contenedor, placa,
            chasis, choferContenedor, ci, nombreFinca, candadosLlegada, sellosInternos, sellosExternos;
    int semana;

    public Controlador_Datos_Llegada(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.vistaLlegada.btn_siguiente_llegada.addMouseListener(this);
        this.vistaLlegada.boton_home.addMouseListener(this);

        this.vistaLlegada.datosLlegada_tipocaja.addKeyListener(this);
        this.vistaLlegada.datosLlegada_cupo.addKeyListener(this);
        this.vistaLlegada.datosLlegada_contenedor.addKeyListener(this);
        this.vistaLlegada.datosLlegada_placa.addKeyListener(this);
        this.vistaLlegada.datosLlegada_chasis.addKeyListener(this);
        this.vistaLlegada.datosLlegada_chofer.addKeyListener(this);
        this.vistaLlegada.datosLlegada_ci.addKeyListener(this);
        this.vistaLlegada.datosLlegada_nombrefinca.addKeyListener(this);
        this.vistaLlegada.datosLlegada_candadosllegada.addKeyListener(this);
        this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(1, false);
        this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(2, false);
        this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(3, false);
        this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(4, false);

        this.cargaDefault();
    }

    // #SE NECESITA PROBAR BIEN ESTO AUN. // Esto es porque ambas tablas tienen el mismo id de tupla, por ser unica.
    public void idBusqueda(int idBusquedaUno) {
        this.idContenedor = idBusquedaUno;
        this.idDatosLlegada = this.idContenedor;
        this.modeloDatosLlegada.id_contenedor = this.idContenedor;
    }

    public void idEntidadContenedores() {
        try {
            rs = modeloDaLleContenedor.consultaID_contenedor();
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
        System.out.println("ValorHerencia DatosLLegada DLL: " + idContenedor + " , " + idDatosLlegada);
    }

    public void almacenarDatosLlegada() {
        //  Hacemos este tryCatch por si no colocan fecha en algun campo, eso genera exepciones.
        //  ## Revisar lo de fecha y hora, para que no salga error.
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

    // #Borrar lo de consola.
    public void guardarContenedor() {
        this.modeloDaLleContenedor.id = idContenedor;
        this.modeloDaLleContenedor.codigo_Contenedor = contenedor;
        System.out.println("Guardar Conten DLL: " + idContenedor + " , " + contenedor);
    }

    // #Actualizar lo de id para actualizar... Eso falta ###### En el modelo esta pre cargado 1;
    public void cargarDatosLlegada() {
        String sellosInternos = "", sellosExternos = "";
        rsC = modeloDatosLlegada.consultaDatos_entidadDatosLlegada();
        try {
            while (rsC.next()) {
                this.vistaLlegada.datosLlegada_fechaInsp.setDate(funcionFecha_Formato(rsC.getString("fecha_insp")));
                this.vistaLlegada.datosLlegada_semana.setValue(Integer.parseInt(rsC.getString("semana")));
                this.vistaLlegada.datosLlegada_fechaSalida.setDate(funcionFecha_Formato(rsC.getString("fecha_hora_salida").substring(0, 10)));
                this.vistaLlegada.datosLlegada_horaSalida.setValue(funcionHora_Formato(rsC.getString("fecha_hora_salida").substring(11, 19)));
                this.vistaLlegada.datosLlegada_horaLlegada.setValue(funcionHora_Formato(rsC.getString("hora_llegada")));
                this.vistaLlegada.datosLlegada_tipocaja.setText(rsC.getString("tipo_caja"));
                this.vistaLlegada.datosLlegada_cupo.setText(rsC.getString("cupo"));
                this.vistaLlegada.datosLlegada_contenedor.setText(rsC.getString("contenedor"));
                this.vistaLlegada.datosLlegada_placa.setText(rsC.getString("placa"));
                this.vistaLlegada.datosLlegada_chasis.setText(rsC.getString("chasis"));
                this.vistaLlegada.datosLlegada_chofer.setText(rsC.getString("chofer_contenedor"));
                this.vistaLlegada.datosLlegada_ci.setText(rsC.getString("cedula_chofer"));
                this.vistaLlegada.datosLlegada_nombrefinca.setText(rsC.getString("nombre_finca"));
                this.vistaLlegada.datosLlegada_candadosllegada.setText(rsC.getString("candados"));
                sellosInternos = rsC.getString("sellos_internos");
                sellosExternos = rsC.getString("sellos_externos");
            }
            /*  
                Con este tipo de dato lo dividimos con el .split donde damos el tipo de dato de division y cuantos 
                hay, no es obligatorio el ultimo dato.
             */
            String[] dataI = sellosInternos.split(";", 3);
            String[] dataE = sellosExternos.split(";", 9);
            //  --> Datos Internos
            this.vistaLlegada.datosLlegada_sellosInternos_1.setText(dataI[0]);
            this.vistaLlegada.datosLlegada_sellosInternos_2.setText(dataI[1]);
            this.vistaLlegada.datosLlegada_sellosInternos_3.setText(dataI[2]);
            //  --> Datos Externos
            this.vistaLlegada.datosLlegada_sellosExtrenos_1.setText(dataE[0]);
            this.vistaLlegada.datosLlegada_sellosExtrenos_2.setText(dataE[1]);
            this.vistaLlegada.datosLlegada_sellosExtrenos_3.setText(dataE[2]);
            this.vistaLlegada.datosLlegada_sellosExtrenos_4.setText(dataE[3]);
            this.vistaLlegada.datosLlegada_sellosExtrenos_5.setText(dataE[4]);
            this.vistaLlegada.datosLlegada_sellosExtrenos_6.setText(dataE[5]);
            this.vistaLlegada.datosLlegada_sellosExtrenos_7.setText(dataE[6]);
            this.vistaLlegada.datosLlegada_sellosExtrenos_8.setText(dataE[7]);
            this.vistaLlegada.datosLlegada_sellosExtrenos_9.setText(dataE[8]);

        } catch (Exception e) {
            System.out.println("Error al cargar componentes Modelo_Datos_LLegada: " + e);
        }
    }

    public void borrarCamposDatosLlegada() {
        try {
            this.vistaLlegada.datosLlegada_fechaInsp.setDate(null);
            this.vistaLlegada.datosLlegada_semana.setValue(0);
            this.vistaLlegada.datosLlegada_fechaSalida.setDate(null);
            this.vistaLlegada.datosLlegada_horaSalida.setValue(funcionHora_Formato("00:00:00"));
            this.vistaLlegada.datosLlegada_horaLlegada.setValue(funcionHora_Formato("00:00:00"));
            this.vistaLlegada.datosLlegada_tipocaja.setText(null);
            this.vistaLlegada.datosLlegada_cupo.setText(null);
            this.vistaLlegada.datosLlegada_contenedor.setText(null);
            this.vistaLlegada.datosLlegada_placa.setText(null);
            this.vistaLlegada.datosLlegada_chasis.setText(null);
            this.vistaLlegada.datosLlegada_chofer.setText(null);
            this.vistaLlegada.datosLlegada_ci.setText(null);
            this.vistaLlegada.datosLlegada_nombrefinca.setText(null);
            this.vistaLlegada.datosLlegada_candadosllegada.setText(null);
            //  --> Datos Internos
            this.vistaLlegada.datosLlegada_sellosInternos_1.setText(null);
            this.vistaLlegada.datosLlegada_sellosInternos_2.setText(null);
            this.vistaLlegada.datosLlegada_sellosInternos_3.setText(null);
            //  --> Datos Externos
            this.vistaLlegada.datosLlegada_sellosExtrenos_1.setText(null);
            this.vistaLlegada.datosLlegada_sellosExtrenos_2.setText(null);
            this.vistaLlegada.datosLlegada_sellosExtrenos_3.setText(null);
            this.vistaLlegada.datosLlegada_sellosExtrenos_4.setText(null);
            this.vistaLlegada.datosLlegada_sellosExtrenos_5.setText(null);
            this.vistaLlegada.datosLlegada_sellosExtrenos_6.setText(null);
            this.vistaLlegada.datosLlegada_sellosExtrenos_7.setText(null);
            this.vistaLlegada.datosLlegada_sellosExtrenos_8.setText(null);
            this.vistaLlegada.datosLlegada_sellosExtrenos_9.setText(null);
        } catch (Exception e) {
            System.out.println("Error de borrado: " + e);
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

    public void guardadoFinal() {
        this.almacenarDatosLlegada();
        this.enviarDatosLLegada();
        this.guardarContenedor();
        this.modeloDaLleContenedor.pruebaGuardado();
        this.modeloDatosLlegada.pruebaGuardado();
        this.modeloDaLleContenedor.guardarContenedorDatos();
        this.modeloDatosLlegada.guardarActualizar_DatosLlegada();
    }

    public void cargaDefault() {
        LocalDate actualDate = LocalDate.now();
        this.vistaLlegada.datosLlegada_fechaInsp.setDate(funcionFecha_Formato(actualDate.toString()));
        this.vistaLlegada.datosLlegada_fechaSalida.setDate(funcionFecha_Formato(actualDate.toString()));
    }

    public void Completo() {

        if (vistaLlegada.datosLlegada_tipocaja.getText().isEmpty() || vistaLlegada.datosLlegada_cupo.getText().isEmpty() || vistaLlegada.datosLlegada_contenedor.getText().isEmpty()
                || vistaLlegada.datosLlegada_placa.getText().isEmpty() || vistaLlegada.datosLlegada_chasis.getText().isEmpty() || vistaLlegada.datosLlegada_chofer.getText().isEmpty()
                || vistaLlegada.datosLlegada_ci.getText().isEmpty() || vistaLlegada.datosLlegada_nombrefinca.getText().isEmpty()
                || vistaLlegada.datosLlegada_candadosllegada.getText().isEmpty() || vistaLlegada.datosLlegada_sellosExtrenos_1.getText().isEmpty()
                || vistaLlegada.datosLlegada_sellosInternos_1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaLlegada, "Porfavor no dejar campos vacios ");

        } else {
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setSelectedIndex(1);
            this.vistaLlegada.jp_grupoOpciones_datosLlegada.setEnabledAt(1, true);

        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        // usamos para hacer el cambio de formulario en boton siguiente
        if (me.getSource() == this.vistaLlegada.btn_siguiente_llegada) {
            Completo();
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
        if (e.getSource() == vistaLlegada.datosLlegada_tipocaja) {
            if (vistaLlegada.datosLlegada_tipocaja.getText().length() >= 50) {
                e.consume();
            }
        }

        if (e.getSource() == vistaLlegada.datosLlegada_cupo) {
            if (vistaLlegada.datosLlegada_cupo.getText().length() >= 50) {
                e.consume();
            }
        }

        if (e.getSource() == vistaLlegada.datosLlegada_contenedor) {
            if (vistaLlegada.datosLlegada_contenedor.getText().length() >= 50) {
                e.consume();
            }
        }

        if (e.getSource() == vistaLlegada.datosLlegada_placa) {
            if (vistaLlegada.datosLlegada_placa.getText().length() >= 50) {
                e.consume();
            }
        }

        if (e.getSource() == vistaLlegada.datosLlegada_chasis) {
            if (vistaLlegada.datosLlegada_chasis.getText().length() >= 50) {
                e.consume();
            }
        }

        if (e.getSource() == vistaLlegada.datosLlegada_chofer) {
            char c = e.getKeyChar();
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                e.consume();
            }
            if (vistaLlegada.datosLlegada_chofer.getText().length() >= 50) {
                e.consume();
            }
        }

        if (e.getSource() == vistaLlegada.datosLlegada_ci) {

            char c = e.getKeyChar();
            if (c < '0' || c > '9') {
                e.consume();
            }
            if (vistaLlegada.datosLlegada_ci.getText().length() >= 13) {
                e.consume();

            }
        }

        if (e.getSource() == vistaLlegada.datosLlegada_nombrefinca) {
            if (vistaLlegada.datosLlegada_nombrefinca.getText().length() >= 50) {
                e.consume();
            }
        }
        if (e.getSource() == vistaLlegada.datosLlegada_candadosllegada) {
            if (vistaLlegada.datosLlegada_candadosllegada.getText().length() >= 30) {
                e.consume();
            }
        }
        if (e.getSource() == vistaLlegada.datosLlegada_sellosExtrenos_1) {
            if (vistaLlegada.datosLlegada_sellosExtrenos_1.getText().length() >= 250) {
                e.consume();
            }
        }
        if (e.getSource() == vistaLlegada.datosLlegada_sellosInternos_1) {
            if (vistaLlegada.datosLlegada_sellosInternos_1.getText().length() >= 250) {
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
