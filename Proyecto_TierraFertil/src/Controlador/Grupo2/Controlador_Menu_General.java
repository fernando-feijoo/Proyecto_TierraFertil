package Controlador.Grupo2;

//importaciones de la vista
import Vista.Grupo2.Vista_Listado_Menu;
import Vista.Grupo2.Vista_Menu_Calidad;
import Vista.Grupo2.Vista_Evaluacion_Total;
//importaciones del controlador

import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class Controlador_Menu_General implements MouseListener {

    Vista_Menu_Calidad vistaMenu;
    Vista_Evaluacion_Total vistaEvaluacion = new Vista_Evaluacion_Total();
    Vista_Listado_Menu vistaListado = new Vista_Listado_Menu();
    
    //Colores para eventos con el mouse
    Color colorNormal = new Color(247, 246, 246);
    Color colorSeleccionMinimizar = new Color(133, 193, 233);
    Color colorSeleccionExit = new Color(231, 76, 60);
    Color colorUsuarioSeleccion = new Color(223,238,255);
    Color colorNormalOscuro = new Color(204,204,204);

    public Controlador_Menu_General(Vista_Menu_Calidad vistaMenu) {
        this.vistaMenu = vistaMenu;
        
        this.vistaMenu.btn_acopio_control.addMouseListener(this);
        this.vistaMenu.btn_acopio_control.addMouseListener(this);
        this.vistaMenu.btn_reportes_opcion_uno.addMouseListener(this);
        this.vistaMenu.btn_reportes_opcion_dos.addMouseListener(this);
        
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
