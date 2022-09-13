package Controlador.Grupo2;

import Vista.Grupo2.Vista_Escritorio_Prueba;
import Vista.Grupo2.Vis_evaluacion;
import Controlador.Grupo2.Controlador_Escritorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class Controlador_Escritorio implements MouseListener {

    Vista_Escritorio_Prueba visEscritorio;

    public Controlador_Escritorio(Vista_Escritorio_Prueba visEscritorio) {
        this.visEscritorio = visEscritorio;

        this.visEscritorio.btn_control.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.visEscritorio.btn_control) {
            try {
                Vis_evaluacion visEvaluacion = new Vis_evaluacion();
                Controlador_Evaluacion ctrlEvaluacion = new Controlador_Evaluacion(visEvaluacion);

                this.visEscritorio.escritorio.add(visEvaluacion);
                visEvaluacion.show();
                visEvaluacion.setBorder(null);
                System.out.println("Boton control ejecutado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en btn_control " + ex);
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
