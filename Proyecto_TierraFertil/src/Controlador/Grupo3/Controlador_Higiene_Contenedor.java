package Controlador.Grupo3;

import Vista.Grupo3.Vista_Llegada;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controlador_Higiene_Contenedor implements MouseListener {

    Vista_Llegada vistaLlegada;

    public static int idContenedor;
    String opcionUno, opcionDos, opcionTres, opcionCuatro, opcionCinco, opcionSeis,
            opcionSiete, opcionOcho, observacionHigCont;

    public Controlador_Higiene_Contenedor(Vista_Llegada vistaLlegada) {
        this.vistaLlegada = vistaLlegada;
        this.vistaLlegada.btn_siguiente_higCont.addMouseListener(this);
    }

    public void autoIncrementarID_Entidades(int herenciaTres) {
        this.idContenedor = herenciaTres;
        System.out.println("ValorHerencia HigieneConendor ContHC: " + idContenedor);
    }

    public void almacenarHigieneContendor() {
        Boolean opcionUno = (this.vistaLlegada.higCont_rb_si_lavado.isSelected()) ? true : false;
        this.opcionUno = (opcionUno) ? "SI" : "NO";
        Boolean opcionDos = (this.vistaLlegada.higCont_rb_si_drenajes.isSelected()) ? true : false;
        this.opcionDos = (opcionDos) ? "SI" : "NO";
        Boolean opcionTres = (this.vistaLlegada.higCont_rb_si_olor.isSelected()) ? true : false;
        this.opcionTres = (opcionTres) ? "SI" : "NO";
        Boolean opcionCuatro = (this.vistaLlegada.higCont_rb_si_residuos.isSelected()) ? true : false;
        this.opcionCuatro = (opcionCuatro) ? "SI" : "NO";
        Boolean opcionCinco = (this.vistaLlegada.higCont_rb_si_insectos.isSelected()) ? true : false;
        this.opcionCinco = (opcionCinco) ? "SI" : "NO";
        Boolean opcionSeis = (this.vistaLlegada.higCont_rb_si_sello.isSelected()) ? true : false;
        this.opcionSeis = (opcionSeis) ? "SI" : "NO";
        Boolean opcionSiete = (this.vistaLlegada.higCont_rb_si_moho.isSelected()) ? true : false;
        this.opcionSiete = (opcionSiete) ? "SI" : "NO";
        Boolean opcionOcho = (this.vistaLlegada.higCont_rb_si_contenedor_aceptable.isSelected()) ? true : false;
        this.opcionOcho = (opcionOcho) ? "SI" : "NO";
        
        this.observacionHigCont = this.vistaLlegada.higCont_observaciones.getText();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vistaLlegada.btn_siguiente_higCont) {
            almacenarHigieneContendor();
            System.out.println(opcionUno + " , " + opcionDos + " , " + opcionTres + " , " + opcionCuatro + " , " +  opcionCinco
             + " , " + opcionSeis + " , " + opcionSiete + " , " + opcionOcho  + " \n, " + observacionHigCont);
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
