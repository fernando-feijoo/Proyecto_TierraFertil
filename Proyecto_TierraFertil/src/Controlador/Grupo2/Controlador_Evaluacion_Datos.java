package Controlador.Grupo2;

import Vista.Grupo2.Vista_Evaluacion_Total;
import Modelo.Grupo2.Modelo_Evaluacion_Datos;
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

public class Controlador_Evaluacion_Datos implements ActionListener, AncestorListener, MouseListener {

    Vista_Evaluacion_Total vistaEvaluacion = new Vista_Evaluacion_Total();
    Modelo_Evaluacion_Datos modeloEvaluacionCalidad = new Modelo_Evaluacion_Datos();

    ResultSet rs;

    public Controlador_Evaluacion_Datos(Vista_Evaluacion_Total vistaEvaluacion) {
        this.vistaEvaluacion = vistaEvaluacion;

        //Botones de datos
        this.vistaEvaluacion.btn_siguiente.addMouseListener(this);

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
            try {
                // SimpleDateFormat formatoP = new SimpleDateFormat("dd/MM/yyyy");
                // this.vistaLlegada.datosLlegada_fechaInsp.setDate(formatoP.format(28/09/2022).toDate);
                if (this.vistaEvaluacion.lb_id_evaluacion.getText().isEmpty()) {

                    modeloEvaluacionCalidad.semana = (int) this.vistaEvaluacion.js_semana.getValue();
                    modeloEvaluacionCalidad.finca = (int) this.vistaEvaluacion.js_finca.getValue();
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

                    if (this.vistaEvaluacion.txt_codigo.getText().isEmpty() || this.vistaEvaluacion.txt_calibracion.getText().isEmpty() || this.vistaEvaluacion.txt_vapor.getText().isEmpty()
                            || this.vistaEvaluacion.txt_transporte.getText().isEmpty() || this.vistaEvaluacion.txt_peso.getText().isEmpty() || this.vistaEvaluacion.txt_dedos.getText().isEmpty()
                            || this.vistaEvaluacion.txt_pedidos.getText().isEmpty() || this.vistaEvaluacion.txt_caja_insp.getText().isEmpty() || this.vistaEvaluacion.txt_destino.getText().isEmpty()
                            || this.vistaEvaluacion.txt_codigo.getText().isEmpty() || this.vistaEvaluacion.txt_fumigacion.getText().isEmpty()) {

                        JOptionPane.showMessageDialog(vistaEvaluacion, "No deje ningun campo vacio. ");
                    } else {
                        System.out.println("Validacion Correcta");
                        int respuesta = JOptionPane.showConfirmDialog(vistaEvaluacion, "Para confirmar sus datos presiones SI.", "ATENCION", JOptionPane.YES_OPTION);
                       
                        if (respuesta == 0) {

                            modeloEvaluacionCalidad.guardarDatos();
                            motrarIdEvaluacion();
                            System.out.println("SEGUIMIENTO: Campos de datos almacenados correctamente. ");
                            JOptionPane.showMessageDialog(vistaEvaluacion, "Datos Almacenados Correctamente", "REGISTRO", JOptionPane.INFORMATION_MESSAGE);

                            //da acceso a la pestaña tabulacion 
                            this.vistaEvaluacion.pestaña_tabulacion.setSelectedIndex(1);
                            this.vistaEvaluacion.pestaña_tabulacion.setEnabledAt(1, true);

                        }

                    }

                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaEvaluacion, "Error al intentar guardar los DATOS. " + ex);

            }

        }
    }

    public void motrarIdEvaluacion() {
        try {

            rs = modeloEvaluacionCalidad.obtenerIdEvaluaciones();

            while (rs.next()) {
                this.vistaEvaluacion.lb_id_evaluacion.setText(rs.getString("id_ev"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vistaEvaluacion, "Error en mostrarIdEvaluacion. " + e);
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

}
