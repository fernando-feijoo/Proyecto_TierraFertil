package Controlador.Grupo3;

import Vista.Grupo3.Vista_Menu_Acopio;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controlador_Menu_Acopio implements MouseListener{

    Vista_Menu_Acopio vistaMenuAcopio;
    Color colorNormal = new Color(204, 204, 204);
    Color colorSeleccionOpcion = new Color(223,238,255);
    Color colorSeleccionIngreso = new Color(159,203,255);
    public static int opcionClick;
    public Controlador_Menu_Acopio(Vista_Menu_Acopio vistaMenuAcopio) {
        this.vistaMenuAcopio = vistaMenuAcopio;
        this.vistaMenuAcopio.btn_acopio_opcion_uno.addMouseListener(this);
        this.vistaMenuAcopio.btn_acopio_opcion_dos.addMouseListener(this);
        this.vistaMenuAcopio.btn_reportes_opcion_uno.addMouseListener(this);
    }
    
    public void opcionClick(int a){
        this.opcionClick = a;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //  Codigo para el cabio de colores, cuando se pasa el mouse y cuando se hace click se asigna un numero.
        if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_uno) {
            this.vistaMenuAcopio.btn_acopio_opcion_uno.setBackground(colorSeleccionIngreso);
            opcionClick = 1;
        }
        if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_dos) {
            this.vistaMenuAcopio.btn_acopio_opcion_dos.setBackground(colorSeleccionIngreso);
            opcionClick = 2;
        }
        if (e.getSource() == this.vistaMenuAcopio.btn_reportes_opcion_uno) {
            this.vistaMenuAcopio.btn_reportes_opcion_uno.setBackground(colorSeleccionIngreso);
            opcionClick = 3;
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
        /*  
            Asigno color al jPanel donde se encuentre el mouse y filtramos segun el numero si tiene asignado un numero
            se interpreta que entro a ese apartado.
        */
        if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_uno && (opcionClick != 1)) {
            this.vistaMenuAcopio.btn_acopio_opcion_uno.setBackground(colorSeleccionOpcion);
        } else if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_dos && (opcionClick != 2)) {
            this.vistaMenuAcopio.btn_acopio_opcion_dos.setBackground(colorSeleccionOpcion);
        } else if (e.getSource() == this.vistaMenuAcopio.btn_reportes_opcion_uno && (opcionClick != 3)) {
            this.vistaMenuAcopio.btn_reportes_opcion_uno.setBackground(colorSeleccionOpcion);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //  Asigno nuevo color, que basicamente es el base o inicial del munu; cuando sale el mouse del jPanel.
        if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_uno && (opcionClick != 1)) {
            this.vistaMenuAcopio.btn_acopio_opcion_uno.setBackground(colorNormal);
        } else if (e.getSource() == this.vistaMenuAcopio.btn_acopio_opcion_dos && (opcionClick != 2)) {
            this.vistaMenuAcopio.btn_acopio_opcion_dos.setBackground(colorNormal);
        } else if (e.getSource() == this.vistaMenuAcopio.btn_reportes_opcion_uno && (opcionClick != 3)) {
            this.vistaMenuAcopio.btn_reportes_opcion_uno.setBackground(colorNormal);
        }
    }
}