package Controlador.Grupo2;

import Vista.Vista_General;
import Vista.Grupo2.Vista_Menu_DanielModifica;
import java.awt.event.MouseEvent;
import java.awt.Color;

import java.awt.event.MouseListener;

public class Controlador_Menu implements MouseListener {

    Vista_Menu_DanielModifica vistaMenu;
    Vista_General vistaGeneral;

    //Colores para eventos con el mouse
    Color colorNormal = new Color(247, 246, 246);
    Color colorSeleccionMinimizar = new Color(133, 193, 233);
    Color colorSeleccionExit = new Color(231, 76, 60);
    Color colorUsuarioSeleccion = new Color(223, 238, 255);
    Color colorUsuarioNormal = new Color(204, 204, 204);

    public Controlador_Menu(Vista_Menu_DanielModifica vistaMenu) {
        this.vistaMenu = vistaMenu;

        this.vistaGeneral = vistaGeneral;

        //componentes de la vistaMenu de daniel
        this.vistaMenu.btn_acopio_control.addMouseListener(this);

        /*componentes de la vistaGeneral de Fernando +
            uso de su vista mas la mia para la visualización de vistaMenu
                en su vistageneral.
        */
        this.vistaGeneral.jp_escritorio_general.add(vistaMenu);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Captura de la accion del boton control
        if (e.getSource() == this.vistaMenu.btn_acopio_control) {
            System.out.println("Se presiono el boton control.");
            vistaMenu.setVisible(true);

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
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
           if (e.getSource() == this.vistaMenu.btn_acopio_control) {
               this.vistaMenu.btn_acopio_control.setBackground(colorNormal);
               
        }
    }

}
