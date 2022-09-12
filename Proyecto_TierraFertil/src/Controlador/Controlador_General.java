package Controlador;

import Vista.Grupo3.Prueba_InstanciarMenu;
import Vista.Vista_General;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controlador_General implements MouseListener, ActionListener, MouseMotionListener {
    
    Vista_General vistaGeneral;
    Prueba_InstanciarMenu pruebaMenu = new Prueba_InstanciarMenu();
    Color colorNormal = new Color(247,246,246);
    Color colorSeleccionMinimizar = new Color(133, 193, 233 );
    Color colorSeleccionExit = new Color(231, 76, 60 );
    int xMouse, yMouse;
    public Controlador_General(Vista_General vistaGeneral) {
        this.vistaGeneral = vistaGeneral;
        // MouseListeners
        this.vistaGeneral.btn_minimizar.addMouseListener(this);
        this.vistaGeneral.btn_cerrar.addMouseListener(this);
        this.vistaGeneral.icono_minimizar.addMouseListener(this);
        this.vistaGeneral.icono_cerrar.addMouseListener(this);
        this.vistaGeneral.jp_banner.addMouseListener(this);
        this.vistaGeneral.btn_minimizar.addMouseListener(this);
        //ActionListesner
        
        //PruebaMenu
        this.menuPrueba();
        //MouseMotionListener
        this.vistaGeneral.jp_banner.addMouseMotionListener(this);
    }
    
    public void menuPrueba(){
        this.vistaGeneral.jp_menu_general.add(pruebaMenu);
        this.pruebaMenu.setBorder(null);
        this.pruebaMenu.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == this.vistaGeneral.btn_minimizar || me.getSource() == this.vistaGeneral.icono_minimizar) {
            //accion minimizar
        }
        if (me.getSource() == this.vistaGeneral.btn_cerrar || me.getSource() == this.vistaGeneral.icono_cerrar) {
            System.exit(0);
        }
        if (me.getSource() == this.vistaGeneral.btn_minimizar || me.getSource() == this.vistaGeneral.icono_minimizar) {
            this.vistaGeneral.setExtendedState(ICONIFIED);
            System.out.println("Presionado");
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == this.vistaGeneral.jp_banner) {
            xMouse = me.getX();
            yMouse = me.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == this.vistaGeneral.btn_minimizar || me.getSource() == this.vistaGeneral.icono_minimizar) {
            this.vistaGeneral.btn_minimizar.setBackground(colorSeleccionMinimizar);
        }
        if (me.getSource() == this.vistaGeneral.btn_cerrar || me.getSource() == this.vistaGeneral.icono_cerrar) {
            this.vistaGeneral.btn_cerrar.setBackground(colorSeleccionExit);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == this.vistaGeneral.btn_minimizar || me.getSource() == this.vistaGeneral.icono_minimizar) {
            this.vistaGeneral.btn_minimizar.setBackground(colorNormal);
        }
        if (me.getSource() == this.vistaGeneral.btn_cerrar || me.getSource() == this.vistaGeneral.icono_cerrar) {
            this.vistaGeneral.btn_cerrar.setBackground(colorNormal);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        int x = me.getXOnScreen();
        int y = me.getYOnScreen();
        this.vistaGeneral.setLocation(x - xMouse, y - yMouse);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
}