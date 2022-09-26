package Controlador.Grupo2;

import Vista.Grupo2.Vista_Evaluacion_Total;
import Modelo.Grupo2.Modelo_Evaluacion_Datos;
import Modelo.Grupo2.Modelo_Evaluacion_Listado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import Modelo.Modelo_Conexion;
import Modelo.Grupo2.Modelo_Evaluacion_Datos;
import Modelo.Modelo_Conexion;
import javax.swing.table.DefaultTableModel;
import Vista.Grupo2.Vista_Listado_Menu;
import Vista.Grupo2.Vista_Home_Calidad;
import Vista.Vista_General;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Controlador_Evaluacion_Datos implements ActionListener, AncestorListener, MouseListener {
    Vista_Home_Calidad vistaHome = new Vista_Home_Calidad();
    Vista_General vistaGeneral = new Vista_General();
    Vista_Evaluacion_Total vistaEvaluacion = new Vista_Evaluacion_Total();
    Modelo_Evaluacion_Datos modeloEvaluacionCalidad = new Modelo_Evaluacion_Datos();
    Modelo_Conexion conexion = new Modelo_Conexion();
   
    Vista_Listado_Menu vistaListado = new Vista_Listado_Menu();

    Modelo_Evaluacion_Listado modeloListado = new Modelo_Evaluacion_Listado();
    ResultSet rs;
    ResultSet rsCarga;

    public static String mensaje;

    public Controlador_Evaluacion_Datos(Vista_Evaluacion_Total vistaEvaluacion) {
        this.vistaEvaluacion = vistaEvaluacion;

        //Botones de datos
        this.vistaEvaluacion.btn_siguiente.addMouseListener(this);
        this.vistaEvaluacion.rdn_finalizar.addMouseListener(this);

        //Evita que se acceda a la pestaña tabulacion
        this.vistaEvaluacion.pestaña_tabulacion.setEnabledAt(1, false);

    }

    @Override

    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void ancestorAdded(AncestorEvent event) {
    }

    @Override
    public void ancestorRemoved(AncestorEvent event) {
    }

    @Override
    public void ancestorMoved(AncestorEvent event) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaEvaluacion.btn_siguiente) {

            System.out.println("Boton siguiente presionado");
            guardarDatos();

        }
        if (e.getSource() == this.vistaEvaluacion.rdn_finalizar) {

            int respuesta = JOptionPane.showConfirmDialog(vistaEvaluacion, "Se ah registrado la evaluacion correctamente.\n ¿Desea generar su reporte?", "REPORTES", JOptionPane.INFORMATION_MESSAGE);
            if (respuesta == 0) {
                generarReporteEvaluacion();
                this.vistaEvaluacion.dispose();
                this.vistaGeneral.jp_escritorio_general.add(vistaHome);
                this.vistaHome.setBorder(null);
                this.vistaHome.setVisible(true);
                

            }
            this.vistaEvaluacion.dispose();

        }
    }

    public void generarReporteEvaluacion() {
        try {

            String respuesta = this.vistaEvaluacion.txt_codigo.getText();
            JasperReport reporte;
            JasperPrint jprint;

            HashMap<String, Object> parameters = new HashMap<>();

            parameters.put("parametro_codigo", respuesta);

            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes_Grupo2/Reporte_Evaluacion.jasper"));
            jprint = JasperFillManager.fillReport(reporte, parameters, conexion.conectarBD());

            if (jprint != null) {
                JasperViewer view = new JasperViewer(jprint);
                view.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaEvaluacion, "Error al generar reporte: " + ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void guardarDatos() {
        try {
            // SimpleDateFormat formatoP = new SimpleDateFormat("dd/MM/yyyy");
            // this.vistaLlegada.datosLlegada_fechaInsp.setDate(formatoP.format(28/09/2022).toDate);
            if (this.vistaEvaluacion.lb_id_evaluacion.getText().isEmpty()) {

                modeloEvaluacionCalidad.semana = (int) this.vistaEvaluacion.js_semana.getValue();
                modeloEvaluacionCalidad.finca = this.vistaEvaluacion.txt_finca.getText();
                modeloEvaluacionCalidad.calibracion = this.vistaEvaluacion.txt_calibracion.getText();
                modeloEvaluacionCalidad.vapor = this.vistaEvaluacion.txt_vapor.getText();
                modeloEvaluacionCalidad.transporte = this.vistaEvaluacion.txt_transporte.getText();
                modeloEvaluacionCalidad.l_dedos = this.vistaEvaluacion.txt_dedos.getText();
                modeloEvaluacionCalidad.pedido = this.vistaEvaluacion.txt_pedidos.getText();
                modeloEvaluacionCalidad.tipo_caja = this.vistaEvaluacion.txt_tipoCaja.getText();
                modeloEvaluacionCalidad.destino = this.vistaEvaluacion.txt_destino.getText();
                modeloEvaluacionCalidad.codigo = this.vistaEvaluacion.txt_codigo.getText();
                modeloEvaluacionCalidad.fumigacion = this.vistaEvaluacion.txt_fumigacion.getText();
                modeloEvaluacionCalidad.peso = this.vistaEvaluacion.txt_peso.getText();
                modeloEvaluacionCalidad.observaciones = this.vistaEvaluacion.txt_observaciones.getText();
                modeloEvaluacionCalidad.fecha = ((JTextField) this.vistaEvaluacion.jd_fecha.getDateEditor().getUiComponent()).getText();
//
//                    if (this.vistaEvaluacion.txt_codigo.getText().isEmpty() || this.vistaEvaluacion.txt_calibracion.getText().isEmpty() || this.vistaEvaluacion.txt_vapor.getText().isEmpty()
//                            || this.vistaEvaluacion.txt_transporte.getText().isEmpty() || this.vistaEvaluacion.txt_peso.getText().isEmpty() || this.vistaEvaluacion.txt_dedos.getText().isEmpty()
//                            || this.vistaEvaluacion.txt_pedidos.getText().isEmpty() || this.vistaEvaluacion.txt_caja_insp.getText().isEmpty() || this.vistaEvaluacion.txt_destino.getText().isEmpty()
//                            || this.vistaEvaluacion.txt_codigo.getText().isEmpty() || this.vistaEvaluacion.txt_fumigacion.getText().isEmpty()) {
//
//                        JOptionPane.showMessageDialog(visÇtaEvaluacion, "No deje ningun campo vacio. ");

//                    } else {
//                        System.out.println("Validacion Correcta");
                int respuesta = JOptionPane.showConfirmDialog(vistaEvaluacion, "Para confirmar sus datos presiones SI.", "ATENCION", JOptionPane.YES_OPTION);

                if (respuesta == 0) {

                    modeloEvaluacionCalidad.guardarDatos();
                    ID_eval();

                    System.out.println("SEGUIMIENTO: Campos de datos almacenados correctamente. ");
                    JOptionPane.showMessageDialog(vistaEvaluacion, "Datos Almacenados Correctamente", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);

                    //da acceso a la pestaña tabulacion 
                    this.vistaEvaluacion.pestaña_tabulacion.setSelectedIndex(1);
                    this.vistaEvaluacion.pestaña_tabulacion.setEnabledAt(1, true);

                }

//                    }
            } else {
                modeloEvaluacionCalidad.id_actualizar = this.vistaEvaluacion.lb_id_evaluacion.getText();

                modeloEvaluacionCalidad.semana = (int) this.vistaEvaluacion.js_semana.getValue();
                modeloEvaluacionCalidad.finca = this.vistaEvaluacion.txt_finca.getText();
                modeloEvaluacionCalidad.calibracion = this.vistaEvaluacion.txt_calibracion.getText();
                modeloEvaluacionCalidad.vapor = this.vistaEvaluacion.txt_vapor.getText();
                modeloEvaluacionCalidad.transporte = this.vistaEvaluacion.txt_transporte.getText();
                modeloEvaluacionCalidad.l_dedos = this.vistaEvaluacion.txt_dedos.getText();
                modeloEvaluacionCalidad.pedido = this.vistaEvaluacion.txt_pedidos.getText();
                modeloEvaluacionCalidad.tipo_caja = this.vistaEvaluacion.txt_tipoCaja.getText();
                modeloEvaluacionCalidad.destino = this.vistaEvaluacion.txt_destino.getText();
                modeloEvaluacionCalidad.codigo = this.vistaEvaluacion.txt_codigo.getText();
                modeloEvaluacionCalidad.fumigacion = this.vistaEvaluacion.txt_fumigacion.getText();
                modeloEvaluacionCalidad.peso = this.vistaEvaluacion.txt_peso.getText();
                modeloEvaluacionCalidad.observaciones = this.vistaEvaluacion.txt_observaciones.getText();
                modeloEvaluacionCalidad.fecha = ((JTextField) this.vistaEvaluacion.jd_fecha.getDateEditor().getUiComponent()).getText();
                int respuesta = JOptionPane.showConfirmDialog(vistaEvaluacion, "Para continuar la actualizacion presiones SI.", "ATENCION", JOptionPane.YES_OPTION);

                if (respuesta == 0) {

                    modeloEvaluacionCalidad.actualizarDatos();

                    System.out.println("SEGUIMIENTO: Campos de datos almacenados correctamente. ");
                    JOptionPane.showMessageDialog(vistaEvaluacion, "Datos actualizados correctamente", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);

                    //da acceso a la pestaña tabulacion 
                    this.vistaEvaluacion.pestaña_tabulacion.setSelectedIndex(1);
                    this.vistaEvaluacion.pestaña_tabulacion.setEnabledAt(1, true);

                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaEvaluacion, "Error al intentar guardar los DATOS. " + ex);

        }
    }

    public void cargarDatos() {
        try {
//            int fila = this.vistaListado.tabla_listado.getSelectedRow();
//            //se manda el codigo a la sentencia select
//            this.modeloEvaluacionCalidad.codigo = (String) this.vistaListado.tabla_listado.getValueAt(fila, 0);

            mensaje = JOptionPane.showInputDialog("Ingrese el codigo a actualizar");
            int respuesta = JOptionPane.showConfirmDialog(vistaEvaluacion, mensaje, "Desea actualizar este registro?", JOptionPane.YES_OPTION);

            if (respuesta == 0) {

                modeloEvaluacionCalidad.codigo = mensaje;
                modeloEvaluacionCalidad.selecionDatos();
                rsCarga = modeloEvaluacionCalidad.selecionDatos();
                while (rsCarga.next()) {
                    this.vistaEvaluacion.txt_codigo.setText(rsCarga.getString("codigo"));

                    this.vistaEvaluacion.txt_finca.setText(rsCarga.getString("finca"));
                    this.vistaEvaluacion.js_semana.setValue(rsCarga.getInt("id_semana"));

                    this.vistaEvaluacion.jd_fecha.setDate(rsCarga.getDate("fecha"));
                    this.vistaEvaluacion.txt_pedidos.setText(rsCarga.getString("pdo"));
                    this.vistaEvaluacion.txt_vapor.setText(rsCarga.getString("vapor"));
                    this.vistaEvaluacion.txt_tipoCaja.setText(rsCarga.getString("tipo_caja"));
                    this.vistaEvaluacion.txt_peso.setText(rsCarga.getString("peso"));
                    this.vistaEvaluacion.txt_destino.setText(rsCarga.getString("destino"));
                    this.vistaEvaluacion.txt_dedos.setText(rsCarga.getString("l_dedos"));
                    this.vistaEvaluacion.txt_calibracion.setText(rsCarga.getString("calibracion"));
                    this.vistaEvaluacion.txt_transporte.setText(rsCarga.getString("transporte"));
                    this.vistaEvaluacion.txt_observaciones.setText(rsCarga.getString("observaciones"));
                    this.vistaEvaluacion.jd_fecha.setDateFormatString(rsCarga.getString("fecha"));
                    this.vistaEvaluacion.txt_fumigacion.setText(rsCarga.getString("fumigacion"));
                    cargarId(mensaje);
                    JOptionPane.showMessageDialog(vistaListado, "Datos Cargados Correctamente\n"
                            + "Ingrese los nuevos datos.");

                }

            }
            DefaultTableModel tabla = (DefaultTableModel) this.vistaListado.tabla_listado.getModel();
            System.out.println("Actualizar ejecutado");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaListado, "Error en cargar los datos controladorDatos" + ex);
        }
    }

    public void cargarId(String valor) {
        try {
            modeloEvaluacionCalidad.codigo = valor;
            modeloEvaluacionCalidad.obtenerIdEvaluacionesUpdate();
            rsCarga = modeloEvaluacionCalidad.obtenerIdEvaluacionesUpdate();
            while (rsCarga.next()) {
                this.vistaEvaluacion.lb_id_evaluacion.setText(rsCarga.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaEvaluacion, "Error en mostrarIdEvaluacionUpdate. " + e);
        }

    }

    public void ID_eval() {
        try {
            ResultSet rs = modeloEvaluacionCalidad.obtenerIdEvaluaciones();

            while (rs.next()) {
                this.vistaEvaluacion.lb_id_evaluacion.setText(rs.getString("id_ev"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en busqueda id_eval " + e);
        }
    }

}
