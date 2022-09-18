package Controlador.Grupo2;

import Vista.Grupo2.Vista_Evaluacion_Total;
import Modelo.Modelo_Conexion;
import Modelo.Grupo2.Modelo_Evaluacion_Datos;
import com.sun.media.sound.ModelOscillator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Controlador_Evaluacion_Datos implements ActionListener, AncestorListener, MouseListener {

    Vista_Evaluacion_Total vistaEvaluacion = new Vista_Evaluacion_Total();
    Modelo_Evaluacion_Datos modeloEvaluacionCalidad = new Modelo_Evaluacion_Datos();

    public Controlador_Evaluacion_Datos(Vista_Evaluacion_Total vistaEvaluacion) {
        this.vistaEvaluacion = vistaEvaluacion;

        //Botones de datos
        this.vistaEvaluacion.btn_siguiente.addMouseListener(this);

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
               
                modeloEvaluacionCalidad.semana = (String) this.vistaEvaluacion.js_semana.getValue();
                modeloEvaluacionCalidad.finca = (String) this.vistaEvaluacion.js_finca.getValue();
                modeloEvaluacionCalidad.calibracion = this.vistaEvaluacion.txt_calibracion.getText();
                modeloEvaluacionCalidad.vapor = this.vistaEvaluacion.txt_vapor.getText();
                modeloEvaluacionCalidad.transporte = this.vistaEvaluacion.txt_transporte.getText();
                modeloEvaluacionCalidad.l_dedos = this.vistaEvaluacion.txt_dedos.getText();
                modeloEvaluacionCalidad.pedido = this.vistaEvaluacion.txt_pedidos.getText();
                modeloEvaluacionCalidad.tipo_caja = this.vistaEvaluacion.txt_tipoCaja.getText();
                modeloEvaluacionCalidad.destino = this.vistaEvaluacion.txt_destino1.getText();
                modeloEvaluacionCalidad.codigo = this.vistaEvaluacion.txt_codigo.getText();
                modeloEvaluacionCalidad.fumigacion = this.vistaEvaluacion.txt_fumigacion.getText();
                modeloEvaluacionCalidad.peso = this.vistaEvaluacion.txt_peso.getText();
                modeloEvaluacionCalidad.observaciones = this.vistaEvaluacion.txt_observaciones.getText();

                modeloEvaluacionCalidad.fecha = ((JTextField)this.vistaEvaluacion.jd_fecha.getDateEditor().getUiComponent()).getText();

                int respuesta = JOptionPane.showConfirmDialog(vistaEvaluacion, "Para confirmar sus datos presiones SI.", "ATENCION", JOptionPane.YES_OPTION);

                if (respuesta == 0) {
                    boolean auxiliar = modeloEvaluacionCalidad.guardarDatos();
                    if (auxiliar = true) {
                        System.out.println("SEGUIMIENTO: Campos de datos almacenados correctamente. ");
                        JOptionPane.showMessageDialog(vistaEvaluacion, "Datos Almacenados Correctamente" +e, "REGISTRO", JOptionPane.INFORMATION_MESSAGE);

                    }

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaEvaluacion, "Error al intentar guardar los DATOS. " + ex);

            }

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
