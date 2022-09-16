package Controlador.Grupo2;

import Vista.Grupo2.Vis_evaluacion;
import Modelo.Modelo_Conexion;
import Modelo.Grupo2.Modeo_Evaluacion_Calidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Controlador_Evaluacion implements ActionListener, AncestorListener {

    Vis_evaluacion vistaEvaluacion;
    Modeo_Evaluacion_Calidad modeloEvaluacionCalidad = new Modeo_Evaluacion_Calidad();

    public Controlador_Evaluacion(Vis_evaluacion vistaEvaluacion) {
        this.vistaEvaluacion = vistaEvaluacion;

        this.vistaEvaluacion.jd_fecha.addAncestorListener(this);
        this.vistaEvaluacion.txt_calibracion.addActionListener(this);
        this.vistaEvaluacion.txt_vapor.addActionListener(this);
        this.vistaEvaluacion.txt_transporte.addActionListener(this);
        this.vistaEvaluacion.txt_dedos.addActionListener(this);
        this.vistaEvaluacion.txt_pedidos.addActionListener(this);
        this.vistaEvaluacion.txt_tipoCaja.addActionListener(this);
        this.vistaEvaluacion.txt_destino1.addActionListener(this);
        this.vistaEvaluacion.txt_codigo.addActionListener(this);
        this.vistaEvaluacion.txt_fumigacion.addActionListener(this);
        this.vistaEvaluacion.txt_destino2.addActionListener(this);

        //campo de vista TABULACION
        this.vistaEvaluacion.txt_caja_insp.addActionListener(this);
        this.vistaEvaluacion.txt_embalador.addActionListener(this);
        this.vistaEvaluacion.txt_peso_neto.addActionListener(this);
        this.vistaEvaluacion.txt_par4.addActionListener(this);
        this.vistaEvaluacion.txt_par6.addActionListener(this);
        this.vistaEvaluacion.txt_par8.addActionListener(this);
        this.vistaEvaluacion.txt_inpar5.addActionListener(this);
        this.vistaEvaluacion.txt_inpar7.addActionListener(this);

        //Botones de datos
        this.vistaEvaluacion.btn_siguiente.addMouseListener(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaEvaluacion.btn_siguiente) {
            System.out.println("Boton siguiente presionado");
            
            modeloEvaluacionCalidad.calibracion = this.vistaEvaluacion.txt_calibracion.getName();
            modeloEvaluacionCalidad.vapor = this.vistaEvaluacion.txt_vapor.getText();
            modeloEvaluacionCalidad.transporte = this.vistaEvaluacion.txt_transporte.getText();
            modeloEvaluacionCalidad.l_dedos = this.vistaEvaluacion.txt_dedos.getText();
            modeloEvaluacionCalidad.pedido = this.vistaEvaluacion.txt_pedidos.getText();
            modeloEvaluacionCalidad.tipo_caja = this.vistaEvaluacion.txt_tipoCaja.getText();
            modeloEvaluacionCalidad.destino = this.vistaEvaluacion.txt_destino1.getText();
            modeloEvaluacionCalidad.codigo = Integer.parseInt(this.vistaEvaluacion.txt_codigo.getText());
            modeloEvaluacionCalidad.fumigacion = this.vistaEvaluacion.txt_fumigacion.getText();
            modeloEvaluacionCalidad.destino2 = this.vistaEvaluacion.txt_destino2.getText();
            
            try {
                boolean auxiliar;
                auxiliar = modeloEvaluacionCalidad.guardarDatos();
                
                int respuesta = JOptionPane.showConfirmDialog(vistaEvaluacion, "Para confirmar sus datos presiones SI.");
                if (respuesta == 0) {
                    if (auxiliar = true) {
                        System.out.println("SEGUIMIENTO: Campos de datos almacenados correctamente. ");
                        
                        
             
                    }
                    
                    
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaEvaluacion, "Error al intentar guardar los DATOS. " +e);
                
            }
           
            

            
        }
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

}
