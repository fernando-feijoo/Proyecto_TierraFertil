package Controlador.Grupo3;

import Vista.Grupo3.Vista_Menu_Acopio;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controlador_Menu_Acopio implements MouseListener {

    Vista_Menu_Acopio vistaMenuAcopio;
    
    Color colorNormal = new Color(204, 204, 204);
    Color colorSeleccionOpcion = new Color(133, 193, 233);
    Color colorSeleccionIngreso = new Color(0, 115, 255);
    int opcionClick;
    public Controlador_Menu_Acopio(Vista_Menu_Acopio vistaMenuAcopio) {
        this.vistaMenuAcopio = vistaMenuAcopio;
        this.vistaMenuAcopio.btn_acopio_opcion_uno.addMouseListener(this);
        this.vistaMenuAcopio.btn_acopio_opcion_dos.addMouseListener(this);
        this.vistaMenuAcopio.btn_reportes_opcion_uno.addMouseListener(this);
        this.vistaMenuAcopio.btn_reportes_opcion_dos.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_uno) {
            opcionClick = 1;
        }
        if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_dos) {
            opcionClick = 2;
        }
        if (e.getSource() == this.vistaMenuAcopio.btn_reportes_opcion_uno) {
            opcionClick = 3;
        }
        if (e.getSource() == this.vistaMenuAcopio.btn_reportes_opcion_dos) {
            opcionClick = 4;
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
        //        Asigno color al jPanel donde se encuentre el mouse.
        if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_uno && (opcionClick != 1)) {
            this.vistaMenuAcopio.btn_acopio_opcion_uno.setBackground(colorSeleccionOpcion);
        } else if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_dos && (opcionClick != 2)) {
            this.vistaMenuAcopio.btn_acopio_opcion_dos.setBackground(colorSeleccionOpcion);
        } else if (e.getSource() == this.vistaMenuAcopio.btn_reportes_opcion_uno && (opcionClick != 3)) {
            this.vistaMenuAcopio.btn_reportes_opcion_uno.setBackground(colorSeleccionOpcion);
        } else if (e.getSource() == this.vistaMenuAcopio.btn_reportes_opcion_dos && (opcionClick != 4)) {
            this.vistaMenuAcopio.btn_reportes_opcion_dos.setBackground(colorSeleccionOpcion);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //        Asigno nuevo color, que es el base cuando sale el mouse del jPanel.
        if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_uno && (opcionClick != 1)) {
            this.vistaMenuAcopio.btn_acopio_opcion_uno.setBackground(colorNormal);
        } else if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_dos && (opcionClick != 2)) {
            this.vistaMenuAcopio.btn_acopio_opcion_dos.setBackground(colorNormal);
        } else if (e.getSource() == this.vistaMenuAcopio.btn_reportes_opcion_uno && (opcionClick != 3)) {
            this.vistaMenuAcopio.btn_reportes_opcion_uno.setBackground(colorNormal);
        } else if (e.getSource() == this.vistaMenuAcopio.btn_reportes_opcion_dos && (opcionClick != 4)) {
            this.vistaMenuAcopio.btn_reportes_opcion_dos.setBackground(colorNormal);
        }
    }

}
