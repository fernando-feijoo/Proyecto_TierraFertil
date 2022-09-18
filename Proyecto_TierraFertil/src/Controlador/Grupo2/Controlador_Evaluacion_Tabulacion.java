package Controlador.Grupo2;

import Vista.Grupo2.Vista_Evaluacion_Total;
import Modelo.Grupo2.Modelo_Evaluacion_Tabulacion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class Controlador_Evaluacion_Tabulacion implements MouseListener {

    //Instanciaciones de la vista y modelo
    Vista_Evaluacion_Total vistaEvaluacion = new Vista_Evaluacion_Total();
    Modelo_Evaluacion_Tabulacion modeloEvaluacionTabulacion = new Modelo_Evaluacion_Tabulacion();
    //Constructor

    public Controlador_Evaluacion_Tabulacion(Vista_Evaluacion_Total vistaEvaluacion) {
        this.vistaEvaluacion = new Vista_Evaluacion_Total();

        this.vistaEvaluacion.jb_guardar.addMouseListener(this);
        this.vistaEvaluacion.jb_agregar_defecto.addMouseListener(this);
        this.vistaEvaluacion.jb_nuevos_datos.addMouseListener(this);
        this.vistaEvaluacion.jb_generar_reporte.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaEvaluacion.jb_guardar) {
            try {
                modeloEvaluacionTabulacion.caja_inspeccionada = Integer.parseInt(this.vistaEvaluacion.txt_caja_insp.getText());
                modeloEvaluacionTabulacion.embalador = Integer.parseInt(this.vistaEvaluacion.txt_embalador.getText());
                modeloEvaluacionTabulacion.peso_neto = Double.parseDouble(this.vistaEvaluacion.txt_peso_neto.getText());
                modeloEvaluacionTabulacion.par4 = Integer.parseInt(this.vistaEvaluacion.txt_par4.getText());
                modeloEvaluacionTabulacion.par6 = Integer.parseInt(this.vistaEvaluacion.txt_par6.getText());
                modeloEvaluacionTabulacion.par8 = Integer.parseInt(this.vistaEvaluacion.txt_par8.getText());
                modeloEvaluacionTabulacion.impar5 = Integer.parseInt(this.vistaEvaluacion.txt_inpar5.getText());
                modeloEvaluacionTabulacion.impar7 = Integer.parseInt(this.vistaEvaluacion.txt_inpar7.getText());
                boolean aux = modeloEvaluacionTabulacion.guardarTabulacion();
                if (aux == true) {
                    System.out.println("SEGUIMIENTO: Campos de datos almacenados correctamente");
                    JOptionPane.showMessageDialog(vistaEvaluacion, "Datos guardados correctamente ", "Registros", JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(vistaEvaluacion, "Error al intentar guardar los datos." + ex);
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
