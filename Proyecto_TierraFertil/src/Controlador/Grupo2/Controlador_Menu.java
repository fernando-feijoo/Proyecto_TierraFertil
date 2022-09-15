package Controlador.Grupo2;

//importaciones de la vista
import Vista.Vista_General;
import Vista.Grupo2.Vista_Listado;
import Vista.Grupo2.Vista_Menu_Calidad;
import Vista.Grupo2.Vis_evaluacion;
//importaciones del controlador
import Controlador.Grupo2.Controlador_Evaluacion;
import Controlador.Grupo2.Controlador_Listado;

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class Controlador_Menu implements MouseListener {

    Vista_Menu_Calidad vistaMenu = new Vista_Menu_Calidad();
    Vista_Listado vistaListado;
    Vis_evaluacion vistaEvaluacion;

    Vista_General vistaGeneral = new Vista_General();

    //Colores para eventos con el mouse
    Color colorNormal = new Color(247, 246, 246);
    Color colorUsuarioSeleccion = new Color(223, 238, 255);

    public Controlador_Menu(Vista_Menu_Calidad vistaMenu) {
        this.vistaMenu = vistaMenu;

        //componentes de la vistaMenu de daniel
        this.vistaMenu.btn_acopio_control.addMouseListener(this);
        this.vistaMenu.btn_acopio_listado.addMouseListener(this);

        /*componentes de la vistaGeneral de Fernando +
            uso de su vista mas la mia para la visualización de vistaMenu
                en su vistageneral.
         */
        this.vistaGeneral.jp_menu_general.add(vistaMenu);
        this.vistaMenu.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Captura de la accion del boton control
        if (e.getSource() == this.vistaMenu.btn_acopio_control) {
            System.out.println("Se presiono el boton control.");

            try {
                Controlador_Evaluacion controladorEvaluacion = new Controlador_Evaluacion(vistaEvaluacion);
                this.vistaGeneral.jp_escritorio_general.add(vistaEvaluacion);

                //En caso de que esten otras vistas abiertas.
                vistaEvaluacion.setVisible(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en el boton control de acopio. " + e);
            }

        }

        if (e.getSource() == this.vistaMenu.btn_acopio_listado) {
            System.out.println("Se presiono el boton listado");

            try {
                Controlador_Listado controladorListado = new Controlador_Listado(vistaListado);
                this.vistaGeneral.jp_escritorio_general.add(vistaListado);
                vistaListado.setBorder(null);
                //En caso de que esten otras vistas abiertas.

                vistaListado.setVisible(true);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en el boton listado de acopio. " + e);

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

        if (e.getSource() == this.vistaMenu.btn_acopio_control) {
            this.vistaMenu.btn_acopio_control.setBackground(colorUsuarioSeleccion);
        }
        if (e.getSource() == this.vistaMenu.btn_acopio_listado) {
            this.vistaMenu.btn_acopio_listado.setBackground(colorUsuarioSeleccion);

        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getSource() == this.vistaMenu.btn_acopio_control) {
            this.vistaMenu.btn_acopio_control.setBackground(colorNormal);

        }
        if (e.getSource() == this.vistaMenu.btn_acopio_listado) {
            this.vistaMenu.btn_acopio_listado.setBackground(colorNormal);

        }
    }

}
