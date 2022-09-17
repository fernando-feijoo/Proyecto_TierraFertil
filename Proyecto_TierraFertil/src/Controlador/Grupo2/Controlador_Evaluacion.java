package Controlador.Grupo2;

import Vista.Grupo2.Vis_evaluacion;
import Modelo.Modelo_Conexion;
import Modelo.Grupo2.Modeo_Evaluacion_Calidad;
import com.sun.media.sound.ModelOscillator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Controlador_Evaluacion implements ActionListener, AncestorListener, MouseListener {

    Vis_evaluacion vistaEvaluacion = new Vis_evaluacion();
    Modeo_Evaluacion_Calidad modeloEvaluacionCalidad = new Modeo_Evaluacion_Calidad();

    public Controlador_Evaluacion(Vis_evaluacion vistaEvaluacion) {
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
            try {

                System.out.println("Boton siguiente presionado");
                
                modeloEvaluacionCalidad.semana = (String) this.vistaEvaluacion.jcomb_semana.getSelectedItem();
                modeloEvaluacionCalidad.finca = (String) this.vistaEvaluacion.jcom_finca.getSelectedItem();
                modeloEvaluacionCalidad.calibracion = this.vistaEvaluacion.txt_calibracion.getText();
                modeloEvaluacionCalidad.vapor = this.vistaEvaluacion.txt_vapor.getText();
                modeloEvaluacionCalidad.transporte = this.vistaEvaluacion.txt_transporte.getText();
                modeloEvaluacionCalidad.l_dedos = this.vistaEvaluacion.txt_dedos.getText();
                modeloEvaluacionCalidad.pedido = this.vistaEvaluacion.txt_pedidos.getText();
                modeloEvaluacionCalidad.tipo_caja = this.vistaEvaluacion.txt_tipoCaja.getText();
                modeloEvaluacionCalidad.destino = this.vistaEvaluacion.txt_destino1.getText();
                
                modeloEvaluacionCalidad.codigo = this.vistaEvaluacion.txt_codigo.getText();
                
                
                modeloEvaluacionCalidad.fumigacion = this.vistaEvaluacion.txt_fumigacion.getText();
                modeloEvaluacionCalidad.destino2 = this.vistaEvaluacion.txt_destino2.getText();
              int respuesta = JOptionPane.showConfirmDialog(vistaEvaluacion, "Para confirmar sus datos presiones SI.", "ATENCION", JOptionPane.YES_OPTION);

                if (respuesta == 0) {
                    boolean auxiliar = modeloEvaluacionCalidad.guardarDatos();
                    if (auxiliar = true) {
                        System.out.println("SEGUIMIENTO: Campos de datos almacenados correctamente. ");

                    }

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaEvaluacion, "Error al intentar guardar los DATOS. " + e);

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
