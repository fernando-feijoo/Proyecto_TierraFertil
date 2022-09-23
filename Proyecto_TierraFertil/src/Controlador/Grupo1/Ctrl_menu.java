package Controlador.Grupo1;

import Vista.Grupo1.Menu_Campo;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ctrl_menu implements MouseListener {

    Menu_Campo vistaMenu;
    Color colorNormal = new Color(204, 204, 204);
    Color colorSeleccionOpcion = new Color(223, 238, 255);
    Color colorSeleccionIngreso = new Color(159, 203, 255);
    public static int opcionClick;

    public Ctrl_menu(Menu_Campo vistaMenu) {
        this.vistaMenu = vistaMenu;
        this.vistaMenu.boton_campo_uno.addMouseListener(this);
        this.vistaMenu.boton_campo_dos.addMouseListener(this);
        this.vistaMenu.boton_listar_uno.addMouseListener(this);
    }

    public void opcionClick(int a) {
        this.opcionClick = a;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //  Codigo para el cabio de colores, cuando se pasa el mouse y cuando se hace click se asigna un numero.
        if (me.getSource() == this.vistaMenu.boton_campo_uno) {
            this.vistaMenu.boton_campo_uno.setBackground(colorSeleccionIngreso);
            opcionClick = 1;
        }
        if (me.getSource() == this.vistaMenu.boton_campo_dos) {
            this.vistaMenu.boton_campo_dos.setBackground(colorSeleccionIngreso);
            opcionClick = 2;
        }
        if (me.getSource() == this.vistaMenu.boton_listar_uno) {
            this.vistaMenu.boton_listar_uno.setBackground(colorSeleccionIngreso);
            opcionClick = 3;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        /*  
            Asigno color al jPanel donde se encuentre el mouse y filtramos segun el numero si tiene asignado un numero
            se interpreta que entro a ese apartado.
         */
        if (me.getSource() == this.vistaMenu.boton_campo_uno && (opcionClick != 1)) {
            this.vistaMenu.boton_campo_uno.setBackground(colorSeleccionOpcion);
        } else if (me.getSource() == this.vistaMenu.boton_campo_dos && (opcionClick != 2)) {
            this.vistaMenu.boton_campo_dos.setBackground(colorSeleccionOpcion);
        } else if (me.getSource() == this.vistaMenu.boton_listar_uno && (opcionClick != 3)) {
            this.vistaMenu.boton_listar_uno.setBackground(colorSeleccionOpcion);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == this.vistaMenu.boton_campo_uno && (opcionClick != 1)) {
            this.vistaMenu.boton_campo_uno.setBackground(colorNormal);
        } else if (me.getSource() == this.vistaMenu.boton_campo_dos && (opcionClick != 2)) {
            this.vistaMenu.boton_campo_dos.setBackground(colorNormal);
        } else if (me.getSource() == this.vistaMenu.boton_listar_uno && (opcionClick != 3)) {
            this.vistaMenu.boton_listar_uno.setBackground(colorNormal);
        }
    }

}
