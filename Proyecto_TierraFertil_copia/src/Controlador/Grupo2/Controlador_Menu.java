package Controlador.Grupo2;

//importaciones de la vista
import Vista.Grupo2.Vista_Listado;
import Vista.Grupo2.Vista_Menu_Calidad;
import Vista.Grupo2.Vis_evaluacion;
//importaciones del controlador

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class Controlador_Menu implements MouseListener {

    Vista_Menu_Calidad vistaMenu;
    Vis_evaluacion vistaEvaluacion = new Vis_evaluacion();
    Vista_Listado vistaListado = new Vista_Listado();
    
    //Colores para eventos con el mouse
    Color colorNormal = new Color(247, 246, 246);
    Color colorUsuarioSeleccion = new Color(223, 238, 255);

    public Controlador_Menu(Vista_Menu_Calidad vistaMenu) {
        this.vistaMenu = vistaMenu;
        //componentes de la vistaMenu de daniel
        
        /*componentes de la vistaGeneral de Fernando +
            uso de su vista mas la mia para la visualización de vistaMenu
                en su vistageneral.
         */
    }

    @Override
    public void mouseClicked(MouseEvent e) {


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
